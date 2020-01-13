import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int totalPlayers;
    private static List<String> playerList = new ArrayList<String>();

    public static void main(String[] args) {
        getPlayers();
        List<Hand> hands = new ArrayList<Hand>();
        Deck deck = new Deck(); //Creating constructors to call
        for (int i = 0; i < totalPlayers; i++) {
            hands.add(new Hand(deck));
//            hand = new Hand(deck); //classes Deck and Hand which create
//            hand2 = new Hand(deck); //a deck of cards and deals & evaluates two hands.
//            hands.get(i).displayCards();
//            hands.get(i).strength();
        }

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
                            if (1 <= totalPlayers) {
                                System.out.printf("%-16s\n", playerList.get(0) + " hand:");
//Top and bottom’s cards are printed to the screen, as well as the strength of each hand.
                                hands.get(0).displayCards();
                                exit = backToMenu();
                            } else {
                                System.out.println("Error! Terminating Program");
                            }
                            break;
                        case 2:
                            if (2 <= totalPlayers) {
                                System.out.printf("%-16s\n", playerList.get(1) + " hand:");
//Top and bottom’s cards are printed to the screen, as well as the strength of each hand.
                                hands.get(1).displayCards();
                                exit = backToMenu();
                            } else {
                                System.out.println("Error! Terminating Program");
                            }
                            break;
                        case 3:
                            if (3 <= totalPlayers) {
                                System.out.printf("%-16s\n", playerList.get(2) + " hand:");
//Top and bottom’s cards are printed to the screen, as well as the strength of each hand.
                                hands.get(2).displayCards();
                                exit = backToMenu();
                            } else {
                                System.out.println("Error! Please try again!");
                            }
                            break;
                        case 4:
                            if (4 <= totalPlayers) {
                                System.out.printf("%-16s\n", playerList.get(3) + " hand:");
//Top and bottom’s cards are printed to the screen, as well as the strength of each hand.
                                hands.get(3).displayCards();
                                exit = backToMenu();
                            } else {
                                System.out.println("Error! Please try again!");
                            }
                            break;
                        case 5:
                            if (5 <= totalPlayers) {
                                System.out.printf("%-16s\n", playerList.get(4) + " hand:");
//Top and bottom’s cards are printed to the screen, as well as the strength of each hand.
                                hands.get(4).displayCards();
                                exit = backToMenu();
                            } else {
                                System.out.println("Error! Please try again!");
                            }
                            break;

                        case 8:
                            System.out.printf("Strength of all Hand Values:\n");
                            for (int i = 0; i < hands.size(); i++) {
                                System.out.println(playerList.get(i) + "'s Hand:");
                                hands.get(i).strength();
                                System.out.println("\n");
                            }
                            exit = backToMenu();
                            break;
                        case 9:
                            // getResults();
                        case 10: // EXIT APPLICATION
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

    }

/*
    private static void getResults() {
        if (hand.compareTo(hand2) == 1)
            System.out.println("!............... *** AND THE WINNER IS " + player1Name + " *** ...............!");

        else if (hand.compareTo(hand2) == -1)
            System.out.println("!............... *** AND THE WINNER IS " + player2Name + " *** ...............!");

        else
            System.out.println("!............... *** AND IT'S A DRAW *** ...............!");
    }
*/

    private static void displayMenu() {
        System.out.println("Menu : ");
        System.out.println("Type any number for selection");
        for (int i = 1; i <= totalPlayers; i++) {
            System.out.println(i + ")View " + playerList.get(i - 1) + " cards");

        }
        System.out.println("8)Display Each Player's Hand Strength");
        System.out.println("9)Declare Winner");
        System.out.println("10)Exit");
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
        System.out.println("Please enter Number of total players (MAX 5 ALLOWED)");
        totalPlayers = intInput.nextInt();
        Scanner strInput = new Scanner(System.in);
        for (int i = 1; i <= totalPlayers; i++) {
            System.out.println("Please Enter Player " + i + " Name:");
            String name = strInput.nextLine();
            playerList.add(name);
        }
//        for (int i = 0; i <playerList.size(); i++) {
//            System.out.println("Player " + i + " : " + playerList.get(i));
//        }

//
//        try {
//            if (totalPlayers > 1) {
//                player1Name = nameArr.get(0);
//                player2Name = nameArr.get(1);
//                player3Name = nameArr.get(2);
//                player4Name = nameArr.get(3);
//                player5Name = nameArr.get(4);
//            }
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Names are all set!");
//        }

    }


}