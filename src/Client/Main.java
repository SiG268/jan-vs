package Client;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Main {

	private static String baseURL = "http://localhost:8090/rest/service/";

	public static void main(String[] args) {
		System.out.println("Bitte eine Zahl eingeben:");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		service(i);
	}

	public static void service(int id) {
		String url = baseURL + id;
		System.out.println("Calling url=" + url);
		Client client = ClientBuilder.newClient();
		Response response = client.target(url).request(MediaType.APPLICATION_XML).get();
		USer c = response.readEntity(User.class);
		System.out.println(u);
	}

}
