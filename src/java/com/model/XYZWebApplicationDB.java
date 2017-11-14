package com.model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XYZWebApplicationDB {
    JDBCWrapper wrapper;
    
    public XYZWebApplicationDB(JDBCWrapper w)
    {
        wrapper = w;
    }
    
    public void insertMember(Member m)
    {
        java.sql.Date sqlDOB = new java.sql.Date(m.getDOB().getTime());
        java.sql.Date sqlReg = new java.sql.Date(m.getDOB().getTime());
        wrapper.createStatement();
        try {
            wrapper.getStatement().executeUpdate("insert into members values ('" + m.getUsername() + "', '" + m.getFullName() + "', '" + m.getAddress() + "', '" + sqlDOB.toString() + "', '" + sqlReg.toString() + "', '" + m.getStatus() + "', " + m.getBalance() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertUser(User u)
    {
        wrapper.createStatement();
        try {
            wrapper.getStatement().executeUpdate("insert into users values ('" + u.getId() + "', '" + u.getPassword() + "', '" + u.getStatus() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User getUser(String id)
    {
        User ret = new User();
        wrapper.createStatement();
        wrapper.findRecord("users", "id", id);
        try {
            ret.setId(wrapper.getResultSet().getString("id"));
            ret.setPassword(wrapper.getResultSet().getString("password"));
            ret.setStatus(wrapper.getResultSet().getString("status"));
        } catch (SQLException ex) {
            Logger.getLogger(XYZWebApplicationDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
