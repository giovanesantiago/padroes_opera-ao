# Template Method — Processamento de Pedidos

## Conceito

O **Template Method** é um padrão de projeto comportamental (categoria Operação) que define o **esqueleto de um algoritmo** em um método de uma classe base, deixando que subclasses sobrescrevam apenas os **passos específicos** desse algoritmo, sem alterar sua estrutura geral.

A ideia central: a sequência de passos é fixa e fica protegida (geralmente em um método `final`), mas cada passo pode ter um comportamento padrão ou ser obrigatoriamente implementado pelas subclasses. Isso evita duplicar o fluxo inteiro do algoritmo em cada variação, mantendo o controle do "como" na classe base e delegando o "o quê muda" para quem estende.

## Problema simulado

Uma loja processa pedidos de duas formas diferentes:

- **Retirada na loja** — o cliente busca o produto, não há frete e a notificação é por SMS.
- **Delivery** — o produto é entregue no endereço do cliente, o frete é calculado pela distância e a notificação é por e-mail com rastreio.

Nos dois casos, o fluxo geral de processar um pedido é o mesmo: **validar → calcular frete → confirmar pagamento → finalizar/notificar**. O que muda são apenas os passos de cálculo de frete e de finalização. Sem o Template Method, cada tipo de pedido reimplementaria o fluxo inteiro, duplicando código e arriscando inconsistência na ordem dos passos.

## Como o código aplica o padrão

- [`ProcessadorPedido`](src/ProcessadorPedido.java) — classe abstrata que contém o **template method** `processarPedido()`, marcado como `final` para garantir que a ordem dos passos nunca seja alterada pelas subclasses. Ela também fornece implementações padrão para `validarPedido()` e `confirmarPagamento()`, comuns a qualquer pedido.
- `calcularFrete()` e `finalizarPedido()` são **passos abstratos**: cada subclasse é obrigada a implementá-los com seu próprio comportamento.
- [`PedidoRetirada`](src/PedidoRetirada.java) — implementa frete zero e notificação por SMS.
- [`PedidoDelivery`](src/PedidoDelivery.java) — implementa frete proporcional à distância e notificação por e-mail com rastreio.
- [`Main`](src/Main.java) — demonstra os dois fluxos chamando `processarPedido()` polimorficamente, sem saber os detalhes internos de cada tipo de pedido.

## Como compilar e executar

```bash
cd src
javac *.java
java Main
```

## Saída esperada

```
=== Pedido 1: Retirada na loja ===
Validando pedido de Ana...
Retirada na loja: sem frete.
Pagamento de R$ 120,00 confirmado.
Pedido pronto para retirada. Notificando Ana por SMS.

=== Pedido 2: Delivery ===
Validando pedido de Bruno...
Delivery: 6,0 km -> frete de R$ 9,00
Pagamento de R$ 89,00 confirmado.
Pedido enviado para entrega. Notificando Bruno por e-mail com rastreio.
```
