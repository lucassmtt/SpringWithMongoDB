package com.lucassmtt.workshopmongodb.repositories;

import com.lucassmtt.workshopmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContaining(String text);

    @Query("{ 'title':  { $regex: ?0, $options: 'i' } }")
    List<Post> searchByTitleWithQuery(String text);


    // This search is a query that searches for the text of the post, which can be in the title, body or comments.
    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, " +
            "{ 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> searchWithMultipleParam(String textThatWillBeSearch, Date minDate, Date maxDate);
}
