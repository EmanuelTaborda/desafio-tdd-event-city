# Desafio TDD — Event City

Projeto desenvolvido em Java com Spring Boot com foco em Test-Driven Development (TDD) e testes de integração. O objetivo é praticar modelagem de domínio, regras de negócio, testes automatizados de integração e aplicação das melhores práticas de arquitetura e organização de código.

---

## Contexto do sistema

O sistema gerencia eventos e cidades (Event / City). Relacionamentos típicos:

- Uma cidade pode ter vários eventos
- Cada evento pertence a uma cidade

O projeto implementa endpoints REST para criação, leitura e relatórios simplificados, com validações e regras de negócio cobertas por testes.

---

## Competências estudadas e aplicadas

- Test-Driven Development (TDD)
  - Ciclo Red-Green-Refactor em classes de serviço e validações
  - Escrita de testes antes da implementação para guiar o design
- Testes unitários
  - JUnit 5 para estruturação dos testes
  - Mockito para mocks e isolamento de dependências
  - AssertJ para asserções expressivas
- Testes de integração
  - @SpringBootTest e @AutoConfigureMockMvc para testes de controllers e fluxo completo
  - Banco em memória (H2) para cenários de integração rápidos e reprodutíveis
  - Testes que verificam mapeamentos JPA, queries customizadas e contratos REST
- Spring Data JPA
  - Mapeamento de entidades, relacionamentos e repositórios com consultas customizadas
- Boas práticas de arquitetura
  - Separação em camadas: Controller, Service, Repository, DTO/Projections
  - Tratamento de parâmetros e regras no Service
  - DTOs/Projections para respostas específicas de relatórios
- CI-friendly testing
  - Testes rápidos, determinísticos e isolados para execução em pipelines

---

## Organização do projeto

- src/main/java
  - controller — endpoints REST
  - service — regras de negócio e tratamento de dados
  - repository — interfaces Spring Data JPA e consultas customizadas
  - model/entity — entidades JPA (Event, City)
  - dto/projection — objetos de transferência/projeções para relatórios
- src/test/java
  - unit — testes unitários das services e utilitários
  - integration — testes de integração cobrindo controllers e repos

---

## Como executar

Pré-requisitos: JDK 11+ e Maven.

- Rodar todos os testes:

  mvn clean test

- Executar a aplicação localmente:

  mvn spring-boot:run

- Executar apenas os testes de integração (exemplo com profile ou tag):

  mvn -Dtest=*IT* test

(Adaptar o comando conforme as convenções de nomes/ tags adotadas no projeto.)

---

## Estratégia de testes (resumo)

1. Escrever um teste unitário que falha (Red): definir comportamento esperado da unidade (service / validação).
2. Implementar o mínimo de código para passar no teste (Green).
3. Refatorar mantendo a cobertura e legibilidade (Refactor).
4. Criar testes de integração que inicializam o contexto Spring e um banco H2 para validar o fluxo completo entre controller → service → repository.
5. Cobrir cenários felizes e de erro (validações, dados inválidos, limites de paginação, filtros).

Essa disciplina garante design orientado a requisitos, baixo acoplamento e código testável.

---

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 (testes)
- Maven
- JUnit 5, Mockito, AssertJ

---

## Observações finais

- O foco principal deste repositório é demonstrar disciplina de TDD e confiança em testes de integração. A leitura dos testes fornece um mapa preciso dos requisitos e do comportamento esperado.
- Para dúvidas sobre onde encontrar um caso de uso específico, consulte a pasta src/test para ver os testes que documentam os comportamentos.

---

