package Controller;

import Controller.ConfigManager;
import model.Config;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.*;

public class DatabaseManager {

    private Connection con ;

    private String connectionUrl;


    private Statement stmt ;


    private Config config;

    public DatabaseManager() throws IOException {

        con = null;

        this.config = ConfigManager.getConfig();

        setConnection();
    }

    private void setConnection(){
        connectionUrl = "jdbc:sqlserver://"+config.getUrl().trim()+":"+config.getPort().trim()+";" +
                "databaseName="+config.getDbName().trim()+";user="+config.getUsername()+";password="+config.getPassword();

    }

    public void openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(connectionUrl);
    }

    public void closeConnection() throws SQLException {
        this.stmt.close();
        this.con.close();
    }


    public ResultSet executeQuery(String sqlQuery) throws SQLException {
        stmt = con.createStatement();
        return stmt.executeQuery(sqlQuery);
    }

}
