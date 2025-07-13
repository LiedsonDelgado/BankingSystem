//Classe que estabelece a conexao com a base de dados do Sistema
package util;
import java.sql.*;

public class TestDataBaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/BankingSystemDB";
        String user = "root";
        String password = "Cisco@2020";

        try(Connection conn = DriverManager.getConnection(url,user,password)){
            System.out.println("Conexao com a Base de Dados estabelecida com sucesso!");

            Statement stmnt = conn.createStatement();
            ResultSet rslt = stmnt.executeQuery("show tables");
            System.out.println(rslt);
        }catch(SQLException error){
            System.out.println("Erro de conexao: "+error.getMessage());
        }
    }
}

