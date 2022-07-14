package Cadastros;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		PessoaDao pd = new PessoaDao();
	
		try {
			Pessoa p1 = new Pessoa(1, "josé", "jose@gmail.com");
			pd.incluirPessoa(p1);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		

		

	}

}
