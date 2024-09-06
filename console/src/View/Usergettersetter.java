package View;

public class Usergettersetter {
    private String Id;
    private String Name;
    private String  Type;
    private int Price;
    private int Availability;
    public void setUid(String Id){
        this.Id=Id;
    }
    public String getUid(){
        return Id;
    }
    public void setUAvailability(int Availability){
        this.Availability=Availability;
    }
    public int getUAvailability(){
        return Availability;
    }
}
