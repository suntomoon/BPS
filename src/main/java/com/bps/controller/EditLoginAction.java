package com.bps.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractManager;
import com.bps.entity.LoginEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditLoginAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditLoginAction.class);
	//List of products; Setter and Getter are below
	private List<AbstractEntity> logins;
	//Product object to be added; Setter and Getter are below
	private LoginEntity login;
	
	//Product manager injected by spring context; This is cool !!
	private AbstractManager loginManager;

	//This method initial login process.
	public String toLogin() {
		logger.info("toLogin method called");
//		products = productManager.getAllEntity();
		return SUCCESS;
	}

	//This method will be called when a sing-in attempt is made
	public String signIn() {
		logger.info("signIn method called");
//		productManager.addEntity(product);
		return SUCCESS;
	}

	//This method will be called when a new user account needs to be created
	public String signUp() {
		logger.info("deleteProduct method called");
//		productManager.deleteEntity(product.getId());
		return SUCCESS;
	}
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		login = null;
	}

	/**
	 * Setters & getters
	 */
	public List<AbstractEntity> getLogins() {
		return logins;
	}

	public void setLogins(List<AbstractEntity> logins) {
		this.logins = logins;
	}

	public LoginEntity getLogin() {
		return login;
	}

	public void setLogin(LoginEntity login) {
		this.login = login;
	}

	public AbstractManager getLoginManager() {
		return loginManager;
	}

	public void setLoginManager(AbstractManager loginManager) {
		this.loginManager = loginManager;
	}
	
}
