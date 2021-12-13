package br.com.guilhermefausto.cursonelioalvesspringmongo.resources;

import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1","Maria Brown","maria@gmail.com");
        User alex = new User("2","Alex Green","alex@gmail.com");
        User john = new User("3","John Red","john@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria,alex,john));
        return ResponseEntity.ok().body(list);
    }
}
