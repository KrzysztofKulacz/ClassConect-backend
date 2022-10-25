package com.example.classconectbackend;

import com.example.classconectbackend.domain.Group;
import com.example.classconectbackend.domain.Post;
import com.example.classconectbackend.domain.User;
import com.example.classconectbackend.repository.GroupRepository;
import com.example.classconectbackend.repository.PostRepository;
import com.example.classconectbackend.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.UUID;

@SpringBootApplication
public class ClassConectBackendApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ClassConectBackendApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);
        GroupRepository groupRepository = context.getBean(GroupRepository.class);
        PostRepository postRepository = context.getBean(PostRepository.class);

        User user = new User("kristof", "1234", "kk@com");
        userRepository.save(user);
        Group group = new Group("math", "2121");
        groupRepository.save(group);
        Post post = new Post(group, user, "Algebra", "to jest tekst testowy. Zobaczymy czy zadziała");
        postRepository.save(post);
        user.addGroup(group);


        user.addPost(post);
        userRepository.save(user);

        group.addPost(post);
        groupRepository.save(group);
    }

}
