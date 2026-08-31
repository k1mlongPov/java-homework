Scanner scan = new Scanner(System.in);

int printMenu() {
    IO.print("""
            ╔═════════════════════════╗
            ║   ROOM MANAGING MENU    ║
            ╠═════════════════════════╣
            ║   1. SET UP ROOM        ║
            ║   2. DISPLAY ROOM       ║
            ║   3. REQUEST ROOM       ║
            ║   4. UPDATE ROOM        ║
            ║   5. DELETE REQUEST     ║
            ║   6. VIEW HISTORY       ║
            ║   7. EXIT PROGRAM       ║
            ╚═════════════════════════╝
            """);
    IO.print("[+] PLEASE CHOOSE ONE OPTION : ");
    int option = scan.nextInt();
    scan.nextLine();
    return option;
}

void main() {
    int numOfFloor;
    int numOfRoom;
    int choice;
    boolean hasInitFloor = false;
    String[][] building = new String[][]{};

    StringBuilder managingActivities =
            new StringBuilder("ALL ROOM MANAGING ACTIVITIES\n");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    do {
        String quit;
        IO.print("PRESS KEY [ENTER] TO CONTINUE OR [Q] TO EXIT...");
        quit = scan.nextLine();

        if (quit.equalsIgnoreCase("quit") || quit.equalsIgnoreCase("q")) {
            IO.println("EXITING THE PROGRAM...");
            return;
        }
        choice = printMenu();

        if (choice != 1 && !hasInitFloor) {
            IO.println("FLOOR AND ROOM HAS NOT BEEN INITIALIZED YET! PLEASE CHOOSE OPTION 1 TO INIT THE BUILDING...");
            continue;
        }

        if (choice == 1 && hasInitFloor) {
            IO.println("FLOOR AND ROOM HAVE ALREADY BEEN INITIALIZED!");
            continue;
        }

        switch (choice) {
            case 1 -> {
                hasInitFloor = true;
                IO.print("""
                        ╔══════════════════════════╗
                        ║   SET UP FLOOR AND ROOM  ║
                        ╚══════════════════════════╝
                        """);
                IO.print("[+] PLEASE ENTER NUMBER OF FLOORS IN THE BUILDING : ");
                numOfFloor = scan.nextInt();
                scan.nextLine();
                building = new String[numOfFloor][];

                for (int i = 0; i < numOfFloor; i++) {
                    IO.print("PLEASE ENTER NUMBER OF ROOMS ON ");
                    IO.print((i == 0) ? ("GROUND FLOOR : ") : (i == 1) ? (i + "ST FLOOR : ") : (i == 2) ? (i + "ND FLOOR : ") : (i == 3) ? (i + "RD FLOOR : ") : (i + "TH FLOOR"));
                    numOfRoom = scan.nextInt();
                    scan.nextLine();
                    building[i] = new String[numOfRoom];
                    for (int j = 0; j < building[i].length; j++) {
                        building[i][j] = "FREE";
                    }
                }
                IO.println();
                managingActivities.append("\nINITIALIZED BUILDING AT : ").append(LocalDateTime.now().format(formatter));
            }
            case 2 -> {
                IO.print("""
                        ╔══════════════════════════╗
                        ║   ALL ROOM INFORMATION   ║
                        ╚══════════════════════════╝
                        """);
                for (int i = 0; i < building.length; i++) {
                    IO.print("FLOOR " + i + ": [ ");
                    for (int j = 0; j < building[i].length; j++) {
                        IO.print(building[i][j] + (j == building[i].length - 1 ? "" : ", "));
                    }
                    IO.print(" ]");
                    IO.println();
                }
                IO.println();
            }
            case 3 -> {
                IO.print("""
                        ╔══════════════════════════╗
                        ║     REQUESTING A ROOM    ║
                        ╚══════════════════════════╝
                        """);
                int reqFloor;
                int reqRoom;
                String questName;
                boolean hasFreeRoom = false;
                IO.print("PLEASE CHOOSE THE FLOOR [ ");
                for (int i = 0; i < building.length; i++) {
                    for (int j = 0; j < building[i].length; j++) {
                        if (building[i][j].equalsIgnoreCase("FREE")) {
                            hasFreeRoom = true;
                            break;
                        }
                    }
                    if (!hasFreeRoom) {
                        continue;
                    }
                    IO.print(i + ((i == building.length - 1) ? "" : ", "));
                }
                IO.print(" ] : ");
                reqFloor = scan.nextInt();
                scan.nextLine();

                for (int i = 0; i < building.length; i++) {
                    if (reqFloor == i) {
                        IO.print("PLEASE CHOOSE THE ROOM [ ");
                        for (int j = 0; j < building[i].length; j++) {
                            if (!(building[i][j].contains("FREE"))) {
                                continue;
                            }
                            IO.print(j + (j == building[i].length - 1 ? "" : ", "));
                        }
                        IO.print(" ] : ");
                    }
                }

                reqRoom = scan.nextInt();
                scan.nextLine();

                if (!building[reqFloor][reqRoom].equalsIgnoreCase("FREE")) {
                    IO.println("ROOM ALREADY ASSIGNED TO SOMEONE");
                    break;
                }

                IO.print("ENTER REQUESTER NAME : ");
                questName = scan.nextLine();
                building[reqFloor][reqRoom] = questName;

                managingActivities.append("\nREQUESTED ROOM ")
                        .append(reqFloor)
                        .append("-")
                        .append(reqRoom)
                        .append(" FOR ")
                        .append(questName)
                        .append(" AT : ")
                        .append(LocalDateTime.now().format(formatter));
            }
            case 4 -> {
                int floor;
                int room;
                String questName;

                IO.print("PLEASE CHOOSE THE FLOOR [ ");
                for (int i = 0; i < building.length; i++) {
                    boolean hasGuest = false;
                    for (int j = 0; j < building[i].length; j++) {
                        if (!building[i][j].equalsIgnoreCase("FREE")) {
                            hasGuest = true;
                            break;
                        }
                    }
                    if (!hasGuest) {
                        continue;
                    }
                    IO.print(i + " ");
                }
                IO.print("] : ");
                floor = scan.nextInt();
                scan.nextLine();
                IO.print("PLEASE CHOOSE THE ROOM [ ");

                for (int j = 0; j < building[floor].length; j++) {
                    if (building[floor][j].equalsIgnoreCase("FREE")) {
                        continue;
                    }
                    IO.print(j + " ");
                }

                IO.print("] : ");
                room = scan.nextInt();
                scan.nextLine();


                if (building[floor][room].equalsIgnoreCase("FREE")) {
                    IO.println("ROOM IS NOT BELONG TO SOMEONE YET");
                    break;
                }

                IO.print("UPDATE GUEST NAME : ");
                questName = scan.nextLine();

                building[floor][room] = questName;

                managingActivities.append("\nUPDATED ROOM ")
                        .append(floor)
                        .append("-")
                        .append(room)
                        .append(" TO ")
                        .append(questName)
                        .append(" AT : ")
                        .append(LocalDateTime.now().format(formatter));
            }
            case 5 -> {
                IO.print("""
                        ╔══════════════════════════╗
                        ║      DELETING A ROOM     ║
                        ╚══════════════════════════╝
                        """);
                int floor;
                int room;
                IO.print("PLEASE CHOOSE THE FLOOR [ ");
                for (int i = 0; i < building.length; i++) {
                    boolean hasGuest = false;
                    for (int j = 0; j < building[i].length; j++) {
                        if (!building[i][j].equalsIgnoreCase("FREE")) {
                            hasGuest = true;
                            break;
                        }
                    }
                    if (!hasGuest) {
                        continue;
                    }
                    IO.print(i + " ");
                }

                IO.print("] : ");
                floor = scan.nextInt();
                scan.nextLine();

                for (int i = 0; i < building.length; i++) {
                    if (floor == i) {
                        IO.print("PLEASE CHOOSE THE ROOM [ ");
                        for (int j = 0; j < building[i].length; j++) {
                            if (building[i][j].contains("FREE")) {
                                continue;
                            }
                            IO.print(j);
                        }
                        IO.print(" ] : ");
                    }
                }
                room = scan.nextInt();
                scan.nextLine();

                if (building[floor][room].equalsIgnoreCase("FREE")) {
                    IO.println("ROOM IS NOT BELONG TO SOMEONE YET");
                    break;
                }

                building[floor][room] = "FREE";

                managingActivities.append("\nDELETED ROOM ")
                        .append(floor)
                        .append("-")
                        .append(room)
                        .append(" AT : ")
                        .append(LocalDateTime.now().format(formatter));
            }

            case 6 -> IO.println(managingActivities);

            case 7 -> IO.println("EXITING THE PROGRAM...");

            default -> IO.println("PLEASE ENTER A VALID OPTION (1-7)...! ");
        }

    } while (choice != 7);
    scan.close();
}
