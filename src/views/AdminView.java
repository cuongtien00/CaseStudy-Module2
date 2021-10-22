package views;

import controller.BillManager;
import model.Bill;
import model.MilkTea;
import storage.BillFile;

import java.io.IOException;
import java.util.Scanner;

public class AdminView {
    private static AdminView adminView;

    private static ToppingView toppingView =ToppingView.getInstance();
    private static MilkTeaView milkTeaView = MilkTeaView.getInstance();
    private static CustomerView customerView = CustomerView.getInstance();
    private  static BillView billView = BillView.getInstance();

//    private static BillManager billManager = BillManager.getInstance();

private AdminView(){}
    public static AdminView getInstance(){
    if(adminView==null){
        adminView = new AdminView();
//        try {
//            billManager.setBillList(BillFile.getInstance().fileReader());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
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
//                case 5:
//                    MilkTea bestSeller = bestSeller();
//                    System.out.println("Sản phẩm bán chạy nhất là: "+bestSeller.getName() + " Với "+ bestSeller.getCount()+" cốc đã bán.");
//                    break;
                case 0:
            }
        }
    }

//    private MilkTea bestSeller() {
//        for (Bill a: billManager.getBillList()) {
//            int maxCount = a.getMilkTeaList().get(0).getCount();
//            int indexMax = 0;
//            for (int i = 1; i < a.getMilkTeaList().size(); i++) {
//                if(maxCount<a.getMilkTeaList().get(i).getCount()){
//                    indexMax = i;
//                }
//            }
//            return a.getMilkTeaList().get(indexMax);
//        }
//        return null;
//    }

    public static void showMenu(){
        System.out.println("                                       　                     " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                                         " + "＝＝＝＝＝＝HỆ THỐNG QUẢN LÝ CỬA HÀNG＝＝＝＝＝＝");
        System.out.println("                                       　                     " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                           　　　　                     " +"1. Quản lý danh sách topping");
        System.out.println("                                           　　　　                     " +"2. Quản lý danh sách trà sữa");
        System.out.println("                                           　　　　                     " +"3. Quản lý danh sách khách hàng");
        System.out.println("                                           　　　　                     " +"4. Quản lý danh sách bill");
        System.out.println("                                           　　　　                     " +"5. Sản phẩm bán chạy nhất");
        System.out.println("                                           　　　　                     " +"0. Exit");
        System.out.println("                                           　　　　                     " +"Nhập lựa chọn");
        System.out.println("          ");
    }

}
