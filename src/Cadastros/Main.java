package Cadastros;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		PessoaDao pd = new PessoaDao();

		/*try {
			Pessoa p1 = new Pessoa(5, "felipe", "felipe@gmail.com");
			pd.incluirPessoa(p1);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
*/
		Pessoa pes = pd.consultarPessoaIndividual(3);
		if (pes != null) {
			pes.setNomePessoa("Jose Marques");
			pes.setEmail("jose2@gmail.com");
			pd.alterarPessoa(pes);
		
		}
		
		try {
			Pessoa p1 = pd.consultarPessoaIndividual(1);
			pd.excluirPessoa(p1);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		/*
		Pessoa pes1 = pd.consultarPessoaIndividual(1);
		System.out.println("Nome pessoa: " + pes1.getNomePessoa());


		List<Pessoa> listaDePessoas = pd.listarPessoas();
		for (Pessoa p: listaDePessoas) {
			System.out.println("Código....." + p.getIdPessoa());
			System.out.println("Nome......." + p.getNomePessoa());
			System.out.println("Email......" + p.getEmail());
			System.out.println("------------------------------------");
		}
		*/
	}

}
