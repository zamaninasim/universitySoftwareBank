package ir.maktab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    private final Connection connection;
    String jdbcURL = "jdbc:mysql://localhost:3306/university_software_bank";
    String username = "root";
    String password = "Nasim1374";

    public BaseDao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, username, password);
    }
    public Connection getConnection() {
        return connection;
    }
}
