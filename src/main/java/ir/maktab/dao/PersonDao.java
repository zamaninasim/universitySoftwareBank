package ir.maktab.dao;

import ir.maktab.model.Disc;
import ir.maktab.model.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDao extends BaseDao {

    public PersonDao() throws ClassNotFoundException, SQLException {
    }

    public void save(Person person) throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = "INSERT INTO persons(name)" + "VALUES (?)";
            PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
            statement.setString(1, person.getName());
            int resultSet = statement.executeUpdate();
        }
    }
}
