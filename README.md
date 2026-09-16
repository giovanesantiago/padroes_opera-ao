# State — Lâmpada Inteligente

## Conceito

O **State** é um padrão de projeto comportamental (categoria Operação) que permite que um objeto **altere seu comportamento quando seu estado interno muda**, dando a impressão de que o objeto mudou de classe. Em vez de concentrar `if/switch` sobre o estado atual espalhados pela classe, cada estado é modelado como uma classe própria, responsável por decidir como reagir e para qual estado transicionar.

O objeto principal (o **contexto**) apenas guarda uma referência ao estado atual e delega a ele toda a lógica de comportamento e transição.

## Problema simulado

Uma lâmpada inteligente de automação residencial tem três estados possíveis:

- **Desligada** — ao pressionar o botão, liga em intensidade normal.
- **Ligada** — ao pressionar o botão, entra em modo noturno (baixa intensidade).
- **Modo Noturno** — ao pressionar o botão, desliga.

O mesmo botão físico (`pressionarBotao()`) produz um efeito diferente dependendo do estado atual da lâmpada. Sem o State, isso exigiria uma variável de estado (enum/int) e um bloco de condicionais checando "se está desligada, faça X; se está ligada, faça Y..." dentro da própria classe `Lampada`, crescendo a cada novo estado.

## Como o código aplica o padrão

- [`EstadoLampada`](src/EstadoLampada.java) — interface que define o contrato de cada estado: `pressionarBotao(Lampada lampada)` e `descricao()`.
- [`EstadoDesligada`](src/EstadoDesligada.java), [`EstadoLigada`](src/EstadoLigada.java), [`EstadoModoNoturno`](src/EstadoModoNoturno.java) — implementações concretas; cada uma sabe seu próprio comportamento e decide o próximo estado chamando `lampada.setEstado(...)`.
- [`Lampada`](src/Lampada.java) — o **contexto**: mantém a referência ao `EstadoLampada` atual e delega `pressionarBotao()` a ele, sem conhecer as regras de transição.
- [`Main`](src/Main.java) — demonstra o botão sendo pressionado repetidamente e a lâmpada ciclando entre os três estados.

## Como compilar e executar

```bash
cd src
javac *.java
java Main
```

## Saída esperada

```
Estado atual: Desligada
Lampada estava desligada -> ligando em intensidade normal.

Estado atual: Ligada
Lampada estava ligada -> entrando em modo noturno.

Estado atual: Modo Noturno
Lampada estava em modo noturno -> desligando.

Estado atual: Desligada
Lampada estava desligada -> ligando em intensidade normal.

Estado final: Ligada
```
