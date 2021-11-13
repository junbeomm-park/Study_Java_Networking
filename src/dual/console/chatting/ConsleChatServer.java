package dual.console.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConsleChatServer {

	public static void main(String[] args) {
		Socket client1 = null;
		Socket client2 = null;
		
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버접속완료...");
			while(true) {
				//클라이언트끼리 1:1 통신하도록 구현하려면 클라이언트 정보를 저장
				//accept해서 클라이언트의 접속을 대기하는 부분도 쓰레드로 처리
				
				
				client1 = server.accept();
				InetAddress clientIp = client1.getInetAddress();
				System.out.println("접속한 클라이언트 : "+clientIp.getHostAddress());
				
				client2 = server.accept();
				InetAddress clientIp2 = client2.getInetAddress();
				System.out.println("접속한 클라이언트2 : "+clientIp2.getHostAddress());
				
				//클라이언트가 접속하면 클라이언트와 통신할 수 있는 서버쪽 쓰레드를 생성하고 start
				ServerReceiveThread receiveThread = new ServerReceiveThread(client1);
				receiveThread.start();
				ServerReceiveThread receiveThread2 = new ServerReceiveThread(client2);
				receiveThread2.start();
				new ServerSenderThread(client1).start();
				new ServerSenderThread(client2).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
