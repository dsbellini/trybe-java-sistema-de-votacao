package com.betrybe.sistemadevotacao;

/**
 * The type Pessoa candidata.
 */
public class PessoaCandidata extends Pessoa {

  /**
   * The Numero.
   */
  int numero;
  /**
   * The Votos.
   */
  int votos;

  /**
   * Gets numero.
   *
   * @return the numero
   */
  public int getNumero() {
    return numero;
  }

  /**
   * Sets numero.
   *
   * @param numero the numero
   */
  public void setNumero(int numero) {
    this.numero = numero;
  }

  /**
   * Gets votos.
   *
   * @return the votos
   */
  public int getVotos() {
    return votos;
  }

  /**
   * Receber voto.
   */
  public void receberVoto() {
    votos++;
  }

  /**
   * Instantiates a new Pessoa candidata.
   *
   * @param nome   the nome
   * @param numero the numero
   */
  public PessoaCandidata(String nome, int numero) {
    this.votos = 0;
    this.numero = numero;
    this.nome = nome;
  }
}
