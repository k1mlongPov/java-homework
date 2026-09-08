public class Student {
    private int id;
    String name;
    String gender;
    String course;
    double score;
    static String format = "%-12S %-22S %-14S %-14S %-13S%n";

    public Student(int id, String name, String gender, String course, double score) {
        this.id = id;
        this(name, gender, course, score);
    }

    public Student(String name, String gender, String course, double score) {
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.score = score;
    }

    public static void displayHeader() {
        System.out.printf(format, "ID", "FULL NAME", "GENDER", "COURSE", "SCORE");
    }

    @Override
    public String toString() {
        return String.format(format, String.format("ISTAD%03d", id), name, gender, course, String.format("%.2f", score));
    }
}


