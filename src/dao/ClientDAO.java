package dao;
import model.*;
import util.ConnectionToDB;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ClientDAO{

    //Insere dados de um Cliente na Base de Dados
    public void insertOnDB(Client p_client) throws SQLException,IOException{
        String sqlQuery = "insert into Client(name_client,adress,phone_number,id_card,age) values (?,?,?,?,?)";

        try(Connection connection = ConnectionToDB.makeConnection();PreparedStatement stmnt = connection.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS)){

            stmnt.setString(1,p_client.getClientName());
            stmnt.setString(2,p_client.getClientAdress());
            stmnt.setString(3,p_client.getClientPhoneNumber());
            stmnt.setString(4,p_client.getClientIDCard());
            stmnt.setInt(5,p_client.getClientAge());

            stmnt.executeUpdate();

            try(ResultSet rslt = stmnt.getGeneratedKeys()){
                if(rslt.next()){
                    p_client.setClientId(rslt.getInt(1));
                }
            }
        }

    }

    //Lista todos os Clientes da Base de Dados
    public List<Client> listAll() throws SQLException,IOException{
        List clients = new ArrayList<>();
        String sqlQuery = "select * from clients";

        try(Connection connection = ConnectionToDB.makeConnection(); Statement smtnt = connection.createStatement(); ResultSet rslt = smtnt.executeQuery(sqlQuery)){
            while(rslt.next()){
                Client client = new Client();

                client.setClientId(rslt.getInt("id_client"));
                client.setClientIDCard(rslt.getString("id_card"));
                client.setClientAdress(rslt.getString("name_client"));
                client.setClientEmail(rslt.getString("email_client"));
                client.setBornedYear(rslt.getString("borned_year_client"));
                client.setClientAdress(rslt.getString("adress"));
                client.setClientPhoneNumber(rslt.getString("phone_number"));
                client.setClientAge(rslt.getInt("age"));

                clients.add(client);
            }
        }
        return clients;
    }

    //Lista todos os Clientes da Base de Dados

    //Executa uma determinada atualizacao na Base de Dados
    public void updateOnDB(Client p_client) throws SQLException,IOException{

    }

    //Remove um Cliente da Base de Dados pelo ID
    public boolean removeFromDB(Client p_client) throws SQLException,IOException{
        int id = p_client.getClientId();
        String sqlQuery = "delete from clients where id = ?";

        try(Connection connection = ConnectionToDB.makeConnection(); PreparedStatement stmnt = connection.prepareStatement(sqlQuery)){
            stmnt.setInt(1,id);
            stmnt.executeUpdate();
        }

        return true;
    }
}
