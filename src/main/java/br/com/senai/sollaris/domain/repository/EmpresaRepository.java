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
	
	Optional<Empresa> findBySenha(String senha);
	
	@Query ("SELECT e from Empresa e WHERE e.email = :emailUser and e.senha = :senhaUser")
	Optional<Empresa> login(@Param("emailUser") String emailUser, @Param("senhaUser") String senhaUser);
}
