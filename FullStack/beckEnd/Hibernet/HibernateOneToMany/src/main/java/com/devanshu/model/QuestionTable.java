package com.devanshu.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class QuestionTable {
           @Id
           @Column(name="question_id")
           private Integer id;
           private String question;
           
           private AnswerTable answer;

		   public Integer getId() {
			   return id;
		   }

		   public void setId(Integer id) {
			   this.id = id;
		   }

		   public String getQuestion() {
			   return question;
		   }

		   public void setQuestion(String question) {
			   this.question = question;
		   }

		   public AnswerTable getAnswer() {
			   return answer;
		   }

		   public void setAnswer(AnswerTable answer) {
			   this.answer = answer;
		   }
           
           
}
