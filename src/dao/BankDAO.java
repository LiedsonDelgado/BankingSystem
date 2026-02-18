package dao;
import model.*;
import util.ConnectionToDB;

import java.io.*;
import java.sql.*;
import java.util.*;

public class BankDAO{
    public BankDAO(){

    }

    //Faz uma determinada insercao na base de dados
    public void insertOnDB(){

    }

    //Faz uma determinada remocao na base de dados
    public void removeFromDB(){

    }

    //Lista todos os bancos da base de dados
    public void listAll(){

    }

    //Faz uma determinada consulta na base de dados
    public void queryOnDB(int p_code){
        String sqlQuery = "select name_bank,code_bank from bank where code_bank = ?";
        try{
            Connection connection = ConnectionToDB.makeConnection();
            PreparedStatement stmnt = connection.prepareStatement(sqlQuery);

            stmnt.setInt(1,p_code);
            ResultSet rlstSet = stmnt.executeQuery();

            System.out.println("CODIGO DO BANCO | NOME DO BANCO");
            System.out.println("-------------------------------");

            while(rlstSet.next()){
                String code = rlstSet.getString("code_bank");
                String name = rlstSet.getString("name_bank");
                System.out.println(code +"                               " +name);
            }
            rlstSet.close();
            stmnt.close();
            connection.close();
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }catch(IOException sqle){
            sqle.printStackTrace();
        }
    }

    //Executa uma determinada atualizacao na base de dados
    public void updateOnDB(){

    }
}

/* METODOS PADRAO PARA CADA CLASSE DAO

    //Faz uma determinada insercao na base de dados
    public void insertOnDB(){

    }

    //Faz uma determinada remocao na base de dados
    public void removeFromDB(){

    }

    //Lista todos as/os <...> da base de dados
    public void listAll(){

    }

    //Executa uma determinada atualizacao na base de dados
    public void updateOnDB(){

    }

*/
