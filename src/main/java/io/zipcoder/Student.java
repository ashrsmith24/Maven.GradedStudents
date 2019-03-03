package io.zipcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;


public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;
    private Character grade;

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (examScores != null)
            this.examScores = new ArrayList<>(Arrays.asList(examScores));
        else
            this.examScores = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        String result = "Exam Scores:\n";
        int idx = 1;
        for (Double score : examScores) {
            result = result + "\t\tExam " + idx + " -> " + String.format("%2d", score.intValue()) + "\n";
            idx++;
        }
        return result;
    }

    public double getExamScore(int examNumber) {

        return examScores.get(examNumber);
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);

    }

    public void setExamScore(int examNumber, double newScore) {
        if (examNumber < examScores.size())
            examScores.set(examNumber, newScore);
    }

    double sum = 0;

    public double getAverageExamScore() {
        sum = 0;
        examScores.forEach(score -> sum += score);// find the sum of scores

        double avg = 0;
        if (examScores.size() != 0)
            avg = sum / examScores.size();
        return avg;
    }

    public String toString() {
        String result = "Student Name: " + this.firstName + " " + this.lastName + "\n";
        result += "\t> Average Score: " + String.format("%.2f", getAverageExamScore()) + "\n";
        result += "\t> ";
        if (examScores.size() > 0)
            result += getExamScores();

        return result;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName);
    }

    public void setGrade(int rank, int numberOfStudents) {
        double percentile = (100 * (rank - 0.05)) / numberOfStudents;
        if (percentile < 11.0) grade = 'F';
        else if (percentile <= 51.0) grade = 'D';
        else if (percentile <= 70.0) grade = 'C';
        else if (percentile <= 89.0) grade = 'B';
        else grade = 'A';
    }

    public Character getGrade() {
        return grade;
    }
}











//    private String firstName = "";
//    private String lastName = "";
//    private ArrayList<Double> examScores = new ArrayList<>();
//
//    public Student(String firstName, String lastName, Double[] testScores) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.examScores.addAll(Arrays.asList(testScores));
//    }
//
//    public String getFirstName() {
//        return this.firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return this.lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public int getNumberOfExamsTaken() {
//        return examScores.size();
//    }
//
//    public void getExamScores() {
//        System.out.println(examScores);
//    }
//
//    public void addExamScore(double score) {
//        this.examScores.add(score);
//
//    }
//
//    public void setExamScore(int examNumber, double newScore) {
//        this.examScores.set(examNumber - 1, newScore);
//    }
//
//    public Double getAverageExamScore() {
//        Double sumOfExamScores = 0.00;
//        for (int i = 0; i < examScores.size(); i++) {
//            sumOfExamScores += examScores.get(i);
//        }
//        return sumOfExamScores / examScores.size();
//    }
//}




