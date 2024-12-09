
import java.sql.ResultSet;

public class ProdutoDAO {
    
    public int gravar(Produto obj) throws Exception{ 
       Banco bb;
       int qtde = 0; 
       
       try{
           bb = new Banco();
           bb.comando = Banco.conexao.prepareStatement("Insert into produto(nomeProduto, precoProduto, unidadeDeMedida, peso, qtdeProduto) values(?, ?, ?, ?, ?);");
           bb.comando.setString(1, obj.getNomeProduto());
           bb.comando.setDouble(2, obj.getPrecoProduto());
           bb.comando.setString(3, obj.getUnidadeDeMedida());
           bb.comando.setDouble(4, obj.getPeso());
           bb.comando.setInt(5, obj.getQtdeProduto());

           qtde = bb.comando.executeUpdate();
           Banco.conexao.close();
           return(qtde);
       }
       catch(Exception ex){
           throw new Exception("Erro ao gravar: "+ ex.getMessage());
       }
    }
    
    public int alterar(Produto obj) throws Exception{ 
       Banco bb;
       int qtde = 0; 

       try{
           bb = new Banco();
           bb.comando = Banco.conexao.prepareStatement("Update produto set nomeProduto=?,precoProduto=?, unidadeDeMedida=?, peso=?, qtdeProduto=? where codigo=?;");
           bb.comando.setString(1, obj.getNomeProduto());
           bb.comando.setDouble(2, obj.getPrecoProduto());
           bb.comando.setString(3, obj.getUnidadeDeMedida());
           bb.comando.setDouble(4, obj.getPeso());
           bb.comando.setInt(5, obj.getQtdeProduto());
           bb.comando.setInt(6, obj.getCodigo());

           qtde = bb.comando.executeUpdate();
           Banco.conexao.close();
           return(qtde);
       }
       catch(Exception ex){
           throw new Exception("Erro ao alterar: "+ ex.getMessage());
       }
    }
    
    public ResultSet listarProdutos() throws Exception{
       Banco bb;       
       try{
           bb = new Banco();
           bb.comando = Banco.conexao.prepareStatement("Select codigo, nomeProduto, precoProduto, unidadeDeMedida, peso, qtdeProduto from produto order by 2;");
           bb.tabela = bb.comando.executeQuery();
           Banco.conexao.close();
           return(bb.tabela);
       }
       catch(Exception ex){
           throw new Exception("Erro ao listar: "+ ex.getMessage());
       }
    }
}
