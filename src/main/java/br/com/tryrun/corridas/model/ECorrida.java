package br.com.tryrun.corridas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "corridas")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ECorrida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 100)
    private String nome;

    @NotNull
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @NotNull
    @Size(max = 100)
    private String local;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

}
