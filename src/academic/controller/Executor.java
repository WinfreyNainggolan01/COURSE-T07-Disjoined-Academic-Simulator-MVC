package academic.controller;

/**
 * @author 12S22001 Winfrey Nainggolan
 */

import academic.model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Executor {
    ArrayList<Student> listStudent = new ArrayList<Student>();
    ArrayList<Lecturer> listLecturer = new ArrayList<Lecturer>();
    ArrayList<Course> listCourse = new ArrayList<Course>();
    ArrayList<Enrollment> listEnrollment = new ArrayList<Enrollment>();
    ArrayList<CourseOpening> listCourseOpening = new ArrayList<CourseOpening>();
    
    public Executor() {

    }


// STUDENT
    public boolean isStudentExist(ArrayList<Student> listStudent, String NIM) {
        for (Student student : listStudent) {
            if (student.getId().equals(NIM))  {
                return true;
            }
        }
        return false;
    }

    public void CtrlStudent(String data[]) {
        if(!isStudentExist(listStudent, data[1])) {
            this.listStudent.add(new Student(data[1], data[2], data[3], data[4]));
        }
    }


// LECTURER
    public boolean isLecturerExist(ArrayList<Lecturer> listLecturer, String NIDN) {
        for (Lecturer lecturer : listLecturer) {
            if (lecturer.getId().equals(NIDN)) {
                return true;
            }
        }
        return false;
    }

    public void CtrlLecturer(String[] data) {
        if(!isLecturerExist(listLecturer, data[1])) {
            this.listLecturer.add(new Lecturer(data[1], data[2], data[3], data[4], data[5]));
        }
    }


// COURSE
    public void CtrlCourse(String[] data) {
        Course course = new Course(data[1], data[2], Byte.parseByte(data[3]), data[4]);
        this.listCourse.add(course);

    }

    public static void setLecCourse(String[] lec_init, ArrayList<Lecturer> listLecturer) {
        Course course = new Course();
        StringBuilder sb = new StringBuilder();
        byte count = (byte)lec_init.length;

        for (int i = 0; i < lec_init.length; i++) {
            for(Lecturer lec : listLecturer) {
                if(lec_init[i].equals(lec.getInit())) {
                    sb.append(lec.getInit()+" ("+lec.getEmail()+")");
                    if(count > 1) {
                        sb.append(";");
                        count--;
                    }
                }
            }
        }
        course.setLecCourse(sb.toString());
    }


// ENROLLMENT
    public void CtrlEnrollment(String[] data) {
        Course course = new Course();
        Student student = new Student();

        for(Course crs : this.listCourse) {
            if(crs.getId().equals(data[1])) {
                course = crs;
            }
        }
        for(Student std : this.listStudent) {
            if(std.getId().equals(data[2])) {
                student = std;
            }
        }

        Enrollment enrollment = new Enrollment(course, student, data[3], data[4]);
        enrollment.setGradeStd(enrollment.getGradeStd());
        listEnrollment.add(enrollment);
    }

    public void printListEnroll(ArrayList<Enrollment> listEnrollment) {
        for (Enrollment enrollment : listEnrollment) {
            if(enrollment.getRemedial() != null) {
                System.out.println(enrollment.toStringDetail());
            }else {
                System.out.println(enrollment);
            }
        }
    }

    public void printDetailStd(ArrayList<Student> listStudent, boolean empty, String[] data, double result, int sumSks) {
        for (int i = 0; i < listStudent.size(); i++) {
            if(data[1].equals(listStudent.get(i).getId())) {
                if(!empty) {
                    listStudent.get(i).setGpa(result);
                    listStudent.get(i).setSks(sumSks);
                    System.out.println(listStudent.get(i).toStringDetail()); 
                }else {
                    System.out.println(listStudent.get(i).toStringDetail()); 
                }
            }
        }
    }


// ENROLLMENT GRADE
    public void CtrlEnrollmentG(String[] data) {
        for(Enrollment enr : this.listEnrollment) {
            if(data[1].equals(enr.getCrsId()) && data[2].equals(enr.getStdId()) && enr.getYear().equals(data[3]) && enr.getTerm().equals(data[4])) {
                enr.setGradeStd(data[5]);
                break;
            }
        }
    }
    

// STUDENT DETAILS
    public void CtrlStudentD(String[] data) {
        double sumGrade = 0, result = 0, mulGpa = 0, tempGrade = 0;
        int sumSks = 0;
        boolean empty = false;
        byte count = 0;
        String tempIdEnroll = "";

        for(Enrollment enr : listEnrollment) {
            if(enr.getStdId().equals(data[1])) {
                if(enr.getGradeStd().equals("None")) {
                    if(count == 0)
                        empty = true;
                    break;
                }else {
                    if(enr.getRemedial() != null) {
                        sumGrade = EnumGrade.getScale(enr.getRemedial());
                    }else {
                        sumGrade = EnumGrade.getScale(enr.getGradeStd());
                    }

                    for(Course crs : listCourse) {
                        if(enr.getCrsId().equals(crs.getId())) {
                            if(enr.getCrsId().equals(tempIdEnroll)) {
                                sumSks -= crs.getCredit();
                                mulGpa -= (crs.getCredit() * tempGrade);
                            }
                            sumSks += crs.getCredit();
                            mulGpa += (crs.getCredit() * sumGrade);
                            tempIdEnroll = enr.getCrsId();
                            tempGrade = sumGrade;
                            break;
                        }
                    }
                }
            }
            count = 1;
        }
            try {
                if(sumSks == 0) {
                    result = 0;
                }else {
                    result = (mulGpa/sumSks);
                }
            }catch(Exception e) {
                result = 0;
                System.out.println("Hasil Infinite/ Tak hingga");
            }
        printDetailStd(listStudent, empty, data, result, sumSks);
    }


// ENROLLMENT REMEDIAL
    public void CtrlEnrollmentR(String[] data) { 
        for(Enrollment enr : listEnrollment) {
            if(enr.getCrsId().equals(data[1]) && enr.getStdId().equals(data[2]) && enr.getYear().equals(data[3]) && enr.getGradeStd() != "None" && enr.getTerm().equals(data[4])) {
                if(enr.getCount() < 1) {
                    enr.setRemedial(data[5]);
                    enr.setCount();
                    break;
                }
            }
        }
    }


// COURSE OPENING
    public void CtrlCourseO(String[] data) {
        CourseOpening courseOpening = new CourseOpening(data[1], data[2], data[3], data[4]); 
        listCourseOpening.add(courseOpening);
    }


// COURSE HISTORY
    public void CtrlCourseH(String[] data) {
        Collections.sort(listCourseOpening, Comparator.comparing(CourseOpening::getSemOpen).reversed());
        for (CourseOpening crsOp : listCourseOpening) {
                for(Course crs : listCourse) {
                    if(crs.getId().equals(data[1])) {
                        crsOp.setName(crs.getName());
                        crsOp.setCredit(crs.getCredit());
                        crsOp.setGrade(crs.getGrade());
                            for(Lecturer lec : listLecturer) {
                                if(crsOp.getLecOpen().equals(lec.getInit())) {
                                    crsOp.setLecEmail(lec.getEmail());
                                    break;
                                }
                            }

                        break;
                    }
            }
            System.out.println(crsOp);

            for(Enrollment enr : listEnrollment) {
                if(enr.getCrsId().equals(crsOp.getId()) && enr.getYear().equals(crsOp.getYearOpen()) && enr.getTerm().equals(crsOp.getSemOpen())) {
                    if(enr.getRemedial() != null) {
                        System.out.println(enr.toStringDetail());
                    }else {
                        System.out.println(enr);
                    }
                }
            }
        }
        
    }


// PRINT DATA IN ELEMENT
    public void printElement() {
        Generic.printList(this.listLecturer);
        Generic.printList(this.listCourse);
        Generic.printList(this.listStudent);
        printListEnroll(this.listEnrollment);
    }
}
