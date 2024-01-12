package com.myproject.demo.model;

public class UserSecurityAnswer {

	private UserLogin userLogin;
	private UserSecurityQuestion question; 
    private String answerText;
	
    public UserLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	public UserSecurityQuestion getQuestion() {
		return question;
	}
	public void setQuestion(UserSecurityQuestion question) {
		this.question = question;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
    
    
}
