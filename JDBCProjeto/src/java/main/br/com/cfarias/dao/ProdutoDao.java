package br.com.cfarias.dao;

import java.util.List;

import br.com.cfarias.dao.generic.jdbc.ConnectionFactory;
import br.com.cfarias.domain.Produto;
import br.com.cfarias.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDao implements IprodutoDAO {

	@Override
	public Integer cadastrarProduto(Produto produto) throws Exception {

		Connection conexaoDb = null;
		PreparedStatement stmCompiler = null;

		try {
			conexaoDb = ConnectionFactory.getConnection();
			String sqlCommand = "INSERT INTO tb_produto (id,codigo,nome) VALUES (NEXTVAL('sq_produto'),?,?) ";
			stmCompiler = conexaoDb.prepareStatement(sqlCommand);
			stmCompiler.setString(1, produto.getCodigo());
			stmCompiler.setString(2, produto.getNome());
			return stmCompiler.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {

			if (stmCompiler != null && !stmCompiler.isClosed()) { // se o PreparedStatement não for nulo, ou não estiver
																	// fechado, feche-o!
				stmCompiler.close();
			}
			if (conexaoDb != null && !conexaoDb.isClosed()) { // se a Conexão não for nula, ou não estiver fechada,
																// feche-a!
				conexaoDb.close();
			}

		}

	}

	
	public Produto consultarProduto(String codigo) throws Exception {
		Connection conexaoDb = null;
		PreparedStatement stmCompiler = null;
		ResultSet produtoEncontrado;
		Produto produtoReturn = null;

		try {
			conexaoDb = ConnectionFactory.getConnection();
			String sqlCommand = "SELECT * FROM tb_produto WHERE codigo = ?";
			stmCompiler = conexaoDb.prepareStatement(sqlCommand);
			stmCompiler.setString(1, codigo);
			produtoEncontrado = stmCompiler.executeQuery();
			
			if(produtoEncontrado.next()) {
				produtoReturn = new Produto(produtoEncontrado.getLong("id"),produtoEncontrado.getString("codigo"),produtoEncontrado.getString("nome"));
			}
					
		} catch (Exception e) {
			throw e;
			
		} finally {

			if (stmCompiler != null && !stmCompiler.isClosed()) { // se o PreparedStatement não for nulo, ou não estiver
																	// fechado, feche-o!
				stmCompiler.close();
			}
			if (conexaoDb != null && !conexaoDb.isClosed()) { // se a Conexão não for nula, ou não estiver fechada,
																// feche-a!
				conexaoDb.close();
			}

		}
	
		return produtoReturn;
	}

	@Override
	public Integer excluirProduto(Produto produto) throws Exception {
		Connection conexaoDB = null;
		PreparedStatement stmCompiler = null;
	
		try {
			conexaoDB = ConnectionFactory.getConnection();
			String sql = "DELETE FROM tb_produto WHERE codigo = ?";
			stmCompiler = conexaoDB.prepareStatement(sql);
			stmCompiler.setString(1, produto.getCodigo());
			return stmCompiler.executeUpdate();
			}
		
		catch(Exception e){
			throw e;
		}
		
		finally {
			if(stmCompiler != null && !stmCompiler.isClosed()) { //se o PreparedStatement não for nulo, ou não estiver fechado, feche-o!
				stmCompiler.close();
			}
			if(conexaoDB != null && !conexaoDB.isClosed()) { //se a Conexão não for nula, ou não estiver fechada, feche-a!
				conexaoDB.close();
			}
			
		}
	}

	
	public Integer atualizarProduto(Produto produto) throws Exception {
		Connection connectionDb = null;
		PreparedStatement stmCompiler = null;
		
		if(consultarProduto(produto.getCodigo()) == null) { 
			/*Precisamos verificar se há produto com o código
			 * inserido no método atualizarCliente, podemos reaproveitar 
			 * o método consultarCliente.
			 */ 
			return null;
		}
		else
	
		
		try {
			connectionDb = ConnectionFactory.getConnection();
			String sql = """
						UPDATE tb_produto
						SET nome = ?
						WHERE codigo = ?;
						""";
			//Utilizado multilinhas para o código ficar mais organizado e semelhante ao DQL.
			stmCompiler = connectionDb.prepareStatement(sql);
			
			stmCompiler = connectionDb.prepareStatement(sql);
			stmCompiler.setString(1, produto.getNome());
			stmCompiler.setString(2, produto.getCodigo());
			return stmCompiler.executeUpdate();
			}
		
		catch(Exception e){
			throw e;
		}
		
		finally {
			if(stmCompiler != null && !stmCompiler.isClosed()) { //se o PreparedStatement não for nulo, ou não estiver fechado, feche-o!
				stmCompiler.close();
			}
			if(connectionDb != null && !connectionDb.isClosed()) { //se a Conexão não for nula, ou não estiver fechada, feche-a!
				connectionDb.close();
			}
			
		}
	}


	
	public List<Produto> buscarTodosProdutos() throws Exception {
		
		Connection conectionDb = null;
		PreparedStatement stmCompiler = null;
		ResultSet rs = null;
		List<Produto> ProdList = new ArrayList<Produto>();
		
		try {
			conectionDb = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM tb_produto";
			stmCompiler = conectionDb.prepareStatement(sql);
			rs = stmCompiler.executeQuery();

			while(rs.next()) {
				ProdList.add(new Produto(rs.getLong("id"), rs.getString("codigo"), rs.getString("nome"))); //Código mais conciso
				}	
		}
		
		catch(Exception e){
			throw e;
		}
		
		finally {
			if(stmCompiler != null && !stmCompiler.isClosed()) { //se o PreparedStatement não for nulo, ou não estiver fechado, feche-o!
				stmCompiler.close();
			}
			if(conectionDb != null && !conectionDb.isClosed()) { //se a Conexão não for nula, ou não estiver fechada, feche-a!
				conectionDb.close();
			}	
		}
		return ProdList;
	}

	

}
