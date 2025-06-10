package br.com.tryrun.corridas.dto;

import br.com.tryrun.corridas.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CorridaDto {
    private long id;
    private String nome;
    private LocalDate data;
    private String local;
    private Status status;
}

