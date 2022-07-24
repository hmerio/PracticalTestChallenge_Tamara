import java.util.Scanner;

public class Main {
    /**
     * Basic system requirements:
     * ● System from the start has 3 products that can be sold. Each product contains:
     *      1. Id
     *      2. Name
     *      3. Price
     * ● System from the start has 3 users that can buy products. Each user has:
     *      1. Id
     *      2. First name
     *      3. Last name
     *      4. Amount of money
     * ● System has menu that supports next operations:
     *      1. Display list of all users
     *      2. Display list of all products
     *      3. User should be able to buy product, to do this operation we should enter:Id of user who want to buy productId of
     *      product which user want to buy
     *          ● If user doesn't have enough money to buy product, throw exception
     *          ● If user successfully bought the product display message about successful purchase
     *          ● When user is buying product, his amount of money decreases by product price
     *          ● After successful purchase, information about user and his products has to be stored in collection best
     * suited for that purpose
     *
     * todo:
     *      4. Display list of user products by user id (If user didn't buy anything yet, don't show anything)
     *      5. Display list of users that bought product by product id (If nobody bought this product yet, don't show
     *      anything)
     */


    private static int amountOfMoney01 = 80;
    private static int amountOfMoney02 = 200;
    private static int amountOfMoney03 = 150;

    private static final int userId01 = 1;
    private static final int userId02 = 2;
    private static final int userId03 = 3;

    private static final int productId01 = 1;
    private static final int productId02 = 2;
    private static final int productId03 = 3;


    private static final int price01 = 30;
    private static final int price02 = 60;
    private static final int price03 = 150;
    private static int mainPrice  = 0;


    public static void main(String[] args) {



        welcomeBox();
        displayUserList();




    }

    private static void displayUserList() {

    }

    private static void welcomeBox() {
        System.out.println("\nHello and welcome to LuxuryBeachResortMegaSuperShop^^");
        makeChoiceWelcomeBox();

    }

    private static void makeChoiceWelcomeBox() {
        System.out.println("\nChoose: \nI want to see list of all products (press 1) \nI want to see list of all users (press 2) \nexit (0)");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        switch (num) {
            case "1" -> productsList();
            case "2" -> usersList();
            case "0" -> System.exit(0);
            default -> {
                System.out.println("please, make correct choice (1, 2 or 0)");
                makeChoiceWelcomeBox();
            }
        }
    }

    private static void productsList() {
        System.out.println("\nWe have 3 items to buy for a moment:");

        System.out.println("\nID      NAME       PRICE");
        System.out.println("\n"+productId01+"      POTATO     UAH " + price01);
        System.out.println(productId02+"      TOMATO     UAH " + price02);
        System.out.println(productId03+"      CONDOMS    UAH " + price03);

        makeChoiceProductsList();
    }

    private static void makeChoiceProductsList() {
        System.out.println("\nWant to buy something? (press 1) \nWant to see users list? (press 2)");
        System.out.println("Want to go to main menu? (press *) \nexit (press 0)");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        switch (num) {
            case "1" -> buyProduct();
            case "*" -> welcomeBox();
            case "2" -> usersList();
            case "0" -> System.exit(0);
            default -> {
                System.out.println("please, make correct choice (1, 2, 3 or 0)");
                makeChoiceUserList();
            }
        }
    }

    private static void usersList() {


        System.out.println("\nMeet our 3 users:");
        System.out.println("\nID      FIRST NAME    LAST NAME       AMOUNT OF MONEY");
        System.out.println("\n"+userId01+"      Jack          Sparrow       UAH " + amountOfMoney01);
        System.out.println(userId02+ "      Hermione      Granger       UAH " + amountOfMoney02);
        System.out.println(userId03+ "      Zorro         Just Zorro    UAH " + amountOfMoney03);

        makeChoiceUserList();

    }

    private static void makeChoiceUserList() {

        System.out.println("\nWant to buy something? (press 1) \nWant to see products list? (press 2)");
        System.out.println("Want to go to main menu? (press *) \nexit (press 0)");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        switch (num) {
            case "1" -> buyProduct();
            case "*" -> welcomeBox();
            case "2" -> productsList();
            case "0" -> System.exit(0);
            default -> {
                System.out.println("please, make correct choice (1, 2, 3 or 0)");
                makeChoiceUserList();
            }
        }
    }

    private static void buyProduct() {


//        chooseUserToBuyProduct();
//        chooseProductToBuy();


//        System.out.println(processOfBuying(chooseUserToBuyProduct(), chooseProductToBuy()));


        System.out.println("Congrats! On your account left "
                + processOfBuying(chooseUserToBuyProduct(), mainPrice) + " UAH.");
//        System.out.println(mainPrice);

        usersList();

    }

    private static int processOfBuying(int amountToBuy, int priceToBuy)  {


        if (priceToBuy > amountToBuy) {
            try {
                throw new PriceException("Sorry! Price is higher than user has!");
            } catch (PriceException e) {
                throw new RuntimeException(e);
            }
        }

        return amountToBuy - priceToBuy;
    }

    private static int chooseProductToBuy() {
        System.out.println("Please, enter ID of Product, you want to buy:");
        System.out.println("(1 - Potato, 2 - Tomato, 3 - Condoms, 0 - exit, * - main menu)");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();

        switch (num) {
            case "1" -> mainPrice  =  price01;
            case "2" -> mainPrice  =  price02;
            case "3" -> mainPrice  =  price03;
            case "0" -> System.exit(0);
            case "*" -> welcomeBox();
            default -> {
                System.out.println("please, make correct choice (01, 02, 03, 00 or 0)");
                chooseProductToBuy();
            }
        }

        return mainPrice;
    }

    private static int chooseUserToBuyProduct() {
        System.out.println("Please, enter ID of User:");
        System.out.println("(1 - Jack, 2 - Hermione, 3 - Zorro, 0 - exit, * - main menu)");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int mainAmount = 0;
        switch (num) {
            case "1" -> {
                mainAmount = amountOfMoney01;
                amountOfMoney01 -= chooseProductToBuy();
            }
            case "2" -> {
                mainAmount =  amountOfMoney02;
                amountOfMoney02 -= chooseProductToBuy();
            }
            case "3" -> {
                mainAmount =  amountOfMoney03;
                amountOfMoney03 -= chooseProductToBuy();
            }
            case "0" -> System.exit(0);
            case "*" -> welcomeBox();
            default -> {
                System.out.println("please, make correct choice (01, 02, 03, 00 or 0)");
                chooseUserToBuyProduct();
            }
        }

        return mainAmount;
    }
}