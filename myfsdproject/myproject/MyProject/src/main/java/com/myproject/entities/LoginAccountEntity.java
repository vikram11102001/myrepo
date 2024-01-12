package com.myproject.entities;

import jakarta.persistence.*;
import com.myproject.model.Account;
import com.myproject.model.UserLogin;

@Entity
@Table(name = "loginaccount")
public class LoginAccountEntity {

	@ManyToOne
	@JoinColumn(name = "userloginid", referencedColumnName = "userloginid", table = "userlogin")
	private UserLogin userLogin;
	
	@ManyToOne
	@JoinColumn(name = "accountid", referencedColumnName = "accountid", table = "account")
	private Account account;
	
	public UserLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
