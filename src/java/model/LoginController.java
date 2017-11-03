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
    public ArrayList<Member> members;

    public LoginController() {
        users = new ArrayList<>();
        members = new ArrayList<>();
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
            wrapper.getStatement().close();
        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public boolean authenticate(String id, String password) {
        for(int i = 0; i != users.size(); ++i)
        {
            if(password.equals(users.get(i).getPassword()) && id.equals(users.get(i).getId()))
                return true;
        }      
        return false;
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
