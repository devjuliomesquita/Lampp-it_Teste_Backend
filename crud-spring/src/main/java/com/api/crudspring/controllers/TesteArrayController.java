package com.api.crudspring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crudspring.dtos.TesteArray_InputModel;
import com.api.crudspring.services.TesteArrayService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/testeArray")
public class TesteArrayController {

  private final TesteArrayService testeArrayService;

  public TesteArrayController(TesteArrayService testeArrayService) {
    this.testeArrayService = testeArrayService;
  }

  @PostMapping
  @Operation(summary = "Informar um Array de Strings.", description = "Retorno True ou False para a ordenação da sequência.")
  @ApiResponse(responseCode = "202", description = "Valores aceitos.")
  @ApiResponse(responseCode = "400", description = "Valores informado não estão na forma de Array.")
  public ResponseEntity<String> TesteArrayByOrder(@RequestBody TesteArray_InputModel inputModel) {
    var resposta = testeArrayService.TestandoArray(inputModel);
    if (resposta) {
      return ResponseEntity.status(HttpStatus.ACCEPTED).body("True: Lista informada está em ordem alfabética.");
    }
    return ResponseEntity.status(HttpStatus.ACCEPTED).body("False: Lista informada não está em ordem alfabética.");
  }
}
