package View;

import Control.AdminController;

import java.util.ArrayList;
import java.util.Scanner;
import Control.AdminController;
public class Adminaccess {
    Scanner sc = new Scanner(System.in);

    public void display() {
        while (true) {
            System.out.println(" --ENTER 1 FOR ADD KIT-- ");
            System.out.println(" --ENTER 2 FOR UPDATE KIT-- ");
            System.out.println(" --ENTER 3 FOR DELETE KIT-- ");
            System.out.println(" --ENTER 4 FOR VIEW KIT-- ");
            System.out.println(" --ENTER 5 FOR VIEW USERS-- ");
            System.out.println(" --ENTER 6 FOR VIEW ORDERS-- ");
            System.out.println(" --ENTER 7 FOR LOGOUT-- ");
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.print(" --OOPS!INVALID CHOICE-- ");
            }
            if (choice == 1) {
                Admingetset a = new Admingetset();

                System.out.println(" --ENTER ITEM ID-- ");
                a.setId(sc.next());
                System.out.println(" --ENTER ITEM NAME-- ");
                a.setName(sc.next());
                System.out.println(" --ENTER ITEM TYPE-- ");
                a.setType(sc.next());
                System.out.println(" --ENTER AVAILABILITY-- ");
                a.setAvailability(sc.nextInt());
                System.out.println(" --ENTER PRICE-- ");
                a.setPrice(sc.nextInt());
                if (AdminController.insert(a.getId(), a.getName(), a.getType(), a.getAvailability(), a.getPrice())) {
                    System.out.println();
                    System.out.println(" --ITEMS ADDED SUCCESSFULLY-- ");
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println(" --ITEMS NOT ADDED-- ");
                    System.out.println();
                }

            } else if (choice == 2) {
                Admingetset a = new Admingetset();
                System.out.println(" --ENTER 1 FOR UPDATE PRICE-- ");
                System.out.println(" --ENTER 2 FOR UPDATE AVAILABILITY-- ");
                int choice1 = sc.nextInt();
                if (choice1 == 1) {
                    System.out.println(" --ENTER PRICE OF THE ITEM TO UPDATE-- ");
                    a.setUPrice(sc.nextInt());
                    System.out.println(" --ENTER ITEM ID  TO BE  UPDATE-- ");
                    a.setUId(sc.next());
                    if (AdminController.updatePrice(a.getUPrice(), a.getUId()))
                        System.out.println(" --PRICE UPDATED SUCCESSFULLY-- ");
                }
                if (choice1 == 2) {
                    System.out.println(" --ENTER AVAILABILITY OF THE ITEM TO UPDATE-- ");
                    a.setUPrice(sc.nextInt());
                    System.out.println(" --ENTER ITEM ID TO  BE UPDATE-- ");
                    a.setUId(sc.next());
                    if (AdminController.updateAvailability(a.getUPrice(), a.getUId()))
                        System.out.println(" --AVAILABILITY  UPDATED SUCCESSFULLY-- ");

                }
            } else if (choice == 3) {
                Admingetset a = new Admingetset();
                System.out.println();
                System.out.println(" --ENTER ITEM ID TO DELETE-- ");
                a.setDelId(sc.next());
                if (AdminController.delete(a.getDelId())) {
                    System.out.println();
                    System.out.println(" --ITEM DELETED SUCCESSFULLY-- ");
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println(" --ITEM NOT DELETED-- ");
                    System.out.println();
                }
            } else if (choice == 4) {
                String s = "-";
                ArrayList<String> a1 = new ArrayList<>();
                System.out.println("" + s.repeat(75));
                System.out.printf("| %-10s | %-15s |  %-10s |  %-10s |  %-8s  |\n", "ID", "NAME", "TYPE", "AVAILABILITY", "PRICE");
                System.out.println("" + s.repeat(75));
                while (true) {
                    a1 = AdminController.viewitems();
                    if (a1.size() > 0) {
                        System.out.printf("| %-10s | %-15s |  %-10s |  %-12s |  %-8s  |\n", a1.get(0), a1.get(1), a1.get(2), a1.get(3), a1.get(4));
                        System.out.println("" + s.repeat(75));
                        a1.clear();
                    }
                    else
                        break;
                }
            } else if (choice == 5) {
                String s = "-";
                ArrayList<String> a11 = new ArrayList<>();
                System.out.println("" + s.repeat(84));
                System.out.printf("| %-10s | %-22s |  %-10s |  %-10s |  %-13s |\n", "NAME", "EMAIL", "PASSWORD", " NUMBER", " ADDRESS");
                System.out.println("" + s.repeat(84));
                while (true) {
                    a11 = AdminController.viewuser();
                    if (a11.size() > 0) {
                        System.out.printf("| %-10s | %-22s |  %-10s |  %-10s |  %-13s |\n", a11.get(0), a11.get(1), a11.get(2), a11.get(3), a11.get(4));
                        System.out.println("" + s.repeat(84));
                        a11.clear();
                    }
                    else
                        break;
                }
            }
            else if (choice == 6) {
                String s = "-";
                ArrayList<String> a11 = new ArrayList<>();
                System.out.println("" + s.repeat(84));
                System.out.printf("| %-10s | %-22s |  %-10s |  %-10s |  %-13s |\n", "ORDER_ID", "EMAIL", "ITEM_ID", " QUANTITY", " PRICE");
                System.out.println("" + s.repeat(84));
                while (true) {
                    a11 = AdminController.vieworders();
                    if (a11.size() > 0) {
                        System.out.printf("| %-10s | %-22s |  %-10s |  %-10s |  %-13s |\n", a11.get(0), a11.get(1), a11.get(2), a11.get(3), a11.get(4));
                        System.out.println("" + s.repeat(84));
                        a11.clear();
                    }
                    else
                        break;
                }
            }
            else if(choice==7){
                System.out.println(" --LOGOUT SUCCESSFULLY-- ");
                break;
            }
        }
    }
}

