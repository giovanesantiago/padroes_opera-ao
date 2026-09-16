# Interpreter — Calculadora de Expressões

## Conceito

O **Interpreter** é um padrão de projeto comportamental (categoria Operação) que, dada uma **gramática simples**, define uma representação para suas regras (uma árvore de expressões) e um **interpretador** capaz de avaliar sentenças escritas nessa gramática. Cada regra da gramática vira uma classe: expressões **terminais** (não dependem de outras expressões) e expressões **não-terminais** (combinam o resultado de subexpressões).

## Problema simulado

Uma calculadora precisa avaliar expressões de texto com soma e subtração, como `"5 + 3 - 2"`. A gramática é mínima: números inteiros e os operadores `+` e `-`, lidos da esquerda para a direita.

Sem o Interpreter, essa avaliação viraria um parsing manual e imperativo (variáveis acumulando resultado enquanto percorre a string). Com o padrão, a expressão é transformada em uma **árvore de objetos**, onde cada nó sabe interpretar (avaliar) apenas a sua própria regra, e o resultado final emerge da combinação recursiva desses nós.

## Como o código aplica o padrão

- [`Expressao`](src/Expressao.java) — interface que define o contrato `interpretar()`, comum a toda regra da gramática.
- [`NumeroExpressao`](src/NumeroExpressao.java) — **expressão terminal**: representa um número literal, não depende de mais nada para ser interpretada.
- [`SomaExpressao`](src/SomaExpressao.java) e [`SubtracaoExpressao`](src/SubtracaoExpressao.java) — **expressões não-terminais**: cada uma guarda duas subexpressões (esquerda/direita) e combina o resultado da interpretação de ambas.
- [`InterpretadorExpressao`](src/InterpretadorExpressao.java) — o **contexto/parser**: recebe a frase em texto (ex.: `"5 + 3 - 2"`), separa os tokens e monta a árvore de `Expressao` correspondente, delegando a avaliação final a ela.
- [`Main`](src/Main.java) — demonstra o interpretador avaliando algumas expressões de texto diferentes.

## Como compilar e executar

```bash
cd src
javac *.java
java Main
```

## Saída esperada

```
"5 + 3 - 2" = 6
"10 - 4 + 1" = 7
"7" = 7
```
