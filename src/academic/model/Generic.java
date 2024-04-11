package academic.model;

/**
 * @author 12S22001 Winfrey Nainggolan
 */

import java.util.ArrayList;

public class Generic{
    public static <E> void printList(ArrayList<E> elements) {
        for (E element : elements) {
            System.out.println(element);
        }
    }
}
