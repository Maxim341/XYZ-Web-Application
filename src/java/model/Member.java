
package model;

import java.util.Date;
import javax.mail.Address;

/**
 *
 * @author BMT
 */
public class Member {
    
    //variables
    private Address address;
    private Date DOB;
    private Date registration;
    
    private String username;
    private String password;
    
    
    
    
    //Constructor

    public Member(String username, String password, Address address, Date DOB, Date registration) {
        this.username = username;
        this.password = password;
        this.DOB=DOB;
        this.address = address;
        this.registration = registration;
    }

    
    
    //Getters and Setters
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
    
}
