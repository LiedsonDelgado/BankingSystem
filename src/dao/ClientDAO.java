package dao;
import model.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ClientDAO{
    public void insertOnDB(Client p_cliente) throws SQLException,IOException{
        String sqlQuery = "insert into Client(name,borned_year) values (?,?,?)";

    }

    public void updateOnDB(Client p_client) throws SQLException,IOException{

    }

    public boolean removeFromDB(Client p_client) throws SQLException,IOException{

        return true;
    }
}
