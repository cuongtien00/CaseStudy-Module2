package views;

import controller.CustomerManager;
import model.Customer;
import storage.CustomerFile;

import java.io.IOException;
import java.util.Scanner;

public class CustomerView {
    private static CustomerView customerView;
    private CustomerView(){}
    public static CustomerView getInstance(){
        if(customerView == null){
            customerView = new CustomerView();
        }
        return customerView;
    }

    public void runCustomerView(){



        Scanner scanner = new Scanner(System.in);
        CustomerManager customerManager = CustomerManager.getInstance();
        try {
            customerManager.setCustomerList(CustomerFile.getInstance().fileReader());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int choice = -1;
        while (choice!=0){
            showMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    try {
                        customerManager.addNewC(newCustomer());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        customerManager.removeC(inputID());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        customerManager.editC(inputID(),newCustomer());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    customerManager.showList();
                    break;
                case 5:
                    Customer customer = customerManager.searchC(inputID());
                    if(customer!=null){
                        System.out.println(customer);
                    }
                    else {
                        System.out.println("Kh??ng t??m th???y kh??ch h??ng");
                    }
                    break;
                case 0:
            }
        }
    }
    private static String inputID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nh???p Id: ");
        return scanner.nextLine();
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
    private static void showMenu(){
        System.out.println("                                       ???                     " + "??????????????????????????????????????????????????????????????????");
        System.out.println("                                                            " + "??????????????????CUSTOMER_LIST-MANAGER??????????????????");
        System.out.println("                                       ???                     " + "??????????????????????????????????????????????????????????????????");
        System.out.println("                                           ????????????                     " +"1. Th??m m???i customer : ");
        System.out.println("                                           ????????????                     " +"2. X??a customer : ");
        System.out.println("                                           ????????????                     " +"3. S???a customer : ");
        System.out.println("                                           ????????????                     " +"4. Customer Menu: ");
        System.out.println("                                           ????????????                     " +"5. T??m kh??ch h??ng: ");
        System.out.println("                                           ????????????                     " +"0. Exit ");
        System.out.println("          ");
    }
}
