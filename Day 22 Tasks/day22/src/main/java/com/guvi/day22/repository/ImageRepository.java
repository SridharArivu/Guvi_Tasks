package com.guvi.day22.repository;

import com.guvi.day22.entity.ImageData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends MongoRepository<ImageData, ObjectId> {
    Optional<ImageData> findByEmail (String fileName);
}
