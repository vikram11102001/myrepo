package com.myproject.entities;

import jakarta.persistence.*;
import com.myproject.model.UserLogin;
import com.myproject.model.UserSecurityQuestion;

@Entity
@Table(name = "usersecurityanswer")
public class UserSecurityAnswerEntity {

	@ManyToOne
	@JoinColumn(name = "userloginid", referencedColumnName = "userloginid", table = "userlogin")
	private UserLogin userLogin;
	
	@ManyToOne
	@JoinColumn(name = "usersecurityquestionid", referencedColumnName = "usersecurityquestionid", table = "usersecurityquestion")
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
