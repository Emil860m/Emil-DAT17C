import java.util.ArrayList;

public class Teacher extends Person {
    private String title;
    private ArrayList<String> courseList;
    private static int teacherCount = 0;

    public Teacher(String name, String cpr, String title) {
        super(name, cpr);
        this.title = title;
        teacherCount++;
    }

    public static int getTeacherCount() {
        return teacherCount;
    }

    public static void setTeacherCount(int teacherCount) {
        Teacher.teacherCount = teacherCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<String> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Teacher: " + name + ", " + title + ", " + cpr;
    }
}

