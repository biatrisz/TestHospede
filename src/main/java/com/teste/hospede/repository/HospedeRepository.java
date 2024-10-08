package com.teste.hospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.hospede.entitie.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long>{

}
