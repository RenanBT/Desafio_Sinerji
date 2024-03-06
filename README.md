# Desafio_Sinerji

Criado por:  Renan Betereli

[Linkedin](https://www.linkedin.com/in/renanbetereli/)
[Github](https://github.com/RenanBT)


API desenvolvida utilizando hibernate para conectar o backend desenvolvido em Java ao BD (Postgresql), usando Maven como gerenciador de dependências.

Frontend não implementado. 

Para testar o código:

1- crie um database chamado "crud_sinerji" no PG Admin por ex.

Considere os seguintes parâmetros:
DB Name: crud_sinerji
Porta padrão: 5432
DB User: "postgres"
DB Password: "admin"

Ou altere tais parâmetros no arquivo "persistence.xml"

2 - Abra o código em sua IDE de preferência.

3 - Execute as classes de teste dentro de src\main\test\br\com\betereli\CrudTest.java

**testeCadastrarEndereço**

**testeCadastrarPessoa**

**testeRelacionamentoEntidades**

4 - Altere os dados hardcoded para inserir mais dado no BD.


**Nota ao avaliador**

Tentei desenvolver esta API da forma mais simples possível levando em consideração prazo para entrega 
e as boas práticas apredidas no curso Especialista Backend Java Pro da escola EBAC.
Optei por não utilizar um ambiente dockerizado para simplificar a implementação e Maven para 
não precisar importar arquivos ".jar" no momento de testar a API.
Espero ter demonstrado as habilidades requeridas pelo teste. 
