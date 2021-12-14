package br.com.guilhermefausto.cursonelioalvesspringmongo.resources;

import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.Post;
import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.User;
import br.com.guilhermefausto.cursonelioalvesspringmongo.dto.UserDto;
import br.com.guilhermefausto.cursonelioalvesspringmongo.resources.util.URL;
import br.com.guilhermefausto.cursonelioalvesspringmongo.services.PostService;
import br.com.guilhermefausto.cursonelioalvesspringmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
