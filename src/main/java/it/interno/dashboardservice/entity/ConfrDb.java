package it.interno.dashboardservice.entity;

import it.interno.dashboardservice.dto.DettaglioDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CONFRDB", schema = "SSD_SECURITY")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NamedNativeQuery(name = "query_dettaglio_conteggio",
                  query = "SELECT DISTINCT chiave " +
                          ",FIRST_VALUE(VALORE)OVER(PARTITION BY CHIAVE ORDER BY DECODE(DB,'ORA',0,1)) valore_1 " +
                          ",DECODE(TIPO_CONFRONTO,'CORRISPONDENZA',FIRST_VALUE(VALORE)OVER(PARTITION BY CHIAVE ORDER BY DECODE(DB,'SDI',0,1)),NULL) valore_2 " +
                          "FROM (SELECT TIPO_CONFRONTO,NVL(A.DB,B.DB)DB  " +
                          ",DECODE(PARS.ATTRIBUTO_CHIAVE,'ID_CONTEGGIO',to_char(A.ID_CONTEGGIO),'DB',to_char(A.DB),'ID_UTE',to_char(A.ID_UTE),'NOME',to_char(A.NOME),'COGN',to_char(A.COGN),'C_FISC',to_char(A.C_FISC),'D_NAS',to_char(A.D_NAS),'DES_LUO',to_char(A.DES_LUO),'ID_CONTEGGIO',to_char(B.ID_CONTEGGIO),'DB',to_char(B.DB),'C_UFF_SEGN',to_char(B.C_UFF_SEGN),'ID_UTE_CMD',to_char(B.ID_UTE_CMD),'T_FOR_POL',to_char(B.T_FOR_POL),'DES_UFF_SEGN',to_char(B.DES_UFF_SEGN),'NOME_COMANDANTE',to_char(B.NOME_COMANDANTE),'D_REG_CAN',to_char(B.D_REG_CAN),'D_INI_VAL',to_char(B.D_INI_VAL),'D_FIN_VAL',to_char(B.D_FIN_VAL),1) CHIAVE " +
                          ",DECODE(PARS.ATTRIBUTO_CONFRONTATO,'ID_CONTEGGIO',to_char(A.ID_CONTEGGIO),'DB',to_char(A.DB),'ID_UTE',to_char(A.ID_UTE),'NOME',to_char(A.NOME),'COGN',to_char(A.COGN),'C_FISC',to_char(A.C_FISC),'D_NAS',to_char(A.D_NAS),'DES_LUO',to_char(A.DES_LUO),'ID_CONTEGGIO',to_char(B.ID_CONTEGGIO),'DB',to_char(B.DB),'C_UFF_SEGN',to_char(B.C_UFF_SEGN),'ID_UTE_CMD',to_char(B.ID_UTE_CMD),'T_FOR_POL',to_char(B.T_FOR_POL),'DES_UFF_SEGN',to_char(B.DES_UFF_SEGN),'NOME_COMANDANTE',to_char(B.NOME_COMANDANTE),'D_REG_CAN',to_char(B.D_REG_CAN),'D_INI_VAL',to_char(B.D_INI_VAL),'D_FIN_VAL',to_char(B.D_FIN_VAL),1) VALORE " +
                          "FROM SSD_SECURITY.CONFRDB PARS " +
                          ",SSD_SECURITY.V_CONFRDB_UTE A " +
                          ",SSD_SECURITY.V_CONFRDB_UFF B " +
                          "WHERE A.ID_CONTEGGIO (+) = PARS.ID_CONTEGGIO " +
                          "AND B.ID_CONTEGGIO (+) = PARS.ID_CONTEGGIO  " +
                          "AND (A.ID_CONTEGGIO IS NOT NULL OR B.ID_CONTEGGIO IS NOT NULL) " +
                          "AND PARS.ID_CONTEGGIO = :idConteggio)", resultSetMapping = "resultSet_dettaglioConteggio")
@SqlResultSetMapping(name = "resultSet_dettaglioConteggio",
                     classes = @ConstructorResult(
                             targetClass = DettaglioDto.class,
                             columns = {
                                   @ColumnResult(name = "chiave", type = String.class),
                                   @ColumnResult(name = "valore_1", type = String.class),
                                   @ColumnResult(name = "valore_2",type = String.class)
                             }
                     ))
public class ConfrDb implements Serializable {

    private static final long serialVersionUID = 8333808738641905866L;

    @Id
    @Column(name = "ID_CONTEGGIO", length = 38)
    Long idConteggio;

    @Column(name = "AMBITO", length = 250)
    String ambito;

    @Column(name = "TIPO_CONFRONTO", length = 250)
    String tipoConfronto;

    @Column(name = "DESCRIZIONE", length = 1000)
    String descrizione;

    @Column(name = "VISTA_INTERESSATA", length = 250)
    String vistaInteressata;

    @Column(name = "ATTRIBUTO_CHIAVE", length = 250)
    String attributoChiave;

    @Column(name = "ATTRIBUTO_CONFRONTATO", length = 250)
    String attributoConfrontato;
}
