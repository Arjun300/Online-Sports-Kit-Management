package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc {
    private static Jdbc con1=null;

    private static Statement stmt=null;
    private Jdbc() {
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kitsportsshop","root","1122");
            stmt=con.createStatement();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    public static Jdbc getInstance() {
        if(con1==null)
            con1=new Jdbc();
        return con1;
    }
    public  Statement getStatement() {

        return stmt;
    }
}
