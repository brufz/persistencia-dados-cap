package Cadastros;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao extends Dao{

	public void incluirPessoa(Pessoa p1) throws SQLException {
		open();
		stmt = con.prepareStatement("insert into pessoa values (?,?,?)");
		stmt.setInt(1, p1.getIdPessoa());
		stmt.setString(2, p1.getNomePessoa());
		stmt.setString(3, p1.getEmail());
		stmt.execute();
		stmt.close();
		System.out.println("Pessoa incluída com sucesso!");
		close();

	}

	public Pessoa consultarPessoaIndividual(int cod) throws SQLException {
		open();
		stmt = con.prepareStatement("select * from pessoa where idPessoa = ? ");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		Pessoa p = null;
		if(rs.next()) {
			p = new Pessoa();
			p.setIdPessoa(rs.getInt("idPessoa"));
			p.setNomePessoa(rs.getString("nomePessoa"));
			p.setEmail(rs.getString("email"));
		} else {
			System.out.println("Registro não encontrado.");
		}
		close();
		return p;
	}

	public void alterarPessoa(Pessoa p) throws SQLException {
		open();
		stmt = con.prepareStatement("update Pessoa set nomepessoa = ?, email = ? where idPessoa = ?");
		stmt.setString(1, p.getNomePessoa());
		stmt.setString(2, p.getEmail());
		stmt.setInt(3, p.getIdPessoa());
		stmt.execute();
		stmt.close();
		System.out.println("Cadastro alterado com sucesso!");
		close();
	}

	public void excluirPessoa(Pessoa p) throws SQLException {
		open();
		stmt = con.prepareStatement("delete from Pessoa where idPessoa = ?");
		stmt.setInt(1, p.getIdPessoa());
		stmt.execute();
		stmt.close();
		System.out.println("Cadastro excluído com sucesso!");
		close();


	}
	
	public List<Pessoa> listarPessoas(){
		try {
			open();
			stmt = con.prepareStatement("select * from pessoa order by idpessoa");
			rs = stmt.executeQuery();
			List<Pessoa> listaPessoas = new ArrayList<>();
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setIdPessoa(rs.getInt("idPessoa"));
				p.setNomePessoa(rs.getString("nomePessoa"));
				p.setEmail(rs.getString("email"));
				listaPessoas.add(p);
			}
			close();
			return listaPessoas;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


}
