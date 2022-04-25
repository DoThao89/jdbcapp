package jdbcapp;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.mysql.cj.jdbc.exceptions.MySQLTimeoutException;

import java.sql.*;

public class LoginStatementAndPreparedStatement {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        loginStatment("'admin'", "'admin'");

    }
    public static void loginStatment(String username, String password) throws SQLException, ClassNotFoundException {
        //Step1,2:
        Connection connection = MySQLConnection.getMySQLConnection();
        String query = "select username from users where username = "+username+""+"and password="+password+"";
        //Step3: Create statement
        Statement statement = connection.createStatement();
        //Step 4: Create RasultSet
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.println("Login thanh cong:"+resultSet.getString("username"));
        }


    }
    public static void loginPreparedStatement(String username, String password) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getMySQLConnection();

            String query = "select username from users where username = ? and password = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Login thanh cong:" +resultSet.getString("username"));
        }

    }
}
