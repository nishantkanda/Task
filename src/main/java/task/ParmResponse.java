package task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ParmResponse {

	public int PrmResponse(int k, String USER_AGENT) throws Exception {
		UICntr fr = new UICntr();
		String url = "http://swapi.co/api/planets/" + k + "/?format=json";

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
		} else {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			fr.framepanel(response.toString());
		}
		return (responseCode);
	}

}
