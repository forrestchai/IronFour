package PawandeepModel;


import pawandeepController.DBController;

import javax.print.Doc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by PawandeepSingh on 14/12/16.
 */
public class Doctor
{
    private String dID;
    private String Password;
    private String name;

    public Doctor() {}

    public Doctor(String did , String password)
    {
        this.dID = did;
        this.Password = password;
    }

    public String getdID() {
        return dID;
    }

    public void setdID(String dID) {
        this.dID = dID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public static Doctor getDoctor(String id , String password)
    {

        DBController db = new DBController();
        String query;
        PreparedStatement ps;
        ResultSet rs;

        Doctor dr = new Doctor();

        try
        {
            db.getConnection();
            query = "select * from doctor where did = ? and password = ?";
            ps = db.getPreparedStatement(query);
            ps.setString(1,id);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next())
            {
                String did = rs.getString("did");
                String pass = rs.getString("password");
                String name = rs.getString("name");
                dr.setdID(did);
                dr.setPassword(pass);
                dr.setName(name);
            }
            else
                {
                    dr = null;
                    return dr;
                }


        }catch (SQLException e)
        {
            e.printStackTrace();
        }


        return dr;
    }

    public static void main(String [] args)
    {
        System.out.println(getDoctor("d01","Test1234").getdID());
    }
}


