package View;

public class Admingetset {

    private String Id;
    private String Name;
    private String  Type;
    private int Price;
    private int Availability;
    public void setId(String Id) {
        this.Id=Id;
    }
    public String getId() {
        return Id;
    }
    public void setName(String Name) {
        this.Name=Name;
    }
    public String getName(){
        return Name;
    }
    public String getType() {
        return Type;
    }
    public void setType(String Type) {
        this.Type= Type;
    }
    public int getAvailability() {
        return Availability;
    }
    public void setAvailability(int Availability) {
        this.Availability=Availability;
    }
    public int  getPrice() {
        return Price;
    }
    public void setPrice(int Price) {
        this.Price=Price;
    }
    //Delete
    public void setDelId(String Name){
        this.Name=Name;
    }
    public String getDelId(){
        return Name;
    }
    //update
    public void setUId(String Name){
        this.Name=Name;
    }
    public String getUId(){
        return Name;
    }
    public void setUPrice(int Price){

        this.Price=Price;
    }
    public int getUPrice(){
        return Price;
    }

}
