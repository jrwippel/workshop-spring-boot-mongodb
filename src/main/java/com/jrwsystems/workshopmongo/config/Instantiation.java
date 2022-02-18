package com.jrwsystems.workshopmongo.config;

import com.jrwsystems.workshopmongo.domain.User;
import com.jrwsystems.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        User jackson = new User(null, "Jackson Ricardo Wippel", "jackson.wippel@abin.com.br");
        User james = new User(null, "James Bond", "james.bond@mi6.com.uk");
        User jack = new User(null, "Jack Reacher", "jack.reacher@cia.com.us");
        User puttin = new User(null, "Vladmir Puttin", "vladmir.puttin@kgb.com.ru");
        User ryan = new User(null, "Jack Ryan", "jack.ryan@cia.com.us");

        userRepository.saveAll(Arrays.asList(jack, jackson, james, puttin, ryan));
    }
}
