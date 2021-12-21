package idl1;

import javax.xml.ws.Endpoint;

public class Serveur {
	
	
	static final String URL ="http://localhost:8081/";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("running on"+URL);
      Endpoint.publish(URL, new Hello());
	}

}
