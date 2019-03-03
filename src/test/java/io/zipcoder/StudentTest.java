package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    private Student givenStudent;
    private Student givenNullStudent;
    private String givenFirstName = "Ashley";
    private String givenLastName = "Smith";
    private Double[] givenScores = {10.9, 72.2, 39.5};

    @Before
    public void setup(){
        givenStudent = new Student(givenFirstName, givenLastName, givenScores);
        givenNullStudent = new Student(null, null, null);
    }
    @Test
    public void ConstructorTest(){
        givenStudent = new Student(givenFirstName, givenLastName, givenScores);
        Assert.assertEquals(givenStudent.getFirstName() , givenFirstName);
        Assert.assertEquals(givenStudent.getLastName() , givenLastName);
        Assert.assertEquals(givenStudent.getNumberOfExamsTaken() , 3);

    }

    @Test
    public void getFirstNameTest() {

        String retrievedName = givenStudent.getFirstName();
        Assert.assertEquals(retrievedName, givenFirstName);
    }

    @Test
    public void getNullFirstNameTest() {
        String retrievedName = givenNullStudent.getFirstName();
        Assert.assertNull(retrievedName);

    }

    @Test
    public void setFirstNameTest(){

        givenStudent.setFirstName("newName");
        Assert.assertEquals(givenStudent.getFirstName(), "newName");

    }

    @Test
    public void getLastNameTest(){
        String retrievedName = givenStudent.getLastName();
        Assert.assertEquals(retrievedName, givenLastName);

    }

    @Test
    public void setLastNameTest(){
        givenStudent.setLastName("newName");
        Assert.assertEquals(givenStudent.getLastName(), "newName");

    }

    @Test
    public void getNumberOfExamsTakenTest(){
        givenStudent.addExamScore(19.5);
        givenStudent.addExamScore(20.5);
        Assert.assertEquals(givenStudent.getNumberOfExamsTaken() , 5);

    }

    @Test
    public void getExamScoresTest(){
        String received = givenStudent.getExamScores();

        String expected = "Exam Scores:\n"+
                "\t\tExam 1 -> 10\n"+
                "\t\tExam 2 -> 72\n"+
                "\t\tExam 3 -> 39\n";

        Assert.assertEquals(received, expected);
    }

    @Test
    public void getExamScoresWhenListEmptyTest(){
        String received = givenNullStudent.getExamScores();

        String expected = "Exam Scores:\n";


        Assert.assertEquals(received, expected);
    }


    @Test
    public void addExamScoreTest(){
        givenStudent.addExamScore(19.5);
        givenStudent.getExamScores();
        Assert.assertEquals(givenStudent.getNumberOfExamsTaken() , 4);

    }

    @Test
    public void setExamScoreTest(){
        givenStudent.setExamScore(2, 122.0);
        double retrieved = givenStudent.getExamScore(2);
        Assert.assertEquals(retrieved , 122.0, 0.01);

    }

    @Test
    public void setExamScoreWhoseValueNotPresentTest(){
        givenStudent.setExamScore(5, 122.0);

    }

    @Test
    public void getAverageExamScoreTest() {
        double calculatedAvg = givenStudent.getAverageExamScore();
        Assert.assertEquals(calculatedAvg , 40.86, 0.01);

    }

    @Test
    public void getAverageExamScoreWhenListEmptyTest() {
        double calculatedAvg = givenNullStudent.getAverageExamScore();
        Assert.assertEquals(calculatedAvg , 0, 0.01);

    }

    @Test
    public void toStringTest(){
        String received = givenStudent.toString();

        String expected = "Student Name: Ashley Smith\n"+
                "\t> Average Score: 40.87\n"+
                "\t> Exam Scores:\n"+
                "\t\tExam 1 -> 10\n"+
                "\t\tExam 2 -> 72\n"+
                "\t\tExam 3 -> 39\n";

        Assert.assertEquals(received, expected);

    }


}