package com.example.demo.model;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
public class Question {
	int Test_Lang;
	String Question_Title;
	String Question_Description;
	String Answer1;
	String Answer2;
	String Answer3;
	String Correct_Answer;
	@ManyToOne
	Test test;
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public int getTest_Lang() {
		return Test_Lang;
	}
	public void setTest_Lang(int test_Lang) {
		Test_Lang = test_Lang;
	}
	public String getQuestion_Title() {
		return Question_Title;
	}
	public void setQuestion_Title(String question_Title) {
		Question_Title = question_Title;
	}
	public String getQuestion_Description() {
		return Question_Description;
	}
	public void setQuestion_Description(String question_Description) {
		Question_Description = question_Description;
	}
	public String getAnswer1() {
		return Answer1;
	}
	public void setAnswer1(String answer1) {
		Answer1 = answer1;
	}
	public String getAnswer2() {
		return Answer2;
	}
	public void setAnswer2(String answer2) {
		Answer2 = answer2;
	}
	public String getAnswer3() {
		return Answer3;
	}
	public void setAnswer3(String answer3) {
		Answer3 = answer3;
	}
	public String getCorrect_Answer() {
		return Correct_Answer;
	}
	public void setCorrect_Answer(String correct_Answer) {
		Correct_Answer = correct_Answer;
	}


}
