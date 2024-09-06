package View;
import Control.CartController;
import Control.UserController;
import Model.UserModel;

import java.util.ArrayList;
import java.util.Scanner;

public class Useraccess {
    Scanner sc=new Scanner(System.in);
    private String email;
    int buy=0;
    int cart=0;
    Signgetset sg=new Signgetset();
    Useraccess(Signgetset obj){
        this.email=obj.getEmail();
    }
    public String getEmail(){
        return this.email;
    }
    String merge="";
    String merge2="";
    String merge3="";
    String merge4="";
    boolean flag=false;
    public void shop(String email) {
        while (true) {
            System.out.println(" --ENTER 1 FOR VIEW CRICKET KITS--- ");
            System.out.println(" --ENTER 2 FOR VIEW FOOTBALL KITS-- ");
            System.out.println(" ---ENTER 3 FOR VIEW HOCKEY KITS--- ");
            System.out.println(" ---ENTER 4 FOR VIEW ADD TO CART--- ");
            System.out.println(" -------ENTER 5 FOR LOGOUT--------- ");
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println(" --OOPS!INVALID CHOICE-- ");
            }
            if (choice == 1) {
                String s = "-";
                ArrayList<String> a12 = new ArrayList<>();
                System.out.println("" + s.repeat(54));
                System.out.printf("| %-6s | %-15s | %-10s |  %-7s |\n", "ID", "NAME", "AVAILABILITY", "PRICE");
                System.out.println("" + s.repeat(54));
                while (true) {
                    a12 = UserController.viewcricket();
                    if (a12.size() > 0) {
                        System.out.printf("| %-6s | %-15s | %-12s |  %-7s |\n", a12.get(0), a12.get(1), a12.get(2), a12.get(3));
                        System.out.println("" + s.repeat(54));
                        a12.clear();
                    } else
                        break;
                }
                System.out.println();
                System.out.println(" --ENTER 1 FOR ADD TO CART---- ");
                System.out.println(" --ENTER 2 FOR BUY A PRODUCT-- ");
                int choice1 = sc.nextInt();
                if (choice1 == 1) {
                    System.out.println(" --ENTER ITEM ID FOR ADD TO CART-- ");
                    Usergettersetter us1 = new Usergettersetter();
                    us1.setUid(sc.next());
                    System.out.println(" --HOW MANY NUMBER OF ITEMS DO yOU NEED-- ");
                    us1.setUAvailability(sc.nextInt());
                    cart += us1.getUAvailability() * UserController.buy(us1.getUid(), us1.getUAvailability());
                    merge3+=us1.getUid();
                    merge4+=Integer.toString(us1.getUAvailability());
                    CartController.insertcart(getEmail(), us1.getUid(), us1.getUAvailability(), cart);
                    System.out.println(" --ADDED TO CART-- ");
                    System.out.println(" --ENTER 1 FOR VIEW ADD TO CART-- ");
                    System.out.println(" --ENTER 2 FOR PURCHASE GIVEN IN ADD TO CART--");
                    int view=sc.nextInt();
                    if(view==1){
                        String f = "-";
                        ArrayList<String> a13 = new ArrayList<>();
                        System.out.println("" + f.repeat(32));
                        System.out.printf("| %-6s | %-10s | %-6s |\n", "ID", "QUANTITY", "PRICE");
                        System.out.println("" + f.repeat(32));
                        while (true) {
                            a13 = UserController.viewcart(email);
                            if (a13.size() > 0) {
                                System.out.printf("| %-6s | %-10s | %-6s |\n", a13.get(0), a13.get(1), a13.get(2));
                                System.out.println("" + f.repeat(32));
                                a13.clear();
                            } else
                                break;
                        }
                    }
                    else if(view==2){
                        CartController.insertorder(getEmail(),merge3,merge4,cart);
                        System.out.println(" --THANKS FOR SHOPPING-- ");
                        System.out.println(" --YOUR ORDER IS PLACED-- ");

                    }
                } else if (choice1 == 2) {
                    while (true) {
                        Usergettersetter us = new Usergettersetter();
                        System.out.println(" --ENTER ITEM ID FOR BUY A PRODUCT-- ");
                        us.setUid(sc.next());
                        System.out.println(" --HOW MANY NUMBER OF ITEMS DO yOU NEED-- ");
                        us.setUAvailability(sc.nextInt());
                        if (UserController.updateAvailability(us.getUAvailability(), us.getUid())) {
                            buy += us.getUAvailability() * UserController.buy(us.getUid(), us.getUAvailability());
                            System.out.println(" --ENTER 1 FOR CONTINUE SHOPPING-- ");
                            System.out.println(" --ENTER 2 FOR QUIT SHOPPING-- ");
                            int choice2 = sc.nextInt();
                            if (choice2 == 1) {
                                merge += us.getUid();
                                int k = us.getUAvailability();
                                merge2 += Integer.toString(k);
                                merge += ",";
                                merge2 += ",";
                                continue;
                            } else if (choice2 == 2) {
                                System.out.println();
                                merge += us.getUid();
                                int h = us.getUAvailability();
                                merge2 += Integer.toString(h);
                                CartController.insertorder(getEmail(), merge, merge2, buy);
                                System.out.println(" -- THANKS FOR SHOPPING-- ");
                                System.out.println(" --YOUR ORDER IS PLACED-- ");
                                System.out.println("YOUR TOTAL AMOUNT : " + buy);
                                System.out.println();
                                buy = 0;
                                flag = true;
                                break;
                            }
                        }
                    }
                }
                System.out.println();
            }
            if (choice == 2) {
                String s = "-";
                ArrayList<String> a13 = new ArrayList<>();
                System.out.println("" + s.repeat(54));
                System.out.printf("| %-6s | %-15s | %-10s |  %-7s |\n", "ID", "NAME", "AVAILABILITY", "PRICE");
                System.out.println("" + s.repeat(54));
                while (true) {
                    a13 = UserController.viewfootball();
                    if (a13.size() > 0) {
                        System.out.printf("| %-6s | %-15s | %-12s |  %-7s |\n", a13.get(0), a13.get(1), a13.get(2), a13.get(3));
                        System.out.println("" + s.repeat(54));
                        a13.clear();
                    } else
                        break;
                }
                 System.out.println();
                System.out.println(" --ENTER 1 FOR ADD TO CART---- ");
                System.out.println(" --ENTER 2 FOR BUY A PRODUCT-- ");
                int choice1 = sc.nextInt();
                if (choice1 == 1) {
                    System.out.println(" --ENTER ITEM ID FOR ADD TO CART-- ");
                    Usergettersetter us1 = new Usergettersetter();
                    us1.setUid(sc.next());
                    System.out.println(" --HOW MANY NUMBER OF ITEMS DO yOU NEED-- ");
                    us1.setUAvailability(sc.nextInt());
                    cart += us1.getUAvailability() * UserController.buy(us1.getUid(), us1.getUAvailability());
                    merge3+=us1.getUid();
                    merge4+=Integer.toString(us1.getUAvailability());
                    CartController.insertcart(getEmail(), us1.getUid(), us1.getUAvailability(), cart);
                    System.out.println("Added to Cart");
                    System.out.println(" --ENTER 1 FOR VIEW ADD TO CART-- ");
                    System.out.println(" --ENTER 2 FOR PURCHASE GIVEN IN ADD TO CART--");
                    int view=sc.nextInt();
                    if(view==1){
                        String f = "-";
                        ArrayList<String> a14 = new ArrayList<>();
                        System.out.println("" + f.repeat(32));
                        System.out.printf("| %-6s | %-10s | %-6s |\n", "ID", "QUANTITY", "PRICE");
                        System.out.println("" + f.repeat(32));
                        while (true) {
                            a14 = UserController.viewcart(email);
                            if (a14.size() > 0) {
                                System.out.printf("| %-6s | %-10s | %-6s |\n", a14.get(0), a14.get(1), a14.get(2));
                                System.out.println("" + f.repeat(32));
                                a14.clear();
                            } else
                                break;
                        }
                    }
                    else if(view==2){
                        CartController.insertorder(getEmail(),merge3,merge4,cart);
                        System.out.println(" --THANKS FOR SHOPPING-- ");
                        System.out.println(" --YOUR ORDER IS PLACED-- ");

                    }
                }
                    while (true) {
                        Usergettersetter us = new Usergettersetter();
                        System.out.println(" --ENTER ITEM ID FOR BUY A PRODUCT-- ");
                        us.setUid(sc.next());
                        System.out.println(" --HOW MANY NUMBER OF KITS DO TOU NEED-- ");
                        us.setUAvailability(sc.nextInt());
                        if (UserController.updateAvailability(us.getUAvailability(), us.getUid())) {
                            buy += us.getUAvailability() * UserController.buy(us.getUid(), us.getUAvailability());
                            System.out.println(" --ENTER 1 FOR CONTINUE SHOPPING-- ");
                            System.out.println(" --ENTER 2 FOR QUIT SHOPPING-- ");
                            int choice2 = sc.nextInt();
                            if (choice2 == 1) {
                                merge += us.getUid();
                                int k = us.getUAvailability();
                                merge2 += Integer.toString(k);
                                merge += ",";
                                merge2 += ",";
                                continue;
                            } else if (choice2 == 2) {
                                System.out.println();
                                merge += us.getUid();
                                int h = us.getUAvailability();
                                merge2 += Integer.toString(h);
                                CartController.insertorder(getEmail(), merge, merge2, buy);
                                System.out.println(" -- THANKS FOR SHOPPING-- ");
                                System.out.println("--YOUR ORDER IS PLACED-- ");
                                System.out.println("YOUR TOTAL AMOUNT : " + buy);
                                flag=true;
                                System.out.println();
                                buy = 0;
                                break;
                            }
                        }

                }
            }
            if (choice == 3) {
                String s = "-";
                ArrayList<String> a14 = new ArrayList<>();
                System.out.println("" + s.repeat(54));
                System.out.printf("| %-6s | %-15s | %-10s |  %-7s |\n", "ID", "NAME", "AVAILABILITY", "PRICE");
                System.out.println("" + s.repeat(54));
                while (true) {
                    a14 = UserController.viewhockey();
                    if (a14.size() > 0) {
                        System.out.printf("| %-6s | %-15s | %-10s |  %-7s |\n", a14.get(0), a14.get(1), a14.get(2), a14.get(3));
                        System.out.println("" + s.repeat(54));
                        a14.clear();
                    } else
                        break;
                }
                System.out.println();
                System.out.println(" --ENTER 1 FOR ADD TO CART---- ");
                System.out.println(" --ENTER 2 FOR BUY A PRODUCT-- ");
                int choice1 = sc.nextInt();
                if (choice1 == 1) {
                    System.out.println(" --ENTER ITEM ID FOR ADD TO CART-- ");
                    Usergettersetter us1 = new Usergettersetter();
                    us1.setUid(sc.next());
                    System.out.println(" --HOW MANY NUMBER OF ITEMS DO yOU NEED-- ");
                    us1.setUAvailability(sc.nextInt());
                    cart += us1.getUAvailability() * UserController.buy(us1.getUid(), us1.getUAvailability());
                    merge3 += us1.getUid();
                    merge4 += Integer.toString(us1.getUAvailability());
                    CartController.insertcart(getEmail(), us1.getUid(), us1.getUAvailability(), cart);
                    System.out.println("Added to Cart");
                    System.out.println(" --ENTER 1 FOR VIEW ADD TO CART-- ");
                    System.out.println(" --ENTER 2 FOR PURCHASE GIVEN IN ADD TO CART--");
                    int view = sc.nextInt();
                    if (view == 1) {
                        String f = "-";
                        ArrayList<String> a13 = new ArrayList<>();
                        System.out.println("" + f.repeat(32));
                        System.out.printf("| %-6s | %-10s | %-6s |\n", "ID", "QUANTITY", "PRICE");
                        System.out.println("" + f.repeat(32));
                        while (true) {
                            a13 = UserController.viewcart(email);
                            if (a13.size() > 0) {
                                System.out.printf("| %-6s | %-10s | %-6s |\n", a13.get(0), a13.get(1), a13.get(2));
                                System.out.println("" + f.repeat(32));
                                a13.clear();
                            } else
                                break;
                        }
                    } else if (view == 2) {
                        CartController.insertorder(getEmail(), merge3, merge4, cart);
                        System.out.println(" --THANKS FOR SHOPPING-- ");
                        System.out.println(" --YOUR ORDER IS PLACED-- ");

                    }
                } else if (choice1 == 2) {
                    while (true) {
                        Usergettersetter us = new Usergettersetter();
                        System.out.println(" --ENTER ITEM ID FOR BUY A PRODUCT-- ");
                        us.setUid(sc.next());
                        System.out.println(" --HOW MANY NUMBER OF KITS DO TOU NEED-- ");
                        us.setUAvailability(sc.nextInt());
                        if (UserController.updateAvailability(us.getUAvailability(), us.getUid())) {
                            buy += us.getUAvailability() * UserController.buy(us.getUid(), us.getUAvailability());
                            System.out.println(" --ENTER 1 FOR CONTINUE SHOPPING-- ");
                            System.out.println(" --ENTER 2 FOR QUIT SHOPPING-- ");
                            int choice2 = sc.nextInt();
                            if (choice2 == 1) {
                                merge += us.getUid();
                                int k = us.getUAvailability();
                                merge2 += Integer.toString(k);
                                merge += ",";
                                merge2 += ",";
                                continue;
                            } else if (choice2 == 2) {
                                System.out.println();
                                merge += us.getUid();
                                int h = us.getUAvailability();
                                merge2 += Integer.toString(h);
                                CartController.insertorder(getEmail(), merge, merge2, buy);
                                System.out.println(" -- THANKS FOR SHOPPING-- ");
                                System.out.println("--YOUR ORDER IS PLACED-- ");
                                System.out.println("YOUR TOTAL AMOUNT : " + buy);
                                System.out.println();
                                buy = 0;
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }
            else if(choice == 4) {
                if (UserModel.validatecart(email)){
                    String f = "-";
                    ArrayList<String> a13 = new ArrayList<>();
                    System.out.println("" + f.repeat(32));
                    System.out.printf("| %-6s | %-10s | %-6s |\n", "ID", "QUANTITY", "PRICE");
                    System.out.println("" + f.repeat(32));
                    while (true) {
                        a13 = UserController.viewcart(email);
                        if (a13.size() > 0) {
                            System.out.printf("| %-6s | %-10s | %-6s |\n", a13.get(0), a13.get(1), a13.get(2));
                            System.out.println("" + f.repeat(32));
                            a13.clear();
                        } else
                            break;
                    }
                }
                else{
                    System.out.println(" --YOUR CART IS EMPTY-- ");
                }
            }
            else if(choice== 5){
                System.out.println(" --LOGOUT SUCCESSFULLY-- ");
                break;
            }
        }
    }
}
