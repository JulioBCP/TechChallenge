package com.fiap.techchallenge.carrental.aluguel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.techchallenge.carrental.aluguel.entity.Contrato;


@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> { 

}