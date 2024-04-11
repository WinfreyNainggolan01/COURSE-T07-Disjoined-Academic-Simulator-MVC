package academic.model;

/**
 * @author 12S22001 Winfrey Nainggolan
 */

public class CourseOpening extends Course{
    private String yearOpen;
    private String semOpen;
    private String lecOpen;
    private String lecEmail;

    public CourseOpening(String id, String yearOpen, String semOpen, String lecOpen) {
        super.id = id;
        this.yearOpen = yearOpen;
        this.semOpen = semOpen;
        this.lecOpen = lecOpen;
        this.lecEmail = "";
    }

    public CourseOpening(){

    }

// ACCESSOR
    public String getLecOpen(){
        return this.lecOpen;
    }

    public String getYearOpen(){
        return this.yearOpen;
    }

    public String getSemOpen(){
        return this.semOpen;
    }

// MUTATOR
    public void setLecOpen(String lecOpen){
        this.lecOpen = lecOpen;
    }

    public void setLecEmail(String lecEmail){
        this.lecEmail = lecEmail;
    }

    @Override
    public String toString(){
        return super.toString() + "|" + this.yearOpen + "|" + this.semOpen + "|" + this.lecOpen + " (" + this.lecEmail + ")";
    }
}