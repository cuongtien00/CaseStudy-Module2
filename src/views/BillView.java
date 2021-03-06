package views;

import controller.BillManager;
import controller.CustomerManager;
import controller.MilkTeaManager;
import controller.ToppingManager;
import model.*;
import storage.BillFile;
import storage.CustomerFile;
import storage.MilkTeaFile;
import storage.ToppingFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillView {
    private static BillView billView;

    private BillView() {
    }

    public static BillView getInstance() {
        if (billView == null) {
            billView = new BillView();
        }
        return billView;
    }

    private static CustomerManager customerManager = CustomerManager.getInstance();
    private static MilkTeaManager milkTeaManager = MilkTeaManager.getInstance();
    private static ToppingManager toppingManager = ToppingManager.getInstance();
    private static BillManager billManager = BillManager.getInstance();


    public void runBillView() {
        Scanner scanner = new Scanner(System.in);
        try {
            billManager.setBillList(BillFile.getInstance().fileReader());
            milkTeaManager.setMilkTeaList(MilkTeaFile.getInstance().fileReader());
            customerManager.setCustomerList(CustomerFile.getInstance().fileReader());
            toppingManager.setToppings(ToppingFile.getInstance().fileReader());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        billManager.editBill(inputCode(), newBill());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        billManager.removeBill(inputCode());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    billManager.showList();
                    break;
                case 0:
            }
        }
    }

    private static String inputCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nh???p id: ");
        return scanner.nextLine();

    }


    public static void showMenu() {
        System.out.println("                                       ???                     " + "??????????????????????????????????????????????????????????????????");
        System.out.println("                                                            " + "??????????????????BILL_LIST-MANAGER??????????????????");
        System.out.println("                                       ???                     " + "??????????????????????????????????????????????????????????????????");
        System.out.println("                                           ????????????                     " +"1. S???a bill : ");
        System.out.println("                                           ????????????                     " +"2. X??a bill : ");
        System.out.println("                                           ????????????                     " +"3. Bill Menu: ");
        System.out.println("                                           ????????????                     " +"0. Exit ");
        System.out.println("          ");
    }

    private static Bill newBill() {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Nh???p billCode: ");
        String code = input1.nextLine();
        Customer customer = newCustomer();
        Scanner input2 = new Scanner(System.in);
        System.out.println("M???i nh???p ng??y: ");
        String date = input2.nextLine();
        return new Bill(code, customer,date);

    }


    private static Customer newCustomer(){
        Scanner scanner1= new Scanner(System.in);
        System.out.println("Nh???p id kh??ch h??ng: ");
        String id = scanner1.nextLine();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nh???p t??n: ");
        String name = scanner.nextLine();
        System.out.println("Nh???p ?????a ch???: ");
        String add = scanner.nextLine();
        return new Customer(id,name,add);
    }
}

