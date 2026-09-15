# Padrões de Projeto — Categoria: Operação

Trabalho acadêmico (UCSAL) para demonstração dos **padrões de projeto (design patterns) da categoria Operação**. Cada padrão é implementado como um mini-projeto Java que simula um problema do mundo real, e vive em sua própria branch — a `main` serve apenas como índice/documentação geral.

## Organização do repositório

Não há um único código-fonte na `main`. Cada padrão estudado tem:

1. Uma **branch própria**, nomeada com o padrão em minúsculas (ex.: `template-method`, `state`, `strategy`, `command`, `interpreter`);
2. Um **mini-projeto Java simples**, simulando um cenário real, sem uso de classes genéricas como `ClasseA`/`ClasseB`;
3. Um **README.md próprio** (na raiz da branch) explicando:
   - o conceito do padrão;
   - o problema que ele resolve;
   - como a implementação do mini-projeto aplica o padrão;
   - trechos de código comentados quando necessário.

## Padrões cobertos

| Padrão            | Branch            |
|--------------------|-------------------|
| Template Method    | `template-method` |
| State              | `state`           |
| Strategy           | `strategy`        |
| Command            | `command`         |
| Interpreter        | `interpreter`     |

## Como navegar pelo projeto

Para ver a implementação e a explicação de um padrão específico, troque para a branch correspondente:

```bash
git checkout template-method
```

E leia o `README.md` daquela branch, que contém a explicação teórica e o código do mini-projeto.

## Requisitos gerais

- Java 17+
- Cada branch é um projeto Java independente (pode conter seu próprio `pom.xml`/`build.gradle` ou apenas classes soltas compiláveis via `javac`), com instruções de execução no respectivo README.

---

Desenvolvido por Giovane Santiago e Beatriz Correia como atividade avaliativa — UCSAL.
