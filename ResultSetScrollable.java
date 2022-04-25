package jdbcapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetScrollable {

    public static void main(String[] args) throws SQLException,ClassNotFoundException {
//Gọi Connection kết nối đến CSDL từ lớp SQLServerConnection
        Connection connection = MySQLConnection.getMySQLConnection();

//Tạo Statement. It nhạy cảm với sự thay đổi của bảng.
//Chỉ đọc
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        String query = "select * from employee";

//Thuc thi chi thi cua SQL thong qua statement
        ResultSet resultSet = statement.executeQuery(query);

//di chuyen con tro den cuoi ban ghi
        boolean last = resultSet.last();
        System.out.println("Last: "+last);
        if(last){
//ghi ban ghi cua Last
            System.out.println("Employee Id: "+resultSet.getInt(1));
            System.out.println("Employee No: "+resultSet.getString(2));
            System.out.println("Employee's name: "+resultSet.getString(3));
        }


//di chuyen con tro den dau ban ghi
        boolean first = resultSet.first();
        System.out.println("First: "+first);
        if(first){
//ghi ban ghi cua Last
            System.out.println("Employee Id: "+resultSet.getInt(1));
            System.out.println("Employee No: "+resultSet.getString(2));
            System.out.println("Employee's name: "+resultSet.getString(3));
        }




        while (resultSet.next()){
//Lay du lieu theo id cua cot 2
            String empNo = resultSet.getString(2);

//Lay du lieu theo id cua cot 1
            int empId = resultSet.getInt(1);

//Lay due lieu theo ten cot(column label)
            String empName = resultSet.getString("name");
            System.out.println("--------------------------------------");
            System.out.println("Id: "+empId);
            System.out.println("Emp No: "+empNo);
            System.out.println("Name : "+empName);

        }
        connection.close();
    }
}
