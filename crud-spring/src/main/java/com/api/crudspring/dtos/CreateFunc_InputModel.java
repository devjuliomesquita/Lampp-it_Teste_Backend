package com.api.crudspring.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFunc_InputModel {
  @NotBlank
  @Schema(example = "Júlio César de Mesquita Camilo Martins")
  private String nome;
  @NotBlank
  @Size(max = 11, min = 11)
  @Schema(example = "12345678912")
  private String cpf;
  @NotBlank
  @Schema(example = "Desenvolvedor Treinee")
  private String cargo;
  // @NotEmpty
  @Schema(example = "500000")
  private Integer salario;
}
