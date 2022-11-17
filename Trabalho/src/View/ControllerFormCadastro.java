package View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ControllerFormCadastro {
	
	// para ver as classes do ViewCadastro
	private ViewCadastro view;
	
	public ControllerFormCadastro(ViewCadastro view) {
		this.view = view;
		
	}
	//metodo para salvar o usuario
	public void salvaUsuario() {
		String usuario = view.getTxtusuario().getText();
		String senha = view.getTxtsenha().getText();
		//verifica se o usuario ja existe no banco ou nao
		String sql1 = "select * from login where usuario=?";
		 
		 PreparedStatement stmt;
		try {
			Connection conexao = new Conexao().getConnection();
			stmt = conexao.prepareStatement(sql1);	
			stmt.setString(1, usuario);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			//caso exista no banco ele mostra um aviso de erro
		if(rs.next()) {
			JOptionPane.showMessageDialog(null, "Usuario ja existe!", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}else  if(usuario.isEmpty() || senha.isEmpty()) {
			//caso os txt sejam vazios ele mostra um aviso de erro
			JOptionPane.showMessageDialog(null, "Valores nulos não são aceitos!", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}else {	
			//caso ele nao exista e o usuario coloque as informacoes certas ele vai adicionar as informações no banco
			String sql = "insert into login(usuario, senha) values(?, ?); ";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, usuario);
			statement.setString(2, senha);
			statement.execute();
			statement.close();
			stmt.close();
			conexao.close();
			//ao adicionar as informações no banco, fechar a conexao e o statement o programa abre um aviso que o usuario foi adicionado no banco
			JOptionPane.showMessageDialog(null, "Usuario Cadastrado!", "Parabens!", JOptionPane.CLOSED_OPTION);
			}
		} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
			}	
		}
		
	}

