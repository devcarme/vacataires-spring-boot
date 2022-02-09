package com.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class CreneauDto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateHeure;
    private Integer duree;

    @Enumerated(EnumType.ORDINAL)
    private TypeCreneau type;

}
