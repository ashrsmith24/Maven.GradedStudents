package io.zipcoder;

import java.util.*;

public class Classroom {

    private List<Student> studentList;
    private int maxNumberOfStudents;
    private int numberOfStudents;
    public Classroom() {
        this(30);
    }

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        studentList = new ArrayList<Student>(Arrays.asList(new Student[maxNumberOfStudents]));
    }

    public Classroom(Student[] studentArray) {
        this();
        if(studentArray != null) {
            this.studentList = new ArrayList<Student>(Arrays.asList(studentArray));
            maxNumberOfStudents = studentList.size();
            numberOfStudents = studentList.size();
        }

    }

    public Student[] getStudents(){
        return studentList.toArray(new Student[studentList.size()]);
    }

    double sum = 0;
    public double getAverageExamScore(){
        studentList.forEach(student -> sum += student!= null ? student.getAverageExamScore() : 0);
        return sum / maxNumberOfStudents;
    }

    public void addStudent(Student student){
        if(student != null && numberOfStudents < maxNumberOfStudents) {
            studentList.set(numberOfStudents, student);
            numberOfStudents++;
        }
    }

    public void removeStudent(String firstName, String lastName){
        Student studentToBeRemoved = new Student(firstName, lastName, null);
        if(studentList.contains(studentToBeRemoved)){
            studentList.remove(studentToBeRemoved);
        }
    }

    public Student[] getStudentsByScore(){
        ArrayList<Student> tempList = new ArrayList<>(studentList);
        Collections.sort(tempList, new ExamScoreComparator());
        return tempList.toArray(new Student[tempList.size()]);
    }

    public Map<Character, Collection<Student>> getGradeBook(){
        ArrayList<Student> tempList = new ArrayList<>(studentList);
        Map gradeMap = new HashMap<Character, Collection<Student>>();

        Collections.sort(tempList, new ExamScoreComparator());
        for(int i = 0; i < tempList.size(); i++){
            Student student = tempList.get(i);
            if(student != null) {
                student.setGrade(i + 1, tempList.size());
                putStudentToMap(gradeMap, student);
            }
        }

        return gradeMap;
    }
    private void putStudentToMap(Map<Character, Collection<Student>> map, Student student){
        if(map.containsKey(student.getGrade())){
            map.get(student.getGrade()).add(student);
        }else{
            Set<Student> set = new HashSet<Student>();
            set.add(student);
            map.put(student.getGrade(), set);
        }
    }




    //    private Student[] students;
//
//
//    public Classroom(int maxStudents) {
//        this.students = new Student[maxStudents];
//    }
//
//    public Classroom(Student[] students) {
//        this.students = students;
//    }
//
//    public Classroom() {
//        this.students = new Student[30];
//    }
//
//    public Student[] getStudents() {
//        return students;
//    }
//
//    public Double getAverageExamScore() {
//        Double sum = 0.0;
//        for (Student s : students) {
//            sum += s.getAverageExamScore();
//        }
//        return sum / students.length;
//    }
//
//    public void addStudent(Student student) {
//        Student[] newStudents = new Student[students.length + 1];
//        int index = 0;
//        for (Student s : students) {
//            newStudents[index] = s;
//            index++;
//        }
//        newStudents[index] = student;
//        this.students = newStudents;
//    }
//
//    public void removeStudent(String firstName, String lastName) {
//        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
//        Student studentToRemove = null;
//        for (Student s : studentList) {
//            if ((s.getLastName().equals(lastName)) && (s.getFirstName().equals(firstName))) {
//                studentToRemove = s;
//            }
//        }
//        if (studentToRemove != null) {
//            studentList.remove(studentToRemove);
//            studentList.add(null);
//        }
//        students = studentList.toArray(students);
//    }
//
//
//    public Student[] getStudentsByScore() {
//        Arrays.sort(students);
//        return students;
//    }
//
//
//    public Map<Student, String> getGradebook() {
//        Map<Student, String> gradebook = new TreeMap<>();
//        Student[] sortedGrades = getStudentsByScore();
//        Double percentile;
//        Double classSize = new Double(sortedGrades.length);
//        for (int i = 0; i < sortedGrades.length; i++) {
//            percentile = (((classSize - i) / classSize) * 100.0);
//            if (percentile >= 90) {
//                gradebook.put(sortedGrades[i], "A");
//            } else if (percentile >= 71) {
//                gradebook.put(sortedGrades[i], "B");
//            } else if (percentile >= 50) {
//                gradebook.put(sortedGrades[i], "C");
//            } else if (percentile >= 11) {
//                gradebook.put(sortedGrades[i], "D");
//            } else {
//                gradebook.put(sortedGrades[i], "F");
//            }
//        }
//        return gradebook;
//    }

}

//
//    public Classroom(int maxNumberOfStudents) {
//        this.students = new Student[maxNumberOfStudents];
//    }
//
//    public Classroom(Student[] students) {
//        this.students = students;
//    }
//
//    public Classroom() {
//        students = new Student[30];
//    }
//
//    public Student[] getStudents() {
//        return this.students;
//    }
//
//    public Double getAverageExamScore() {
//        double totalScore = 0;
//        double averageScore;
//
//        for (int i = 0; i < students.length; i++) {
//            totalScore += (students[i].getAverageExamScore());
//        }
//
//        averageScore = totalScore / students.length;
//        return averageScore;
//    }
//    public String add(String , String student);


