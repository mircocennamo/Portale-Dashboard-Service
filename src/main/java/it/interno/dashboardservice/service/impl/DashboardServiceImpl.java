package it.interno.dashboardservice.service.impl;

import it.interno.dashboardservice.dto.ConteggioDto;
import it.interno.dashboardservice.dto.DettaglioDto;
import it.interno.dashboardservice.repository.ConfrDbRepository;
import it.interno.dashboardservice.service.DashboardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final ConfrDbRepository confrDbRepository;

    public DashboardServiceImpl(ConfrDbRepository confrDbRepository) {
        this.confrDbRepository = confrDbRepository;
    }


    @Override
    public List<ConteggioDto> conteggioDiscrepanze() {
        return confrDbRepository.conteggioDiscrepanze();
    }

    @Override
    public List<DettaglioDto> dettaglioConteggio(Long idConteggio) {
        return confrDbRepository.dettaglioConteggio(idConteggio);
    }
}
