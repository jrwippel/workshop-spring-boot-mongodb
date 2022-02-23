package com.jrwsystems.workshopmongo.config;

import com.jrwsystems.workshopmongo.domain.Post;
import com.jrwsystems.workshopmongo.domain.User;
import com.jrwsystems.workshopmongo.dto.AuthorDto;
import com.jrwsystems.workshopmongo.dto.CommentDto;
import com.jrwsystems.workshopmongo.repository.PostRepository;
import com.jrwsystems.workshopmongo.repository.UserRepository;
import org.slf4j.helpers.MarkerIgnoringBase;
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
        userRepository.saveAll(Arrays.asList(jack, jackson, james, puttin, ryan));

        Post post1 = new Post(null, sdf.parse("22/02/2022"), "Partiu para mais uma missão top secret", "Estarei OFF pelos próximos 2 meses", new AuthorDto(jackson));
        Post post2 = new Post(null, sdf.parse("23/02/2022"), "Problemas com agentes infiltrados", "Outro dia normal, seguimos em frente", new AuthorDto(jackson));

        CommentDto c1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDto(jack));
        CommentDto c2 = new CommentDto("Se precisar de ajuda, estou a disposição", sdf.parse("22/03/2018"), new AuthorDto(james));
        CommentDto c3 = new CommentDto("Tenha um ótimo dia! Certeza que não sou eu, rsrs", sdf.parse("23/03/2018"), new AuthorDto(puttin));
        CommentDto c4 = new CommentDto("Obrigado por avisar camarada, rsrs", sdf.parse("24/03/2018"), new AuthorDto(jackson));


        post1.getCommentDtoList().addAll(Arrays.asList(c1, c2));
        post2.getCommentDtoList().addAll(Arrays.asList(c3, c4));
        postRepository.saveAll(Arrays.asList(post1, post2));

        jackson.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(jackson);
    }
}
