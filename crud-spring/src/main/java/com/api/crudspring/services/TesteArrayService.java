package com.api.crudspring.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.crudspring.dtos.TesteArray_InputModel;

@Service
public class TesteArrayService {
  public Boolean TestandoArray(TesteArray_InputModel inputModel) {
    var resposta = true;
    List<String> palavrasOrder = new ArrayList<>();
    palavrasOrder.addAll(inputModel.getPalavras());
    palavrasOrder.sort(Comparator.comparing(t -> t.toString()));
    for (int i = 0; i < palavrasOrder.size(); i++) {
      if (palavrasOrder.get(i) != inputModel.getPalavras().get(i)) {
        return false;
      }
    }
    return resposta;
  }
}
