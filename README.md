# Sobre o projeto

Esse projeto representa o Alura Challenge Back-End 5° Edição

## Resumo detalhado do Challenge Back-End

- Nosso Challenge é dividido em 3 fases, que são distribuídas entre 4 semanas;
- Em cada fase, além da teoria, você também aprende colocando a mão na massa e praticando tudo em um projeto real;
- Neste Challenge você irá desenvolver uma API com rotas CRUD para o AluraFlix;
- No final de tudo, além de todo o conhecimento adquirido que vai aumentar seu valor no mercado de trabalho, você vai ter um projeto completo para adicionar ao seu portfólio.

A alura-challenge-api é uma aplicação back-end construída durante a 5ª edição do **Alura Challenge**

# Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Spring Security
- JWT (JSON Web Token)
- Flyway
- MySQL
- Spring Doc

# Como executar o projeto

Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/Emerson-Freitas/alura-challenge-api

# entrar na pasta do projeto
cd <nome-da-pasta-do-projeto>

# executar o projeto
./mvnw spring-boot:run
```

## Documentação da API (lembre-se de clonar e rodar antes o projeto)
- Acesse a URL da imagem abaixo (http://localhost:8080/swagger-ui/index.html#)
![Web 1](https://github.com/Emerson-Freitas/alura-challenge-api/blob/master/src/main/resources/imagens-projeto/documentacao.png)

## Como realizar as requisições HTTP (Pelo swagger-ui)
Todas os end-points necessitam de um Token JWT para que as requisições sejam realizadas com sucesso, exceto o end-point /videos/free

## Como obter o Token JWT e utilizar na API (Pelo swagger-ui)
- Para obter o token é que preciso que crie um usuario, para isso acesse o end-point /usuario e clique em "Try it out";
- Ao clicar, será aberto o corpo da requisição (Request Body) que é o lugar onde informamos o nosso login e senha e clique em "Execute";
- Após realizar os passos anteriores é esperado que você obtenha esse resultado:

![Web 2](https://github.com/Emerson-Freitas/alura-challenge-api/blob/master/src/main/resources/imagens-projeto/cadastro-usuario.png)
- Agora é preciso pegar o token jwt para realizar as requisições;

- Após realizar o cadastro, acesse o end-point /login e clique novamente em "Try it out";
- Ao clicar, será aberto o corpo da requisição. Informe o login e senha que você acabou de cadastrar e clique em "Execute"
- Após realizar os passos anteriores é esperado que você obtenha esse resultado:
 
![Web 3](https://github.com/Emerson-Freitas/alura-challenge-api/blob/master/src/main/resources/imagens-projeto/token-jwt.png)

- Agora volte ao topo da página e clique em "Authorize" (Ao lado da palavra contém uma imagem que representa um cadeado);
- Ao clicar, será aberto o seguinte pop-up:
 
![Web 4](https://github.com/Emerson-Freitas/alura-challenge-api/blob/master/src/main/resources/imagens-projeto/authorize.png)

- Agora insira o token que a API te gerou (Observação: O token tem duração de duas horas, após isso ele será expirado. Para gerar outro token basta realizar o login novamente);
- Após ter inserido o valor do token, clique em "Authorize" e depois em "Close";
- Pronto, agora todos os end-points da API estão liberados

# Autor

Emerson Freitas de Sousa

# Contatos

- e-mail: emerson_freitas@outlook.com.br
- linkedin: https://www.linkedin.com/in/emerson-freitas-5b6468240/

