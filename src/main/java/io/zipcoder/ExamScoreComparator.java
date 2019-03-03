package io.zipcoder;

import java.util.Comparator;

public class ExamScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1 == null)
            return -1;
        if (o2 == null)
            return 1;

        int scoreDiff = (int) (o1.getAverageExamScore() - o2.getAverageExamScore());
        if (scoreDiff == 0)
            return o1.getFirstName().compareTo(o2.getFirstName());
        return scoreDiff;
    }
}