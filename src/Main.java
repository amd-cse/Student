import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    ArrayList<studentObj> students = new ArrayList<>();
    int optionSelected = showPrompt();
    executeOption(optionSelected, students);
    }


    public static int showPrompt(){
        Object[] options = {"Add A Student", "Search by Name", "Search by Roll", "Result Update", "Delete Student Record", "Exit"};
       return JOptionPane.showOptionDialog(null,"Choose an Option: ", "Student Panel", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    public static void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    public static void displayStudent(studentObj student){
        JOptionPane.showMessageDialog(null, "Name: " + student.name + "\n Roll: " + student.roll + "\n Age: " + student.age);
    }
    public static String takeWhat(String what){
        return JOptionPane.showInputDialog("Enter " + what + ": ");
    }
    public static void executeOption(int optionSelected, ArrayList<studentObj> students){
        switch(optionSelected) {
            case 0:
                // Should Call Add Student Option
                students.add(studentObj.takeStudentInput());
                executeOption(showPrompt(), students);
                break;
            case 1:
                // Should Call Search
                studentObj temp= studentObj.findStudent(takeWhat("Name"), students);
                if(temp != null){
                    displayStudent(temp);
                }
                else {
                    showMessage("Student not found");
                }
                executeOption(showPrompt(), students);
                break;
            case 2:
                // Should Search By Roll
                temp = studentObj.findByRoll(Integer.parseInt(takeWhat("Roll")), students);
                if(temp != null){
                    displayStudent(temp);
                }
                else {
                    showMessage("Student not found");
                }
                executeOption(showPrompt(), students);
                break;
            case 3:
                // Should Update Result
                temp = studentObj.findByRoll(Integer.parseInt(takeWhat("Roll")), students);
                if(temp != null){
                    // update info
                    displayStudent(temp);
                    int roll = temp.roll;
                    temp = studentObj.updateInfo(temp);
                    students.add(roll - 1, temp);
                    displayStudent(temp);
                }
                else {
                    showMessage("Student not found");
                }

                executeOption(showPrompt(), students);
                break;
            case 4:
                temp = studentObj.findByRoll(Integer.parseInt(takeWhat("Roll")), students);
                if(temp != null){
                    students.remove(temp);
                }
                else{
                showMessage("Student not found");
                }
                executeOption(showPrompt(), students);
                break;
            case 5:
                break;
            default:
                showMessage("Invalid option");
                showPrompt();
        }
    }
}