package rough;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElements {


    public static void main(String[] args) {

        String names[] = {"Java", "Javascript", "Javascript", "Ruby", "C", "Cobol", "Python", "C"};

      /*  //1. Compare each element - worst solution by the way
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].equals(names[j])) {
                    System.out.println("Duplicate element is:" + names[j]);
                }
            }
        }*/

        //2.Using HashSet : JavaCollection: it stores unique values.

        Set<String> store = new HashSet<String>();
        for (String name : names) {
            if (!store.add(name)) {
                System.out.println("duplicate element is:" + name);
            }
        }

        //3. using HashMap : JavaCollection ; It stores duplicates as well.


    }
}
