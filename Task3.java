import java.util.Scanner;
class BankAccount {
    String accountNO, password;
    float balance =50000f;
    int transactions = 0;
    String transactionHistory = "";

    public void toRegister() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER YOUR ACCOUNT NUMBER: ");
        this.accountNO = sc.nextLine();
        System.out.print("ENTER YOUR PASSWORD: ");
        this.password = sc.nextLine();
        System.out.println("\nREGISTRATION SUCCESSFUL\nLOG IN TO YOUR BANK ACCOUNT");
    }

    public boolean toLogin() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.print("ENTER YOUR ACCOUNT NUMBER: ");
            String accNumber = sc.nextLine();
            if (accNumber.equals(accountNO)) {
                while (!isLogin) {
                    System.out.print("ENTER YOUR PASSWORD: ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("LOGIN SUCCESSFUL.");
                        isLogin = true;
                    } else {
                        System.out.println("INCORRECT PASSWORD.");
                    }
                }
            } else {
                System.out.println("ACCOUNT NUMBER NOT FOUND!!");
            }
        }
        return isLogin;
    }

    public void toWithdraw() {
        System.out.println("ENTER THE AMOUNT TO WITHDRAW: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("WITHDRAWAL SUCCESSFUL.");
                String str = amount + " RS WITHDRAWN\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("INSUFFICIENT BALANCE.");
            }
        } catch (Exception e) {
        }
    }

    public void toDeposit() {
        System.out.print("ENTER THE AMOUNT TO DEPOSIT: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (amount <= 900000f) {
                transactions++;
                balance += amount;
                System.out.println("DEPOSIT SUCCESSFUL.");
                String str = amount + " RS DEPOSITED\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("SORRY YOU HAVE CROSSED THE LIMIT. THE LIMIT IS 900000.");
            }
        } catch (Exception e) {
        }
    }

    public void toTransfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER RECEIPIENT'S ACCOUNT NUMBER: ");
        String receipent = sc.nextLine();
        System.out.print("ENTER THE AMOUNT TO TRANSFER: ");
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("SUCCESSFULLY TRANSFERRED TO " + receipent);
                    String str = amount + " RS TRANSFERRED TO " + receipent + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("SORRY YOU HAVE CROSSED THE LIMIT. THE LIMIT IS 50000.");
                }
            } else {
                System.out.println("INSUFFICIENT BALANCE.");
            }
        } catch (Exception e) {
        }
    }

    public void toCheckBalance() {
        System.out.println("YOUR BALANCE AMOUNT IS: " + balance + " RS");
    }

    public void toTransHistory() {
        if (transactions == 0) {
            System.out.println("NO TRANSACTIONS HAPPENED!!");
        } else {
            System.out.print("\n" + transactionHistory);
        }
    }
}

public class Task3 {
    public static int takenIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if (flag && (input > limit || input < 1)) {
                    System.out.println("CHOOSE THE NUMBER BETWEEN 1 TO " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT!!\nENTER ONLY INTEGER VALUE");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n*WELCOME TO THE ATM INTERFACE*");
        System.out.println("1. REGISTER\n2. EXIT");
        System.out.print("CHOOSE ONE OPTION FROM ABOVE: ");
        int choose = takenIntegerInput(2);

        if (choose == 1) {
            BankAccount b = new BankAccount();
            b.toRegister();
            while (true) {
                System.out.println("\n1. LOGIN\n2. EXIT");
                System.out.print("ENTER YOUR CHOICE: ");
                int ch = takenIntegerInput(2);
                if (ch == 1) {
                    if (b.toLogin()) {
                        System.out.println("\n**WELCOME BACK!!**");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1. WITHDRAW\n2. DEPOSIT\n3. TRANSFER\n4. CHECK BALANCE\n5. TRANSACTION HISTORY\n6. EXIT");
                            System.out.print("ENTER YOUR CHOICE: ");
                            int c = takenIntegerInput(6);
                            switch (c) {
                                case 1:
                                    b.toWithdraw();
                                    break;
                                case 2:
                                    b.toDeposit();
                                    break;
                                case 3:
                                    b.toTransfer();
                                    break;
                                case 4:
                                    b.toCheckBalance();
                                    break;
                                case 5:
                                    b.toTransHistory();
                                    break;
                                case 6:
                                
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
