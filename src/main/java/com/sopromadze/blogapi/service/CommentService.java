package com.sopromadze.blogapi.service;

import com.sopromadze.blogapi.model.Comment;
import com.sopromadze.blogapi.payload.ApiResponse;
import com.sopromadze.blogapi.payload.CommentRequest;
import com.sopromadze.blogapi.payload.PagedResponse;
import com.sopromadze.blogapi.security.UserPrincipal;
import org.bson.types.ObjectId;

public interface CommentService {

	PagedResponse<Comment> getAllComments(ObjectId postId, int page, int size);

	Comment addComment(CommentRequest commentRequest, ObjectId postId, UserPrincipal currentUser);

	Comment getComment(ObjectId postId, ObjectId id);

	Comment updateComment(ObjectId postId, ObjectId id, CommentRequest commentRequest, UserPrincipal currentUser);

	ApiResponse deleteComment(ObjectId postId, ObjectId id, UserPrincipal currentUser);

}
