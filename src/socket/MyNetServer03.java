package socket;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
//클라이언트와 통신하기 위한 서버
//=> 클라이언트가 접속하면 클라이언트와 통신할 수 있는 IO스트림객체를 구해서 클라이언트에게 메시지를 보낸다.
//=> 클라이언트가 서버의 메시지를 받고 다시 보내온 메시지를 서버콘솔에 출력하기
//   클라이언트와 IO(input -> DataInputStream, output -> DataOutputStream)
public class MyNetServer03 {
	public static void main(String[] args) {
		Socket client = null;
		Random rand = new Random();
		InputStream socketIn = null; // 클라이언트가 보내오는 데이터를 읽기 위해서 소켓에서 꺼내오는 스트림객체
		OutputStream socketOut = null; // 클라이언트에게 데이터를 보내기 위해서 소켓에서 꺼내오는 스트림객체
		DataInputStream dis = null; // 클라이언트로 부터 읽은 데이터를 타입별로 읽기 위해 사용하는 최종스트림객체
		DataOutputStream dos = null; // 클라이언트로 데이터를 타입별로 보내기 위해 사용하는 최종스트림객체
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버준비완료....클라이언트의 접속을 기다림");
			//여러 클라이언트에게 서비스를 제공하기 위해서 무한루프
			while(true) {
			    client = server.accept();
				InetAddress clientIp = client.getInetAddress();
				System.out.println("접속한 클라이언트 : "+clientIp.getHostAddress());
				
				//클라이언트와 통신하기 위한 Input/Output 스트림객체를 소켓으로 부터 구해 생성한다.
				socketIn = client.getInputStream();
				socketOut = client.getOutputStream();
				dis = new DataInputStream(socketIn);
				dos = new DataOutputStream(socketOut);
				
				//1. 서버 -> 클라이언트
				dos.writeUTF("안녕하세요 클라이언트님");
				
				//2. 서버 -> 클라이언트
				int randNum = rand.nextInt(8)+2;
				dos.writeInt(randNum);
				
				//3. 서버 <- 클라이언트
				String data = dis.readUTF();
				System.out.println(data);
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
