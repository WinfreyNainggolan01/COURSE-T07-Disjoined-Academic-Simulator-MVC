package academic.view;

import academic.controller.*;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Executor ExeElement = new Executor();
        while (sc.hasNext()){
            String input = sc.nextLine();
            if(input.equals("---")){
                break;
            }else{
                String data[] = input.split("#");
                switch (data[0]){
                    case "lecturer-add":
                        ExeElement.CtrlLecturer(data);
                        break;
                    case "student-add":
                        ExeElement.CtrlStudent(data);
                        break;
                    case "course-add":
                        ExeElement.CtrlCourse(data);
                        break;
                    case "enrollment-add":
                        ExeElement.CtrlEnrollment(data);
                        break;
                    case "enrollment-grade":
                        ExeElement.CtrlEnrollmentG(data);
                        break;
                    case "student-details":
                        ExeElement.CtrlStudentD(data);
                        break;
                    case "enrollment-remedial":
                        ExeElement.CtrlEnrollmentR(data);
                        break;
                    case "course-open":
                        ExeElement.CtrlCourseO(data);
                        break; 
                    case "course-history":
                        ExeElement.CtrlCourseH(data);
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
        }
        sc.close();
        ExeElement.printElement();
    }
}
