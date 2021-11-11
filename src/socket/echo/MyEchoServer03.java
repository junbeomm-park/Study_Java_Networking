package socket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyEchoServer03 {

	public static void main(String[] args) {
		Socket client = null;
		BufferedReader in = null; //클라이언트와 통신하기 위한 스트림
		BufferedReader keyin = null; //키보드로 입력하는 메시지를 읽기 위한 스트림
		PrintWriter out = null;
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버접속완료...");
			while(true) {
				client = server.accept();
				InetAddress clientIp = client.getInetAddress();
				System.out.println("접속한 클라이언트 : "+clientIp.getHostAddress());

				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream(), true);
				keyin = new BufferedReader(new InputStreamReader(System.in));
				String sendMsg="";
				String resMsg = ""; //클라이언트가 보내는 메시지
				while(true) {
					//1. 서버 <- 클라이언트
					resMsg = in.readLine();
					if(resMsg==null) {
						break;
					}
					System.out.println("클라이언트가 보낸 메시지 >>>"+resMsg);
					//2. 서버 -> 클라이언트
					sendMsg = keyin.readLine();
					out.println(sendMsg);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
