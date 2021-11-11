package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyNetServer04 {

	public static void main(String[] args) {
		Socket client = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버접속완료...");
			while(true) {
				client = server.accept();
				InetAddress clientIp = client.getInetAddress();
				System.out.println("접속한 클라이언트 : "+clientIp.getHostAddress());
				//네트워크를 통해서 입출력을 하기 위한 IO스트림객체를 생성
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream());
				
				//*****************통신시작*****************
				//1. 서버 -> 클라이언트
				out.println("클라이언트님 접속 성공");
				//출력하기 위한 데이터를 출력버퍼에 임시로 쌓았다가 스트림으로 출력되기 위해서 버퍼에 쌓여있는
				//데이터를 내보내기를 해야 한다. - flush는 버퍼를 비워서 출력을 내보내기 위한 메소드
				out.flush();
				
				//2. 서버 <- 클라이언트
				String msg = in.readLine();
				System.out.println("클라이언트가 전송한 메시지 >>>>"+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
