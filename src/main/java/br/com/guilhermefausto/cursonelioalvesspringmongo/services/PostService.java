package br.com.guilhermefausto.cursonelioalvesspringmongo.services;

import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.Post;
import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.User;
import br.com.guilhermefausto.cursonelioalvesspringmongo.dto.UserDto;
import br.com.guilhermefausto.cursonelioalvesspringmongo.repository.PostRepository;
import br.com.guilhermefausto.cursonelioalvesspringmongo.repository.UserRepository;
import br.com.guilhermefausto.cursonelioalvesspringmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> optional = repo.findById(id);
        if(optional.isEmpty()){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return optional.get();
    }

    public List<Post> findByTitle(String text){
        //return repo.findByTitleContainingIgnoreCase(text);
        return repo.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text,minDate,maxDate);
    }
}
