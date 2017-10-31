package model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author BMT
 */
public class LoginController {

    public ArrayList<User> users;

    public LoginController() {
        users = new ArrayList<>();
    }

    public void readUsers() {
        try {
            // create connection
            JDBCWrapper wrapper = new JDBCWrapper("org.apache.derby.jdbc.ClientDriver", "jdbc:derby://localhost:1527/XYZ Web Application DB", "root", "root");
            wrapper.createResultSet("select * from USERS");
            wrapper.createStatement();

            // iterate through the java resultset
            while (wrapper.getResultSet().next()) {
                String id = wrapper.getResultSet().getString("id");
                String password = wrapper.getResultSet().getString("password");
                String status = wrapper.getResultSet().getString("status");

                users.add(new User(id,password,status));
                
            }
            wrapper.getStatement().close();
        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public boolean authenticate(String username, String password) {
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
