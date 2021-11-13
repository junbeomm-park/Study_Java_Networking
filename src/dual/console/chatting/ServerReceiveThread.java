package dual.console.chatting;
//서버가 전송하는 메시지를 읽는 일을 처리하는 쓰레드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReceiveThread extends Thread{
	Socket client1; // 클라이언트 1
	Socket client2; // 클라이언트 2
	//쓰레드가 생성될때 클라이언트 정보를 넘겨 받도록 작업
	public ServerReceiveThread(Socket client) {
		super();
		this.client1 = client;
		this.client2 = client;
		
	}
	
	//클라이언트가 보내는 메시지를 읽어서 콘솔에 출력하는 실행흐름
	@Override
	public void run() {
		BufferedReader in1 = null;
		BufferedReader in2 = null;
		try {
			in1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
			in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
			
			String resMsg1="";
			String resMsg2="";
			while(true) {
				resMsg1 = in1.readLine();
				if(resMsg1==null) {
					break;
				}
				System.out.println("클라이언트1 >>>>"+resMsg1);
				
				resMsg2 = in2.readLine();
				if(resMsg2==null) {
					break;
				}
				System.out.println("클라이언트2 >>>>"+resMsg2);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
}