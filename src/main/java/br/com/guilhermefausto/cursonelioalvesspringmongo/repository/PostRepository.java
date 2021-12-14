package br.com.guilhermefausto.cursonelioalvesspringmongo.repository;

import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
