package jdbcapp;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

    //"Dấu" toàn bộ code SQL ko cho nó xuất hiện trong code java nữa
    public class CallableStatementDemo {
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            Connection connection = MySQLConnection.getMySQLConnection();

//PreparedStatement
//String query = "select * from employee where empid=? and name like ?";

//CallableStatement
            String query = "{call getEmployeeInfo(?,?,?)}";
            CallableStatement callableStatement = connection.prepareCall(query);


//Lay ket qua ten ra
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.VARCHAR);

            callableStatement.executeUpdate();
            int empId = callableStatement.getInt(1);
            String empNo = callableStatement.getString(2);
            String name = callableStatement.getString(3);

            System.out.println("Emp ID: "+empId);
            System.out.println("Emp No: "+empNo);
            System.out.println("Name: "+name);

        }
    }
