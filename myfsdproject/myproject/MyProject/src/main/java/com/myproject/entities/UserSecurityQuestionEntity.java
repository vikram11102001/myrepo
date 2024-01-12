package com.myproject.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usersecurityquestion")
public class UserSecurityQuestionEntity {

	@Id
	private long questionID;
    private String questionText;
	
    public long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
}
