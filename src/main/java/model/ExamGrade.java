package main.java.model;

import java.io.Serializable;
import java.util.Objects;

public class ExamGrade implements Serializable {

    private int id;
    private int studentId;
    private int mark;
    private int examId;

    public ExamGrade(int id, int studentId, int mark, int examId) {
        this.id = id;
        this.studentId = studentId;
        this.mark = mark;
        this.examId = examId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ExamGrade{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", mark=" + mark +
                ", examId=" + examId +
                '}';
    }
}
