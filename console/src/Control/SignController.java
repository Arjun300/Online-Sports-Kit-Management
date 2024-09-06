package Control;
import java.util.*;
import Model.Signupdetails;
public class SignController {
    public static boolean insertdetails (String username,String email,String password,String number,String aadhar) {
        return Signupdetails.insertdetails(username, email, password, number, aadhar);
    }
    public static int validate(String email1,String password1){
      //  System.out.println(currentuser);
        return Signupdetails.validate(email1,password1);
    }

    }

