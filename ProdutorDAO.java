package Back;

import java.sql.ResultSet;

public class ProdutorDAO {
    
    public int gravar(Produtor obj) throws Exception{ 
       Banco bb;
       int qtde = 0; 
       
       try{
           bb = new Banco();
           bb.comando = Banco.conexao.prepareStatement("Insert into cliente(nomeDeUsuario, email, telefone, senha, certificado) values(?, ?, ?, ?, ?);");
           bb.comando.setString(1, obj.getNomeDeUsuario());
           bb.comando.setString(2, obj.getEmail());
           bb.comando.setString(3, obj.getTelefone());
           bb.comando.setString(4, obj.getSenha());
           bb.comando.setString(5, obj.getCertificado());
           qtde = bb.comando.executeUpdate();
           Banco.conexao.close();
           return(qtde);
       }
       catch(Exception ex){
           throw new Exception("Erro ao gravar: "+ ex.getMessage());
       }
    }
    
    public int alterar(Produtor obj) throws Exception{ 
       Banco bb;
       int qtde = 0; 

       try{
           bb = new Banco();
           bb.comando = Banco.conexao.prepareStatement("Update cliente set nomeDeUsuario=?, email=?, telefone=?, senha=?, certificado=? where codigo=?;");
           bb.comando.setString(1, obj.getNomeDeUsuario());
           bb.comando.setString(2, obj.getEmail());
           bb.comando.setString(3, obj.getTelefone());
           bb.comando.setString(4, obj.getSenha());
           bb.comando.setString(5, obj.getCertificado());
           bb.comando.setInt(6, obj.getCodigo());
           qtde = bb.comando.executeUpdate();
           Banco.conexao.close();
           return(qtde);
       }
       catch(Exception ex){
           throw new Exception("Erro ao alterar: "+ ex.getMessage());
       }
    }
    
    public ResultSet listar() throws Exception{ // Avisa que o seu método dispara uma exceção
       Banco bb;       
       try{
           bb = new Banco();
           bb.comando = Banco.conexao.prepareStatement("Select codigo, nome from aluno order by 2;");
           bb.tabela = bb.comando.executeQuery();
           Banco.conexao.close();
           return(bb.tabela);
       }
       catch(Exception ex){
           throw new Exception("Erro ao listar: "+ ex.getMessage());
       }
    }
}
