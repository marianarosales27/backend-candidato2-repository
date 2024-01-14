package com.candidato.backendcandidato.repository;
import com.candidato.backendcandidato.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    @Query("SELECT c FROM Candidato c")
    List<Candidato> finCandidatos();

    Candidato getReferenceById(Long id);

    Candidato save(Candidato candidato);

    void deleteById(Long id);

}