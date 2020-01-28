/*
 * Zork is a simple text based adventure game where the user goes through different rooms that contain various items.
 * Users can move in the directions specified by the program and have the chance of encountering the "secret" room.
 * Austin Wang
 */

import java.util.*;

public class Zork {

    private static Scanner in = new Scanner(System.in);
    private static Map<Integer, String> roomNames = new HashMap<>();
    private static Map<Integer, String> roomItems = new HashMap<>();
    private static Set<String> itemsSeen = new LinkedHashSet<>();
    private static Random rand = new Random();
    private static boolean isSecretRmAvail = false;
    private static boolean [] visitedArray = new boolean [8];
    private static boolean [] isMoneyTaken = new boolean [8];
    private static int moneyCollected = 0;
    private static String character = "Zork";
    private static int setCharRoom = 1 + rand.nextInt(9);

    public static void main (String[] args) {
        startGame();
        exit();
    }

    // Method starts the game
    private static void startGame() {
        String dir = "q";
        int room = 1;

        do {
            switch (room) {
                case 1:
                    room = foyer(dir);
                    break;
                case 2:
                    room = frontRoom(dir);
                    break;
                case 3:
                    room = library(dir);
                    break;
                case 4:
                    room = kitchen(dir);
                    break;
                case 5:
                    room = diningRoom(dir);
                    break;
                case 6:
                    room = vault(dir);
                    break;
                case 7:
                    room = parlor(dir);
                    break;
                case 8:
                    room = secretRoom(dir);
                    break;
                default:
                    System.out.println("Invalid Room");
                    break;
            }
            System.out.println("================================================================");
        } while (true);
    }

