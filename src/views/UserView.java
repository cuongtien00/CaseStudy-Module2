package views;

import controller.UserManager;
import model.User;
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
                    try {
                        userManager.addNewUser(creatUser());
                        System.out.println("Đăng ký thành công!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID: ");
        String id = scanner.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập Password: ");
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

    private static User creatUser() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Đăng ký tài khoản");
        System.out.println("Nhập ID: ");
        String id = scanner1.nextLine();
        System.out.println("Nhập Password: ");
        Scanner scanner2 = new Scanner(System.in);
        String password = scanner2.nextLine();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Client or Admin ? ");
        String role = scanner3.nextLine();
        return new User(id, password, role);
    }


    public static void showMenu() {
        System.out.println("                                       　      " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                             " + "＝＝＝＝＝＝＝。DINGTEA　募茶。＝＝＝＝＝＝＝");
        System.out.println("                                       　      " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                           　　　　 " + " ①【Đăng ký】 " + "②【Đăng nhập】");

    }
}
