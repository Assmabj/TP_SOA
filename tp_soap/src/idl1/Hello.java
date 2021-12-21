package idl1;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Hello {
	@WebMethod
   public String sayHello(){
	return "HELLO WORLD";
     }
	@WebMethod
	public int somme(@WebParam(name="a")int a ,@WebParam(name="b") int b ){
		return a+b;}
	
	@WebMethod
	public int soustraction(@WebParam(name="a")int a ,@WebParam(name="b") int b ){
		return a-b;
	}

	@WebMethod
	public int multiplication(@WebParam(name="a")int a ,@WebParam(name="b") int b ){
		return a*b;
	}	
}

