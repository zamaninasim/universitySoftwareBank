package ir.maktab.dao;

import ir.maktab.model.date.Date;
import ir.maktab.model.Borrow;
import ir.maktab.model.Disc;
import ir.maktab.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            statement.setString(3, borrow.getDate().toString());
            int resultSet = statement.executeUpdate();
        }
    }

    public boolean isMemberBorrowDisc(String member, String disc) throws SQLException {
        String sqlQuery = "SELECT * FROM borrows  WHERE member = ? AND disc=?";
        PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
        statement.setString(1, member);
        statement.setString(2, disc);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    public Borrow findMemberBorrow(String member, String disc) throws SQLException {
        String sqlQuery = "SELECT * FROM borrows  WHERE member = ? AND disc=?";
        PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
        statement.setString(1, member);
        statement.setString(2, disc);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String memberName = resultSet.getString("member");
            String discName = resultSet.getString("disc");
            String date = resultSet.getString("date");
            Disc borrowedDisc = new Disc(discName);
            Person person = new Person(memberName);
            String[] splitDate = date.split("/");
            int year = Integer.parseInt(splitDate[0]);
            int month = Integer.parseInt(splitDate[1]);
            int day = Integer.parseInt(splitDate[2]);
            Date borrowedDate = new Date(year, month, day);
            Borrow borrow = new Borrow(borrowedDisc, borrowedDate, person);
            return borrow;
        }
        return null;
    }
}
