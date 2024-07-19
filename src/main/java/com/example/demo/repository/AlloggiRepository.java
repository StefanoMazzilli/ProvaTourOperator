package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Alloggi;

@Repository
public interface AlloggiRepository extends JpaRepository<Alloggi, Long> {
	List<Alloggi> findAllBydestinazione_id(Long destinazione_id);
}
