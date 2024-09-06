package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminModel {

    static Jdbc connection=Jdbc.getInstance();
    static Statement statement=connection.getStatement();
    public static boolean insert(String Id,String Name,String Type,int Availability,int price) {
        try {
            statement.executeUpdate("Insert INTO ItemDetails(item_id,item_name,item_type,Availability,Price)VALUES('"+Id+"','"+Name+"','"+Type+"','"+Availability+"','"+price+"');");
            return true;}
        catch(Exception e) {
            System.out.print("error found"+e);
        }
        return false;
    }
    public static boolean delete(String Id){
        try{
            statement.executeUpdate("Delete from ItemDetails where item_id = '"+Id+"'");
            return true;
        }
        catch(Exception e){
            System.out.println("error");
        }
        return false;
    }
    //Update
    public static boolean updatePrice(int Price,String Id) {
        try {
            statement.executeUpdate("UPDATE ItemDetails SET Price='"+Price+"' WHERE item_id='"+Id+"'");
            return true;}
        catch(Exception e) {
            System.out.print("error found"+e);
        }
        return false;
    }


    public static boolean updateAvailability(int Availability,String Id) {
        try {
            statement.executeUpdate("UPDATE ItemDetails SET Availability ='"+Availability+"' WHERE item_id='"+Id+"'");
            return true;}
        catch(Exception e) {
            System.out.print("error found"+e);
        }
        return false;
    }
    //View Items
    static int count=0;
    static ResultSet res;
    public static ArrayList<String> viewitems() {
        count++;
        ArrayList<String>a=new ArrayList<>();
        try {
            if(count==1) {
                res=statement.executeQuery("SELECT * FROM ItemDetails");
            }
            if(count>=1) {
                if(res.next()) {
                    a.add(res.getString(1));
                    a.add(res.getString(2));
                    a.add(res.getString(3));
                    a.add(String.valueOf(res.getInt(4)));
                    a.add(String.valueOf(res.getInt(5)));
                    return a;
                }
                else {
                    count=0;
                    res.close();
                }}}
        catch(Exception e) {
            System.out.print("ERROR"+e);
        }

        return a;
    }
    static int count1=0;
    static ResultSet ress;
    public static ArrayList<String> viewuser() {
        count1++;
        ArrayList<String>a=new ArrayList<>();
        try {
            if(count1==1) {
                String x="Customer";
                ress=statement.executeQuery("SELECT * FROM signupdetails where Role ='"+x+"' ");
            }
            if(count1>=1) {
                if(ress.next()) {
                    a.add(ress.getString(1));
                    a.add(ress.getString(2));
                    a.add(ress.getString(3));
                    a.add(ress.getString(4));
                    a.add(ress.getString(5));
                    return a;
                }
                else {
                    count1=0;
                    ress.close();
                }}}
        catch(Exception e) {
            System.out.print("ERROR"+e);
        }

        return a;
    }
    static int count5=0;
    static ResultSet ress1;
    public static ArrayList<String> vieworders() {
        count5++;
        ArrayList<String>a=new ArrayList<>();
        try {
            if(count5==1) {
                //String x="Customer";
                ress1=statement.executeQuery("SELECT * FROM orders");
            }
            if(count5>=1) {
                if(ress1.next()) {
                    a.add(String.valueOf(ress1.getString(1)));
                    a.add(ress1.getString(2));
                    a.add(ress1.getString(3));
                    a.add(ress1.getString(4));
                    a.add(String.valueOf(ress1.getString(5)));
                    return a;
                }
                else {
                    count5=0;
                    ress1.close();
                }}}
        catch(Exception e) {
            System.out.print("ERROR"+e);
        }

        return a;
    }
}
