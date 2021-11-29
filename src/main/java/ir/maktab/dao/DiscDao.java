package ir.maktab.dao;

import ir.maktab.model.Disc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscDao extends BaseDao{
    public DiscDao() throws ClassNotFoundException, SQLException {
    }

    public void save(Disc disc) throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = "INSERT INTO discs(name)" + "VALUES (?)";
            PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
            statement.setString(1, disc.getName());
            int resultSet = statement.executeUpdate();
        }
    }
    public Integer findDiscIdByName(String name) throws SQLException {
        String sqlQuery = "SELECT id FROM discs  WHERE name = ?";
        PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int studentId = resultSet.getInt("id");
            return studentId;
        }
        return null;
    }
}
