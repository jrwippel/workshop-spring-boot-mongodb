package com.jrwsystems.workshopmongo.config;

import com.jrwsystems.workshopmongo.domain.Post;
import com.jrwsystems.workshopmongo.domain.User;
import com.jrwsystems.workshopmongo.repository.PostRepository;
import com.jrwsystems.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
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

        postRepository.deleteAll();

        User jackson = new User(null, "Jackson Ricardo Wippel", "jackson.wippel@abin.com.br");
        User james = new User(null, "James Bond", "james.bond@mi6.com.uk");
        User jack = new User(null, "Jack Reacher", "jack.reacher@cia.com.us");
        User puttin = new User(null, "Vladmir Puttin", "vladmir.puttin@kgb.com.ru");
        User ryan = new User(null, "Jack Ryan", "jack.ryan@cia.com.us");

        Post post1 = new Post(null, sdf.parse("22/02/2022"), "Partiu Gabiroba", "Vou para Vitor com a familia", jackson);
        Post post2 = new Post(null, sdf.parse("23/02/2022"), "Café da manhã", "Começando o dia super bem", jackson);

        userRepository.saveAll(Arrays.asList(jack, jackson, james, puttin, ryan));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
