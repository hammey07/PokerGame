import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Hand hand;
    private static Hand hand2;
    private static Hand hand3;
    private static Hand hand4;
    private static Hand hand5;
    private static String Player1Name;
    private static String Player2Name;
    private static String Player3Name;
    private static String Player4Name;
    private static String Player5Name;
    private static int totalPlayers;

    public static void main(String[] args) {

        getPlayers();
        Deck deck = new Deck(); //Creating constructors to call
        hand = new Hand(deck); //classes Deck and Hand which create
        hand2 = new Hand(deck); //a deck of cards and deals & evaluates two hands.

        Scanner sc = new Scanner(System.in);
        String selection;
        int selectionInt;
        boolean exit = false;
        while (!exit) {
            boolean badInput = true;
            displayMenu();
            while (badInput) {
                try {
                    selection = sc.next();
                    selectionInt = Integer.parseInt(selection);
                    badInput = false;

                    switch (selectionInt) {
                        case 1:
                            System.out.printf("%-16s\n", Player1Name + " hand:");
//Top and bottom’s cards are printed to the screen, as well as the strength of each hand.
                            hand.displayCards();
                            exit = backToMenu();
                            break;
                        case 2:
                            System.out.printf("%-16s\n", Player2Name + " hand:");
//Top and bottom’s cards are printed to the screen, as well as the strength of each hand.
                            hand2.displayCards();
                            exit = backToMenu();
                            break;

                        case 3:
                            System.out.printf("Strength of all Hand Values:\n");
                            System.out.println(Player1Name + "'s Hand:");
                            hand.strength();
                            System.out.println("\n");
                            System.out.println(Player2Name + "'s Hand:");
                            hand2.strength();
                            System.out.println("\n");
                            exit = backToMenu();
                            break;

                        case 4:
                            getResults();
                        case 5: // EXIT APPLICATION
                            System.out.println("Thank you for using this application! GoodBye");
                            exit = true;
                            break;
                        default:
                            System.out.println("Please enter correct input. Returning to main menu...");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid Choice Number");
                }
            }
        }

//The winner of the game is printed to the screen after a comparison.
    }

    private static void getResults() {

        if (hand.compareTo(hand2) == 1)
            System.out.println("!............... *** AND THE WINNER IS " + Player1Name + " *** ...............!");

        else if (hand.compareTo(hand2) == -1)
            System.out.println("!............... *** AND THE WINNER IS " + Player2Name + " *** ...............!");

        else
            System.out.println("!............... *** AND IT'S A DRAW *** ...............!");
    }

    private static void displayMenu() {
        System.out.println("Menu : ");
        System.out.println("Type any number for selection");
        System.out.println("1)View Player 1 cards");
        System.out.println("2)View Player 2 cards");
        System.out.println("3)Display Each Player's Hand Strength");
        System.out.println("4)Declare Winner");
        System.out.println("5)Exit");
    }

    // navigates back to menu
    private static boolean backToMenu() {
        boolean exit = false;
        System.out.println("Return to Main Menu? Type Yes / No");
        Scanner sc2 = new Scanner(System.in);
        if (sc2.next().equalsIgnoreCase("no"))
            exit = true;
        return exit;
    }

    public static void getPlayers() {
        Scanner intInput = new Scanner(System.in);
        System.out.println("Please enter Number of total players");
        totalPlayers = intInput.nextInt();
        Scanner strInput = new Scanner(System.in);
        List<String> nameArr = new ArrayList<String>();
        for (int i = 1; i <= totalPlayers; i++) {
            System.out.println("Please Enter Player " + i + " Name:");
            String name = strInput.nextLine();
            nameArr.add(name);
        }
        System.out.println(nameArr);
    }


}