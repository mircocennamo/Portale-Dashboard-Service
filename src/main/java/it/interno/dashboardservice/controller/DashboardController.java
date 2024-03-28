package it.interno.dashboardservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.interno.dashboardservice.dto.ConteggioDto;
import it.interno.dashboardservice.dto.DettaglioDto;
import it.interno.dashboardservice.dto.ResponseDto;
import it.interno.dashboardservice.service.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DashboardController {


    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @Operation(summary = "API per recuperare il conteggio delle discrepanze")
    @GetMapping("/conteggio")
    public ResponseEntity<ResponseDto<List<ConteggioDto>>> conteggioDiscrepanze(){
        return ResponseEntity.ok(ResponseDto.<List<ConteggioDto>>builder().code(HttpStatus.OK.value()).body(dashboardService.conteggioDiscrepanze()).build());
    }

    @Operation(summary = "API per recuperare il dettaglio del conteggio")
    @GetMapping("/dettaglio-conteggio")
    public ResponseEntity<ResponseDto<List<DettaglioDto>>> dettaglioConteggio(@RequestParam Long idConteggio){
        return ResponseEntity.ok(ResponseDto.<List<DettaglioDto>>builder().code(HttpStatus.OK.value()).body(dashboardService.dettaglioConteggio(idConteggio)).build());
    }
}
