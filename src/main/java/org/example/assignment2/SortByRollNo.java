package StudentPackage;

import java.util.Comparator;

public class SortByRollNo extends UserIO  implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getRollNoOfStudent() - o2.getRollNoOfStudent();
    }
}
