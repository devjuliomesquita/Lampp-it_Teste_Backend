package com.api.crudspring.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crudspring.dtos.TesteArray_InputModel;

@RestController
@RequestMapping("/api/testeArray")
public class TesteArrayController {
  @PostMapping
  public Boolean TesteArrayByOrder(@RequestBody TesteArray_InputModel inputModel) {
    List<String> palavrasOrder = new ArrayList<>();
    palavrasOrder.addAll(inputModel.getPalavras());

    var resposta = false;
    for (int i = 0; i < palavrasOrder.size(); i++) {
      if (palavrasOrder.get(i) == inputModel.getPalavras().get(i)) {
        resposta = true;
      }
    }
    return resposta;
  }
}
