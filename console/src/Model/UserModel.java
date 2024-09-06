package Model;

import View.Signgetset;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserModel {
    static Jdbc connection=Jdbc.getInstance();
    static Statement statement=connection.getStatement();
    Signgetset sg=new Signgetset();
    private String email2;
    UserModel(Signgetset obj){
        this.email2=obj.getEmail();
    }
    public String getEmail(){
        return this.email2;
    }
    String str=sg.getEmail();
    static int count2=0;
    static ResultSet ress;
    public static ArrayList<String> viewcricket() {
        count2++;
        ArrayList<String>c=new ArrayList<>();
        try {
            if(count2==1) {
                String x="Cricket";
                ress=statement.executeQuery("SELECT * FROM ItemDetails where item_type ='"+x+"' ");
            }
            if(count2>=1) {
                if(ress.next()) {
                    c.add(ress.getString(1));
                    c.add(ress.getString(2));
                   // a.add(ress.getString(3));
                    c.add(String.valueOf(ress.getString(4)));
                    c.add(String.valueOf(ress.getString(5)));
                    return c;
                }
                else {
                    count2=0;
                    ress.close();
                }}}
        catch(Exception e) {
            System.out.print("ERROR"+e);
        }

        return c;
    }
    /////////football
    static int count3=0;
    static ResultSet resss;
    public static ArrayList<String> viewfootball() {
        count3++;
        ArrayList<String>f=new ArrayList<>();
        try {
            if(count3==1) {
                String x="Football";
                resss=statement.executeQuery("SELECT * FROM ItemDetails where item_type ='"+x+"' ");
            }
            if(count3>=1) {
                if(resss.next()) {
                    f.add(resss.getString(1));
                    f.add(resss.getString(2));
                    // a.add(ress.getString(3));
                    f.add(String.valueOf(resss.getString(4)));
                    f.add(String.valueOf(resss.getString(5)));
                    return f;
                }
                else {
                    count3=0;
                    resss.close();
                }}}
        catch(Exception e) {
            System.out.print("ERROR"+e);
        }

        return f;
    }
    static int count4=0;
    static ResultSet ress1;
    public static ArrayList<String> viewhockey() {
        count4++;
        ArrayList<String>h=new ArrayList<>();
        try {
            if(count4==1) {
                String x="Hockey";
                ress1=statement.executeQuery("SELECT * FROM ItemDetails where item_type ='"+x+"' ");
            }
            if(count4>=1) {
                if(ress1.next()) {
                    h.add(ress1.getString(1));
                    h.add(ress1.getString(2));
                    h.add(String.valueOf(ress1.getString(4)));
                    h.add(String.valueOf(ress1.getString(5)));
                    return h;
                }
                else {
                    count4=0;
                    ress1.close();
                }}}
        catch(Exception e) {
            System.out.print("ERROR"+e);
        }

        return h;
    }
    static int count5=0;
    static ResultSet ress2;
    public static boolean updateAvailability(int Availability,String Id){
        try {
            ResultSet ress2=statement.executeQuery("SELECT Availability FROM ItemDetails WHERE item_id='"+Id+"'");
            if(ress2.next()) {
                if(ress2.getInt(1)>=Availability) {
                    count5=ress2.getInt(1)-Availability;
                    statement.executeUpdate("UPDATE ItemDetails SET Availability ='"+count5+"' WHERE item_id='"+Id+"'");
                    return true;
                }
                else
                    return false;
            }
        }
        catch(Exception e) {
            System.out.print("Error"+e);
        }
        return false;
    }
    public static int buy(String Id, int Availability){
        try{
            ResultSet ress3=statement.executeQuery("SELECT Price FROM ItemDetails WHERE item_id = '"+Id+"'");
            if(ress3.next()){
                int k = ress3.getInt(1);
                ress3.close();
                return k;
            }
        }
        catch (Exception e){
            System.out.println("error"+e);
        }
        return 0;
    }

    static int count6=0;
    static ResultSet ress5;
    public static ArrayList<String> viewcart(String email) {
        count6++;
        ArrayList<String>v=new ArrayList<>();
        try {
            if(count6==1) {
                System.out.println();
                //String x=ge();
                ress5 =statement.executeQuery("SELECT item_id,Quantity,Price FROM addtocart where User_email ='"+email+"' ");
            }
            if(count6>=1) {
                if(ress5.next()) {
                    v.add(ress5.getString(1));
                    v.add(String.valueOf(ress5.getString(2)));
                    v.add(String.valueOf(ress5.getString(3)));
                    return v;
                }
                else {
                    count6 =0;
                    ress5.close();
                }}}
        catch(Exception e) {
            System.out.print("ERROR"+e);
        }

        return v;
    }
    public static boolean validatecart(String email){
        try{
            String q5="Select User_email from addtocart where User_email = '"+email+"'";
                ResultSet re=statement.executeQuery(q5);
                if(re.next()){
                    return true;
                }
        }
        catch(Exception e){
            System.out.println("error"+e);
        }
        return false;
    }

}




