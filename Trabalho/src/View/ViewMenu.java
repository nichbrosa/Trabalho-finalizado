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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class ViewMenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtid;
	private JTable tbdados;
	private JTextField txtquantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenu frame = new ViewMenu();
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
	public ViewMenu() {
		setResizable(false);
		//heranca de ControllerMenuView
		ControllerMenuView menu = new ControllerMenuView(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewMenu.class.getResource("/Imagens/farmcacia 1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		StatusEnum e = StatusEnum.LOGADO;
		JLabel lblstatus = new JLabel("Status: "+e);
		lblstatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblstatus.setBounds(10, 87, 148, 22);
		contentPane.add(lblstatus);
		
		tbdados = new JTable();
		tbdados.setBounds(198, 0, 441, 362);
		contentPane.add(tbdados);
		tbdados.setRowSelectionAllowed(false);
		tbdados.setEnabled(false);
		tbdados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tbdados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id_produto", "Nome", "Quantidade"
			}
		));
		
		txtquantidade = new JTextField();
		txtquantidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtquantidade.setColumns(10);
		txtquantidade.setBounds(11, 301, 177, 33);
		contentPane.add(txtquantidade);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 199, 22);
		contentPane.add(menuBar);
		
		JMenu File = new JMenu("Dados");
		menuBar.add(File);
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtnome.setBounds(11, 226, 177, 33);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		

		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtid.setBounds(10, 151, 121, 33);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		
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
				//verifica se os txt estao vazios avisando que algo nao foi informado
				if(txtnome.getText().isEmpty() || txtquantidade.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nome do produto não informado!\nQuantidade do produto não informado!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}else {
				//se nao estiverem vazios e nao existirem ele sera salvo no banco
				String nome = txtnome.getText();
				int quantidade = Integer.parseInt(txtquantidade.getText());
					menu.salvaprodutos(nome, quantidade);
					}
				}
		});
		//botao muda de cor quando o mouse passar por cima e sair
		JButton btnid = new JButton("ID");
		File.add(btnid);
		btnid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnid.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnid.setBackground(getBackground());
			}
		});
		btnid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//caso o txtid seja nulo o programa avisara para preenchelo
				if(txtid.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null,"ID não informado!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}else {
					//caso o id nao seja nulo sera verificado se ele existe
					int id = Integer.parseInt(txtid.getText());
				boolean existe = menu.getProduto2(id)==null?false:true; 
					if(existe==true) {
					//caso ele exista sera executada heranca
				menu.abririd(id);
				}else if(existe==false) {
					//caso o id nao exista no banco sera avisado com um pop-up de erro
					JOptionPane.showMessageDialog(null,"ID não existe!", "ERROR!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnsalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		File.add(btnsalvar);
		
		JMenu mnNewMenu = new JMenu("Editar");
		menuBar.add(mnNewMenu);
		//botao muda de cor quando o mouse passar por cima e sair
		JButton btnatualizar = new JButton("Atualizar");
		btnatualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnatualizar.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnatualizar.setBackground(getBackground());
			}
		});
		btnatualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verificadores de textfields para eles nao serem nulos
				if(txtnome.getText().isEmpty() && txtquantidade.getText().isEmpty() && txtid.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null,"ID não informado!\nNome do produto não informado!\nQuantidade do produto não informado!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}else if(txtid.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null,"ID não informado!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}else if(txtnome.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Nome do produto não informado!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}else if(txtquantidade.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Quantidade do produto não informado!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}else {
					//caso nenhum deles seja nulo sera verificado a sua existencia
					int id = Integer.parseInt(txtid.getText());
					String nome = txtnome.getText();;
					int quantidade = Integer.parseInt(txtquantidade.getText());
				boolean existe = menu.getProdutos3(id, nome)==null?false:true; 
					if(existe==true) {	
						//se o nome ou id nao estiver condizente com o banco sera avisado com um pop-up de erro
						JOptionPane.showMessageDialog(null,"ID ou nome não existe!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}else if(existe==false) {
					//caso ele exista o usuario podera atualizar a quantidade do produto 
					menu.atualizarproduto(quantidade, id);	
					}
				}
			
			}
		});
		btnatualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnNewMenu.add(btnatualizar);
		//botao muda de cor quando o mouse passar por cima e sair
		JButton btnexcluir = new JButton("Excluir");
		btnexcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexcluir.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnexcluir.setBackground(getBackground());
			}
		});
		btnexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verificador de textfield caso nao tenha nada
				if(txtid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ID não digitado!", "Tente Novamente!", JOptionPane.INFORMATION_MESSAGE);
				}else {
				//caso ele exista no banco o mesmo sera excluido com todas as suas informacoes
				int id = Integer.parseInt(txtid.getText());
				menu.excluir(id);
				}
			}
		});
		btnexcluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnNewMenu.add(btnexcluir);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(11, 194, 70, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Quantidade");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(11, 269, 120, 22);
		contentPane.add(lblSenha);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(10, 119, 70, 22);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ViewMenu.class.getResource("/Imagens/verde ciano.jpeg")));
		lblNewLabel_1.setBounds(-14, -15, 679, 393);
		contentPane.add(lblNewLabel_1);
		//mostar os dados da tabela ao abrir a tela
		menu.tabela();
		
	}
	// metodos para heranca dos textfields para uso no ControllerMenuView
	public JTextField getTxtnome() {
		return txtnome;
	}

	public void setTxtnome(JTextField txtnome) {
		this.txtnome = txtnome;
	}

	public JTextField getTxtquantidade() {
		return txtquantidade;
	}

	public void setTxtquantidade(JTextField txtquantidade) {
		this.txtquantidade = txtquantidade;
	}

	public JTextField getTxtid() {
		return txtid;
	}

	public void setTxtid(JTextField txtid) {
		this.txtid = txtid;
	}

	public JTable getTbdados() {
		return tbdados;
	}

	public void setTbdados(JTable tbdados) {
		this.tbdados = tbdados;
	}
}
