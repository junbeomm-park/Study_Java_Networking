package basic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest02 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		
		try {
			URL url =
					new URL("http://cafefiles.naver.net/20120209_226/pododumok_13287752996753FNE4_jpg/%C0%E5%B5%BF%B0%C7_5_pododumok.jpg");
			//인터넷에서 확인할 수 있는 자원인 이미지를 이용해서 URL생성
			//=> 이 이미지를 클라이언트 PC에 저장하기(image폴더에 myimg.jpg로 저장)
			//=> file IO(binary file이므로 BufferedInputStream(read메소드),
			//   출력 => FileOutputStream이용하기)
			BufferedInputStream br = new BufferedInputStream(url.openStream());
			fos = new FileOutputStream("src/image/myimg.jpg");
			while(true) {
				int data_byte = br.read();
				if(data_byte==-1) {
					break;
				}
				fos.write(data_byte);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
