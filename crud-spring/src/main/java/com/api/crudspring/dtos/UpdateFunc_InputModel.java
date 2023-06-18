package com.api.crudspring.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateFunc_InputModel {
  @NotBlank
  private String nome;
  @NotBlank
  @Size(max = 11, min = 11)
  private String cpf;
  @NotBlank
  private String cargo;
}
