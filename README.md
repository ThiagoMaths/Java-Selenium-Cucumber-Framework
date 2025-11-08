### Advanced Web UI Test Automation Framework

![CI/CD Pipeline Status](https://github.com/thiagomaths/Java-Selenium-Cucumber-Framework/actions/workflows/CI-pipeline.yml/badge.svg)

#### Overview

This repository contains a robust, scalable, and maintainable test automation framework built with **Java**, **Selenium**, and **Cucumber**. The project was architected to go beyond a simple test script, applying software engineering principles and design patterns to create a professional-grade solution, ready for Continuous Integration (CI/CD) environments.

The automation target is an e-commerce website, demonstrating the framework's application in a real-world scenario.

#### Architectural Principles & Key Features

The quality of this framework lies in its architecture, which was carefully planned with a focus on scalability and maintainability.

* **Behavior-Driven Development (BDD) with Cucumber:** Tests are written in Gherkin (`.feature`), a natural language that describes the system's behavior.
* **Page Object Model (POM):** UI interaction is fully abstracted into Page classes, ensuring code reusability.
* **Thread-Safe WebDriver Management for Parallel Execution:** The framework uses `ThreadLocal` to manage WebDriver instances, ensuring that each test thread has its own isolated instance. This makes the framework **parallel-execution ready**.
* **Advanced Test Data Management Strategy:** It uses a hybrid approach with **SQLite** for user creation and **CSV/Faker** for other test data.
* **Clean Code Principles:** The code was refactored to follow Clean Code best practices, with a clear **separation of concerns** (Asserts in Step Definitions, not in Pages).
* **Executive Reporting with Allure Report:** Result reporting is done through **Allure**, which generates interactive and detailed HTML dashboards.
* **Fully Automated CI/CD Pipeline:** Integrated with **GitHub Actions** for automated testing, report generation, and live dashboard publication.

#### Tech Stack

* **Language:** Java (JDK 21)
* **Web Automation:** Selenium WebDriver
* **BDD Testing Framework:** Cucumber
* **Build & Dependency Management:** Apache Maven
* **Reporting:** Allure Report
* **CI/CD:** GitHub Actions
* **Data Management:** SQLite, OpenCSV, JavaFaker
* **Logging:** SLF4J & Log4j2
* **Test Runner:** JUnit

#### How to Run the Project (Local)

**Prerequisites:**
* Java (JDK 21) installed
* Apache Maven installed
* Allure Commandline installed

**Running the Tests:**
1.  Clone this repository.
2.  Open a terminal in the project's root folder.
3.  Run the following Maven command to execute all tests:
    ```bash
    mvn clean test
    ```

**Viewing the Reports:**
1.  After the test execution, generate and serve the Allure report with the command:
    ```bash
    allure serve
    ```
2.  Your browser will automatically open with the complete results dashboard.

---

### CI/CD Pipeline with GitHub Actions

This framework is fully integrated with a GitHub Actions workflow defined in `.github/workflows/CI-pipeline.yml`.

This pipeline automatically triggers on every `push` to the main branches, ensuring that no regressions are introduced.

**The automated pipeline performs the following steps:**
1.  **Set up:** Checks out the code, sets up JDK 21, and caches Maven dependencies.
2.  **Test Execution:** Runs the entire test suite (`mvn clean test`) in a **headless Linux environment**.
3.  **Report Generation:** Uses `allure-commandline` to generate the HTML report from the test results (even if tests fail).
4.  **Report Deployment:** Automatically publishes the generated `allure-report` folder to a dedicated `gh-pages` branch.

📊 **You can view the latest executive test report, published live from the CI pipeline, at any time:**

**[https://thiagomaths.github.io/Java-Selenium-Cucumber-Framework/](https://thiagomaths.github.io/Java-Selenium-Cucumber-Framework/)**

---

<details>
<summary>🇧🇷 Ver este README em Português</summary>

### Framework Avançado de Automação de Testes para UI Web

![Status do Pipeline de CI/CD](https://github.com/thiagomaths/Java-Selenium-Cucumber-Framework/actions/workflows/CI-pipeline.yml/badge.svg)

#### Visão Geral

Este repositório contém um framework de automação de testes robusto, escalável e de fácil manutenção, construído com **Java**, **Selenium** e **Cucumber**. O projeto foi arquitetado para ir além de um simples script de teste, aplicando princípios de engenharia de software e padrões de design para criar uma solução de nível profissional, pronta para ambientes de Integração Contínua (CI/CD).

O alvo da automação é um site de e-commerce, demonstrando a aplicação do framework em um cenário do mundo real.

#### Princípios de Arquitetura e Features Principais

A qualidade deste framework reside em sua arquitetura, que foi cuidadosamente planejada com foco em escalabilidade e manutenibilidade.

* **Behavior-Driven Development (BDD) com Cucumber:** Os testes são escritos em Gherkin (.feature), uma linguagem natural que descreve o comportamento do sistema.
* **Page Object Model (POM):** A interação com a UI é totalmente abstraída em classes de Page, garantindo a reutilização do código.
* **Gerenciamento de WebDriver Thread-Safe para Execução Paralela:** O framework utiliza `ThreadLocal` para gerenciar as instâncias do WebDriver, garantindo que cada thread de teste tenha sua própria instância isolada. Isso torna o framework **pronto para execução paralela**.
* **Estratégia Avançada de Gerenciamento de Dados de Teste:** Utiliza uma abordagem híbrida com **SQLite** para criação de usuários e **CSV/Faker** para outros dados de teste.
* **Princípios de Clean Code:** O código foi refatorado para seguir as melhores práticas de Clean Code, com uma clara **separação de responsabilidades** (Asserts nos Step Definitions, não nas Pages).
* **Relatórios Executivos com Allure Report:** A comunicação dos resultados é feita através do **Allure**, que gera dashboards HTML interativos e detalhados.
* **Pipeline de CI/CD Automatizada:** Integrado com **GitHub Actions** para execução, geração de relatórios e publicação automatizada.

#### Stack de Tecnologias

* **Linguagem:** Java (JDK 21)
* **Automação Web:** Selenium WebDriver
* **Framework de Testes BDD:** Cucumber
* **Build e Dependências:** Apache Maven
* **Relatórios:** Allure Report
* **CI/CD:** GitHub Actions
* **Gestão de Dados:** SQLite, OpenCSV, JavaFaker
* **Logging:** SLF4J & Log4j2
* **Runner de Teste:** JUnit

#### Como Executar o Projeto (Localmente)

**Pré-requisitos:**
* Java (JDK 21) instalado
* Apache Maven instalado
* Allure Commandline instalado

**Executando os Testes:**
1.  Clone este repositório.
2.  Abra um terminal na pasta raiz do projeto.
3.  Execute o seguinte comando Maven para rodar todos os testes:
    ```bash
    mvn clean test
    ```

**Visualizando os Relatórios:**
1.  Após a execução dos testes, gere e sirva o relatório do Allure com o comando:
    ```bash
    allure serve
    ```
2.  Seu navegador abrirá automaticamente com o dashboard completo dos resultados.

---

### Pipeline de CI/CD com GitHub Actions

Este framework é totalmente integrado com um *workflow* do GitHub Actions definido em `.github/workflows/CI-pipeline.yml`.

Este pipeline é disparado automaticamente a cada `push` para os branches principais, garantindo que nenhuma regressão seja introduzida.

**O pipeline automatizado executa os seguintes passos:**
1.  **Configuração:** Clona o código, configura o JDK 21 e armazena as dependências do Maven em cache.
2.  **Execução de Testes:** Roda a suíte de testes completa (`mvn clean test`) num ambiente **Linux headless**.
3.  **Geração de Relatório:** Usa o `allure-commandline` para gerar o relatório HTML a partir dos resultados (mesmo que os testes falhem).
4.  **Deploy do Relatório:** Publica automaticamente a pasta `allure-report` gerada para um *branch* dedicado `gh-pages`.

📊 **Você pode ver o último relatório executivo de testes, publicado ao vivo pelo pipeline, a qualquer momento:**

**[https://thiagomaths.github.io/Java-Selenium-Cucumber-Framework/](https://thiagomaths.github.io/Java-Selenium-Cucumber-Framework/)**

</details>
