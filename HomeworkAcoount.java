
import java.util.*;

class Account {
    int id;
    String ownerName;
    double balance;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }

    void getAccount() {

    }
}

public class HomeworkAcoount {
    // acc id owner balance
    // add acc add edit remove show
    // show account information
    // 1 . descending order by account_id
    // 2. ascending order by account_id
    // 3. descendinder order by balance
    public static void main(String[] args) {
        int option;
        List<Account> accountList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1: Add account");
            System.out.println("2: Remove Account ");
            System.out.println("3. Edit Account ");
            System.out.println("4. Show account information");
            System.out.println("5. Exit ");
            System.out.println("Choose option ( 1 - 5 ) : ");
            System.out.println("==========================================================");
            option = input.nextInt();

            switch (option) {
                case 1:
                    // enter account information
                    // object add list
                    // accountList.add();
                    System.out.println("Enter your account information :");
                    Account acc = new Account();
                    System.out.print("Input ID:");
                    acc.id = input.nextInt();
                    System.out.print("Name:");
                    input.nextLine();
                    acc.ownerName = input.nextLine();
                    System.out.print("Balance:");
                    acc.balance = input.nextInt();

                    accountList.add(acc);
                    break;
                case 2:
                    System.out.println("Remove account by Id");
                    System.out.println("Enter Id :");
                    int deletedID = input.nextInt();
                    System.out.println(deletedID);
                    boolean result1 = false;

                    for (int i = 0; i < accountList.size(); i++) {

                        if (accountList.get(i).id == deletedID) {
                            accountList.remove(i);
                            result1 = true;
                        }
                    }

                    if (!result1) {
                        System.out.println("Invalid ID!!");
                    }
                    break;
                case 3:
                    System.out.println("Edit Account Tool ");
                    System.out.println("Please enter your ID :");
                    int updateID = input.nextInt();
                    boolean result2 = false;
                    if (accountList.size() > 0) {
                        for (Account account : accountList) {

                            if (account.id == updateID) {
                                System.out.println("Enter the new Owner Name :");
                                account.ownerName = input.next();
                                System.out.println("Enter the new Balance :");
                                account.balance = input.nextDouble();
                                result2 = true;
                            }
                        }
                    }
                    if (!result2)
                        System.out.println("Invalid Update Please try again!!");
                    break;
                case 4:
                    int showOption;
                    do {
                        System.out.println("Show account information");
                        System.out.println("1. Ascending order (by ID )");
                        System.out.println("2. Descending order (by ID) ");
                        System.out.println("3. Descending order by balance ");

                        System.out.println("Choose option (1 - 3): ");
                        System.out.println("==========================================================");
                        showOption = input.nextInt();
                        List<Account> Collection = new ArrayList<>();
                        for (Account sort : accountList) {
                            Collection.add(sort);
                        }
                        switch (showOption) {
                            case 1:
                                System.out.println("Sort Ascending by Id");
                                Collections.sort(accountList, new Comparator<Account>() {
                                    @Override
                                    public int compare(Account acc1, Account acc2) {
                                        return (Integer.compare(acc1.id, acc2.id));
                                    }
                                });
                                for (Account account : accountList) {
                                    System.out.println(account);
                                }

                                break;
                            case 2:
                                System.out.println("Sort Descending by Id");
                                Collections.sort(accountList, new Comparator<Account>() {
                                    @Override
                                    public int compare(Account acc1, Account acc2) {
                                        return (Integer.compare(acc2.id, acc1.id));
                                    }
                                });
                                for (Account account : accountList) {
                                    System.out.println(account);
                                }
                                break;
                            case 3:
                                System.out.println(" Descending Balance");
                                Collections.sort(accountList, new Comparator<Account>() {
                                    @Override
                                    public int compare(Account acc1, Account acc2) {
                                        return (Integer.compare((int) acc2.balance, (int) acc1.balance));
                                    }
                                });
                                for (Account account : accountList) {
                                    System.out.println(account);
                                }
                                break;
                        }
                        break;
                    } while (showOption != 3);
                case 5:
                    System.out.println("Exit the program....!");
                    break;

            }
        } while (option != 5);

    }
}