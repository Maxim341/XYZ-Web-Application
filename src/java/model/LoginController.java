
package model;

/**
 *
 * @author BMT
 */
public class LoginController {
    
    //public ArrayList<Member> members;
   
    public LoginController() {
    }

    public boolean authenticate(String username, String password) {
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}

