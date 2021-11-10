package socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyNetClient01 {
	public static void main(String[] args) {
		
		try {
			//서버와 통신할 수 있는 소켓객체를 생성
			//서버에 연결을 요청
			Socket client = new Socket("192.168.0.221", 12345);
			System.out.println("서버접속완료 : "+client);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
