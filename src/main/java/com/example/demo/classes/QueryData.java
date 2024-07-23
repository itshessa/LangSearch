package com.example.demo.classes;

import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryData {
	String NativeLanguage;
	String DesiredLanguage;
	String Skill;
	String Level;
	
	public void setNativeLanguage (String NativeLanguage) {
		this.NativeLanguage=NativeLanguage;
	}
	public void setDesiredLanguage (String DesiredLanguage) {
		this.DesiredLanguage=DesiredLanguage;
	}
	public void setSkill (String Skill) {
		this.Skill=Skill;
	}
	public void setLevel (String Level) {
		this.Level=Level;
	}
	public String getNativeLanguage () {
		return NativeLanguage;
	}
	public String getDesiredLanguage () {
		return DesiredLanguage;
	}
	public String getSkill () {
		return Skill;
	}
	public String getLevel () {
		return Level;
	}
	@Override
	public String toString() {
		return  DesiredLanguage +" "
				+ Skill+" " + Level;
	}

}
