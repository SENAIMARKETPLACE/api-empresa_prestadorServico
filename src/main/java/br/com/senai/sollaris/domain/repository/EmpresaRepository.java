package br.com.senai.sollaris.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.sollaris.domain.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
