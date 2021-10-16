package br.com.residencia.bankend.visual.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.residencia.bankend.bd.Query;
import br.com.residencia.bankend.contas.ContaCorrente;
import br.com.residencia.bankend.contas.ContaPoupanca;
import br.com.residencia.bankend.contas.Contas;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Deposito extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String login;
	private String senha;
	private Connection con;
	private JTextField txtCartao;
	private JTextField txtValor;
	private Contas contaDestinatario = null;
	private Contas contaRemetente = null;
	ContaCorrente corrente = null;
	private ContaPoupanca poupanca = null;

	private JLabel lblConta;
	private JLabel lblNome;
	private JButton btnVerificar;
	private JLabel lbl1;
	private JLabel lblCupomTipoConta;
	private JLabel lblValor;
	private JLabel lblAgencia;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lblTipo;

	public Deposito(Connection conexao, Contas contaRemetente) {
		this.con = conexao;
		this.contaRemetente = contaRemetente;

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Deposito.class.getResource("/br/com/residencia/bankend/imagens/cadeado-trancado.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_4_1 = new JButton("6");

		lbl3 = new JLabel("AGENCIA");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lbl3.setVisible(false);
		
		JLabel lblCupomConta = new JLabel("Conta:");
		lblCupomConta.setForeground(new Color(128, 128, 128));
		lblCupomConta.setBounds(1134, 211, 46, 14);
		contentPane.add(lblCupomConta);
		
		JLabel lblCupomNome = new JLabel("Nome:");
		lblCupomNome.setForeground(new Color(128, 128, 128));
		lblCupomNome.setBounds(1134, 167, 33, 14);
		contentPane.add(lblCupomNome);
		
		JLabel lblCupomAgencia = new JLabel("Agencia");
		lblCupomAgencia.setForeground(new Color(128, 128, 128));
		lblCupomAgencia.setBounds(1134, 189, 46, 14);
		contentPane.add(lblCupomAgencia);
		
		JLabel lblCupomFavorecido = new JLabel("Favorecido");
		lblCupomFavorecido.setForeground(new Color(112, 128, 144));
		lblCupomFavorecido.setBounds(1163, 147, 53, 14);
		contentPane.add(lblCupomFavorecido);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Esteves\\Desktop\\unnamed.png"));
		lblNewLabel_2.setBounds(823, 476, 278, 286);
		contentPane.add(lblNewLabel_2);
		lbl3.setForeground(Color.WHITE);
		lbl3.setBounds(732, 403, 59, 14);
		contentPane.add(lbl3);

		lbl2 = new JLabel("CONTA");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lbl2.setVisible(false);

		lblTipo = new JLabel("TIPO");
		lblTipo.setVisible(false);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo.setBounds(825, 375, 104, 14);
		contentPane.add(lblTipo);
		lbl2.setForeground(Color.WHITE);
		lbl2.setBounds(811, 403, 46, 14);
		contentPane.add(lbl2);

		JButton btnNewButton_3_1_2 = new JButton("");
		btnNewButton_3_1_2.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\atencao.png"));
		btnNewButton_3_1_2.setBackground(Color.YELLOW);
		btnNewButton_3_1_2.setBounds(1170, 534, 48, 22);
		contentPane.add(btnNewButton_3_1_2);

		lblAgencia = new JLabel("Agencia");
		lblAgencia.setForeground(Color.WHITE);
		lblAgencia.setBounds(737, 424, 59, 14);
		contentPane.add(lblAgencia);

		lblNome = new JLabel("New label");
		lblNome.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 26));
		lblNome.setBounds(796, 327, 197, 54);
		contentPane.add(lblNome);

		JButton btnVerde = new JButton("");
		btnVerde.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\marca-de-verificacao (2).png"));
		btnVerde.setBackground(new Color(50, 205, 50));
		btnVerde.setBounds(1231, 534, 48, 22);
		contentPane.add(btnVerde);
		btnNewButton_4_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4_1.setBounds(1231, 445, 48, 22);
		contentPane.add(btnNewButton_4_1);

		JButton btnNewButton_4_1_1 = new JButton("0");
		btnNewButton_4_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4_1_1.setBounds(1170, 505, 48, 22);
		contentPane.add(btnNewButton_4_1_1);

		JButton btnNewButton_3_1_1 = new JButton("#");
		btnNewButton_3_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3_1_1.setBounds(1231, 505, 48, 22);
		contentPane.add(btnNewButton_3_1_1);

		JButton btnNewButton_6 = new JButton("*");
		btnNewButton_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton_6.setBounds(1111, 505, 48, 22);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\cancelar.png"));
		btnNewButton_3_1.setBackground(new Color(220, 20, 60));
		btnNewButton_3_1.setBounds(1111, 534, 50, 22);
		contentPane.add(btnNewButton_3_1);

		JButton btnNewButton = new JButton("1");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(1111, 416, 48, 22);
		contentPane.add(btnNewButton);
