package br.com.residencia.bankend.principal;

import java.sql.Connection;

import br.com.residencia.banco.Conexao;
import br.com.residencia.telas.Transferencia;

public class SistemaInterno {

	public static void main(String[] args) {
		//aguarde o processo
		//polvo lazinhooo

		Connection conexao = new Conexao().conectar();

		Transferencia tela1 = new Transferencia(conexao);

		tela1.setVisible(true);

	}

}
