package academic.model;

/**
 * @author 12S22001 Winfrey Nainggolan
 */

public class Lecturer extends Identifier{
    private String initial;
    private String email;
    private String studyProgram;

    public Lecturer(String id, String name, String initial, String email, String studyProgram) {
        super.id = id;
        super.name = name;
        this.initial = initial;
        this.email = email;
        this.studyProgram = studyProgram;
    }

    public Lecturer(){

    }

    // ACCESSOR
    public String getEmail(){
        return this.email;
    }

    public String getInit(){
        return this.initial;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + this.initial + "|" + this.email + "|" + this.studyProgram;
    }
}
