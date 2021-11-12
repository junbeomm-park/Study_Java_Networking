package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

//URLConnection을 이용해서 웹과 데이터를 주고 받는 방법
//구글이 제공하는 메시징서비스인 FCM이용해서 데이터를 주고 받는 경우에도 구글서비스를 요청해서 처리해야 하므로 필요
/*
 * URLConnection을 구현한 HttpURLConnection을 이용해서 활용
 * 주로 길이를 알 수 있는 스트리밍 데이터를 주고 받을 때 사용
 * http의 URL을 통해 데이터를 처리하기 위해 필요한 여러가지 메소드를 제공한다.
 * 메소드를 설정해서 get방식인지 post방식인지 설정할 수 있다.
 * JSON데이터나 스트링데이터등을 response 하도록 설정할 수 있다.
 * HttpURLConnection REST API호출
 */
public class HttpURLConnectionTest {
	public static void main(String[] args) throws IOException {
		//String url = "http://192.168.0.29:8088/bigdataERP/board/list.do?category=all";
		//String url = "http://192.168.0.29:8088/bigdataERP/emp/idcheck.do?id=jang1";
		String url = "http://192.168.0.29:8088/bigdataERP/board/ajax_list.do?category=all";
		URL urlObj = new URL(url);
		HttpURLConnection con = (HttpURLConnection)urlObj.openConnection();
		//전송방식
		con.setRequestMethod("GET"); // 서버에서 리소스 가져오기
		int responseCode = con.getResponseCode();
		System.out.println("responseCode : "+responseCode);
		
		Charset charset = Charset.forName("UTF-8");
		BufferedReader in = new BufferedReader(
							new InputStreamReader(con.getInputStream(),charset));
		
		String inputline="";
		StringBuffer response = new StringBuffer();
		while((inputline=in.readLine())!=null) {
			response.append(inputline+"\n");
		}
		in.close();
		System.out.println("조회결과 : ");
		System.out.println(response.toString());
	}
}
