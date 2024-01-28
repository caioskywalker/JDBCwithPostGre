package br.com.cfarias.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cfarias.dao.generic.jdbc.ConnectionFactory;
import br.com.cfarias.domain.Cliente;

public class ClienteDao implements IclienteDAO {

	
	


	public Integer cadastrarCliente(Cliente cliente) throws Exception {
		
		Connection connection = null;
		PreparedStatement stm = null;
	
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO tb_cliente (id,codigo,nome) VALUES (NEXTVAL('sq_cliente'),?,?) ";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			stm.setString(2, cliente.getNome());
			return stm.executeUpdate();
			}
		
		catch(Exception e){
			throw e;
		}
		
		finally {
			if(stm != null && !stm.isClosed()) { //se o PreparedStatement não for nulo, ou não estiver fechado, feche-o!
				stm.close();
			}
			if(connection != null && !connection.isClosed()) { //se a Conexão não for nula, ou não estiver fechada, feche-a!
				connection.close();
			}
			
		}
		
	}
	
	
	
	
	
	public Cliente consultarCliente(String codigo) throws Exception  {
		
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente cliente = null;
	
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM tb_cliente WHERE codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if(rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCodigo(rs.getString("codigo"));	
				}	
		}
		
		catch(Exception e){
			throw e;
		}
		
		finally {
			if(stm != null && !stm.isClosed()) { //se o PreparedStatement não for nulo, ou não estiver fechado, feche-o!
				stm.close();
			}
			if(connection != null && !connection.isClosed()) { //se a Conexão não for nula, ou não estiver fechada, feche-a!
				connection.close();
			}	
		}
		return cliente;
	}



	
	public Integer excluir(Cliente cliente) throws Exception {
		
		Connection connection = null;
		PreparedStatement stm = null;
	
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "DELETE FROM tb_cliente WHERE codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			return stm.executeUpdate();
			}
		
		catch(Exception e){
			throw e;
		}
		
		finally {
			if(stm != null && !stm.isClosed()) { //se o PreparedStatement não for nulo, ou não estiver fechado, feche-o!
				stm.close();
			}
			if(connection != null && !connection.isClosed()) { //se a Conexão não for nula, ou não estiver fechada, feche-a!
				connection.close();
			}
			
		}
	}





	@Override
	public Integer atualizarCliente(Cliente cliente) throws Exception {
		
		Connection connection = null;
		PreparedStatement stm = null;
		
		
		if(consultarCliente(cliente.getCodigo()) == null) { 
			/*Precisamos verificar se há cliente com o código
			 * inserido no método atualizarCliente, podemos reaproveitar 
			 * o método consultarCliente.
			 */ 
			return null;
		}
		else
	
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = """
						UPDATE tb_cliente
						SET nome = ?
						WHERE codigo = ?;
						""";
			//Utilizado multilinhas para o código ficar mais organizado e semelhante ao DQL.
			
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCodigo());
			return stm.executeUpdate();
			}
		
		catch(Exception e){
			throw e;
		}
		
		finally {
			if(stm != null && !stm.isClosed()) { //se o PreparedStatement não for nulo, ou não estiver fechado, feche-o!
				stm.close();
			}
			if(connection != null && !connection.isClosed()) { //se a Conexão não for nula, ou não estiver fechada, feche-a!
				connection.close();
			}
			
		}
	
	}





	@Override
	public List<Cliente> buscarTodos() throws Exception {
		
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Cliente> resultadoList = new ArrayList<Cliente>();
	
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM tb_cliente";
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();

			while(rs.next()) {
				//clienteEncontrado = new Cliente(,rs.getString("codigo"),rs.getString("nome"));
				//clienteEncontrado.setId(rs.getLong("id"));
				//clienteEncontrado.setNome(rs.getString("nome"));
				//clienteEncontrado.setCodigo(rs.getString("codigo"));	
				resultadoList.add(new Cliente(rs.getLong("id"), rs.getString("codigo"), rs.getString("nome"))); //Código mais conciso
				}	
		}
		
		catch(Exception e){
			throw e;
		}
		
		finally {
			if(stm != null && !stm.isClosed()) { //se o PreparedStatement não for nulo, ou não estiver fechado, feche-o!
				stm.close();
			}
			if(connection != null && !connection.isClosed()) { //se a Conexão não for nula, ou não estiver fechada, feche-a!
				connection.close();
			}	
		}
		return resultadoList;
		
	}
	
	

}
