package com.devanshu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Answer {
    @Id
    @Column(name = "answer_Aid")
    private Integer id;
    private String answer;

    public Answer() {
        System.out.println("Zero parameter constructor form answer ");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer [id=" + id + ", answer=" + answer + "]";
    }

}
