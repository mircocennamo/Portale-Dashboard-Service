package it.interno.dashboardservice.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "V_CONFRDB_CONTEGGI", schema = "SSD_SECURITY")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VConfrDbConteggio implements Serializable {

    private static final long serialVersionUID = 5723308185387039385L;

    @Id
    @Column(name = "ID_CONTEGGIO", length = 38)
    Long idConteggio;

    @Column(name = "CONTEGGIO", length = 38)
    Long conteggio;
}
