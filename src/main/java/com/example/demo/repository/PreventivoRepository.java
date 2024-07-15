package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Preventivo;

@Repository
public interface PreventivoRepository extends JpaRepository<Preventivo, Long> {

}
