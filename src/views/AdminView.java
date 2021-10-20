package views;

import java.util.Scanner;

public class AdminView {
    private static AdminView adminView;

    private static ToppingView toppingView =ToppingView.getInstance();
    private static MilkTeaView milkTeaView = MilkTeaView.getInstance();
    private static CustomerView customerView = CustomerView.getInstance();
    private  static BillView billView = BillView.getInstance();

private AdminView(){}
    public static AdminView getInstance(){
    if(adminView==null){
        adminView = new AdminView();
    }return adminView;
    }

    public void runAdminView(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while(choice!=0){
            showMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    toppingView.runToppingView();
                    break;
                case 2:
                    milkTeaView.runMilkTeaView();
                    break;
                case 3:
                    customerView.runCustomerView();
                    break;
                case 4:
                    billView.runBillView();
                    break;
                case 0:
            }
        }
    }
    public static void showMenu(){
        System.out.println("                                       　                     " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                                         " + "＝＝＝＝＝＝HỆ THỐNG QUẢN LÝ CỬA HÀNG＝＝＝＝＝＝");
        System.out.println("                                       　                     " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                           　　　　                     " +"1. Quản lý danh sách topping");
        System.out.println("                                           　　　　                     " +"2. Quản lý danh sách trà sữa");
        System.out.println("                                           　　　　                     " +"3. Quản lý danh sách khách hàng");
        System.out.println("                                           　　　　                     " +"4. Quản lý danh sách bill");
        System.out.println("                                           　　　　                     " +"0. Exit");
        System.out.println("                                           　　　　                     " +"Nhập lựa chọn");
        System.out.println("          ");
    }

}
