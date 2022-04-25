package jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String databaseName = "company";
        String userName = "root";
        String password ="";
        Connection connection = getMySQLConnection(hostName,databaseName,userName,password);
        return connection;
    }
    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password)
            throws SQLException, ClassNotFoundException{

//Load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

//Tao chuoi ket noi den CSDL. Connection String
        String connURL = "jdbc:mysql://" +hostName +":3306/" + dbName;
//Thuc hien ket noi voi csdl
        Connection connection = DriverManager.getConnection(connURL,userName,password);
//Tra ve doi tuong ket noi sau khi ket noi thanh cong
        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection = getMySQLConnection();
        if(connection!=null){
            System.out.println("Ket noi CSDL thanh cong");
        }

    }
}