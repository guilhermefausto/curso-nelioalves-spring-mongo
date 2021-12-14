package br.com.guilhermefausto.cursonelioalvesspringmongo.config;

import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.Post;
import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.User;
import br.com.guilhermefausto.cursonelioalvesspringmongo.dto.AuthorDto;
import br.com.guilhermefausto.cursonelioalvesspringmongo.repository.PostRepository;
import br.com.guilhermefausto.cursonelioalvesspringmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

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

        User maria = new User(null,"Maria Brown","maria@gmail.com");
        User alex = new User(null,"Alex Green","alex@gmail.com");
        User bob = new User(null,"Bob Grey","bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null, sdf.parse("21/03/2021"),"Partiu Viagem","Vou viajar para São Paulo", new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("28/03/2021"),"Bom dia","Hoje eu acordei feliz", new AuthorDto(maria));

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);
    }
}
