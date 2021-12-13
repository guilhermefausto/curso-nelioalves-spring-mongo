package br.com.guilhermefausto.cursonelioalvesspringmongo.services;

import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.User;
import br.com.guilhermefausto.cursonelioalvesspringmongo.repository.UserRepository;
import br.com.guilhermefausto.cursonelioalvesspringmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> optional = repo.findById(id);
        if(optional.isEmpty()){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return optional.get();
    }
}
