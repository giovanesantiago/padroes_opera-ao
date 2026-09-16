# Command — Controle Remoto de Automação Residencial

## Conceito

O **Command** é um padrão de projeto comportamental (categoria Operação) que **encapsula uma solicitação como um objeto**. Isso permite parametrizar quem invoca a ação com diferentes comandos, enfileirar/logar execuções e, principalmente, suportar **desfazer** (undo) — já que o próprio comando sabe como reverter o que fez.

Três papéis ficam claros no padrão: o **invocador** (quem dispara o comando, sem saber o que ele faz), o **comando** (objeto que encapsula a ação e sabe como desfazê-la) e o **receptor** (o objeto real que sofre a ação).

## Problema simulado

Um controle remoto universal de automação residencial precisa acionar dispositivos diferentes (**Luz** e **Ar-condicionado**) sem conhecer os detalhes de cada um, e ainda permitir desfazer a última ação executada.

Sem o Command, o controle remoto precisaria de métodos específicos para cada dispositivo/ação (`ligarLuz()`, `desligarLuz()`, `ligarAr()`...) e uma lógica própria para saber como reverter cada uma. Com o padrão, cada ação vira um objeto `Comando` independente, e o controle só sabe executar e desfazer o último comando guardado.

## Como o código aplica o padrão

- [`Comando`](src/Comando.java) — interface que define o contrato `executar()` / `desfazer()`.
- [`Luz`](src/Luz.java) e [`ArCondicionado`](src/ArCondicionado.java) — os **receptores**: dispositivos reais com `ligar()`/`desligar()`, sem qualquer conhecimento do padrão.
- [`ComandoLigarLuz`](src/ComandoLigarLuz.java), [`ComandoDesligarLuz`](src/ComandoDesligarLuz.java), [`ComandoLigarAr`](src/ComandoLigarAr.java), [`ComandoDesligarAr`](src/ComandoDesligarAr.java) — **comandos concretos**: cada um encapsula uma ação sobre um receptor e sabe como revertê-la.
- [`ControleRemoto`](src/ControleRemoto.java) — o **invocador**: executa o comando recebido em `pressionarBotao()` e guarda como último, permitindo desfazê-lo em `pressionarDesfazer()`, sem conhecer os dispositivos por trás.
- [`Main`](src/Main.java) — demonstra ligar a luz, ligar o ar-condicionado, desligar a luz e depois desfazer a última ação (religando a luz).

## Como compilar e executar

```bash
cd src
javac *.java
java Main
```

## Saída esperada

```
=== Ligando a luz ===
Luz ligada.

=== Ligando o ar-condicionado ===
Ar-condicionado ligado.

=== Desligando a luz ===
Luz desligada.

=== Desfazendo a ultima acao (deveria ligar a luz de novo) ===
Luz ligada.
```
