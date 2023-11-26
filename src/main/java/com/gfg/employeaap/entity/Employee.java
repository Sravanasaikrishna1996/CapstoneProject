package com.gfg.employeaap.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "QUESTION")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "QUESTION_TEXT")
	 private String questionText;

	@Column(name = " OPTION_A")
	private String option1;
	  
	@Column(name = " OPTION_B")
    private String option2;
	
	@Column(name = " OPTION_C")
	private String option3;
	
	@Column(name = " OPTION_D")
    private String option4;
	
	@Column(name = "CORRECT_OPTION")
    private String correctOption;

	public void setId(int id) {
		this.id = id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public int getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public String getQuestionText() {
		return questionText;
	}

	public String getOption1() {
		return option1;
	}

	public String getOption2() {
		return option2;
	}

	public String getOption3() {
		return option3;
	}

	public String getOption4() {
		return option4;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	
}
