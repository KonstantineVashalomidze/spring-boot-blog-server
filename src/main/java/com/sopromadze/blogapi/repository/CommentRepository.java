package com.sopromadze.blogapi.repository;

import com.sopromadze.blogapi.model.Comment;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, ObjectId> {
	Page<Comment> findByPost(ObjectId post, Pageable pageable);
}
