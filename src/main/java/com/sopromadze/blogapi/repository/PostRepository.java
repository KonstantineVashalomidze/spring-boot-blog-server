package com.sopromadze.blogapi.repository;

import com.sopromadze.blogapi.model.Post;
import com.sopromadze.blogapi.model.Tag;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, ObjectId> {
	Page<Post> findByCreatedBy(ObjectId userId, Pageable pageable);

	Page<Post> findByCategory(ObjectId categoryId, Pageable pageable);

	Page<Post> findByTags(List<Tag> tags, Pageable pageable);

	Long countByCreatedBy(ObjectId userId);
}
