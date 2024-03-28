package it.interno.dashboardservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConteggioDto {

    Long idConteggio;
    String ambito;
    String tipoConfronto;
    String descrizione;
    String vistaInteressata;
    String attributoChiave;
    String attributoConfrontato;
    Long conteggio;
}
