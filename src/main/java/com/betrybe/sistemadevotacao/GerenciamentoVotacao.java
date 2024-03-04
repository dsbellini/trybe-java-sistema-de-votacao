package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private final ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private final ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private final ArrayList<String> cpfsComputados = new ArrayList<>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean numeroUtilizado = false;

    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.numero == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        numeroUtilizado = true;
        break;
      }
    }

    if (!numeroUtilizado) {
      PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(pessoaCandidata);
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean cpfCadastrado = false;

    for (PessoaEleitora pessoa : pessoasEleitoras) {
      if (Objects.equals(pessoa.getCpf(), cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        cpfCadastrado = true;
        break;
      }
    }

    if (!cpfCadastrado) {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(pessoaEleitora);
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean alreadyVoted = cpfsComputados.contains(cpfPessoaEleitora);

    if (alreadyVoted) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      boolean findPessoaCandidata = pessoasCandidatas.stream()
          .anyMatch(pessoa -> pessoa.getNumero() == numeroPessoaCandidata);

      if (findPessoaCandidata) {
        pessoasCandidatas.stream()
            .filter(pessoa -> pessoa.getNumero() == numeroPessoaCandidata)
            .forEach(PessoaCandidata::receberVoto);

        cpfsComputados.add(cpfPessoaEleitora);
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      int totalVotos = cpfsComputados.size();
      for (PessoaCandidata pessoa : pessoasCandidatas) {
        int uniqueVote = pessoa.getVotos();
        int porcentagem = Math.round(((float) uniqueVote / totalVotos) * 100);

        String resultado = String.format(
            "Nome: %s - %d votos ( %s )",
            pessoa.getNome(),
            uniqueVote,
            porcentagem
        );
        System.out.println(resultado);
      }
      System.out.println("Total de votos: " + totalVotos);
    }
  }
}
