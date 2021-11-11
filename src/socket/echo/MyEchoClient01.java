package socket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyEchoClient01 {

	public static void main(String[] args) {
		Socket server = null;
		BufferedReader in = null; //서버에서 보내는 메시지를 읽기 위한 스트림객체
		BufferedReader keyin = null;
		PrintWriter out = null; //서버로 보내기 위해 키보드를 통해 입력한 메시지를 읽기 위한 스트림객체
		
		try {
			server = new Socket("192.168.0.143", 12345);
			System.out.println("서버에 접속성공");
			
			//네트워크를 통해서 서버로 입출력을 하기 위한 IO스트림객체를 생성
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			out = new PrintWriter(server.getOutputStream(),true);
			keyin = new BufferedReader(new InputStreamReader(System.in));
			
			//****************통신시작*************
			//키보드로 입력한 데이터를 서버로 지속 전송하기
			//서버가 다시 보내오는 메시지를 콘솔에 출력
			String sendMsg = ""; //서버로 보낼 메시지
			String resMsg = ""; //서버에서 받은 메시지
			while((sendMsg = keyin.readLine()) != null) {
				//1. 클라이언트 -> 서버(키보드로 입력하는 메시지를 서버로 전송)
				out.println(sendMsg);
				//2. 클라이언트 <- 서버
				resMsg = in.readLine();
				System.out.println("서버가 보내는 메시지 >>>>"+resMsg);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
