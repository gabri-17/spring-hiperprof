package br.com.treinaweb.hyperprof.core.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.hyperprof.core.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    boolean existsByEmail(String email);
    Optional<Professor> findByEmail(String email);
    // Método que faz uma busca do tipo LIKE (verificar se estar contido).
    List<Professor> findByDescricaoContaining(String descricao);

}
