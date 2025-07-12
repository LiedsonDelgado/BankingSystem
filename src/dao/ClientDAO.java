package dao;
import model.*;
import util.DataBaseConnection;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ClientDAO{
    public void insertOnDB(Client p_cliente) throws SQLException,IOException{
        String sqlQuery = "insert into Client(name,borned_year) values (?,?,?)";

    }

    public List<Client> listAll() throws SQLException,IOException{
        List clients = new ArrayList<>();
        String sqlQuery = "select * from clients";

        try(Connection connection = DataBaseConnection.makeConnection(); Statement smtnt = connection.createStatement(); ResultSet rslt = smtnt.executeQuery(sqlQuery)){
            while(rslt.next()){
                Client client = new Client(rslt.getInt("clientId"));

                client.setClientAdress(rslt.getString("name"));
                client.setBornedYear(rslt.getString("bornedYear"));
                client.setClientAdress(rslt.getString("clientAdress"));
                client.setClientPhoneNumber(rslt.getString("clientPhoneNumber"));
                client.setClientIDCard(rslt.getString("idCard"));
                client.setClientAge(rslt.getInt("age"));
                client.setAccount((Account)rslt.getObject("account"));

                clients.add(client);
            }
        }
        return clients;
    }

    public void updateOnDB(Client p_client) throws SQLException,IOException{

    }

    public boolean removeFromDB(Client p_client) throws SQLException,IOException{

        return true;
    }
}
