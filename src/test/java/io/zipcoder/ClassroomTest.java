package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ClassroomTest {

    Student[] studentArray;

    @Before
    public void setup() {
        studentArray = new Student[5];
        studentArray[0] = new Student("Ashley", "Smith", new Double[]{12.0, 33.0, 55.0});
        studentArray[1] = new Student("Ajah", "D", new Double[]{19.0, 20.0, 45.0});
        studentArray[2] = new Student("Kyle", "J", new Double[]{32.0, 30.0, 45.0});
        studentArray[3] = new Student("Brian", "Smith", new Double[]{33.0, 30.0, 39.0});
        studentArray[4] = new Student("Kevin", "S", new Double[]{25.0, 40.0, 55.0});
    }

    @Test
    public void NullaryConstructorTest() {
        Classroom classroom = new Classroom();
        Student[] retrievedStudents = classroom.getStudents();
        Assert.assertNull(retrievedStudents[0]);
    }

    @Test
    public void ConstructorWithMaxNumberOfStudentsTest() {
        Classroom classroom = new Classroom(25);
        Student[] retrievedStudents = classroom.getStudents();
        Assert.assertEquals(retrievedStudents.length, 25);

    }

    @Test
    public void ConstructorWithStudentsArrayTest() {
        Classroom classroom = new Classroom(studentArray);
        Student[] retrievedStudents = classroom.getStudents();
        Assert.assertEquals(retrievedStudents[0], studentArray[0]);
        Assert.assertEquals(retrievedStudents.length, 5);

    }

    @Test
    public void ConstructorWithStudentsArrayNullTest() {
        Classroom classroom = new Classroom(null);
        Student[] retrievedStudents = classroom.getStudents();
        Assert.assertNull(retrievedStudents[0]);
    }

    @Test
    public void getStudentsTest() {
        Classroom classroom = new Classroom(studentArray);
        Student[] retrievedStudents = classroom.getStudents();
        Assert.assertEquals(retrievedStudents[0], studentArray[0]);
        Assert.assertEquals(retrievedStudents.length, 5);
    }

    @Test
    public void getAverageExamScoreTest() {
        Classroom classroom = new Classroom(studentArray);
        double retrievedavgScore = classroom.getAverageExamScore();
        Assert.assertEquals(34.2, retrievedavgScore, 0.1);
    }

    @Test
    public void getAverageExamScoreNullTest() {
        Classroom classroom = new Classroom(null);
        double retrievedavgScore = classroom.getAverageExamScore();
        Assert.assertEquals(0, retrievedavgScore, 0.1);
    }

    @Test
    public void addStudentTest() {
        Classroom classroom = new Classroom();
        Student student = new Student("Ashley", "Smith",
                new Double[]{10.0, 23.0, 21.0});
        classroom.addStudent(student);

        Student[] retrievedStudents = classroom.getStudents();
        Assert.assertEquals(retrievedStudents[0], student);
    }

    @Test
    public void addStudentNullTest() {
        Classroom classroom = new Classroom();
        classroom.addStudent(null);
        Student[] retrievedStudents = classroom.getStudents();
        Assert.assertNull(retrievedStudents[0]);
    }

    @Test
    public void removeStudentTest() {
        Classroom classroom = new Classroom(studentArray);
        classroom.removeStudent(studentArray[0].getFirstName(), studentArray[0].getLastName());
        Student[] retrievedStudents = classroom.getStudents();
        Assert.assertEquals(retrievedStudents[0], studentArray[1]);
    }

    @Test
    public void removeStudentNotPresentTest() {
        Classroom classroom = new Classroom(studentArray);
        classroom.removeStudent("notAStudent", "lastName");
        Student[] retrievedStudents = classroom.getStudents();
        Assert.assertEquals(retrievedStudents[0], studentArray[0]);
    }

    @Test
    public void removeStudentNullTest() {
        Classroom classroom = new Classroom(studentArray);
        classroom.removeStudent(null, null);
        Student[] retrievedStudents = classroom.getStudents();
        Assert.assertEquals(retrievedStudents[0], studentArray[0]);
    }

    @Test
    public void getStudentsByScoreTest() {
        Classroom classroom = new Classroom(studentArray);
        Student[] expectedArray = {studentArray[1], studentArray[0], studentArray[3], studentArray[2], studentArray[4]};
        Student[] retrievedStudents = classroom.getStudentsByScore();
        Assert.assertArrayEquals(retrievedStudents, expectedArray);
    }

    @Test
    public void getStudentsByScoreNullTest() {
        Classroom classroom = new Classroom(null);
        Student[] retrievedStudents = classroom.getStudentsByScore();
        Assert.assertEquals(retrievedStudents[0], null);
    }

    @Test
    public void getGradeBookTest() {
        Classroom classroom = new Classroom(studentArray);
        Map<Character, Collection<Student>> retrievedMap = classroom.getGradeBook();
        Set<Student> setA = (Set<Student>) retrievedMap.get('A');
        Set<Student> setB = (Set<Student>) retrievedMap.get('B');
        Set<Student> setC = (Set<Student>) retrievedMap.get('C');
        Set<Student> setD = (Set<Student>) retrievedMap.get('D');
        Set<Student> setF = (Set<Student>) retrievedMap.get('F');

        Assert.assertEquals(setA.size(), 1);
        Assert.assertEquals(setB.size(), 1);
        Assert.assertEquals(setC.size(), 1);
        Assert.assertEquals(setD.size(), 2);
        Assert.assertNull(setF);
    }
}




