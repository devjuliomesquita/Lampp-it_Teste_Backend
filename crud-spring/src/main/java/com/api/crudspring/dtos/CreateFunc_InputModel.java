package com.api.crudspring.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFunc_InputModel {
  @NotBlank
  private String nome;
  @NotBlank
  @Size(max = 11, min = 11)
  private String cpf;
  @NotBlank
  private String cargo;
  // @NotEmpty
  private Integer salario;
}
