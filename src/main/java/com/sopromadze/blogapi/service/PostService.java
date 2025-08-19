package com.sopromadze.blogapi.service;

import com.sopromadze.blogapi.model.Post;
import com.sopromadze.blogapi.payload.ApiResponse;
import com.sopromadze.blogapi.payload.PagedResponse;
import com.sopromadze.blogapi.payload.PostRequest;
import com.sopromadze.blogapi.payload.PostResponse;
import com.sopromadze.blogapi.security.UserPrincipal;
import org.bson.types.ObjectId;

public interface PostService {

	PagedResponse<Post> getAllPosts(int page, int size);

	PagedResponse<Post> getPostsByCreatedBy(String username, int page, int size);

	PagedResponse<Post> getPostsByCategory(ObjectId id, int page, int size);

	PagedResponse<Post> getPostsByTag(ObjectId id, int page, int size);

	Post updatePost(ObjectId id, PostRequest newPostRequest, UserPrincipal currentUser);

	ApiResponse deletePost(ObjectId id, UserPrincipal currentUser);

	PostResponse addPost(PostRequest postRequest, UserPrincipal currentUser);

	Post getPost(ObjectId id);

}
