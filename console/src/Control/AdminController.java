package Control;
import java.util.*;
import Model.AdminModel;
public class AdminController {
    public static boolean insert(String Id,String Name,String Type,int Availability,int Price){
        return AdminModel.insert(Id, Name,Type,Availability,Price);
    }
    public static boolean updatePrice(int Price,String Id)
    {
        return AdminModel.updatePrice(Price,Id);

    }
    public static boolean updateAvailability(int Price,String Id)
    {
        return AdminModel.updateAvailability(Price,Id);

    }
    public static boolean delete(String Id)
    {
        return AdminModel.delete(Id);

    }
    public static ArrayList<String> viewitems(){
       return AdminModel.viewitems();
    }
    public static ArrayList<String> viewuser(){
        return AdminModel.viewuser();
    }
    public static ArrayList<String> vieworders(){
        return AdminModel.vieworders();
    }
}
