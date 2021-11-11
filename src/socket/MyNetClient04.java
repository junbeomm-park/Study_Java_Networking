package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyNetClient04 {

	public static void main(String[] args) {
		Socket server = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			server = new Socket("192.168.0.29", 12345);
			System.out.println("서버에 접속성공");
			//네트워크를 통해서 서버로 입출력을 하기 위한 IO스트림객체를 생성
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			out = new PrintWriter(server.getOutputStream(),true);
			
			//****************통신시작*************
			//1. 클라이언트 <- 서버
			String msg = in.readLine();
			System.out.println("서버가 보내 온 메시지 >>>>"+msg);
			
			//2. 클라이언트 -> 서버
			out.println("서버야 안녕 나는 클라이언트");
			//out.flush();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
