package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
public class Test {
	@OneToMany(mappedBy = "Test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Question> questions;
	int Test_Lang;
	int Score;
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public int getTest_Lang() {
		return Test_Lang;
	}
	public void setTest_Lang(int test_Lang) {
		Test_Lang = test_Lang;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	
}
