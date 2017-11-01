package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

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
            wrapper.createStatement();
            wrapper.createResultSet("select * from USERS");

            // iterate through the java resultset
            while (wrapper.getResultSet().next()) {
                String id = wrapper.getResultSet().getString("id");
                String password = wrapper.getResultSet().getString("password");
                String status = wrapper.getResultSet().getString("status");

                users.add(new User(id,password,status));
                
            }
            for(int i = 0; i != users.size(); ++i)
            {
                System.out.println("Username " + i + ": " + users.get(i).getPassword());
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
    
    
    public String createPassword() {
        String password = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        while (builder.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * password.length());
            builder.append(password.charAt(index));
        }
        String finalPass = builder.toString();
        System.out.println(finalPass);
        return finalPass;

    }
    
    
    
    
}
