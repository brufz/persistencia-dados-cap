package Cadastros;

import java.sql.SQLException;

public class PessoaDao extends Dao{
	
	public void incluirPessoa(Pessoa p1) throws SQLException {
		open();
		stmt = con.prepareStatement("insert into pessoa values (?,?,?)"); 
		stmt.setInt(1, p1.getIdPessoa());
		stmt.setString(2, p1.getNomePessoa());
		stmt.setString(3, p1.getEmail());
		stmt.execute();
		stmt.close();
		close();
		
	}
	
	
	public void alterarPessoa(Pessoa p) throws SQLException {
		open();
		stmt = con.prepareStatement("update Pessoa nome = ?m email = ?, where idPessoa = ?");
		stmt.setString(1, p.getNomePessoa());
		stmt.setString(2, p.getEmail());
		stmt.setInt(3, p.getIdPessoa());
		stmt.execute();
		stmt.close();
		close();
	}
	
	public void excluirPessoa(Pessoa p) throws SQLException {
		open();
		stmt = con.prepareStatement("delete from Pessoa where idPessoa = ?");
		stmt.setInt(1, p.getIdPessoa());
		stmt.execute();
		stmt.close();
		close();
		
		
	}
	
	
}
