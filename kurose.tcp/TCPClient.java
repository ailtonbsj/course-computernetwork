import java.io.*;
import java.net.*;

class TCPClient {
	public static void main(String argv[]) throws Exception{
		String sentence;
		String modifiedSentece;
		BufferedReader inFromUser = new BufferedReader(
			new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 5000);
		DataOutputStream outToServer = new DataOutputStream(
			clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(
			new InputStreamReader(clientSocket.getInputStream()));
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
		modifiedSentece = inFromServer.readLine();
		System.out.println("FROM SERVER: " + modifiedSentece);
		clientSocket.close();
	}
}