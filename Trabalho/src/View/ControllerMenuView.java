package View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class ControllerMenuView {
	private ViewMenu view;
	public int length;

	ControllerMenuView(ViewMenu view) {
		super();
		this.view = view;
	}
	
	public void salvaprodutos(String nome, int quantidade) {
		
			String sql1 = "select * from produtos where nome=?";
			PreparedStatement statement;
			try {
			Connection conexao = new Conexao().getConnection();
			statement = conexao.prepareStatement(sql1);
			statement.setString(1, nome);
			statement.execute();  
			ResultSet rs = statement.getResultSet();	
			 if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Produto ja existe!", "ERROR!", JOptionPane.ERROR_MESSAGE);
			 }else {
				
					String sql = "insert into produtos(nome, qntd) values (?, ?);";

					PreparedStatement stmt;
					
						stmt = conexao.prepareStatement(sql);
				
					stmt.setString(1, nome);
					stmt.setInt(2, quantidade);
					stmt.execute();
					stmt.close();
					statement.close();
					conexao.close();
					tabela();
					JOptionPane.showMessageDialog(null, "Produto Cadastrado!", "Parabens!", JOptionPane.CLOSED_OPTION);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					}
				}
		
	
	public void abririd(int id) {
		if(view.getTxtid().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor informe um ID!", "Tente Novamente!", JOptionPane.ERROR_MESSAGE);
		}else {
		try {
			Connection conexao = new Conexao().getConnection();
			
			String sql = "select *from produtos where id=?";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				view.getTxtid().setText(rs.getString("id"));
				view.getTxtnome().setText(rs.getString("nome"));
				view.getTxtquantidade().setText(rs.getString("qntd"));
				
				
				}
			rs.close();
			stmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
					}
				}
			}
		public void tabela() {
			try {
				Connection conexao = new Conexao().getConnection();
				//seleciona todos os dados
				String sql = "select *from produtos";
				
				PreparedStatement stmt = conexao.prepareStatement(sql);
				
				ResultSet rs = stmt.executeQuery();
				//para passar a tabela pro programa
				DefaultTableModel modelo = (DefaultTableModel) view.getTbdados().getModel();
				//inicia com nada
				modelo.setNumRows(0);
				
				while(rs.next()) {
					//vai passar pra tabela em ordem os valores
					modelo.addRow(new Object[] {rs.getString("id"), rs.getString("nome"), rs.getString("qntd")});
					
					
				}
				
				rs.close();
				conexao.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		public void atualizarproduto(int quantidade, int id){
			
		
            try {
                Connection con = new Conexao().getConnection();

                String sql = "update produtos set qntd=? where id=?";

                PreparedStatement stmt = con.prepareStatement(sql);



                stmt.setInt(1, quantidade);
                stmt.setInt(2, id);
                
                stmt.execute();
                stmt.close();
                con.close();
                tabela();
                JOptionPane.showMessageDialog(null, "Valor atualizado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            	}
             
			}
		public void excluir(int id) {
				boolean existe = getProduto2(Integer.parseInt(view.getTxtid().getText()))==null?false:true;
				if(existe==true) {
				try {
					String sql = "delete from produtos where id=?";
					Connection con = new Conexao().getConnection();
					PreparedStatement stmt = con.prepareStatement(sql);
				
					stmt.setInt(1,id);	
					stmt.execute();
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Dados deletados", "Parabens!", JOptionPane.PLAIN_MESSAGE);
					view.getTxtid().setText("");
					view.getTxtnome().setText("");
					view.getTxtquantidade().setText("");
					tabela();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "ID indisponivel!", "Tente Novamente!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		public Produtos getProdutos1(String nome, int quantidade) {
			Produtos produto = null;
			String sql = "SELECT * FROM produtos WHERE nome = ? and qtnd = ?";

			PreparedStatement stmt;
			try {
				Connection conexao = new Conexao().getConnection();
				stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, nome);
			stmt.setInt(2, quantidade);
			stmt.execute();
			
			ResultSet rs = stmt.getResultSet();
			rs.next();
			
			int id = rs.getInt("id");
			
			produto = new Produtos(id, nome, quantidade);
			
			stmt.close();
			conexao.close();
			
			return produto;
			} catch (SQLException e) {
				return null;
				}
			}
		public Produtos getProduto2(int id){
			Produtos prod = null;
			
			String sql = "SELECT * FROM produtos WHERE id = ?";

			PreparedStatement stmt;
			try {
				Connection conexao = new Conexao().getConnection();
				stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			stmt.execute();
			
			ResultSet rs = stmt.getResultSet();
			rs.next();
			
			String nome = rs.getString("nome");
			int quantidade = rs.getInt("qntd");
			
		    prod = new Produtos(id, nome, quantidade);
			
			stmt.close();
			conexao.close();
			
			return prod;
			} catch (SQLException e) {
				return null;
				}
			}
		public Produtos getProdutos3(int id1, String nome) {
			Produtos produto = null;
			String sql = "SELECT * FROM produtos WHERE id = ? and nome = ?";

			PreparedStatement stmt;
			try {
				Connection conexao = new Conexao().getConnection();
				stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, nome);
			stmt.setInt(2, id1);
			stmt.execute();
			
			ResultSet rs = stmt.getResultSet();
			rs.next();
			
			int id = rs.getInt("id");
			
			produto = new Produtos(id, nome);
			
			stmt.close();
			conexao.close();
			
			return produto;
			} catch (SQLException e) {
				return null;
				}
			}
		
		}
