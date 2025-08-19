package com.sopromadze.blogapi.repository;

import com.sopromadze.blogapi.model.Todo;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, ObjectId> {
	Page<Todo> findByCreatedBy(ObjectId userId, Pageable pageable);
}
