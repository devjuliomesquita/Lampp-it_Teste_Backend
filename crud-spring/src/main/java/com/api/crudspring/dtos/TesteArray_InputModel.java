package com.api.crudspring.dtos;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TesteArray_InputModel {
  @Schema(description = "Lista de Palavras")
  private List<String> palavras;
}
