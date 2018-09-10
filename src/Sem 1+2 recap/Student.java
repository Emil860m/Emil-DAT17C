import java.util.ArrayList;

public class Student extends Person {
    protected int studentNo;
    protected double gradeAverage;
    private static int studentCount;
    public ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name, String cpr, int studentNo) {
        super(name, cpr);
        this.studentNo = studentNo;
        studentCount++;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public static void setStudentCount(int studentCount) {
        Student.studentCount = studentCount;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public double getGradeAverage() {
        for (int i:grades) {
            gradeAverage+=i;
        }
        gradeAverage = gradeAverage/grades.size();
        return gradeAverage;
    }

    public void setGradeAverage(int gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    @Override
    public String toString() {
        return "Student: " + name + ", " + cpr + ", " + studentNo;
    }


    public static String equals(Student S, Student S1){
        if(S.getStudentNo() == S1.getStudentNo()) {
            return "Yes";
        }
        else{
            return "No";
        }
    }

}
