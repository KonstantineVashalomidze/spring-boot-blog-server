package com.sopromadze.blogapi.service;

import com.sopromadze.blogapi.payload.ApiResponse;
import com.sopromadze.blogapi.payload.PagedResponse;
import com.sopromadze.blogapi.payload.PhotoRequest;
import com.sopromadze.blogapi.payload.PhotoResponse;
import com.sopromadze.blogapi.security.UserPrincipal;
import org.bson.types.ObjectId;

public interface PhotoService {

	PagedResponse<PhotoResponse> getAllPhotos(int page, int size);

	PhotoResponse getPhoto(ObjectId id);

	PhotoResponse updatePhoto(ObjectId id, PhotoRequest photoRequest, UserPrincipal currentUser);

	PhotoResponse addPhoto(PhotoRequest photoRequest, UserPrincipal currentUser);

	ApiResponse deletePhoto(ObjectId id, UserPrincipal currentUser);

	PagedResponse<PhotoResponse> getAllPhotosByAlbum(ObjectId albumId, int page, int size);

}