package Model;

import java.sql.Statement;

public class CartModel {
    static Jdbc connection = Jdbc.getInstance();

    static Statement st = connection.getStatement();

    // String Role= "Admin";
    public static boolean insertcart(String currentemail1, String Id, int quantity,int Price) {
        try {
          //  System.out.println(currentemail1);
            String q1 = "insert into AddtoCart(User_email,item_id,Quantity,Price) values('" + currentemail1 + "','" + Id + "','"+quantity+"','"+Price+"');";
            st.executeUpdate(q1);
            return true;
        } catch (Exception e) {
            System.out.print("error" + e);
        }
        return false;
    }
    public static boolean insertorder(String email,String Id,String quantity,int Price){
        try{
            String q2="insert into orders (User_email,item_id,Quantity,Price) values ('"+email+"','"+Id+"','"+quantity+"','"+Price+"')";
            st.executeUpdate(q2);
            return true;
        }
        catch (Exception e){
            System.out.println("error"+e);
        }
        return false;
    }
}
