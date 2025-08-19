package com.sopromadze.blogapi.service;

import com.sopromadze.blogapi.model.Todo;
import com.sopromadze.blogapi.payload.ApiResponse;
import com.sopromadze.blogapi.payload.PagedResponse;
import com.sopromadze.blogapi.security.UserPrincipal;
import org.bson.types.ObjectId;

public interface TodoService {

	Todo completeTodo(ObjectId id, UserPrincipal currentUser);

	Todo unCompleteTodo(ObjectId id, UserPrincipal currentUser);

	PagedResponse<Todo> getAllTodos(UserPrincipal currentUser, int page, int size);

	Todo addTodo(Todo todo, UserPrincipal currentUser);

	Todo getTodo(ObjectId id, UserPrincipal currentUser);

	Todo updateTodo(ObjectId id, Todo newTodo, UserPrincipal currentUser);

	ApiResponse deleteTodo(ObjectId id, UserPrincipal currentUser);

}
