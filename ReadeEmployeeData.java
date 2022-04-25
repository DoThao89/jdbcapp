package jdbcapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadeEmployeeData {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Tra ve 1 doi tuong connection da ket noi den CSDL
        //SQLConnection
        //Connection connection = SQLServerConnection.getSQLServerConnection();
        //MySQL Connection
        Connection connection = MySQLConnection.getMySQLConnection();

        //Tao doi tuong Statement
        Statement statement = connection.createStatement();
        //Ket qua tra ve tu bang employee duoc ResultSet chua thong tin
        ResultSet resultSet = statement.executeQuery("select * from employee");
        while (resultSet.next()) {//Doc tu dau den het cac ban ghi
            {
                int empId = resultSet.getInt(1);
                String empNo = resultSet.getString(2);
                String name = resultSet.getString(("name"));
                System.out.println("-------------------");
                System.out.println("EmpId:" + empId);
                System.out.println("EmpNo:" + empNo);
                System.out.println("Name:" + name);
            }

        }
        connection.close();
    }
}