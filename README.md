# Projeto: Urna Eletrônica Java

Este projeto implementa uma simulação de uma urna eletrônica em Java. O programa permite o registro de votos, contabilização dos votos válidos e nulos, e exibe o resultado final da votação, indicando o vencedor ou um possível empate.

## Classes e Estrutura do Código

#### Classe: `Candidato`
Responsável por armazenar e gerenciar os dados de cada candidato.

#### • Atributos:
` - _nome` (String): Nome do candidato.

` - _numero` (int): Número identificador do candidato.

` - _votos` (int): Total de votos recebidos pelo candidato.

#### • Construtor:
- `Candidato (String nome, int numero)`: Inicializa o nome e o número do candidato. O número de votos é iniciado como 0.

#### • Métodos:
- `getNome()`: Retorna o nome do candidato.
  
- `getNumero()`: Retorna o número identificador do candidato.

- `getVotos()`: Retorna o total de votos recebidos pelo candidato.
  
- `incrementarVotos()`: Incrementa em 1 o número de votos do candidato.

##### Classe: `UrnaEletronicaJava`
Gerencia o funcionamento geral da votação, incluindo registro de votos e apuração de resultados.

#### • Atributos:
- `candidatos` (List<Candidato>): Lista de candidatos disponíveis para votação.

- `votosNulos` (int): Contador de votos nulos.
  
#### • Construtor:
- `UrnaEletronicaJava()`: Inicializa a lista de candidatos com 5 opções e define o contador de votos nulos como 0.
  
#### • Métodos:
- `receberVoto(int numero)`: Registra o voto para o candidato correspondente ao número fornecido ou contabiliza como voto nulo se o número for inválido.

- `apurarResultados()`: Calcula e exibe os resultados da votação, incluindo o total de votos e percentuais de cada candidato.

- `exibirResultados()`: Determina o vencedor (ou empate) com base nos votos e exibe o resultado.

#### Método `main`
Ponto de entrada do programa. Ele:

1. Inicializa o sistema de votação.

2. Exibe a lista de candidatos.
   
3. Permite o registro de 10 votos (com validação de entrada).

4. Exibe os resultados da votação ao final.

## Guia de Configuração do Ambiente
### Pré-requisitos
#### 1. Java Development Kit (JDK):

- Faça o download e instale o JDK 17 ou superior a partir do site oficial da Oracle ou do OpenJDK.
  
- Verifique a instalação no terminal:

```bash  
java -version
```

- A saída deve exibir a versão instalada do Java.

#### 2.  Maven: 
- Baixe e instale o Apache Maven para gerenciar dependências (opcional, mas recomendado).
  
- Verifique a instalação no terminal:
```bash
mvn -version
```
#### 3. Visual Studio Code:
- Baixe o VSCode e instale.
  
- Instale a extensão "Extension Pack for Java" para suporte ao desenvolvimento em Java.

### Configuração do Projeto
#### 1. Clonar o Repositório:
   
- Clone o repositório para a sua máquina:
