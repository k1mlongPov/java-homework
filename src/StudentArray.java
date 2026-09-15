int printMenu () {
    System.out.println();
    Scanner scan = new Scanner(System.in);
    System.out.println("""
                ===> Options Menu
                1. Add more student
                2. Display Students Information
                3. Update Student
                4. Delete Student
                5. Exit Program
                """);
    System.out.print("Please choose one option: ");
    int op = scan.nextInt(); scan.nextLine();
    System.out.println();
    return op;
}

void main() {
    Scanner scan = new Scanner(System.in);

    Student[] students = new Student[100];

    System.out.print("Enter number of students: ");
    int size = scan.nextInt();
    scan.nextLine();

    if (size <= 0 || size > 100) {
        System.out.println("Invalid size!");
        return;
    }
    int i = 0;

    while (i < size) {

        System.out.println("\n===== Student " + (i + 1) + " =====");

        System.out.print("Enter Name: ");
        String name = scan.nextLine();

        System.out.print("Enter Gender: ");
        String gender = scan.nextLine();

        System.out.print("Enter Course: ");
        String course = scan.nextLine();

        System.out.print("Enter Score: ");
        double score = scan.nextDouble();
        scan.nextLine();

        students[i] = new Student(
                i + 1,
                name,
                gender,
                course,
                score
        );

        i++;
    }

    int option;
    do {
        option = printMenu();
        switch (option) {
            case 1 -> {
                if (size == 100) {
                    System.out.println("Array is full!");
                    continue;
                }
                System.out.print("How many students do you want to add? ");
                int add = scan.nextInt();
                scan.nextLine();
                if (size + add > 100) {
                    System.out.println("Cannot add " + add + " students. Only " + (100 - size) + " spaces available.");
                    continue;
                }
                int x = 0;

                while (x < add) {
                    System.out.println("\n===== Student " + (size + 1) + " =====");

                    System.out.print("Enter Name: ");
                    String name = scan.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = scan.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scan.nextLine();

                    System.out.print("Enter Score: ");
                    double score = scan.nextDouble();
                    scan.nextLine();

                    students[size] = new Student(
                            size + 1,
                            name,
                            gender,
                            course,
                            score
                    );

                    size++;
                    x++;
                }
                System.out.println(add + " student(s) added successfully!"
                );
            }
            case 2 -> {
                System.out.println("\n===== STUDENTS =====");
                Student.displayHeader();
                i = 0;
                while (i < size) {

                    if (students[i] != null) {
                        System.out.print(students[i]);
                    }

                    i++;
                }
            }
            case 3 -> {
                System.out.print("Enter Student ID: ");
                int updateId = scan.nextInt();
                scan.nextLine();
                boolean found = false;
                i = 0;
                while (i < size) {
                    if (students[i] != null && students[i].id == updateId) {

                        System.out.println("\n===== Update Student =====");

                        System.out.print("Enter New Name: ");
                        String name = scan.nextLine();

                        System.out.print("Enter New Gender: ");
                        String gender = scan.nextLine();

                        System.out.print("Enter New Course: ");
                        String course = scan.nextLine();

                        System.out.print("Enter New Score: ");
                        double score = scan.nextDouble();
                        scan.nextLine();

                        students[i] = new Student(
                                updateId,
                                name,
                                gender,
                                course,
                                score
                        );

                        found = true;

                        System.out.println("Student updated successfully!");
                        break;
                    }
                    i++;
                }
                if (!found) {
                    System.out.println("Student ID not found!");
                }
            }

            case 4 -> {
                System.out.print("Enter Student ID: ");
                int deleteId = scan.nextInt();
                scan.nextLine();
                boolean found = false;
                i = 0;
                while (i < size) {
                    if (students[i] != null && students[i].id == deleteId) {
                        int j = i;
                        while (j < size - 1) {
                            students[j] = students[j + 1];
                            j++;
                        }
                        students[size - 1] = null;
                        size--;
                        found = true;
                        System.out.println("Student deleted successfully!");
                    }
                    i++;
                }

                if (!found) {
                    System.out.println("Student ID not found!");
                }
            }
            case 5 -> System.out.println("Program exited.");

            default-> System.out.println("Invalid option!");
        }

    } while (option != 5);
    scan.close();
}