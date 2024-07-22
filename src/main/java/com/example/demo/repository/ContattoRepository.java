package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Contatto;

public interface ContattoRepository extends JpaRepository<Contatto, Long> {
} 
