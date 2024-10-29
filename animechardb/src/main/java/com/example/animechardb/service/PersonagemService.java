package com.example.animechardb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.animechardb.model.Personagem;
import com.example.animechardb.repository.PersonagemRepository;

@Service
public class PersonagemService {
    @Autowired
    private PersonagemRepository repository;
    
    public List<Personagem> getAll() {
        return repository.findAll();
    }
    public Personagem getById(int id){
        return repository.findById(id).orElse(null);
    }
    public Personagem insert(Personagem personagem){
        return repository.save(personagem);
    }
    public Personagem update(int id, Personagem personagemAtualizado){

        Optional<Personagem> optionalPersonagem = repository.findById(id);

        return optionalPersonagem.map(personagemExistente ->{
            BeanUtils.copyProperties(personagemAtualizado, personagemExistente,"id");
            return repository.save(personagemExistente);
        }).orElse(null);
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
