package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
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
	public ViewLogin() {
		setResizable(false);
		
		ControllerLogin controller = new ControllerLogin(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewLogin.class.getResource("/Imagens/farmcacia 1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		StatusEnum e = StatusEnum.ESPERANDO_LOGIN;
		JLabel lblNewLabel_2 = new JLabel("Status: "+e);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(23, 10, 267, 27);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(82, 47, 79, 18);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		txtusuario = new JTextField();
		txtusuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtusuario.setBounds(82, 82, 144, 31);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(82, 127, 79, 18);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblSenha);
		
		txtsenha = new JPasswordField();
		txtsenha.setBounds(82, 155, 144, 32);
		txtsenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(txtsenha);
		
		JButton btnentrar = new JButton("Entrar");
		btnentrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnentrar.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnentrar.setBackground(getBackground());
			}
		});
		btnentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatusEnum i = StatusEnum.LOGIN_INVALIDO;
				String usuario = getTxtusuario().getText();
				String senha = String.valueOf(getTxtsenha().getPassword());		
				boolean existe = controller.getUsuario(usuario, senha)==null?false:true;	
				if(existe) {
					
					JOptionPane.showMessageDialog(null, "Bem vindo ao sistema "+usuario+" !", "Paraben!", JOptionPane.INFORMATION_MESSAGE);
					ViewMenu menu = new ViewMenu();							
					menu.setVisible(true);
					setVisible(false);
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Status: "+i+"\nLogin ou senha errada ou inexistente" , "Tente novamente", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnentrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnentrar.setBounds(82, 197, 144, 31);
		contentPane.add(btnentrar);
		
		JButton btncadastrar = new JButton("Cadastrar");
		btncadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btncadastrar.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btncadastrar.setBackground(getBackground());
			}
		});
		btncadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastro telacadastro = new ViewCadastro();
				telacadastro.setVisible(true);
				setVisible(false);
			}
		});
		btncadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btncadastrar.setBounds(82, 237, 144, 31);
		contentPane.add(btncadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ViewLogin.class.getResource("/Imagens/verde ciano.jpeg")));
		lblNewLabel_1.setBounds(-12, -11, 328, 322);
		contentPane.add(lblNewLabel_1);
	}

	public JTextField getTxtusuario() {
		return txtusuario;
	}

	public void setTxtusuario(JTextField txtusuario) {
		this.txtusuario = txtusuario;
	}

	public JPasswordField getTxtsenha() {
		return txtsenha;
	}

	public void setTxtsenha(JPasswordField txtsenha) {
		this.txtsenha = txtsenha;
	}

}
