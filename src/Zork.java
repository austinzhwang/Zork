import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

public class Zork {

    static Scanner in = new Scanner(System.in);
    static Map<Integer, String> roomNames = new HashMap<>();
    static Map<Integer, String> roomItems = new HashMap<>();
    static Random rand = new Random();
    static boolean isSecretRmAvail = false;
    static boolean [] visitedArray = new boolean [8];

    public static void main (String[] args) {
        startGame();
        exit();
    }

    public static void startGame() {
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

    public static int foyer(String dir) {
        int roomNum = 1;
        String roomName = "foyer", items = "dead scorpion", canMove = "Direction: N | Room #: 2";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[0] = true;

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        System.out.println("You can move in the following directions: ");
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        switch(dir.toLowerCase()) {
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

    public static int frontRoom(String dir) {
        int roomNum = 2;
        String roomName = "front room", items = "piano", canMove = "Direction: S | Room #: 1\n" +
                "Direction: W | Room #: 3\n" +
                "Direction: E | Room #: 4";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[1] = true;

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
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

    public static int library(String dir) {
        int roomNum = 3;
        String roomName = "library", items = "spiders", canMove = "Direction: E | Room #: 2\n" +
                "Direction: N | Room #: 5";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[2] = true;

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        switch(dir.toLowerCase()) {
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

    public static int kitchen(String dir) {
        int roomNum = 4;
        String roomName = "kitchen", items = "bats", canMove = "Direction: W | Room #: 2\n" +
                "Direction: N | Room #: 7";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[3] = true;

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        switch(dir.toLowerCase()) {
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

    public static int diningRoom(String dir) {
        int roomNum = 5;
        String roomName = "dining room", items = "dust & empty box", canMove = "Direction: S | Room #: 3";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[4] = true;

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        switch(dir.toLowerCase()) {
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

    public static int vault(String dir) {
        int roomNum = 6;
        String roomName = "vault", items = "3 walking skeletons", canMove;
        if (rand.nextDouble() < 0.25) {
            canMove = "Direction: E | Room #: 7\n" +
                    "Direction: E | Room #: 8";
            isSecretRmAvail = true;
        } else {
            canMove = "Direction: E | Room #: 7";
        }

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[5] = true;

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        switch(dir.toLowerCase()) {

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

    public static int parlor(String dir) {
        int roomNum = 7;
        String roomName = "parlor", items = "treasure chest", canMove = "Direction: W | Room #: 6\n" +
                "Direction: S | Room #: 4";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[6] = true;

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        switch(dir.toLowerCase()) {
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

    public static int secretRoom(String dir) {
        int roomNum = 8;
        String roomName = "secret room", items = "piles of gold", canMove = "Direction: W | Room #: 6";

        roomNames.put(roomNum, roomName);
        roomItems.put(roomNum, items);
        visitedArray[7] = true;

        System.out.println("You are currently in the " + roomNames.get(roomNum));
        System.out.println("The " + roomNames.get(roomNum) + " contains " + roomItems.get(roomNum));
        System.out.println(canMove);
        System.out.print("Which direction would you like to move in? (enter q to quit): ");
        dir = in.nextLine();

        switch(dir.toLowerCase()) {
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
    // has followed them.
    public static void exit() {
        int visitedCount = 0;
        for (int i = 0; i < visitedArray.length; i++) {
            if (visitedArray[i] == true) {
                    visitedCount++;
            }
        }
        System.out.println("You have visited " + visitedCount + " rooms");
        if (rand.nextDouble() < 0.25) {
            System.out.println("A ghost followed you!");
        }
        System.exit(0);
    }
}