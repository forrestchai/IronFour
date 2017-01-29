package PawandeepModel;

import pawandeepController.DBController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by PawandeepSingh on 14/12/16.
 */
public class Consultation
{
    private String dID;
    String pID;
    String consultationTime;
    String ConsultationDate;

    String consultationDuration;

    public String getdID() {
        return dID;
    }

    public void setdID(String dID) {
        this.dID = dID;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(String consultationTime) {
        this.consultationTime = consultationTime;
    }

    public String getConsultationDate() {
        return ConsultationDate;
    }

    public void setConsultationDate(String consultationDate) {
        ConsultationDate = consultationDate;
    }

    public String getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(String consultationDuration) {
        this.consultationDuration = consultationDuration;
    }

    public Consultation getConsultation()
    {
        DBController db = new DBController();
        String query;
        PreparedStatement ps;
        ResultSet rs;

        db.getConnection();

        Consultation cn = new Consultation();


        return cn;
    }
}
