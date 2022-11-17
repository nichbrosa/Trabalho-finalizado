package View;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ControllerLogin {
	private ViewLogin view;

	public ControllerLogin(ViewLogin view) {
		super();
		this.view = view;
	}
	public ViewLogin getView() {
		return view;
	}

	public void setView(ViewLogin view) {
		this.view = view;
	}
	
	public Usuario getUsuario(String user, String senha) {
		Usuario usuario = null;
		String sql = "SELECT * FROM login WHERE usuario = ? and senha = ?";

		PreparedStatement stmt;
		try {
			Connection conexao = new Conexao().getConnection();
			stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, user);
		stmt.setString(2, senha);
		stmt.execute();
		
		ResultSet rs = stmt.getResultSet();
		rs.next();
		
		int id = rs.getInt("id");
		
		usuario = new Usuario(id, user, senha);
		
		stmt.close();
		conexao.close();
		
		return usuario;
		} catch (SQLException e) {
			return null;
			}
		}
	}
	