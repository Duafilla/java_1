package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnectionTest {


    @Test
    public void testDbConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select group_id, group_name, group_header, group_footer from group_list");
            List<GroupData> groups = new ArrayList<>();
            while (resultSet.next()) {
                groups.add(new GroupData(resultSet.getInt("group_id"), resultSet.getString("group_name"), resultSet.getString("group_header"),
                        resultSet.getString("group_footer")));
            }
            resultSet.close();
            statement.close();
            conn.close();
            System.out.println(groups);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
