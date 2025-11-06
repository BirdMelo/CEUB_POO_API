# CEUB_POO_API_IFOOD

## 📝 Sobre o Projeto

Este projeto é um trabalho acadêmico desenvolvido durante as aulas da disciplina de **Programação Orientada a Objetos (POO)**.

Ele faz parte da grade curricular do curso de **Análise e Desenvolvimento de Sistemas (ADS)** do **Centro Universitário de Brasília (CEUB)**.

O objetivo principal foi aplicar os conceitos fundamentais de POO (como encapsulamento, herança, polimorfismo e abstração) para criar uma API que consome um banco de dados desenvolvido pelo grupo.

## 🛠️ Tecnologias Utilizadas

* **Java**
* **Eclipse IDE**
* **ifood**
* **Maven**
* **Spring Boot**

## 🚀 Como Executar o Projeto

Siga estas instruções para configurar e executar o projeto em seu ambiente local.

### Pré-requisitos

* **Java JDK** (Recomendado: Versão 17)
* **Eclipse IDE** (O projeto foi desenvolvido e testado na 2025-12)
* Um servidor de banco de dados **ifood** instalado e em execução.

### 1. Importando o Projeto no Eclipse

1.  Abra o Eclipse IDE.
2.  Vá em `File` > `Import...`.
3.  Selecione `General` > `Existing Projects into Workspace` e clique em `Next`.
4.  Clique em `Select root directory:` e navegue até a pasta onde você clonou ou descompactou este projeto.
5.  Certifique-se de que o projeto apareceu na lista `Projects` e clique em `Finish`.

### 2. Configurando o Banco de Dados

Antes de configurar as variáveis de ambiente, você precisa criar o banco de dados e suas tabelas. O script SQL para fazer isso está incluído no repositório.

1.  Acesse seu servidor de banco de dados [Nome do BD, ex: MySQL].
2.  Crie um *schema* (banco de dados) chamado `[nome_do_seu_banco]`.
3.  Execute o script SQL abaixo para criar todas as tabelas necessárias:

* **[Clique aqui para baixar o modelo de banco de dados](./model_Ifood.mwb)**

### 3. Configurando as Variáveis de Ambiente

Este projeto **não armazena** credenciais de banco de dados diretamente no código. Em vez disso, ele utiliza variáveis de ambiente para configurar a conexão.

Você precisará definir as três variáveis a seguir dentro do Eclipse:

* `${DATA_BANK}`: O nome ou a URL de conexão JDBC do seu banco de dados.
* `${USER}`: O nome de usuário para acessar o banco.
* `${PASSWORD}`: A senha para acessar o banco.

#### Como criar as variáveis no Eclipse:

1.  No Eclipse, clique com o botão direito sobre o projeto no `Package Explorer`.
2.  Vá em `Run As` > `Run Configurations...` (ou `Debug As` > `Debug Configurations...`).
3.  Na janela que abrir, procure a configuração de execução principal do seu projeto (geralmente sob `Java Application`).
4.  Clique na aba **`Environment`**.
5.  Clique no botão **`New...`** para adicionar uma nova variável.
6.  Repita o processo para as três variáveis necessárias:

    * **Variável 1:**
        * `Name:` `DATA_BANK`
        * `Value:` [Ex: "meu_banco" ou "jdbc:mysql://localhost:3306/meu_banco"]
    * **Variável 2:**
        * `Name:` `USER`
        * `Value:` [Ex: "root"]
    * **Variável 3:**
        * `Name:` `PASSWORD`
        * `Value:` [Ex: "sua_senha_secreta"]

7.  Após adicionar as três variáveis, clique em **`Apply`** e depois em **`Close`** (ou `Run` para executar imediatamente).

### 4. Executando

Após importar e configurar as variáveis de ambiente, você pode executar a classe principal do projeto `Main.java` como uma `Java Application`.
