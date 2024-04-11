package academic.model;

/**
 * @author 12S22001 Winfrey Nainggolan
 */

public class Enrollment {
    private Course course;
    private Student student;
    private String yearAcademic;
    private String term;
    private String gradeStd;
    private String remedial;
    private byte countEnrollRemedial;

    public Enrollment(Course course, Student student, String year_enroll, String term) {
        this.course = course;
        this.student = student;
        this.yearAcademic = year_enroll;
        this.term = term;
        this.gradeStd = null;
        this.remedial = null;
        this.countEnrollRemedial = 0;
    }

    public Enrollment(){

    }

// ACCESSOR
    public String getGradeStd() {
        return this.gradeStd;
    }

    public String getTerm() {
        return this.term;
    }

    public String getCrsId() {
        return this.course.getId();
    }

    public String getStdId(){
        return this.student.getId();
    }

    public String getYear(){
        return this.yearAcademic;
    }

    public String getRemedial(){
        return this.remedial;
    }

    public int getCount(){
        return this.countEnrollRemedial;
    }

// MUTATOR
    public void setGradeStd(String gradeStd){
        switch (gradeStd){
            case null:
                this.gradeStd = "None";
                break;
            default:
                this.gradeStd = gradeStd;
                break;
        }
    }

    public void setRemedial(String _remedial){
        this.remedial = _remedial;
    }

    public void setCount(){
        this.countEnrollRemedial += 1;
    }

    @Override
    public String toString() {
        return this.course.getId() + "|" + this.student.getId() + "|" + this.yearAcademic + "|" + this.term + "|" + this.gradeStd;
    }

    public String toStringDetail(){
        return this.course.getId() + "|" + this.student.getId() + "|" + this.yearAcademic + "|" + this.term + "|" + this.remedial + "(" + this.gradeStd + ")";
    }
    
}
