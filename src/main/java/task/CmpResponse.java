package task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CmpResponse {
	UICntr fr = new UICntr();
	public int cmpResp(String USER_AGENT) throws Exception {
		
		String url = "http://swapi.co/api/planets/?format=json";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		if (responseCode != 200) {
			int resp = fr.ConDiag("Incorrect Option \n " + "Do you want to re-enter ", "Warning");
			if (resp == 0) {
				fr.msg();
			}
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		fr.framepanel(response.toString());
		return (responseCode);
	}
	
	
}
