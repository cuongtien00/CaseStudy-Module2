package views;

import controller.BillManager;
import controller.CustomerManager;
import controller.MilkTeaManager;
import controller.ToppingManager;
import model.Bill;
import model.Customer;
import model.MilkTea;
import model.Topping;
import storage.BillFile;
import storage.CustomerFile;
import storage.MilkTeaFile;
import storage.ToppingFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientView {
    private static ClientView clientView;

    private static CustomerManager customerManager = CustomerManager.getInstance();
    private static MilkTeaManager milkTeaManager = MilkTeaManager.getInstance();
    private static ToppingManager toppingManager = ToppingManager.getInstance();
    private static BillManager billManager = BillManager.getInstance();

    private ClientView() {
    }
    public static ClientView getInstance(){
        if(clientView==null){
            clientView = new ClientView();
        }
        return clientView;
    }

    public  void runClientView(){
        try {
            customerManager.setCustomerList(CustomerFile.getInstance().fileReader());
            milkTeaManager.setMilkTeaList(MilkTeaFile.getInstance().fileReader());
            toppingManager.setToppings(ToppingFile.getInstance().fileReader());
            billManager.setBillList(BillFile.getInstance().fileReader());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    dingTeaMenu();
                    break;
                case 2:
buyMilkTea();
                    break;
                case 3:
                    billManager.showList();
                    break;
                case 0:
            }

        }
    }

    public static void showMenu() {
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　    　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　  　＝＝＝＝＝。DINGTEA　募茶。＝＝＝＝＝");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　    　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　。WELCOME。　　　　　　　");
        System.out.println("                                                    1. Hiển thị Menu");
        System.out.println("                                                    2. Mua trà sữa");
        System.out.println("                                                    3. Xuất bill");
        System.out.println("                                                       Nhập lựa chọn:");
    }
    private static void dingTeaMenu() {
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　    　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　  　＝＝＝＝＝。DINGTEA　募茶。＝＝＝＝＝");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　    　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　。WELCOME。　　　　　　　");
        milkTeaManager.showList();
        toppingManager.showList();
    }
    private static void buyMilkTea() {
        dingTeaMenu();
        List<MilkTea> milkTeaList = new ArrayList<>();
        Bill bill = new Bill();

        Scanner input = new Scanner(System.in);
        System.out.println("Mua may loai?");
        int num = input.nextInt();

        for (int i = 0; i < num; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Moi ban chon code tra sua");
            String code = scanner.nextLine();
            MilkTea milkTea = new MilkTea();
            for (MilkTea a : milkTeaManager.getMilkTeaList()) {
                if (a.getCode().equalsIgnoreCase(code)) {
                    milkTea = a;
                }
            }
            Scanner input2 = new Scanner(System.in);
            System.out.println("Moi chon size ");
            String size = input2.nextLine();
            Scanner input3 = new Scanner(System.in);
            System.out.println("chon so luong");
            int quantity = input3.nextInt();
            Scanner input4 = new Scanner(System.in);
            System.out.println("Chon % duong ");
            String sugar = input4.nextLine();
            Scanner input5 = new Scanner(System.in);
            System.out.println("Chon da");
            String ice = input5.nextLine();
            Scanner input6 = new Scanner(System.in);
            System.out.println("chon id cua topping");
            String id = input6.nextLine();
            Topping topping = new Topping();
            for (Topping a : toppingManager.getToppings()) {
                if (a.getId().equalsIgnoreCase(id)) {
                    topping = a;
                }
            }
            milkTea.setSize(size);
            milkTea.setQuantity(quantity);
            milkTea.setSugar(sugar);
            milkTea.setIce(ice);
            milkTea.setTopping(topping);
            milkTeaList.add(milkTea);

        }
        bill.setMilkTeaList(milkTeaList);
        Scanner scanner1 = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Moi nhap ten khach hang");
        String name = scanner1.nextLine();
        for (Customer a : customerManager.getCustomerList()
        ) {
            if (a.getName().equalsIgnoreCase(name)) {
                customer = a;
            }
        }
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhap code bill");
        String codeBill = scanner2.nextLine();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhap ngay ");
        String date = scanner3.nextLine();


        bill.setCode(codeBill);
        bill.setDate(date);
        bill.setCustomer(customer);

        try {
            billManager.addNewBill(bill);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

