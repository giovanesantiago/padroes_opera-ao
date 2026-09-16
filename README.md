# Strategy — Formas de Pagamento no Carrinho

## Conceito

O **Strategy** é um padrão de projeto comportamental (categoria Operação) que define uma **família de algoritmos intercambiáveis**, encapsulando cada um em sua própria classe e permitindo trocá-los em tempo de execução. O contexto que usa o algoritmo não conhece os detalhes de cada variação — ele apenas delega o trabalho à estratégia atual, que pode ser substituída livremente.

## Problema simulado

Um carrinho de compras precisa fechar a compra aceitando **diferentes formas de pagamento**, cada uma com sua própria regra de cálculo:

- **Cartão de Crédito** — sem desconto.
- **Pix** — 5% de desconto.
- **Boleto** — 2% de desconto.

Sem o Strategy, o carrinho precisaria de um `if/else` (ou `switch`) checando a forma de pagamento escolhida para decidir a regra de desconto, crescendo a cada nova forma adicionada. Com o padrão, cada regra vira uma classe própria e o carrinho apenas delega o cálculo a ela.

## Como o código aplica o padrão

- [`EstrategiaPagamento`](src/EstrategiaPagamento.java) — interface que define o contrato: `calcularTotal(double valor)` e `descricao()`.
- [`PagamentoCartao`](src/PagamentoCartao.java), [`PagamentoPix`](src/PagamentoPix.java), [`PagamentoBoleto`](src/PagamentoBoleto.java) — implementações concretas, cada uma com sua própria regra de desconto.
- [`Carrinho`](src/Carrinho.java) — o **contexto**: guarda os itens e uma referência à `EstrategiaPagamento` atual (`setEstrategiaPagamento`), delegando o cálculo do total a ela em `finalizarCompra()`, sem conhecer a regra de cada forma de pagamento.
- [`Main`](src/Main.java) — demonstra o mesmo carrinho fechando a compra com as três estratégias, trocando a forma de pagamento em tempo de execução.

## Como compilar e executar

```bash
cd src
javac *.java
java Main
```

## Saída esperada

```
=== Fechando com Cartao de Credito ===
Subtotal: R$ 239,90
Forma de pagamento: Cartao de Credito (sem desconto)
Total a pagar: R$ 239,90

=== Fechando com Pix ===
Subtotal: R$ 239,90
Forma de pagamento: Pix (5% de desconto)
Total a pagar: R$ 227,91

=== Fechando com Boleto ===
Subtotal: R$ 239,90
Forma de pagamento: Boleto (2% de desconto)
Total a pagar: R$ 235,10
```
