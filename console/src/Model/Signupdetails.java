package Model;

import java.sql.ResultSet;
import java.sql.Statement;


public class Signupdetails {
    static Jdbc connection = Jdbc.getInstance();

    static Statement st = connection.getStatement();

    // String Role= "Admin";
    public static boolean insertdetails(String username, String email, String password, String number, String aadhar) {
        try {
            String q1 = "insert into signupdetails(User_name,User_email,User_pwd,User_phone,Address) values('" + username + "','" + email + "','" + password + "','" + number + "','" + aadhar + "');";
            st.executeUpdate(q1);
            return true;
        } catch (Exception e) {
            System.out.print("error" + e);
        }
        return false;
    }

    public static int validate(String email1, String password1) {
        try {
            String q1 = "select User_email from signupdetails where User_email='" + email1 + "' and User_pwd='"+password1+"';";
            ResultSet rows = st.executeQuery(q1);
            if (rows.next()) {
                if (rows.getString(1).equals("arjunmska@gmail.com")) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                return 3;
            }


        } catch (Exception e) {
            System.out.print("error " + e);
        }
        return 4;
    }
}


//    public boolean admincheck(String email, String pwd) throws SQLException {
//        String d = "Admin";
//        String q2 = "select count(*) as cou2 from signupdetails where Role='" + d +"'and User_email = '" + email +"';";
//        ResultSet rows1 = st.executeQuery(q2);
//         if(rows1.next()){
//             int cou2 = rows1.getInt("cou2");
//             return cou2>=1;
//         }
//         else {
//            return false;
//        }
//    }

