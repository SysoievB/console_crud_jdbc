package com.console.crud.jdbc.app.view;

import java.util.Scanner;

public class CommonView {

    private OrderView orderView;
    private AccountView accountView;
    private CustomerView customerView;
    private static CommonView view;

    private CommonView() {
        orderView = new OrderView();
        accountView = new AccountView();
        customerView = new CustomerView();
    }

    public static CommonView getInstance() {
        if (view == null) {
            view = new CommonView();
        }
        return view;
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nChoose file in order to do operations, please:" +
                    "\nEnter number:" +
                    "\n1.Orders" +
                    "\n2.Accounts" +
                    "\n3.Customers" +
                    "\n4.Exit");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runOrder();
                    break;
                case 2:
                    runAccount();
                    break;
                case 3:
                    runCustomer();
                    break;
                case 4:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number" +
                            "\nEnter number from 1 to 4, please");
            }
        }
    }

    public void runOrder() {
        orderView.run();
    }

    public void runAccount() {
        accountView.run();
    }

    public void runCustomer() {
        customerView.run();
    }

}
