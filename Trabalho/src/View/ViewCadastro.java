package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JTextField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastro frame = new ViewCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewCadastro() {
		setResizable(false);
		//heranca de ControllerFormCadastro
		ControllerFormCadastro Controller = new ControllerFormCadastro(this);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewCadastro.class.getResource("/Imagens/farmcacia 1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtusuario = new JTextField();
		txtusuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtusuario.setColumns(10);
		txtusuario.setBounds(10, 44, 216, 26);
		contentPane.add(txtusuario);
		
		txtsenha = new JTextField();
		txtsenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtsenha.setColumns(10);
		txtsenha.setBounds(10, 114, 216, 26);
		contentPane.add(txtsenha);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(10, 10, 66, 24);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(10, 80, 66, 24);
		contentPane.add(lblSenha);
		//botao muda de cor quando o mouse passar por cima e sair
		JButton btnsalvar = new JButton("Salvar");
		btnsalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnsalvar.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnsalvar.setBackground(getBackground());
			}
		});
		btnsalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//heranca do metodo salvaUsuario do COntrollerFormCadastro
				Controller.salvaUsuario();
				
			}
		});
		btnsalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnsalvar.setBounds(10, 150, 216, 33);
		contentPane.add(btnsalvar);
		//botao muda de cor quando o mouse passar por cima e sair
		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnvoltar.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnvoltar.setBackground(getBackground());
			}
		});
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ao clicar no botao voltar a tela ViewCadastro e tirada e a tela ViewLogin fica visivel
				ViewLogin view = new ViewLogin();
				view.setVisible(true);
				dispose();
			}
		});
		btnvoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnvoltar.setBounds(10, 193, 216, 33);
		contentPane.add(btnvoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewCadastro.class.getResource("/Imagens/verde ciano.jpeg")));
		lblNewLabel.setBounds(-11, 0, 286, 308);
		contentPane.add(lblNewLabel);
	}
	// metodos para heranca dos textfields para uso no ControllerFormCadastro
	public JTextField getTxtusuario() {
		return txtusuario;
	}

	public void setTxtusuario(JTextField txtusuario) {
		this.txtusuario = txtusuario;
	}
	public JTextField getTxtsenha() {
		return txtsenha;
	}

	public void setTxtsenha(JTextField txtsenha) {
		this.txtsenha = txtsenha;
	}
}