    // 1. Foyer
    private static int foyer(String dir) {
        int roomNum = 1, moneyAvail = rand.nextInt(10001);
        String roomName = "foyer", items = "dead scorpion", canMove = "Direction: N | Room #: 2", takeMoney = "";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[0] = true;
        itemsSeen.add(roomItems.get(roomNum));

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));

        if (!isMoneyTaken[0]) {
            System.out.println("You have found $" + moneyAvail);
            System.out.print("Would you like to take the money? (y/n): ");
            takeMoney = in.nextLine();
        }
        if (takeMoney.equalsIgnoreCase("y")) {
            isMoneyTaken[0] = true;
            moneyCollected += moneyAvail;
            System.out.println("You have collected $" + moneyCollected + " so far");
        } else {
            System.out.println("You have collected $" + moneyCollected + " so far");
        }
        if (setCharRoom == roomNum) {
            System.out.println(character + " has appeared and took all your money! ");
            moneyCollected = 0;
        }
        System.out.println("You can move in the following directions: ");
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        // Switches to the specified room or exits the program depending on user input.
        // Checks to make sure user has inputted a valid direction.
        switch (dir.toLowerCase()) {
            case "n":
                roomNum = 2;
                break;
            case "q":
                exit();
                break;
            default:
                System.out.println("The " + roomNames.get(roomNum)
                        + " does not have a door in the " + dir + " direction");
        }
        return roomNum;
    }

    // 2. Front Room
    private static int frontRoom(String dir) {
        int roomNum = 2, moneyAvail = rand.nextInt(10001);
        String roomName = "front room", items = "piano", canMove = "Direction: S | Room #: 1\n" +
                "Direction: W | Room #: 3\n" +
                "Direction: E | Room #: 4", takeMoney = "";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[1] = true;
        itemsSeen.add(roomItems.get(roomNum));

        // Switches to the specified room or exits the program depending on user input.
        // Checks to make sure user has inputted a valid direction.
        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        if (!isMoneyTaken[1]) {
            System.out.println("You have found $" + moneyAvail);
            System.out.print("Would you like to take the money? (y/n): ");
            takeMoney = in.nextLine();
        }
        if (takeMoney.equalsIgnoreCase("y")) {
            isMoneyTaken[1] = true;
            moneyCollected += moneyAvail;
            System.out.println("You have collected $" + moneyCollected + " so far");
        } else {
            System.out.println("You have collected $" + moneyCollected + " so far");
        }
        if (setCharRoom == roomNum) {
            System.out.println(character + " has appeared and took all your money! ");
            moneyCollected = 0;
        }
        System.out.println("You can move in the following directions: ");
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        switch(dir.toLowerCase()) {
            case "s":
                roomNum = 1;
                break;
            case "w":
                roomNum = 3;
                break;
            case "e":
                roomNum = 4;
                break;
            case "q":
                exit();
                break;
            default:
                System.out.println("The " + roomNames.get(roomNum)
                        + " does not have a door in the " + dir + " direction");
        }
        return roomNum;
    }

    // 3. Library
    private static int library(String dir) {
        int roomNum = 3, moneyAvail = rand.nextInt(10001);
        String roomName = "library", items = "spiders", canMove = "Direction: E | Room #: 2\n" +
                "Direction: N | Room #: 5", takeMoney = "";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[2] = true;
        itemsSeen.add(roomItems.get(roomNum));

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        if (!isMoneyTaken[2]) {
            System.out.println("You have found $" + moneyAvail);
            System.out.print("Would you like to take the money? (y/n): ");
            takeMoney = in.nextLine();
        }
        if (takeMoney.equalsIgnoreCase("y")) {
            isMoneyTaken[2] = true;
            moneyCollected += moneyAvail;
            System.out.println("You have collected $" + moneyCollected + " so far");
        } else {
            System.out.println("You have collected $" + moneyCollected + " so far");
        }
        if (setCharRoom == roomNum) {
            System.out.println(character + " has appeared and took all your money! ");
            moneyCollected = 0;
        }
        System.out.println("You can move in the following directions: ");
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        // Switches to the specified room or exits the program depending on user input.
        // Checks to make sure user has inputted a valid direction.
        switch (dir.toLowerCase()) {
            case "e":
                roomNum = 2;
                break;
            case "n":
                roomNum = 5;
                break;
            case "q":
                exit();
                break;
            default:
                System.out.println("The " + roomNames.get(roomNum)
                        + " does not have a door in the " + dir + " direction");
        }
        return roomNum;
    }

    // 4. Kitchen
    private static int kitchen(String dir) {
        int roomNum = 4, moneyAvail = rand.nextInt(10001);
        String roomName = "kitchen", items = "bats", canMove = "Direction: W | Room #: 2\n" +
                "Direction: N | Room #: 7", takeMoney = "";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[3] = true;
        itemsSeen.add(roomItems.get(roomNum));

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        if (!isMoneyTaken[3]) {
            System.out.println("You have found $" + moneyAvail);
            System.out.print("Would you like to take the money? (y/n): ");
            takeMoney = in.nextLine();
        }
        if (takeMoney.equalsIgnoreCase("y")) {
            isMoneyTaken[3] = true;
            moneyCollected += moneyAvail;
            System.out.println("You have collected $" + moneyCollected + " so far");
        } else {
            System.out.println("You have collected $" + moneyCollected + " so far");
        }
        if (setCharRoom == roomNum) {
            System.out.println(character + " has appeared and took all your money! ");
            moneyCollected = 0;
        }
        System.out.println("You can move in the following directions: ");
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        // Switches to the specified room or exits the program depending on user input.
        // Checks to make sure user has inputted a valid direction.
        switch (dir.toLowerCase()) {
            case "w":
                roomNum = 2;
                break;
            case "n":
                roomNum = 7;
                break;
            case "q":
                exit();
                break;
            default:
                System.out.println("The " + roomNames.get(roomNum)
                        + " does not have a door in the " + dir + " direction");
        }
        return roomNum;
    }

    // 5. Dining Room
    private static int diningRoom(String dir) {
        int roomNum = 5, moneyAvail = rand.nextInt(10001);
        String roomName = "dining room", items = "dust & empty box", canMove = "Direction: S | Room #: 3", takeMoney = "";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[4] = true;
        itemsSeen.add(roomItems.get(roomNum));

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        if (!isMoneyTaken[4]) {
            System.out.println("You have found $" + moneyAvail);
            System.out.print("Would you like to take the money? (y/n): ");
            takeMoney = in.nextLine();
        }
        if (takeMoney.equalsIgnoreCase("y")) {
            isMoneyTaken[4] = true;
            moneyCollected += moneyAvail;
            System.out.println("You have collected $" + moneyCollected + " so far");
        } else {
            System.out.println("You have collected $" + moneyCollected + " so far");
        }
        if (setCharRoom == roomNum) {
            System.out.println(character + " has appeared and took all your money! ");
            moneyCollected = 0;
        }
        System.out.println("You can move in the following directions: ");
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        // Switches to the specified room or exits the program depending on user input.
        // Checks to make sure user has inputted a valid direction.
        switch (dir.toLowerCase()) {
            case "s":
                roomNum = 3;
                break;
            case "q":
                exit();
                break;
            default:
                System.out.println("The " + roomNames.get(roomNum)
                        + " does not have a door in the " + dir + " direction");
        }
        return roomNum;
    }

    // 6. Vault
    private static int vault(String dir) {
        int roomNum = 6, moneyAvail = rand.nextInt(10001);
        String roomName = "vault", items = "3 walking skeletons", canMove, takeMoney = "";
        if (rand.nextDouble() < 0.25 || isSecretRmAvail) {
            canMove = "Direction: E | Room #: 7\n" +
                    "Direction: E | Room #: 8";
            isSecretRmAvail = true;
        } else {
            canMove = "Direction: E | Room #: 7";
        }

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[5] = true;
        itemsSeen.add(roomItems.get(roomNum));

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        if (!isMoneyTaken[5]) {
            System.out.println("You have found $" + moneyAvail);
            System.out.print("Would you like to take the money? (y/n): ");
            takeMoney = in.nextLine();
        }
        if (takeMoney.equalsIgnoreCase("y")) {
            isMoneyTaken[5] = true;
            moneyCollected += moneyAvail;
            System.out.println("You have collected $" + moneyCollected + " so far");
        } else {
            System.out.println("You have collected $" + moneyCollected + " so far");
        }
        if (setCharRoom == roomNum) {
            System.out.println(character + " has appeared and took all your money! ");
            moneyCollected = 0;
        }
        System.out.println("You can move in the following directions: ");
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        // Checks to see if the secret room appears (25% chance)
        // Switches to the specified room or exits the program depending on user input.
        // Checks to make sure user has inputted a valid direction.
        switch (dir.toLowerCase()) {

            case "e":
                if (isSecretRmAvail) {
                    System.out.println("You have found the secret room!");
                    System.out.print("Enter 7 to go to the " + roomNames.get(7)
                            + " or enter 8 to go to the secret room: ");
                    int selectRm = in.nextInt();
                    in.nextLine();
                    switch (selectRm) {
                        case 7:
                            roomNum = 7;
                            break;
                        case 8:
                            roomNum = 8;
                            break;
                        default:
                            System.out.println("The " + roomNames.get(roomNum)
                                    + " does not have a door in the " + dir + " direction");
                    }
                } else {
                    roomNum = 7;
                }
                break;
            case "q":
                exit();
                break;
            default:
                System.out.println("The " + roomNames.get(roomNum)
                        + " does not have a door in the " + dir + " direction");
        }
        return roomNum;
    }

    // 7. Parlor
    private static int parlor(String dir) {
        int roomNum = 7, moneyAvail = rand.nextInt(10001);
        String roomName = "parlor", items = "treasure chest", canMove = "Direction: W | Room #: 6\n" +
                "Direction: S | Room #: 4", takeMoney = "";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[6] = true;
        itemsSeen.add(roomItems.get(roomNum));

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        if (!isMoneyTaken[6]) {
            System.out.println("You have found $" + moneyAvail);
            System.out.print("Would you like to take the money? (y/n): ");
            takeMoney = in.nextLine();
        }
        if (takeMoney.equalsIgnoreCase("y")) {
            isMoneyTaken[6] = true;
            moneyCollected += moneyAvail;
            System.out.println("You have collected $" + moneyCollected + " so far");
        } else {
            System.out.println("You have collected $" + moneyCollected + " so far");
        }
        if (setCharRoom == roomNum) {
            System.out.println(character + " has appeared and took all your money! ");
            moneyCollected = 0;
        }
        System.out.println("You can move in the following directions: ");
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        // Switches to the specified room or exits the program depending on user input.
        // Checks to make sure user has inputted a valid direction.
        switch (dir.toLowerCase()) {
            case "w":
                roomNum = 6;
                break;
            case "s":
                roomNum = 4;
                break;
            case "q":
                exit();
                break;
            default:
                System.out.println("The " + roomNames.get(roomNum)
                        + " does not have a door in the " + dir + " direction");
        }
        return roomNum;
    }

    // 8. Secret room
    private static int secretRoom(String dir) {
        int roomNum = 8, moneyAvail = rand.nextInt(10001);
        String roomName = "secret room", items = "piles of gold", canMove = "Direction: W | Room #: 6", takeMoney = "";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[7] = true;
        itemsSeen.add(roomItems.get(roomNum));

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        if (!isMoneyTaken[7]) {
            System.out.println("You have found $" + moneyAvail);
            System.out.print("Would you like to take the money? (y/n): ");
            takeMoney = in.nextLine();
        }
        if (takeMoney.equalsIgnoreCase("y")) {
            isMoneyTaken[7] = true;
            moneyCollected += moneyAvail;
            System.out.println("You have collected $" + moneyCollected + " so far");
        } else {
            System.out.println("You have collected $" + moneyCollected + " so far");
        }
        if (setCharRoom == roomNum) {
            System.out.println(character + " has appeared and took all your money! ");
            moneyCollected = 0;
        }
        System.out.println("You can move in the following directions: ");
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        // Switches to the specified room or exits the program depending on user input.
        // Checks to make sure user has inputted a valid direction.
        switch (dir.toLowerCase()) {
            case "w":
                roomNum = 6;
                break;
            case "q":
                exit();
                break;
            default:
                System.out.println("The " + roomNames.get(roomNum)
                        + " does not have a door in the " + dir + " direction");
        }
        return roomNum;
    }

    // Outputs the amount of rooms the user has visited and also has a 25% chance of displaying a message that a ghost
    // has followed them. Exits the program afterwards.
    private static void exit() {
        int visitedCount = 0;
        // Sums the rooms the user has visited by checking to see which indexes are true in visitedArray
        for (boolean b : visitedArray) {
            if (b) {
                visitedCount++;
            }
        }
        System.out.println("================================================================");
        System.out.println("You have visited: " + visitedCount + " rooms");
        System.out.print("You have seen the following items: " );
        for (String s : itemsSeen) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("You have collected a total of: $" + moneyCollected);
        if (rand.nextDouble() < 0.25) {
            System.out.println("A ghost has followed you!");
        }
        System.exit(0);
    }
}