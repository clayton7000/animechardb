package com.example.animechardb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.animechardb.model.Personagem;
import com.example.animechardb.service.PersonagemService;

@RestController
@RequestMapping(path="/")
public class PersonagemController {

    @Autowired
    private PersonagemService service;

    @GetMapping
    public List<Personagem> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Personagem getById(@PathVariable int id){
        return service.getById(id);
    }
    @PostMapping
    public Personagem insert(@RequestBody Personagem personagem){
        return service.insert(personagem);
    }
    @PutMapping("/{id}")
    public Personagem update(@RequestBody Personagem personagem, @PathVariable int id){
        return service.update(id, personagem);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
