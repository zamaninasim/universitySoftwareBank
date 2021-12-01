package ir.maktab.dao;

import ir.maktab.model.Borrow;
import ir.maktab.model.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BorrowDao extends BaseDao {

    public BorrowDao() throws ClassNotFoundException, SQLException {
    }

    public void save(Borrow borrow) throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = "INSERT INTO borrows(member,disc,date)" + "VALUES (?,?,?)";
            PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
            statement.setString(1, borrow.getPerson().getName());
            statement.setString(2, borrow.getDisc().getName());
            statement.setString(2, borrow.getDate().toString());
            int resultSet = statement.executeUpdate();
        }
    }
}
