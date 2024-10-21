package Back;

import java.sql.*;

public class Banco {
    public static Connection conexao; 
    public PreparedStatement comando; 
    public ResultSet tabela;
    
    public Banco() throws Exception{
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            if ((conexao == null) || (conexao.isClosed())) {
                conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lpb - dominio","user", "senha");
            }
            
        }
        catch(Exception ex){
            throw new Exception("Erro na conexão com o banco: "+ex.getMessage());
        }
    }
    
}
