package academic.model;

/**
 * @author 12S22001 Winfrey Nainggolan
 */

public class Course extends Identifier{
    public byte credit;
    public String grade;
    public String lecCourse;

    public Course(String id, String name, byte credit, String grade) {
        super.id = id;
        super.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public Course(){
        
    }

// ACCESSOR
    public byte getCredit() {
        return this.credit;
    }

    public String getGrade() {
        return this.grade;
    }

// MUTATOR
    public void setLecCourse(String lecCourse){
        this.lecCourse = lecCourse;
    }

    public void setCredit(byte credit){
        this.credit = credit;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString()+ "|" + this.credit + "|" + this.grade;
    }
}
