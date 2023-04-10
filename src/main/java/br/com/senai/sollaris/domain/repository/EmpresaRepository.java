package br.com.senai.sollaris.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senai.sollaris.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	Optional<Empresa> findByEmail(String email);
	
	Optional<Empresa> findByCnpj(String cnpj);
	
	@Query ("SELECT e from Empresa e WHERE e.email = :emailBusiness and e.senha = :senhaBusiness")
	Optional<Empresa> login(@Param("emailBusiness") String emailBusiness, @Param("senhaBusiness") String senhaBusiness);
}	
