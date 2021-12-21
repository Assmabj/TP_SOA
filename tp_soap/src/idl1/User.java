package idl1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class User {
private String username;
@XmlTransient
private String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public User() {
	super();
}


}
