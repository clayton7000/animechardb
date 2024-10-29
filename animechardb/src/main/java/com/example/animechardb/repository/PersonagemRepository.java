package com.example.animechardb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.animechardb.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Integer>{
    
}
