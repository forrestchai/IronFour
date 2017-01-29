package PawandeepModel;

import pawandeepController.DBController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by PawandeepSingh on 14/12/16.
 */
public class Patient
{
    private String pID;
    private String Password;
    private String Name;


    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



    public static Patient getPatient(String pid , String password)
    {
        DBController db = new DBController();
        String query;
        PreparedStatement ps;
        ResultSet rs;
        db.getConnection();

        Patient pt = new Patient();

        query = "select * from patient where pid = ? and password = ? ";
        ps = db.getPreparedStatement(query);
        try {
            ps.setString(1,pid);
            ps.setString(2,password);
            rs = ps.executeQuery();

            if(rs.next())
            {
                String id = rs.getString("pid");
                String pass = rs.getString("password");
                String name = rs.getString("name");

                pt.setName(name);
                pt.setpID(id);
                pt.setPassword(pass);
            }
            else
                return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return pt;
    }
}
