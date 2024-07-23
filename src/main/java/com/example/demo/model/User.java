package com.example.demo.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
		@Id
	    @Column
	    private String email;
		
		@Column
	    private String userName;
	    
	    @Column
	    private String password;
	    
	    @Column
	    private String name;
	    
	    @Column
	    private String native_language;
	    
	    @Column
	    private String targeted_language;
	    
	    @Column
	    private String level;
	    
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNative_language() {
			return native_language;
		}
		public void setNative_language(String native_language) {
			this.native_language = native_language;
		}
		public String getTargeted_language() {
			return targeted_language;
		}
		public void setTargeted_language(String targeted_language) {
			this.targeted_language = targeted_language;
		}
		public String getLevel() {
			return level;
		}
		public void setLevel(String level) {
			this.level = level;
		}
}

