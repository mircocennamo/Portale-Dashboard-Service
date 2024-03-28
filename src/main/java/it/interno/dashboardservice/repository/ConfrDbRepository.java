package it.interno.dashboardservice.repository;

import it.interno.dashboardservice.dto.ConteggioDto;
import it.interno.dashboardservice.dto.DettaglioDto;
import it.interno.dashboardservice.entity.ConfrDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConfrDbRepository extends JpaRepository<ConfrDb, Long> {


    @Query(value = "SELECT new it.interno.dashboardservice.dto.ConteggioDto(a.idConteggio, a.ambito, a.tipoConfronto, " +
                                                                  "a.descrizione, a.vistaInteressata, a.attributoChiave, a.attributoConfrontato, b.conteggio) " +
                   "FROM ConfrDb a, VConfrDbConteggio b WHERE a.idConteggio = b.idConteggio")
    List<ConteggioDto> conteggioDiscrepanze();

    @Query(name = "query_dettaglio_conteggio", nativeQuery = true)
    List<DettaglioDto> dettaglioConteggio(@Param("idConteggio")Long idConteggio);
}