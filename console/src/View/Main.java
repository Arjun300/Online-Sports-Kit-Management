package View;

import Control.SignController;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        boolean flag=false;
        while (flag==false) {
            System.out.println(" ----ENTER 1 FOR SIGNUP---- ");
            System.out.println(" ----ENTER 2 FOR LOGIN----- ");
            System.out.println(" ----ENTER 3 FOR EXIT------ ");
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println(" --INVALID CHOICE PLEASE CHOOSE VALID CHOICE-- ");
            }
            if (choice == 1) {
                System.out.println(" --ENTER NAME-- ");
                String username = sc.next();
                System.out.println(" --ENTER EMAIL-- ");
                String email = sc.next();
                if(email.matches("^\\w+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$")){
                    System.out.println(" --ENTER PASSWORD-- ");
                    String password = sc.next();
                        System.out.println(" --ENTER PHONE-- ");
                        String number = sc.next();
                        System.out.println(" --ENTER ADDRESS-- ");
                        String aadhar = sc.next();
                        SignController.insertdetails(username, email, password, number, aadhar);
                        System.out.println(" --YOU HAVE SIGNED UP SUCCESSFULLY-- ");
                }
                else{
                    System.out.println(" --PLEASE ENTER VALID EMAIL-- ");
                }
            }
                if (choice == 2) {
                    Signgetset sg=new Signgetset();
                    System.out.println(" --ENTER EMAIL-- ");
                    sg.setEmail(sc.next());
                   // String currentuser=sg.getEmail();
                    System.out.println(" --ENTER PASSWORD-- ");
                    sg.setPassword(sc.next());
                    int a=SignController.validate(sg.getEmail(),sg.getPassword1());
                    if (a==1) {
                    System.out.println(" --Welcome Admin-- ");
                             flag=true;
                             Adminaccess av=new Adminaccess();
                             av.display();

                        }
                        else if(a==2){
                               System.out.println(" --WELCOME USER -- ");
                               flag=true;
                                Useraccess uv=new Useraccess(sg);
                                uv.shop(sg.getEmail());
                            }
                            else{
                                System.out.println(" --LOGIN FAILED-- ");
                            }
                        }
            if(choice == 3) {
                System.out.println(" --Exited-- ");
                break;
            }
                    }

                }
            }

