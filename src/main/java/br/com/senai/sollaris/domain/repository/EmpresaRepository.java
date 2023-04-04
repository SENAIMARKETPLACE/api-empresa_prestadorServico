package br.com.senai.sollaris.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.sollaris.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
