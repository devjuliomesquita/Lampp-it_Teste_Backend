package com.api.crudspring.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_Funcionarios")
@Getter
@Setter
public class Funcionario implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @Column(nullable = false, length = 50)
  private String nome;
  @Column(nullable = false, unique = true, length = 11)
  private String cpf;
  @Column(nullable = false, length = 30)
  private String cargo;
  @Column(nullable = false, length = 10)
  private Integer salario; // Salário em centavos
  @Column(nullable = false)
  private LocalDateTime createdAt;
}
