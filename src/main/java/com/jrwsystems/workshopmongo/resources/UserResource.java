package com.jrwsystems.workshopmongo.resources;


import com.jrwsystems.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User james = new User("1", "James Bond", "james.bond@mi6.com");
        User jack = new User("2", "Jack Reacher", "jack.reacher@cia.com");
        List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(james, jack));
        return ResponseEntity.ok().body(userList);
    }
}
