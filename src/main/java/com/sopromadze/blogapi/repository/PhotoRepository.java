package com.sopromadze.blogapi.repository;

import com.sopromadze.blogapi.model.Photo;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, ObjectId> {
	Page<Photo> findByAlbum(ObjectId album, Pageable pageable);
}
