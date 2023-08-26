package com.lucassmtt.workshopmongodb.config;

import com.lucassmtt.workshopmongodb.domain.Post;
import com.lucassmtt.workshopmongodb.domain.User;
import com.lucassmtt.workshopmongodb.dto.AuthorDTO;
import com.lucassmtt.workshopmongodb.dto.CommentDTO;
import com.lucassmtt.workshopmongodb.repositories.PostRepository;
import com.lucassmtt.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));


        postRepository.deleteAll();
        String body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure " +
                "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";

        Post post01 = new Post(null, sdf.parse("21/03/2018"), "I go to the beach", body, new AuthorDTO(maria));
        Post post02 = new Post(null, sdf.parse("23/03/2018"), "I go to the city", body, new AuthorDTO(maria));
        Post post03 = new Post(null, sdf.parse("23/03/2018"), "I go to the camp", body, new AuthorDTO(bob));
        postRepository.saveAll(Arrays.asList(post01, post02, post03));

        maria.getPosts().addAll(Arrays.asList(post01, post02));
        bob.getPosts().add(post03);
        userRepository.saveAll(Arrays.asList(maria, bob));

        CommentDTO comment001 = new CommentDTO( "Good trip, brother!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO comment002 = new CommentDTO( "Enjoy", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO comment003 = new CommentDTO( "Have a great day", sdf.parse("23/03/2018"), new AuthorDTO(bob));

        post01.getComments().addAll(Arrays.asList(comment001, comment002));
        post02.getComments().add(comment003);
        postRepository.saveAll(Arrays.asList(post01, post02, post03));
    }
}
