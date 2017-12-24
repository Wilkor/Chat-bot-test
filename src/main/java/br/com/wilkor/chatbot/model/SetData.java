package br.com.wilkor.chatbot.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SetData{

	@Id
	@GeneratedValue
	private int id;
	
	private String msg_json;
	
	private Date  msg_date = new Date() ;
	
	
	public SetData(String msg_json) {
		
		this.setMsg_json(msg_json);
	}
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg_json() {
		return msg_json;
	}

	public void setMsg_json(String msg_json) {
		this.msg_json = msg_json;
	}
	
	public Date getMsg_date() {
		return msg_date;
	}

	public void setMsg_date(Date date) {
		this.msg_date = date;
	}
	
}