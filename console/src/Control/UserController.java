package Control;

import java.util.ArrayList;
import java.util.*;
import Model.UserModel;

public class UserController {
    public static ArrayList<String> viewcricket(){
        return UserModel.viewcricket();
    }
    public static ArrayList<String> viewfootball(){
        return UserModel.viewfootball();
    }
    public static ArrayList<String> viewhockey(){
        return UserModel.viewhockey();
    }
    public static boolean updateAvailability(int Availability,String Id){
        return UserModel.updateAvailability(Availability,Id);
    }
    public static int buy(String Id,int Availability){

        return UserModel.buy(Id,Availability);
    }
    public static ArrayList<String> viewcart(String email){
        return UserModel.viewcart(email);
    }
//    public static String emailretrive(){
//        return UserModel.
//    }


}
