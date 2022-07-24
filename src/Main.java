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
     * todo: (BUT I DIDNT)
     *      4. Display list of user products by user id (If user didn't buy anything yet, don't show anything)
     *      5. Display list of users that bought product by product id (If nobody bought this product yet, don't show
     *      anything)
     */


    //these three variable mean price of products
    private static int amountOfMoney01 = 80;
    private static int amountOfMoney02 = 200;
    private static int amountOfMoney03 = 150;

    //these three variable mean id of users
    private static final int userId01 = 1;
    private static final int userId02 = 2;
    private static final int userId03 = 3;

    //these three variable mean id of products
    private static final int productId01 = 1;
    private static final int productId02 = 2;
    private static final int productId03 = 3;

    //these three variable mean prices of products
    private static final int price01 = 30;
    private static final int price02 = 60;
    private static final int price03 = 150;

    //this variable is the price we have when we choose what product we buy
    private static int mainPrice  = 0;


    public static void main(String[] args) {
        //this method shows us the main menu with ability to choose next options
        welcomeBox();
    }

    /**
     * this is the start method and main menu.
     */
    private static void welcomeBox() {
        System.out.println("\nHello and welcome to LuxuryBeachResortMegaSuperShop^^");
        makeChoiceWelcomeBox();

    }

    /**
     * this method shows us the menu and we can chose what we want to see next.
     */
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

    /**
     * this method shows list of three products we have
     */
    private static void productsList() {
        System.out.println("\nWe have 3 items to buy for a moment:");

        System.out.println("\nID      NAME       PRICE");
        System.out.println("\n"+productId01+"      POTATO     UAH " + price01);
        System.out.println(productId02+"      TOMATO     UAH " + price02);
        System.out.println(productId03+"      CONDOMS    UAH " + price03);

        makeChoiceProductsList();
    }

    /**
     * this methos shows up in product list and we choose where to go next.
     */
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

    /**
     * this method shows list of three users we have
     */
    private static void usersList() {


        System.out.println("\nMeet our 3 users:");
        System.out.println("\nID      FIRST NAME    LAST NAME       AMOUNT OF MONEY");
        System.out.println("\n"+userId01+"      Jack          Sparrow       UAH " + amountOfMoney01);
        System.out.println(userId02+ "      Hermione      Granger       UAH " + amountOfMoney02);
        System.out.println(userId03+ "      Zorro         Just Zorro    UAH " + amountOfMoney03);

        makeChoiceUserList();

    }

    /**
     * this methos shows up in product list and we choose where to go next.
     */
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

    /**
     * this method shows up if we want to buy something.
     * is calls two other methods where we can choose product we buy and user which wallet we use
     * after it shows how much money left
     * and after it shows the user list so we see what changed
     */
    private static void buyProduct() {

        System.out.println("Congrats! On your account left "
                + processOfBuying(chooseUserToBuyProduct(), mainPrice) + " UAH.");

        usersList();
    }

    /**
     *this method does a subtraction operation (the amount in the user's wallet minus the price for the product).
     * also if user has less money than product costs we have Exeption (class PriceException)
     * @param amountToBuy - this much money user has
     * @param priceToBuy - price of the product we want
     * @return - how much money left
     */
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

    /**
     * in this method we choose product we want to buy and how much money we will spend
     * @return - variable mainPrice shows the price of the product
     */
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

    /**
     * in this method we choose user and his amount of money.
     * we also overwrite the amount that the user will have in the wallet, excluding the price of the product
     * @return - amount of money of user we ve chosen
     */
    private static int chooseUserToBuyProduct() {
        System.out.println("Please, enter ID of User:");
        System.out.println("(1 - Jack, 2 - Hermione, 3 - Zorro, 0 - exit, * - main menu)");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int amountOfUsersMoney = 0;
        switch (num) {
            case "1" -> {
                amountOfUsersMoney = amountOfMoney01;
                amountOfMoney01 -= chooseProductToBuy();
            }
            case "2" -> {
                amountOfUsersMoney =  amountOfMoney02;
                amountOfMoney02 -= chooseProductToBuy();
            }
            case "3" -> {
                amountOfUsersMoney =  amountOfMoney03;
                amountOfMoney03 -= chooseProductToBuy();
            }
            case "0" -> System.exit(0);
            case "*" -> welcomeBox();
            default -> {
                System.out.println("please, make correct choice (01, 02, 03, 00 or 0)");
                chooseUserToBuyProduct();
            }
        }
        return amountOfUsersMoney;
    }
}