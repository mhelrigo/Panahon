package com.mhelrigo.domain.forecast.entity;

public class Condition{
	private int code;
	private String icon;
	private String text;

	public Condition() {
	}

	public Condition(int code, String icon, String text) {
		this.code = code;
		this.icon = icon;
		this.text = text;
	}

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}
}
