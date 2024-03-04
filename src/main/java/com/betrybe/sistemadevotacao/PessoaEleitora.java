package com.betrybe.sistemadevotacao;

/**
 * The type Pessoa eleitora.
 */
public class PessoaEleitora extends Pessoa {

  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    this.cpf = cpf;
    this.nome = nome;
  }
  
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
