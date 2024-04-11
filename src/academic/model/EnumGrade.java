package academic.model;

/**
 * @author 12S22001 Winfrey Nainggolan
 */

public enum EnumGrade {
    A("A",4.0),   AB("AB"   ,3.5),
    B("B",3.0),   BC("BC"   ,2.5), 
    C("C",2.0),   D ("D"    ,1.0), 
    E("E",0.0),   T ("None" , 0.0);

    private final double value;
    private final String letter;

    private EnumGrade(String letter, double value) {
        this.value = value;
        this.letter = letter;
    }

// ACCESSOR
    public double getValue() {
        return value;
    }

    public String getLetter() {
        return letter;
    }

    public static double getScale(String letter) {
        for (EnumGrade elem: EnumGrade.values()) {
            if (elem.getLetter().equals(letter)) {
                return elem.getValue();
            }
        }
        return -1;
    }

}
