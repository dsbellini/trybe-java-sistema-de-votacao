package com.betrybe.sistemadevotacao;

import java.util.Objects;
import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {


  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao votacao = new GerenciamentoVotacao();

    String optionCandidato;

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      optionCandidato = scanner.next();

      if ("1".equals(optionCandidato)) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nomeCandidato = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = Integer.parseInt(scanner.next());
        votacao.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
      }
    } while (!"2".equals(optionCandidato));

    String optionEleitor;
    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      optionEleitor = scanner.next();

      if ("1".equals(optionEleitor)) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nomeEleitor = scanner.next();
        System.out.println("Entre com o CPF da pessoa eleitora:");
        String cpfEleitor = scanner.next();
        votacao.cadastrarPessoaEleitora(nomeEleitor, cpfEleitor);
      } else if (!"2".equals(optionEleitor)) {
        System.out.println("Opção inválida. Tente novamente.");
      }

    } while (!"2".equals(optionEleitor));

    String optionVotar;
    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar votação");
      optionVotar = scanner.next();

      if ("1".equals(optionVotar)) {
        System.out.println("Entre com o CPF da pessoa eleitora:");
        String cpfEleitor = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        String numeroCandidato = scanner.next();
        votacao.votar(cpfEleitor, Integer.parseInt(numeroCandidato));
      } else if ("2".equals(optionVotar)) {
        votacao.mostrarResultado();
      } else if ("3".equals(optionVotar)) {
        votacao.mostrarResultado();
        break;
      }
    } while (!"4".equals(optionVotar));
  }
}