//aaa
		JButton btnNewButton_5 = new JButton("8");
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.setBounds(1170, 476, 48, 22);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_1_1 = new JButton("9");
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_1.setBounds(1231, 476, 48, 22);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_2_1 = new JButton("7");
		btnNewButton_2_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2_1.setBounds(1111, 475, 48, 22);
		contentPane.add(btnNewButton_2_1);

		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(1170, 416, 48, 22);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(1231, 416, 48, 22);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("4");

		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(1110, 445, 48, 22);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.setBounds(1170, 445, 48, 22);
		contentPane.add(btnNewButton_4);

		lblConta = new JLabel("Conta:");
		lblConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConta.setForeground(Color.WHITE);
		lblConta.setBackground(Color.WHITE);
		lblConta.setBounds(812, 424, 90, 14);
		contentPane.add(lblConta);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Esteves\\Downloads\\A23.png"));
		lblNewLabel_1.setBounds(701, 412, 214, 43);
		contentPane.add(lblNewLabel_1);

		btnVerificar = new JButton("VERIFICAR");

		btnVerificar.setBounds(818, 381, 97, 23);
		contentPane.add(btnVerificar);

		lblValor = new JLabel("INFORME UM VALOR");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValor.setBounds(1140, 284, 113, 15);
		contentPane.add(lblValor);

		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(1145, 309, 97, 20);
		contentPane.add(txtValor);

		lblCupomTipoConta = new JLabel("Deposito em conta");
		lblCupomTipoConta.setHorizontalAlignment(SwingConstants.LEFT);
		lblCupomTipoConta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCupomTipoConta.setForeground(SystemColor.controlShadow);
		lblCupomTipoConta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCupomTipoConta.setBounds(1127, 126, 141, 17);
		contentPane.add(lblCupomTipoConta);
		lblCupomTipoConta.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\BANKEND\\macahdoo98.png"));
		lblNewLabel_3.setBounds(921, -538, 1026, 1913);
		contentPane.add(lblNewLabel_3);

		lbl1 = new JLabel("Conta:");
		lbl1.setForeground(Color.WHITE);
		lbl1.setBackground(Color.WHITE);
		lbl1.setBounds(797, 331, 158, 14);
		contentPane.add(lbl1);

		txtCartao = new JTextField();
		txtCartao.setColumns(10);
		txtCartao.setBounds(795, 348, 160, 20);
		contentPane.add(txtCartao);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\card222323.png"));
		lblNewLabel.setBounds(512, 143, 638, 365);
		contentPane.add(lblNewLabel);

		JLabel ImgBackground = new JLabel("");
		ImgBackground.setBounds(0, 0, 1375, 705);
		ImgBackground.setIcon(new ImageIcon("C:\\Users\\Esteves\\Pictures\\2133232232323.jpg"));
		contentPane.add(ImgBackground);

		Query bd = new Query(con);

		lblNome.setVisible(false);

		// setando visibilidade dos components

		lblConta.setVisible(false);
		lblCupomTipoConta.setVisible(false);
		lblValor.setVisible(false);
		txtValor.setVisible(false);
		lblAgencia.setVisible(false);

		btnVerificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// pegando conta digitada no texto
				String numConta = txtCartao.getText();

				// verifica se a conta do destinatario � igual
				if (numConta.equals(contaRemetente.getNumero())) {
					JOptionPane.showMessageDialog(null, "MESMA CONTA!!", "#ERRO404", JOptionPane.ERROR_MESSAGE);

				} else {
					// metodo verifica se a conta informada � valida
					contaDestinatario = bd.verificaConta(numConta);
					mensagemContinuar();

				}

			}
		});

		btnVerde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// pegando e convertendo valor inforamdo
				String valor = txtValor.getText();
				Double deposito = Double.parseDouble(valor);

				System.out.println(valor);

				// verificando qual conta �
				if (contaRemetente.getTipo().equals("corrente")) {

					// fazend o cast
					corrente = (ContaCorrente) contaRemetente;

					corrente.deposito(contaDestinatario, deposito);

					// gambiarra refazendo o cast
					Contas contaRemetnetee = null;

					contaRemetnetee = corrente;

					bd.deposito(contaDestinatario,deposito);

				}

				if (contaRemetente.getTipo().equals("poupanca")) {

					poupanca = (ContaPoupanca) contaRemetente;

					poupanca.deposito(contaDestinatario, deposito);

					// gambiarra refazendo o cast
					Contas contaRemetnetee = null;

					contaRemetnetee = poupanca;

					bd.deposito(contaDestinatario,deposito);

					System.out.println("SOU POUPANCA");
				}

			}
		});

	}

	public boolean mensagemContinuar() {

		String nome = contaDestinatario.getCliente().getNome();

		int i = JOptionPane.showConfirmDialog(null, "Destinario: " + nome + "\n \n \t \t \t  Deseja continuar?",
				"Transferencia", JOptionPane.OK_CANCEL_OPTION);

		// se clicar em sim
		if (i == JOptionPane.YES_OPTION) {
			System.out.println("Clicou em Sim");

			String nome1 = contaDestinatario.getCliente().getNome();
			String sobrenome = contaDestinatario.getCliente().getSobreNome();

			// setando textos
			lblConta.setText(contaDestinatario.getNumero());
			lblNome.setText(nome1 + " " + sobrenome);
			lblAgencia.setText(contaDestinatario.getAgencia());
			lblTipo.setText("Conta: " + contaDestinatario.getTipo());

			// setando visibilidade dos componentes
			lblConta.setVisible(true);
			btnVerificar.setVisible(false);
			txtCartao.setVisible(false);
			lbl1.setVisible(false);
			lblNome.setVisible(true);
			lblCupomTipoConta.setVisible(false);
			lblValor.setVisible(true);
			txtValor.setVisible(true);
			lbl2.setVisible(true);
			lbl3.setVisible(true);
			lblAgencia.setVisible(true);
			lblTipo.setVisible(true);

		}
		
		// se clicar em nao

		else if (i == JOptionPane.CANCEL_OPTION) {

			System.out.println("Clicou em N�o");
			txtCartao.setText("");

		}
		return rootPaneCheckingEnabled;

	}
//vaiiiiiiiiiiiiiiii  AGORAAAAAAAAAAAAA
}
