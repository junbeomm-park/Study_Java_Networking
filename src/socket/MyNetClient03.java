package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
//서버와 통신하며 데이터를 주고 받을 수 있는 클라이언트
public class MyNetClient03 {
	public static void main(String[] args) {
		Socket serverobj = null;
		int random = new Random().nextInt(9);
		
		InputStream socketIn = null; // 서버가 보내오는 데이터를 읽기 위해서 소켓에서 꺼내오는 스트림객체
		OutputStream socketOut = null; // 서버에게 데이터를 보내기 위해서 소켓에서 꺼내오는 스트림객체
		DataInputStream dis = null; // 서버로 부터 읽은 데이터를 타입별로 읽기 위해 사용하는 최종스트림객체
		DataOutputStream dos = null; // 서버로 데이터를 타입별로 보내기 위해 사용하는 최종스트림객체
		try {
			serverobj = new Socket("192.168.0.29", 12345);
			System.out.println("서버접속완료 : "+serverobj);
			socketIn = serverobj.getInputStream();
			socketOut = serverobj.getOutputStream();
			dis = new DataInputStream(socketIn);
			dos = new DataOutputStream(socketOut);
			
			String data = dis.readUTF();
			System.out.println("서버가 전송한 메시지 1 => "+data);
			int gugu = dis.readInt();
				for (int i = 1; i < 10; i++) {
					System.out.println(gugu+"*"+i+"="+(gugu*i));
				}
			
			
			
			
			//2. 클라이언트 -> 서버
			String clientMsg = "";
			if(gugu%2==0) {
				dos.writeUTF("짝수");
			}else {
				dos.writeUTF("홀수");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
