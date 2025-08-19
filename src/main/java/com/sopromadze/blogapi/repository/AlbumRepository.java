package com.sopromadze.blogapi.repository;

import com.sopromadze.blogapi.model.Album;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends MongoRepository<Album, ObjectId> {
	Page<Album> findByCreatedBy(ObjectId userId, Pageable pageable);
}
