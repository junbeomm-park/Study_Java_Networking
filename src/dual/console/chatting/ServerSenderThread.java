package dual.console.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSenderThread extends Thread{
	Socket client1; // 클라이언트
    Socket client2;
	public ServerSenderThread(Socket client) {
		super();
		this.client1 = client;
		this.client2 = client;
	}
	
	//키보드로 입력한 메시지를 서버로 보내는 작업을 처리
	@Override
	public void run() {
		BufferedReader keyin = null;
		PrintWriter out1 = null;
		PrintWriter out2 = null;
		try {
			keyin = new BufferedReader(new InputStreamReader(System.in));
			out1 = new PrintWriter(client1.getOutputStream(), true);
			out2 = new PrintWriter(client2.getOutputStream(), true);
			String sendMsg1=""; //클라이언트로 보낼 메시지
			String sendMsg2="";
			while(true) {
				sendMsg1 = keyin.readLine();
				if(sendMsg1==null) {
					break;
				}
				out1.println(sendMsg1);
				
				sendMsg2 = keyin.readLine();
				if(sendMsg2==null) {
					break;
				}
				out2.println(sendMsg2);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
}
