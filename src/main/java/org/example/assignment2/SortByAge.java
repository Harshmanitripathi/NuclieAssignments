package StudentPackage;

import java.util.Comparator;

public class SortByAge extends UserIO  implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAgeOfStudent() - o2.getAgeOfStudent();
    }
}
