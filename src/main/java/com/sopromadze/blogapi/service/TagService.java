package com.sopromadze.blogapi.service;

import com.sopromadze.blogapi.model.Tag;
import com.sopromadze.blogapi.payload.ApiResponse;
import com.sopromadze.blogapi.payload.PagedResponse;
import com.sopromadze.blogapi.security.UserPrincipal;
import org.bson.types.ObjectId;

public interface TagService {

	PagedResponse<Tag> getAllTags(int page, int size);

	Tag getTag(ObjectId id);

	Tag addTag(Tag tag, UserPrincipal currentUser);

	Tag updateTag(ObjectId id, Tag newTag, UserPrincipal currentUser);

	ApiResponse deleteTag(ObjectId id, UserPrincipal currentUser);

}
