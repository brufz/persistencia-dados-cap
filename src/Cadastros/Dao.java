package Cadastros;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
// realiza a conexão com o banco de dados
	Connection con;
	PreparedStatement stmt; // acessa a tabela (insert, update, delete...)
	ResultSet rs; // guarda dentro de um objeto o resultado de uma consulta
	CallableStatement call; // procedures e functions

	public void open() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/cadastro";
		String user = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Erro ao abrir conexão com banco de dados");

		}

	}

	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao fechar conexão com banco de dados");

		}

	}

}
