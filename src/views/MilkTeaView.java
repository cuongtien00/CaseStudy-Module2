package views;

import controller.MilkTeaManager;
import model.MilkTea;
import storage.MilkTeaFile;

import java.io.IOException;
import java.util.Scanner;

public class MilkTeaView {
    private  static MilkTeaView milkTeaView;
    private static MilkTeaManager milkTeaManager = MilkTeaManager.getInstance();;

    public  MilkTeaManager getMilkTeaManager() {
        return milkTeaManager;
    }

    public  void setMilkTeaManager(MilkTeaManager milkTeaManager) {
        MilkTeaView.milkTeaManager = milkTeaManager;
    }

    private MilkTeaView(){}
    public  static MilkTeaView getInstance(){
        if(milkTeaView == null){
            milkTeaView = new MilkTeaView();
        }
        return milkTeaView;
        }
    public void runMilkTeaView(){
//         milkTeaManager = MilkTeaManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        try {
            milkTeaManager.setMilkTeaList(MilkTeaFile.getInstance().fileReader());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -1;
        while (choice != 0){
            showMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    try {
                        milkTeaManager.addNewMilkTea(newMilkTea());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        milkTeaManager.removeMilkTea(inputCode());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        milkTeaManager.editMilkTeaList(inputCode(),newMilkTea());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    milkTeaManager.showList();
                    break;
                case 0:
            }
        }

    }
    private static String inputCode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nh???p code: ");
        return scanner.nextLine();
    }
    private static void showMenu(){
        System.out.println("                                       ???                     " + "??????????????????????????????????????????????????????????????????");
        System.out.println("                                                            " + "??????????????????MILKTEA_LIST-MANAGER??????????????????");
        System.out.println("                                       ???                     " + "??????????????????????????????????????????????????????????????????");
        System.out.println("                                           ????????????                     " +"1. Th??m m???i milk tea : ");
        System.out.println("                                           ????????????                     " +"2. X??a milk tea : ");
        System.out.println("                                           ????????????                     " +"3. S???a milk tea : ");
        System.out.println("                                           ????????????                     " +"4. MilkTea Menu: ");
        System.out.println("                                           ????????????                     " +"0. Exit ");
        System.out.println("          ");
    }
    private static MilkTea newMilkTea() {
        Scanner input = new Scanner(System.in);
        System.out.println("Moi nhap code: ");
        String code = input.nextLine();
        System.out.println("M???i nh???p lo???i tr?? s???a: ");
        String name = input.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Moi nhap gia");
        double price = input2.nextDouble();
        return new MilkTea(code, name, price);
    }
}
