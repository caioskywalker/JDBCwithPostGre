<h1>JDBCwithPostGre</h1>

<p>Este projeto é uma aplicação Java que utiliza JDBC para se conectar e realizar operações em um banco de dados PostgreSQL. O projeto demonstra o uso de DAO (Data Access Object) para realizar operações CRUD (Create, Read, Update, Delete) em entidades como Cliente e Produto.</p>

<h2>Estrutura do Projeto</h2>

<p>O projeto está organizado da seguinte forma:</p>

<h3>Pacote <code>br.com.cfarias.dao</code></h3>

<p>Contém as classes responsáveis pela interação com o banco de dados:</p>
<ul>
    <li><code>ClienteDao.java</code>: Implementa a interface <code>IclienteDAO</code> e define métodos para operações CRUD no banco de dados para a entidade Cliente.</li>
    <li><code>IclienteDAO.java</code>: Interface que define os métodos que o DAO de Cliente deve implementar.</li>
    <li><code>ProdutoDao.java</code>: Implementa a interface <code>IprodutoDAO</code> e define métodos para operações CRUD no banco de dados para a entidade Produto.</li>
    <li><code>IprodutoDAO.java</code>: Interface que define os métodos que o DAO de Produto deve implementar.</li>
    <li><code>generic.jdbc.ConnectionFactory.java</code>: Classe que gerencia a conexão com o banco de dados, utilizando JDBC.</li>
</ul>

<h3>Pacote <code>br.com.cfarias.domain</code></h3>

<p>Contém as classes de domínio do projeto:</p>
<ul>
    <li><code>Cliente.java</code>: Representa a entidade Cliente, com atributos como <code>id</code>, <code>nome</code>, <code>email</code>, etc.</li>
    <li><code>Produto.java</code>: Representa a entidade Produto, com atributos como <code>id</code>, <code>nome</code>, <code>preco</code>, etc.</li>
</ul>

<h3>Pacote <code>br.com.cfarias.teste</code></h3>

<p>Contém as classes de teste:</p>
<ul>
    <li><code>ClienteTeste.java</code>: Classe de teste que valida as operações da entidade Cliente no banco de dados.</li>
</ul>

<h2>Tecnologias Utilizadas</h2>
<ul>
    <li><strong>Java</strong>: Linguagem de programação principal.</li>
    <li><strong>JDBC (Java Database Connectivity)</strong>: API utilizada para conectar e executar operações no banco de dados PostgreSQL.</li>
    <li><strong>PostgreSQL</strong>: Banco de dados relacional utilizado pelo projeto.</li>
    <li><strong>Maven</strong>: Gerenciador de dependências e build do projeto.</li>
</ul>

<h2>Como Configurar e Executar</h2>

<h3>Pré-requisitos</h3>
<ul>
    <li>Java 8 ou superior</li>
    <li>PostgreSQL instalado e configurado</li>
    <li>Maven instalado</li>
</ul>

<h3>Configuração do Banco de Dados</h3>
<ol>
    <li>Crie um banco de dados no PostgreSQL:
        <pre><code>CREATE DATABASE Vendas_Online;</code></pre>
    </li>
    <li>Ajuste as configurações de conexão na classe <code>ConnectionFactory.java</code> para apontar para o banco de dados criado.</li>
</ol>

<h3>Executando o Projeto</h3>
<ol>
    <li>Clone o repositório:
        <pre><code>git clone https://github.com/caioskywalker/JDBCwithPostGre.git</code></pre>
    </li>
    <li>Navegue até o diretório do projeto:
        <pre><code>cd JDBCwithPostGre-main/JDBCProjeto</code></pre>
    </li>
    <li>Compile e execute o projeto utilizando o Maven:
        <pre><code>mvn clean install
mvn exec:java</code></pre>
    </li>
</ol>

<h2>Operações</h2>

<p>As operações de CRUD são realizadas diretamente via métodos Java nos DAOs, como <code>ClienteDao</code> e <code>ProdutoDao</code>. Exemplos de métodos incluem:</p>
<ul>
    <li><strong>Create</strong>: <code>public Integer cadastrarCliente(Cliente cliente);</code></li>
    <li><strong>Read</strong>: <code>public Cliente consultarCliente(String codigo);</code></li>
    <li><strong>Update</strong>: <code>public Integer atualizarCliente(Cliente cliente);</code></li>
    <li><strong>Delete</strong>: <code>public Integer excluir(Cliente cliente);</code></li>
     <li><strong>FindAll</strong>: <code>public List<Cliente> buscarTodos();</code></li>
</ul>

<h2>Contribuições</h2>

<p>Contribuições são bem-vindas! Para sugerir melhorias ou relatar problemas, por favor abra uma issue ou envie um pull request.</p>

