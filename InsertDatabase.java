// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)


package jdbcapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDatabase {
    public InsertDatabase() {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getMySQLConnection();
        Statement statement = connection.createStatement();
        String query = "insert into employee values(8,'F008','Hoang Anh')";
        int row = statement.executeUpdate(query);
        System.out.println("row " + row);
    }
}

