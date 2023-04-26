package StudentPackage;

import java.util.Comparator;

public class SortByAddress extends UserIO  implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAddressOfStudent().compareTo(o2.getAddressOfStudent());
    }
}
