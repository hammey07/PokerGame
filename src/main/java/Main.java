import java.util.*;

public class Main {
    private static int totalPlayers;
    private static List<String> playerList = new ArrayList<String>();
    private static List<Hand> hands = new ArrayList<Hand>();

    public static void main(String[] args) {
        // This method takes user input to get player names and stores them in playerlist array
        getPlayers();
        Deck deck = new Deck(); //Creating constructors to call
        for (int i = 0; i < totalPlayers; i++) {
            // creating hands for players
            hands.add(new Hand(deck));
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
                                // Player cards are printed to the screen
                                hands.get(0).displayCards();
                                exit = backToMenu();
                            } else {
                                System.out.println("Error! Terminating Program");
                            }
                            break;
                        case 2:
                            if (2 <= totalPlayers) {
                                System.out.printf("%-16s\n", playerList.get(1) + " hand:");
                                // Player cards are printed to the screen
                                hands.get(1).displayCards();
                                exit = backToMenu();
                            } else {
                                System.out.println("Error! Terminating Program");
                            }
                            break;
                        case 3:
                            if (3 <= totalPlayers) {
                                System.out.printf("%-16s\n", playerList.get(2) + " hand:");
                                // Player cards are printed to the screen
                                hands.get(2).displayCards();
                                exit = backToMenu();
                            } else {
                                System.out.println("Error! Please try again!");
                            }
                            break;
                        case 4:
                            if (4 <= totalPlayers) {
                                System.out.printf("%-16s\n", playerList.get(3) + " hand:");
                                // Player cards are printed to the screen
                                hands.get(3).displayCards();
                                exit = backToMenu();
                            } else {
                                System.out.println("Error! Please try again!");
                            }
                            break;
                        case 5:
                            if (5 <= totalPlayers) {
                                System.out.printf("%-16s\n", playerList.get(4) + " hand:");
                                // Player cards are printed to the screen
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
                                // printing strength of each player cards
                                hands.get(i).strength();
                                System.out.println("\n");
                            }
                            exit = backToMenu();
                            break;
                        case 9:
                            if (hands.contains(getResults())) {
                                int winningIndex = hands.indexOf(getResults());
                                System.out.println("Winning player is: " + playerList.get(winningIndex));
                            }
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

    // Compares hand results and returns the winning hand using lambda expression
    private static Hand getResults() {
        System.out.println(hands.size());
        Optional<Hand> winner;
        winner = hands.stream()
                .reduce((hand1, hand2)
                        -> hand1.compareTo(hand2) == 1 ? hand1 : hand2);
        Hand winningHand = null;
        if (winner.isPresent()) {
            winningHand = winner.get();
        }
        return winningHand;

    }

    // A method to display menu
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

    // takes user input to store them as player names
    private static void getPlayers() {
        while (true) {
            Scanner intInput = new Scanner(System.in);
            System.out.println("Please enter Number of total players (MAX 5 ALLOWED)");
            try {
                totalPlayers = intInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid input");
                continue;
            }
            if (totalPlayers > 5 || totalPlayers < 2) {
                System.out.println("Total players must be between 2 - 5");
                continue;
            }
            Scanner strInput = new Scanner(System.in);
            for (int i = 1; i <= totalPlayers; i++) {
                System.out.println("Please Enter Player " + i + " Name:");
                String name = strInput.nextLine();
                playerList.add(name);
            }
            break;
        }
    }
}
