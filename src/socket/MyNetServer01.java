package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyNetServer01 {
	public static void main(String[] args) {
		// 1. 클라이언트와 통신할 수 있는 객체를 생성
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버준비완료....클라이언트의 접속을 기다림");
			// 2. 클라이언트가 접속할때까지 대기
			//    클라이언트가 접속하면 접속한 클라이언트의 정보를 리턴
			Socket client = server.accept();
			System.out.println("접속한 클라이언트 : "+client);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
