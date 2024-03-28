package it.interno.dashboardservice.service;

import it.interno.dashboardservice.dto.ConteggioDto;
import it.interno.dashboardservice.dto.DettaglioDto;

import java.util.List;

public interface DashboardService {

    List<ConteggioDto> conteggioDiscrepanze();

    List<DettaglioDto> dettaglioConteggio(Long idConteggio);
}
