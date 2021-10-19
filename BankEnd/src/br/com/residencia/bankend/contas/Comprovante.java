package br.com.residencia.bankend.contas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Comprovante {
	public static void deposito (Contas conta,Double valor,String tipoConta) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss");
		String data = dtf.format(LocalDateTime.now());
		
		File arquivo = new File( "C:\\temp\\"+data+"  deposito.txt" );
		arquivo.createNewFile();
		
		FileWriter fw = new FileWriter( arquivo );
		BufferedWriter bw = new BufferedWriter( fw );
		
		
		if(tipoConta.equalsIgnoreCase("corrente")) {
		bw.write( "--------------- DEP�SITO --------------- ");
		bw.newLine();
		bw.write( "Opera��o realizada : "+ "DEP�SITO" );
		bw.newLine();
		bw.write( "favorecido  "+conta.getCliente().getNome() );
		bw.newLine();
		bw.write( "conta favorecida :  "+conta.getNumero() );
		bw.newLine();
		bw.write( "valor do dep�sito : "+"R$ "+valor );
		bw.newLine();
		}
		
		else {
			bw.write( "--------------- DEP�SITO --------------- ");
			bw.newLine();
			bw.write( "Opera��o realizada : "+ "DEP�SITO" );
			bw.newLine();
			bw.write( "taxa da opera��o : "+ "R$" + "0.10");
			bw.newLine();
			bw.write( "favorecido  "+conta.getCliente().getNome() );
			bw.newLine();
			bw.write( "conta favorecida :  "+conta.getNumero() );
			bw.newLine();
			bw.write( "valor do dep�sito : "+"R$ "+valor );
			bw.newLine();
		
					
		}
		bw.close();
		fw.close();
	}
	
	public static void saque (Contas conta,Double valor) throws IOException {
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss");
		String data = dtf.format(LocalDateTime.now());
		File arquivo = new File( "C:\\temp\\"+data+"  saque.txt" );
		arquivo.createNewFile();
		
		FileWriter fw = new FileWriter( arquivo );
		BufferedWriter bw = new BufferedWriter( fw );
		
		if(conta.tipo.equalsIgnoreCase("corrente")) {
		bw.write( "--------------- Saque --------------- ");
		bw.newLine();
		bw.write( "Opera��o realizada : "+ "Saque" );
		bw.newLine();
		bw.write( "valor do saque : "+"R$ "+valor );
		bw.newLine();
		bw.write( "Saldo  atual:  "+conta.getSaldo() );
		
		
		}else {
		bw.write( "--------------- Saque --------------- ");
		bw.newLine();
		bw.write( "Opera��o realizada : "+ "Saque" );
		bw.newLine();
		bw.write( "taxa da opera��o : "+"R$ "+"0.10" );
		bw.newLine();
		bw.write( "valor do saque : "+"R$ "+valor );
		bw.newLine();
		bw.write( "Saldo  atual:  "+"R$ "+conta.getSaldo() );
		
		}
		bw.close();
		fw.close();
	}
	
	
	public static void Transferencia (Contas conta,Double valor) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss");
		String data = dtf.format(LocalDateTime.now());
		File arquivo = new File( "C:\\temp\\"+data+"  Transfer�ncia.txt" );
		arquivo.createNewFile();
		
		FileWriter fw = new FileWriter( arquivo );
		BufferedWriter bw = new BufferedWriter( fw );
		if(conta.tipo.equalsIgnoreCase("corrente")) {
		bw.write( "--------------- Transfer�ncia --------------- ");
		bw.newLine();
		bw.write( "Opera��o realizada : "+ "Transfer�ncia" );
		bw.newLine();
		bw.write( "valor da transfer�ncia: "+"R$ "+valor);
		bw.newLine();
		bw.write( "favorecido  "+conta.getCliente().getNome() );
		bw.newLine();
		bw.write( "conta favorecida :  "+conta.getNumero() );
		
		}else {
			bw.write( "--------------- Transfer�ncia --------------- ");
			bw.newLine();
			bw.write( "Opera��o realizada : "+ "Transfer�ncia" );
			bw.newLine();
			bw.write( "taxa da opera��o : "+"R$ "+"0.20" );
			bw.newLine();
			bw.write( "valor da transfer�ncia: "+"R$ "+valor);
			bw.newLine();
			bw.write( "favorecido  "+conta.getCliente().getNome() );
			bw.newLine();
			bw.write( "conta favorecida :  "+conta.getNumero() );
			
			}
		bw.close();
		fw.close();
		}
	
	public static void tributos (ContaCorrente conta,Double valor) throws IOException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss");
		String data = dtf.format(LocalDateTime.now());
		File arquivo = new File( "C:\\temp\\"+data+"  tributos.txt" );
		arquivo.createNewFile();
		
		FileWriter fw = new FileWriter( arquivo );
		BufferedWriter bw = new BufferedWriter( fw );
		
		if(conta.tipo.equalsIgnoreCase("corrente")) {
		bw.write( "--------------- tributo --------------- ");
		for(int i = 0 ;i<=2;i++) {
		bw.newLine();
		bw.write( "numero de "+conta.getTributos().get(i).getNome()+" feitos : " +conta.getTributos().get(i).getValor());
		bw.newLine();
		bw.write( "valor gasto em  "+ conta.getTributos().get(i).getNome() +" : "+" R$ "+(conta.getTributos().get(i).getValor()*0.10)  );
		}

		bw.close();
		fw.close();
	}
		
	}
	}

