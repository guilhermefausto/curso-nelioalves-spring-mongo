package br.com.guilhermefausto.cursonelioalvesspringmongo.dto;

import br.com.guilhermefausto.cursonelioalvesspringmongo.domain.User;

import java.io.Serializable;

public class AuthorDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDto() {
    }

    public AuthorDto(User author) {
        this.id = author.getId();
        this.name = author.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
