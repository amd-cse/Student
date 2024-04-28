import javax.swing.*;
import java.util.ArrayList;

public class studentObj {
    String name;
    int age;
    int roll;
    float grade;
    static int lastRoll = 1;

    public studentObj() {
        this.roll = -1;
        this.age = -1;
        this.name = "DEFAULT_NAME";
        this.grade = -1;
        lastRoll++;
    }

    public studentObj(String name, int age, int roll, float grade){
        this.roll = lastRoll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        lastRoll++;
    }
    public static studentObj updateInfo(studentObj student){
        JCheckBox name = new JCheckBox("Name");
        JCheckBox age = new JCheckBox("Age");
        JCheckBox grade = new JCheckBox("Grade");

        Object[] toSend = {"Select Option to Update: ", name, age, grade};
        int proceed = JOptionPane.showConfirmDialog(null, toSend, "Select Items", JOptionPane.OK_CANCEL_OPTION);
        if(proceed == JOptionPane.OK_OPTION){
            if(name.isSelected()){
                student.name = takeInput("Name");
            }
            if(age.isSelected()){
                student.age = Integer.parseInt(takeInput("Age"));
            }
            if(grade.isSelected()){
                student.grade = Float.parseFloat(takeInput("Grade"));
            }
        }
        else {
            return student;
        }
        return student;
    }
    public static studentObj takeStudentInput(){
        String name = JOptionPane.showInputDialog("Enter Name");
        String age = JOptionPane.showInputDialog("Enter Age");
        String grade = JOptionPane.showInputDialog("Enter Grade");
        return new studentObj(name, Integer.parseInt(age), lastRoll, Float.parseFloat(grade));
    }
    public static String takeInput(String what){
        return JOptionPane.showInputDialog("Enter "+ what+": ");
    }
    public static studentObj findStudent(String name, ArrayList<studentObj> students) {

        for(studentObj student : students){
            if(student.name.equals(name)){
                return student;
            }
        }
        return null;
    }
    public static studentObj findByRoll(int roll, ArrayList<studentObj> students) {
        for(studentObj student : students){
            if(student.roll == roll)
            {
                return student;
            }
        }
        return null;
    }


}
