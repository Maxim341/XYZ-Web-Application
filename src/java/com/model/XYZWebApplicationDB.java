package com.model;

import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XYZWebApplicationDB {
    JDBCWrapper wrapper;
    
    public XYZWebApplicationDB(JDBCWrapper w)
    {
        wrapper = w;
    }
      
    /*
    Name: insertMember
    Parameters: m : Member
    Returns: void
    Comments: Inserts member to DB
    */
    public void insertMember(Member m)
    {
        java.sql.Date sqlDOB = new java.sql.Date(m.getDOB().getTime());
        java.sql.Date sqlReg = new java.sql.Date(m.getRegistration().getTime());
        wrapper.createStatement();
        try {
            wrapper.getStatement().executeUpdate("insert into members values ('" + m.getUsername() + "', '" + m.getFullName() + "', '" + m.getAddress() + "', '" + sqlDOB.toString() + "', '" + sqlReg.toString() + "', '" + m.getStatus() + "', " + m.getBalance() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    Name: insertUser
    Parameters: u : User
    Returns: void
    Comments: inserts user to DB
    */
    public void insertUser(User u)
    {
        wrapper.createStatement();
        try {
            wrapper.getStatement().executeUpdate("insert into users values ('" + u.getId() + "', '" + u.getPassword() + "', '" + u.getStatus() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        /*
    Name: makePayment
    Parameters: u : user, rationale : String, amount : float
    Returns: void
    Comments: Makes payment in DB
    */
    public void makePayment(User u, String paymentType, float amount)
    {
        wrapper.createStatement();
        wrapper.createResultSet("SELECT * FROM payments");
        Payment p = new Payment();

        try {
            wrapper.getResultSet().last();
            p = new Payment(wrapper.getResultSet().getInt("id")+1, u.getId(), paymentType, amount, new Time(0), new Date());
        } catch (SQLException ex) {
            Logger.getLogger(XYZWebApplicationDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        insertPayment(p);
    }
    
    /*
    Name: insertPayment
    Parameters: p : Payment
    Returns: void
    Comments: Inserts payment to DB
    */
    public void insertPayment(Payment p)
    {
        java.sql.Date sqlDate = new java.sql.Date(p.getDate().getTime());
        java.sql.Time sqlTime = new java.sql.Time(p.getTime().getTime());
        wrapper.createStatement();
        try {
            wrapper.getStatement().executeUpdate("insert into payments values (" + p.getId() + ", '" + p.getMemid() + "', '" + p.getTypeOfPayment() + "', " + p.getAmount() + ", '" + sqlDate.toString() + "', '" + sqlTime.toString() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    Name: makeClaim
    Parameters: u : user, rationale : String, amount : float
    Returns: void
    Comments: Makes claim in DB
    */
    public void makeClaim(User u, String rationale, float amount)
    {
        wrapper.createStatement();
        wrapper.createResultSet("SELECT * FROM claims");
        Date d = new Date();
        Claim c = new Claim();
        try {
            wrapper.getResultSet().last();
            c = new Claim(wrapper.getResultSet().getInt("id")+1, u.getId(), d, rationale, "APPLIED", amount);
        } catch (SQLException ex) {
            Logger.getLogger(XYZWebApplicationDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        insertClaim(c);
    }
    
    /*
    Name: insertClaim
    Parameters: c : Claim
    Returns: void
    Comments: inserts claim from param
    */   
    public void insertClaim(Claim c)
    {
        java.sql.Date sqlDate = new java.sql.Date(c.getDate().getTime());
        wrapper.createStatement();
        try {
            wrapper.getStatement().executeUpdate("insert into claims values (" + c.getId() + ", '" + c.getMemid() + "', '" + sqlDate.toString() + "', '" + c.getRationale() + "', '" + c.getStatus() + "', " + c.getAmount() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    Name: getUser
    Parameters: id : String
    Returns: User
    Comments: Gets User from ID
    */
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
    
        /*
    Name: getMember
    Parameters: id : String
    Returns: Member
    Comments: Gets Member from ID
    */
    public Member getMember(String id)
    {
        Member ret = new Member();
        wrapper.createStatement();
        wrapper.findRecord("members", "id", id);
        try {
            String[] addressString = wrapper.getResultSet().getString("address").split(",");
            Address a = new Address(Integer.parseInt(addressString[0]), addressString[1], addressString[2], addressString[3], addressString[4]);
            ret = new Member(wrapper.getResultSet().getString("id"), wrapper.getResultSet().getString("name"), a, wrapper.getResultSet().getDate("dob"), wrapper.getResultSet().getDate("dor"), wrapper.getResultSet().getString("status"), wrapper.getResultSet().getFloat("balance"));
        } catch (SQLException ex) {
            Logger.getLogger(XYZWebApplicationDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    /*
    Name: getUserPayments
    Parameters: id : String
    Returns: ArrayList : Payment
    Comments: Takes ID and returns list of user payments
    */
    public ArrayList<Payment> getUserPayments(String id)
    {
        ArrayList ret = new ArrayList<Payment>();
        wrapper.findRecord("payments", "mem_id", id);
        try { 
            do
            {
               ret.add(new Payment(wrapper.getResultSet().getInt("id"), wrapper.getResultSet().getString("mem_id"), wrapper.getResultSet().getString("type_of_payment"), wrapper.getResultSet().getFloat("amount"), Time.valueOf(wrapper.getResultSet().getString("time")), makeDate(wrapper.getResultSet().getString("date"))));
            }while(wrapper.getResultSet().next());
        } catch (SQLException ex) {
            Logger.getLogger(XYZWebApplicationDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    /*
    Name: getAllMembers
    Parameters: none
    Returns: ArrayList : Member
    Comments: Returns arraylist of Members
    */
    public ArrayList<Member> getAllMembers()
    {
        ArrayList ret = new ArrayList<Member>();
        wrapper.createStatement();
        wrapper.createResultSet("SELECT * FROM members");
        try { 
            wrapper.getResultSet().next();
            do
            {
               String[] addressString = wrapper.getResultSet().getString("address").split(",");
               Address a = new Address(Integer.parseInt(addressString[0]), addressString[1], addressString[2], addressString[3], addressString[4]);
               ret.add(new Member(wrapper.getResultSet().getString("id"), wrapper.getResultSet().getString("name"), a, wrapper.getResultSet().getDate("dob"), wrapper.getResultSet().getDate("dor"), wrapper.getResultSet().getString("status"), wrapper.getResultSet().getFloat("balance")));
            }while(wrapper.getResultSet().next());
        } catch (SQLException ex) {
            Logger.getLogger(XYZWebApplicationDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
        /*
    Name: getAllPayments
    Parameters: none
    Returns: ArrayList : Payment
    Comments: Returns list of payments
    */
    public ArrayList<Payment> getMemberPayments(String id)
    {
        ArrayList ret = new ArrayList<Payment>();
        wrapper.findRecord("payments", "mem_id", id);
        try { 
            //wrapper.getResultSet().next();
            do
            {
               ret.add(new Payment(wrapper.getResultSet().getInt("id"), wrapper.getResultSet().getString("mem_id"), wrapper.getResultSet().getString("type_of_payment"), wrapper.getResultSet().getFloat("amount"), wrapper.getResultSet().getTime("time"), wrapper.getResultSet().getDate("date")));
            }while(wrapper.getResultSet().next());
        } catch (SQLException ex) {
            Logger.getLogger(XYZWebApplicationDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    /*
    Name: getAllPayments
    Parameters: none
    Returns: ArrayList : Payment
    Comments: Returns list of payments
    */
        public ArrayList<Payment> getAllPayments()
    {
        ArrayList ret = new ArrayList<Payment>();
        wrapper.createStatement();
        wrapper.createResultSet("SELECT * FROM payments");
        try { 
            wrapper.getResultSet().next();
            do
            {
               ret.add(new Payment(wrapper.getResultSet().getInt("id"), wrapper.getResultSet().getString("mem_id"), wrapper.getResultSet().getString("type_of_payment"), wrapper.getResultSet().getFloat("amount"), wrapper.getResultSet().getTime("time"), wrapper.getResultSet().getDate("date")));
            }while(wrapper.getResultSet().next());
        } catch (SQLException ex) {
            Logger.getLogger(XYZWebApplicationDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
        
        /*
    Name: getProvisionalMembers
    Parameters: none
    Returns: ArrayList : Member
    Comments: Returns Members "applied" 
    */
    public ArrayList<Member> getProvisionalMembers() {

        ArrayList<Member> users;
        users = getAllMembers();

        ArrayList ret = new ArrayList<Member>();

        for (Member user : users) {
            if (user.getStatus().equals("APPLIED")) {
                ret.add(user);
            }
        }
        return ret;
    }
    
    /*
    Name: getMemberClaims
    Parameters: id : String
    Returns: ArrayList
    Comments: takes in ID and returns claims of the Member
    */
    public ArrayList<Claim> getMemberClaims(String id)
    {
        ArrayList ret = new ArrayList<Claim>();
        wrapper.findRecord("claims", "mem_id", id);
        try { 
            do
            {
               ret.add(new Claim(wrapper.getResultSet().getInt("id"), wrapper.getResultSet().getString("mem_id"), wrapper.getResultSet().getDate("date"), wrapper.getResultSet().getString("rationale"),wrapper.getResultSet().getString("status"), wrapper.getResultSet().getFloat("amount")));
            }while(wrapper.getResultSet().next());
        } catch (SQLException ex) {
            Logger.getLogger(XYZWebApplicationDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    /*
    Name: getAllClaims
    Parameters: none
    Returns: ArratList : Claim
    Comments: Gets claims from DB and returns arrayList
    */
    public ArrayList<Claim> getAllClaims()
    {
        ArrayList ret = new ArrayList<Member>();
        wrapper.createStatement();
        wrapper.createResultSet("SELECT * FROM claims");
        try { 
            wrapper.getResultSet().next();
            do
            {
               ret.add(new Claim(wrapper.getResultSet().getInt("id"), wrapper.getResultSet().getString("mem_id"), wrapper.getResultSet().getDate("date"), wrapper.getResultSet().getString("rationale"),wrapper.getResultSet().getString("status"), wrapper.getResultSet().getFloat("amount")));
            }while(wrapper.getResultSet().next());
        } catch (SQLException ex) {
            Logger.getLogger(XYZWebApplicationDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    /*
    Name: makeDate
    Parameters: date : String
    Returns: date : Date
    Comments: takes in String and returns Date
    */
    public Date makeDate(String dateParam) {
        Date dob = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        try {
            dob = df.parse(dateParam);
        } catch (ParseException ex) {
            System.out.println("Parse exception");
        }
        return dob;
    }
    
    /*
    Name: changePassword
    Parameters: u : User
    Returns: void
    Comments: Takes in user and changes password in DB
    */
    public void changePassword(User u)
    {   
        wrapper.createStatement();
        try {
            wrapper.getStatement().executeUpdate("UPDATE users SET \"password\" = '"+ u.getPassword() +"' WHERE \"id\" = '" + u.getId() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    Name: approveMemberApplication
    Parameters: u : User
    Returns: void
    Comments: Takes in user and approves application
    */
    public void approveMemberApplication(User u)
    {
        wrapper.createStatement();   
        try {
            wrapper.getStatement().executeUpdate("UPDATE users SET \"status\" = 'APPROVED' WHERE \"id\" = '" + u.getId() + "'");
            wrapper.getStatement().executeUpdate("UPDATE members SET \"status\" = 'APPROVED' WHERE \"id\" = '" + u.getId() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    Name: suspendMemberApplication
    Parameters: u : User
    Returns: void
    Comments: Takes in user and suspends application in DB
    */
    public void suspendMemberApplication(User u)
    {
        wrapper.createStatement();   
        try {
            wrapper.getStatement().executeUpdate("UPDATE users SET \"status\" = 'SUSPENDED' WHERE \"id\" = '" + u.getId() + "'");
            wrapper.getStatement().executeUpdate("UPDATE members SET \"status\" = 'SUSPENDED' WHERE \"id\" = '" + u.getId() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    Name: approveClaim
    Parameters: c : Claim
    Returnns: void
    Comments: Takes in claim and approves in DB
    */
    public void approveClaim(Claim c)
    {
        wrapper.createStatement();  
        try {
            wrapper.getStatement().executeUpdate("UPDATE claims SET \"status\" = 'APPROVED' WHERE \"id\" = " + c.getId() + "");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    Name: approveClaim
    Parameters: c : Claim
    Returnns: void
    Comments: Takes in claim and approves in DB
    */
    public void rejectClaim(Claim c)
    {
        wrapper.createStatement();  
        try {
            wrapper.getStatement().executeUpdate("UPDATE claims SET \"status\" = 'REJECTED' WHERE \"id\" = " + c.getId() + "");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    Name: isWithinLastYear
    Parameters: d : Date
    Returns: boolean
    Comments: Generic function checks if date passed is within now and last year.
    */
    public boolean isWithinLastYear(Date d)
    {
        //Work out year in milliseconds.
        long millisecondsInYear = ( (long)365 * 24 * 60 * 60 * 1000 );
        Date yearAgo = new Date((new Date().getTime()) - millisecondsInYear);

        //If date passed is within now and a year ago today.
        if(yearAgo.before(d))
            return true;
        return false;
    }
    
    /*
    Name: isWithinLastSixMonths
    Parameters: d : Date
    Returns: boolean
    Comments: Generic function checks if date passed is within now and last six months.
    */
    public boolean isWithinLastSixMonths(Date d)
    {
        //Work out year in milliseconds.
        long millisecondsInYear = ( (long)180 * 24 * 60 * 60 * 1000 );
        Date yearAgo = new Date((new Date().getTime()) - millisecondsInYear);

        //If date passed is within now and a year ago today.
        if(yearAgo.before(d))
            return true;
        return false;
    }
    
    /*
    Name: isClaimLimit
    Parameters: u : User
    Returns: boolean
    Comments: checks if user has reacher their 2 claim limit
    */
    public boolean isClaimLimit(User u)
    {
        //Get all users claims.
        ArrayList<Claim> c = getMemberClaims(u.getId());
        
        //Count number of claims in past year.
        int limit = 0;
        for(int i = 0; i != c.size(); ++i)
        {
            if(isWithinLastYear(c.get(i).getDate()))
                ++limit;
        }
        
        //If limit equal to or past limit (2) return true.
        if(limit >= 2)
            return true;
        return false;
    }
    
    public OutstandingBalance calculateOutstandingBalance(User u)
    {
        OutstandingBalance ret = new OutstandingBalance();
        ret.setId(u.getId());
        
        ArrayList<Claim> claims = getMemberClaims(u.getId());
        ArrayList<Payment> payments = getMemberPayments(u.getId());
        
        for(int i = 0; i != claims.size(); ++i)
        {
            if(!isWithinLastYear(claims.get(i).getDate()) || !claims.get(i).getStatus().equals("APPROVED"))
            {
                claims.remove(i);
                --i;
            }

        }
        for(int i = 0; i != payments.size(); ++i)
        {
            if(!isWithinLastYear(payments.get(i).getDate()))
            {
                payments.remove(i);
                --i;
            }
        }
        
        boolean paidMembership = false;
        float charge = 10;
        float pays = 0;
        for(int i = 0; i != claims.size(); ++i)
        {
            charge += claims.get(i).getAmount() * 0.05; //Charged %5
        }
        for(int i = 0; i != payments.size(); ++i)
        {
            pays += payments.get(i).getAmount();
            if(payments.get(i).getTypeOfPayment().trim().equals("FEE"))
                paidMembership = true;
        }
        ret.setPaidMembership(paidMembership);
        ret.setCharge(charge);
        ret.setPayments(pays);
        
        ret.setTotal(pays - charge);
        
        return ret;
    }
    
    public ArrayList<OutstandingBalance> getAllOutstandingBalance()
    {
        ArrayList ret = new ArrayList<OutstandingBalance>();
        ArrayList<Member> members = getAllMembers();
        for(int i = 0; i != members.size(); ++i)
        {
            User u = new User();
            u.setId(members.get(i).getUsername());
            ret.add(calculateOutstandingBalance(u));
        }
        
        return ret;
    }
}
