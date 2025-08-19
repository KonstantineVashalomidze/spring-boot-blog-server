package com.sopromadze.blogapi.repository;

import com.sopromadze.blogapi.model.user.Company;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company, ObjectId> {

}
