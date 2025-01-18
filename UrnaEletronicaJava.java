import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Candidato {
    private String _nome;
    private int _numero, _votos;

    public Candidato(String nome, int numero) {
        this._nome = nome;
        this._numero = numero;
        this._votos = 0;
    }

    public String getNome() {
        return this._nome;
    }

    public int getNumero() {
        return this._numero;
    }

    public int getVotos() {
        return this._votos;
    }

    public void incrementarVotos() {
        this._votos++;
    }
}

public class UrnaEletronicaJava {
    private List<Candidato> candidatos;
    private int votosNulos;

    public UrnaEletronicaJava() {
        candidatos = new ArrayList<>();
        candidatos.add(new Candidato("Ada Lovelace", 1));
        candidatos.add(new Candidato("Alan Turing", 2));
        candidatos.add(new Candidato("Marie Curie", 3));
        candidatos.add(new Candidato("Albert Einstein", 4));
        candidatos.add(new Candidato("Ludwig Van Beethoven", 5));
        votosNulos = 0;
    }

    public void receberVoto(int numero) {
        boolean votoValido = false;
        for (Candidato candidato : candidatos) {
            if (candidato.getNumero() == numero) {
                candidato.incrementarVotos();
                votoValido = true;
                System.out.println(" Voto registrado para: " + candidato.getNome() + "\n");
                break;
            }
        }
        if (!votoValido) {
            votosNulos++;
            System.out.println(" Voto Nulo Registrado!\n");
        }
    }

    public void apurarResultados() {
        System.out.println(" Resultado da Votação:\n");
        int totalVotosValidos = candidatos.stream().mapToInt(Candidato::getVotos).sum();
        for (Candidato candidato : candidatos) {
            int votos = candidato.getVotos();
            double percentual = totalVotosValidos > 0 ? (votos * 100.0 / totalVotosValidos) : 0;
            System.out.printf(" %s : %d votos (%.2f%%)%n", candidato.getNome(), votos, percentual);
        }
        System.out.println(" Votos Nulos: " + votosNulos);
        exibirResultados();
    }

    private void exibirResultados() {
        List<Candidato> vencedores = new ArrayList<>();
        int maxVotos = 0;
        for (Candidato candidato : candidatos) {
            if (candidato.getVotos() > maxVotos) {
                maxVotos = candidato.getVotos();
                vencedores.clear();
                vencedores.add(candidato);
            } else if (candidato.getVotos() == maxVotos) {
                vencedores.add(candidato);
            }
        }
        if (vencedores.size() == 1) {
            System.out.println(" Vencedor: " + vencedores.get(0).getNome());
        } else {
            System.out.println(" Houve um empate entre os seguintes candidatos:\n");
            for (Candidato vencedor : vencedores) {
                System.out.println(" - " + vencedor.getNome());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UrnaEletronicaJava urna = new UrnaEletronicaJava();
        System.out.println(" Bem-Vindos à Urna Eletrônica!\n");
        System.out.println(" Candidatos:\n");
        System.out.println(" 01 - Ada Lovelace");
        System.out.println(" 02 - Alan Turing");
        System.out.println(" 03 - Marie Curie");
        System.out.println(" 04 - Albert Einstein");
        System.out.println(" 05 - Ludwig van Beethoven\n");

        int votosRegistrados = 0;
        while (votosRegistrados < 10) {
            System.out.print(" Digite o número do seu candidato (exemplo: 01, 02, ...): \n");
            try {
                String entrada = sc.nextLine().trim();

                // Verificar se a entrada tem exatamente 2 dígitos
                if (entrada.matches("\\d{2}")) {
                    int numero = Integer.parseInt(entrada);
                    urna.receberVoto(numero);
                    votosRegistrados++;
                } else {
                    System.out.println(" Entrada inválida. Digite um número válido no formato 01, 02, etc.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Digite um número válido no formato 01, 02, etc.\n");
            }
        }
        urna.apurarResultados();
        sc.close();
    }
}

		