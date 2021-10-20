package views;

import controller.UserManager;
import model.User;
import regex.AccountExample;
import regex.PasswordExample;
import storage.UseFile;

import java.io.IOException;
import java.util.Scanner;

public class UserView {
    private static ClientView clientView = ClientView.getInstance();
    private static AdminView adminView = AdminView.getInstance();

    private static final String ADMIN = "admin";
    private static final String CLIENT = "client";
    private static UserManager userManager = UserManager.getInstance();

    public void runUserView() {
        Scanner scanner = new Scanner(System.in);
        insertAdminId();
        try {
            userManager.setUserList(UseFile.getInstance().fileReader());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    User user = creatUser();
                    boolean check = checkPassword(user);

                    while (!check){
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Nhap lai mat khau");
                        System.out.println("(Mật khẩu ít nhất 8 ký tự, chữ cái đầu viết hoa và không có ký tự đặc biệt)");
                        String fixPassword = scanner1.nextLine();
                        user.setPassword(fixPassword);
                        check =checkPassword(user);
                    }
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Client or Admin ? ");
                    String role = scanner3.nextLine();
                    user.setRole(role);
                    System.out.println(user);
                    try {
                        userManager.addNewUser(user);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Đăng ký thành công!");
                    break;
                case 2:
                    login();
                    break;
                case 0:
            }

        }

    }

    public void insertAdminId() {
        try {
            userManager.addNewUser(new User("admin", "admin", ADMIN));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login() {

        System.out.println("Nhập ID: ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("｜ID｜");
        String id = scanner.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập Password: ");
        System.out.print("｜Password｜");
        String password = scanner2.nextLine();
        User user = new User(id, password);
        boolean isLogin = userManager.isLogin(user);
        if (isLogin) {
            User user1 = userManager.findUser(id);
            if (user1.getRole().equalsIgnoreCase(ADMIN)) {
                adminView.runAdminView();
            } else {
                clientView.runClientView();
            }

        }
        else {
            System.out.println("Tài khoản hoặc mật khẩu không hợp lệ!");
        }

    }

    public  User creatUser() {


        System.out.println("Đăng ký tài khoản");
        System.out.println("Nhập ID: ");
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("｜ID｜");
        String id = scanner1.nextLine();

        System.out.println("");
        System.out.println("Nhập Password: ");
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("｜Password｜");

        String password = scanner2.nextLine();
        return new User(id, password);

        }
        public boolean checkPassword(User user){
            PasswordExample passwordExample = new PasswordExample();
            return passwordExample.validatePassword(user.getPassword());
        }





    public static void showMenu() {
        System.out.println("                                       　                     " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                                            " + "＝＝＝＝＝＝＝。DINGTEA　募茶。＝＝＝＝＝＝＝");
        System.out.println("                                       　                     " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                           　　　　               " +" ①【Đăng ký】 " + "②【Đăng nhập】");
        System.out.println("          ");

    }

}
