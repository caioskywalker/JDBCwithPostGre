package br.com.cfarias.dao.generic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection connection;
	
		private ConnectionFactory(Connection connection) {
			//Singleton para connection...
		}
		
		public static Connection getConnection() throws SQLException {
			if (connection == null) { //Se a Instância estiver nula, abre uma nova conexão
				connection = initConnection();
				return connection;
				
			} else if (connection.isClosed()) { //Se a conexão estiver fechada, abre uma nova conexão
				connection = initConnection();
				return connection;
				
			} else { //Se houver uma conexão inciada e ativa, retorna a instancia conexão
				return connection;
			}
			
			
		}
			
			private static Connection initConnection() {
				try {
					return DriverManager.getConnection(
							"jdbc:postgresql://localhost:5432/Vendas_Online", "postgres", "34679352");
				}
				catch (SQLException e){
					throw new RuntimeException(e);
				}
					
				}
				
			}


	
	
	
	
	


		



		
	
	

