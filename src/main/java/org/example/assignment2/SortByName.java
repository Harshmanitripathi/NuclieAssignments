package StudentPackage;

import java.util.Comparator;

public class SortByName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getNameOfStudent() != o2.getNameOfStudent())
        return o1.getNameOfStudent().compareTo(o2.getNameOfStudent());
        return o1.getRollNoOfStudent() - o2.getRollNoOfStudent();
    }
}
