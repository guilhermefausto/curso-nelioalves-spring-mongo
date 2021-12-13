package br.com.guilhermefausto.cursonelioalvesspringmongo.services;

import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.User;
import br.com.guilhermefausto.cursonelioalvesspringmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
}
