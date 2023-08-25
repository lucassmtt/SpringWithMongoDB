package com.lucassmtt.workshopmongodb.repositories;

import com.lucassmtt.workshopmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContaining(String text);

    @Query("{ 'title':  { $regex: ?0, $options: 'i' } }")
    List<Post> searchByTitleWithQuery(String text);
}
