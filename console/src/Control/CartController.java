package Control;
import Model.CartModel;

public class CartController {
    public static boolean  insertcart(String currentemail,String Id,int quantity,int Price) {
        return CartModel.insertcart(currentemail,Id,quantity,Price)&&true;
    }
    public static boolean insertorder(String email,String Id,String quantity,int Price){
        return CartModel.insertorder(email,Id,quantity,Price);
    }
}
