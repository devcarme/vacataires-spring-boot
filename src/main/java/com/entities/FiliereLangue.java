package com.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class FiliereLangue {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String codeFiliereLangue;
    private String nomFiliereLangue;

}
