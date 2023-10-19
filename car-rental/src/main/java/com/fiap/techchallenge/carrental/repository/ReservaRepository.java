package com.fiap.techchallenge.carrental.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.techchallenge.carrental.entity.Reserva;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> { 

}