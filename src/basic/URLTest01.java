package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


//URL클래스
//=> 인터넷에서 확인할 수 있는 자원을 추출

public class URLTest01 {
	public static void main(String[] args) {
		try {
			//URL url = new URL("https://www.kisa.or.kr/jsp/common/downloadAction.jsp?bno=259&dno=66&fseq=1");
		    URL url = new URL("https://www.naver.com/"); 
			System.out.println(url.toString());
			System.out.println("url.getHost()=>"+url.getHost());
			System.out.println("url.getPath()=>"+url.getPath());
			//port가 -1
			//-1포트로 접속했다는 의미가 아니라 http의 기본포트로 접속하고 있다는 의미
			//기본포트 : 80
			//우리가 접속하기 위해 사용한 url이 웹의 기본 포트를 사용하고 있다는 의미
			System.out.println("url.getPort()=>"+url.getPort());
			System.out.println("url.getProtocol()=>"+url.getProtocol());
			System.out.println("url.getFile()=>"+url.getFile());
		
			//정의한 url에서 자원 읽어오기
			//
//			InputStream is = url.openStream();
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader br = new BufferedReader(isr);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			while(true) {
				String data_byte = br.readLine();
				if(data_byte==null) {
					break;
				}
				System.out.println(data_byte);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
