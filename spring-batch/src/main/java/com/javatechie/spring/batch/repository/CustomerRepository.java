package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.Deportista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Deportista,Integer> {
}
