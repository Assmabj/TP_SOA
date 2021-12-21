package idl1;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
public class Usercontroller {
	public List<User> listU=new ArrayList<>();
	
	@WebMethod
	public User addUser(@WebParam(name="u")User u ){
	listU.add(u);
		return u;
	}
	
	@WebMethod
	public List<User> afficherUser(){

	return listU;
	}
	
	@WebMethod
	public List<User> supprimerUser(@WebParam(name="id")int id ){
		
	listU.remove(id);
		return listU;
	}
	
}
