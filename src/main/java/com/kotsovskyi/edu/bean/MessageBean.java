package com.kotsovskyi.edu.bean;

import org.springframework.context.annotation.Scope;

import javax.inject.Named;
import java.io.Serializable;

@Named("msgsReg")
@Scope("session")
public class MessageBean implements Serializable{
	private final String nameRequired = "Поле ім'я не може бути порожнім";
	private final String nameLength = "Довжина ім'я повинна бути від 10 до 64 символів";

	private final String emailRequired = "Поле e-mail не може бути порожнім";
	private final String emailLength = "Довжина e-mail повинна бути від 10 до 64 символів";

	private final String passwordRequired = "Поле password не може бути порожнім";
	private final String passwordLength = "Довжина password повинна бути від 7 до 30 символів";

	private final String bookIdRequired = "Поле ISBN не може бути порожнім";
	private final String bookIdLength = "Довжина ISBN повинна складати 13 цифр";
	private final String bookIdType = "ISBN не містить символів, тільки цифри";

	private final String memberPassportRequired = "Поле паспорт не може бути порожнім";
	private final String memberPassportLength = "паспорт - 8 символів, студентський - 10 символів";
	
	public MessageBean(){}
	
	public String getNameRequired(){
		return nameRequired;
	}
	
	public String getEmailRequired(){
		return emailRequired;
	}
	
	public String getPasswordRequired(){
		return passwordRequired;
	}
	
	public String getPasswordLength(){
		return passwordLength;
	}
	
	public String getNameLength(){
		return nameLength;
	}

	public String getEmailLength() {
		return emailLength;
	}

	public String getBookIdRequired() {
		return bookIdRequired;
	}

	public String getBookIdLength() {
		return bookIdLength;
	}

	public String getBookIdType() {
		return bookIdType;
	}

	public String getMemberPassportRequired() {
		return memberPassportRequired;
	}

	public String getMemberPassportLength() {
		return memberPassportLength;
	}
}
