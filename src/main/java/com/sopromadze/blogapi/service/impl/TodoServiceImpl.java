package com.sopromadze.blogapi.service.impl;

import com.sopromadze.blogapi.exception.BadRequestException;
import com.sopromadze.blogapi.exception.BlogapiException;
import com.sopromadze.blogapi.exception.ResourceNotFoundException;
import com.sopromadze.blogapi.exception.UnauthorizedException;
import com.sopromadze.blogapi.model.Todo;
import com.sopromadze.blogapi.model.user.User;
import com.sopromadze.blogapi.payload.ApiResponse;
import com.sopromadze.blogapi.payload.PagedResponse;
import com.sopromadze.blogapi.repository.TodoRepository;
import com.sopromadze.blogapi.repository.UserRepository;
import com.sopromadze.blogapi.security.UserPrincipal;
import com.sopromadze.blogapi.service.TodoService;
import com.sopromadze.blogapi.utils.AppConstants;
import com.sopromadze.blogapi.utils.AppUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.sopromadze.blogapi.utils.AppConstants.CREATED_AT;
import static com.sopromadze.blogapi.utils.AppConstants.ID;
import static com.sopromadze.blogapi.utils.AppConstants.TODO;
import static com.sopromadze.blogapi.utils.AppConstants.YOU_DON_T_HAVE_PERMISSION_TO_MAKE_THIS_OPERATION;

@Service
public class TodoServiceImpl implements TodoService {
	private final TodoRepository todoRepository;
	private final UserRepository userRepository;

	public TodoServiceImpl(TodoRepository todoRepository, UserRepository userRepository) {
		this.todoRepository = todoRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Todo completeTodo(ObjectId id, UserPrincipal currentUser) {
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TODO, ID, id));

		User user = userRepository.getUser(currentUser);

		if (todo.getUser().equals(user.getId())) {
			todo.setCompleted(Boolean.TRUE);
			return todoRepository.save(todo);
		}

		ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, YOU_DON_T_HAVE_PERMISSION_TO_MAKE_THIS_OPERATION);

		throw new UnauthorizedException(apiResponse);
	}

	@Override
	public Todo unCompleteTodo(ObjectId id, UserPrincipal currentUser) {
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TODO, ID, id));
		User user = userRepository.getUser(currentUser);
		if (todo.getUser().equals(user.getId())) {
			todo.setCompleted(Boolean.FALSE);
			return todoRepository.save(todo);
		}

		ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, YOU_DON_T_HAVE_PERMISSION_TO_MAKE_THIS_OPERATION);

		throw new UnauthorizedException(apiResponse);
	}

	@Override
	public PagedResponse<Todo> getAllTodos(UserPrincipal currentUser, int page, int size) {
		AppUtils.validatePageNumberAndSize(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);

		Page<Todo> todos = todoRepository.findByCreatedBy(currentUser.getId(), pageable);

		List<Todo> content = todos.getNumberOfElements() == 0 ? Collections.emptyList() : todos.getContent();

		return new PagedResponse<>(content, todos.getNumber(), todos.getSize(), todos.getTotalElements(),
				todos.getTotalPages(), todos.isLast());
	}

	@Override
	public Todo addTodo(Todo todo, UserPrincipal currentUser) {
		User user = userRepository.getUser(currentUser);
		todo.setUser(user.getId());
		return todoRepository.save(todo);
	}

	@Override
	public Todo getTodo(ObjectId id, UserPrincipal currentUser) {
		User user = userRepository.getUser(currentUser);
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TODO, ID, id));

		if (todo.getUser().equals(user.getId())) {
			return todo;
		}

		ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, YOU_DON_T_HAVE_PERMISSION_TO_MAKE_THIS_OPERATION);

		throw new UnauthorizedException(apiResponse);
	}

	@Override
	public Todo updateTodo(ObjectId id, Todo newTodo, UserPrincipal currentUser) {
		User user = userRepository.getUser(currentUser);
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TODO, ID, id));
		if (todo.getUser().equals(user.getId())) {
			todo.setTitle(newTodo.getTitle());
			todo.setCompleted(newTodo.getCompleted());
			return todoRepository.save(todo);
		}

		ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, YOU_DON_T_HAVE_PERMISSION_TO_MAKE_THIS_OPERATION);

		throw new UnauthorizedException(apiResponse);
	}

	@Override
	public ApiResponse deleteTodo(ObjectId id, UserPrincipal currentUser) {
		User user = userRepository.getUser(currentUser);
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TODO, ID, id));

		if (todo.getUser().equals(user.getId())) {
			todoRepository.deleteById(id);
			return new ApiResponse(Boolean.TRUE, "You successfully deleted todo");
		}

		ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, YOU_DON_T_HAVE_PERMISSION_TO_MAKE_THIS_OPERATION);

		throw new UnauthorizedException(apiResponse);
	}



}
