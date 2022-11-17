package View;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexao {

	/**outra opcao de caminho para conexao
	 * private String caminho ="jdbc:mysql://localhost/aplicacao";
	 * private String usuario ="root";
	 * private String senha="#Endhome10";
	 */
	public Connection getConnection() throws SQLException{
		
		
		//obter conexao a partir do gerenciador de driver (entre aspas o caminho do arquivo)
		
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/aplicacao", "root", "Endhome10");
		
		return conexao;	
		
	}

}
