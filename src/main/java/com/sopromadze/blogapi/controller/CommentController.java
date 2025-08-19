package com.sopromadze.blogapi.controller;

import com.sopromadze.blogapi.model.Comment;
import com.sopromadze.blogapi.payload.ApiResponse;
import com.sopromadze.blogapi.payload.CommentRequest;
import com.sopromadze.blogapi.payload.PagedResponse;
import com.sopromadze.blogapi.security.CurrentUser;
import com.sopromadze.blogapi.security.UserPrincipal;
import com.sopromadze.blogapi.service.CommentService;
import com.sopromadze.blogapi.utils.AppConstants;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {
	private final CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping
	public ResponseEntity<PagedResponse<Comment>> getAllComments(@PathVariable(name = "postId") String postId,
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

		PagedResponse<Comment> allComments = commentService.getAllComments(new ObjectId(postId), page, size);

		return new ResponseEntity< >(allComments, HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Comment> addComment(@Valid @RequestBody CommentRequest commentRequest,
			@PathVariable(name = "postId") String postId, @CurrentUser UserPrincipal currentUser) {
		Comment newComment = commentService.addComment(commentRequest, new ObjectId(postId), currentUser);

		return new ResponseEntity<>(newComment, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comment> getComment(@PathVariable(name = "postId") String postId,
			@PathVariable(name = "id") String id) {
		Comment comment = commentService.getComment(new ObjectId(postId), new ObjectId(id));

		return new ResponseEntity<>(comment, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Comment> updateComment(@PathVariable(name = "postId") String postId,
			@PathVariable(name = "id") String id, @Valid @RequestBody CommentRequest commentRequest,
			@CurrentUser UserPrincipal currentUser) {

		Comment updatedComment = commentService.updateComment(new ObjectId(postId), new ObjectId(id), commentRequest, currentUser);

		return new ResponseEntity<>(updatedComment, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable(name = "postId") String postId,
			@PathVariable(name = "id") String id, @CurrentUser UserPrincipal currentUser) {

		ApiResponse response = commentService.deleteComment(new ObjectId(postId), new ObjectId(id), currentUser);

		HttpStatus status = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

		return new ResponseEntity<>(response, status);
	}

}
