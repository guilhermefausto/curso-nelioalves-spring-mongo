package br.com.guilhermefausto.cursonelioalvesspringmongo.repository;

import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    //Optional<User> findOne(String id);
}
