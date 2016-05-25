package com.wqw.scheme;

import java.net.URI;
import java.net.URISyntaxException;

public class SchemeTest {

	public static void main(String[] args) {

		try {
			URI uri = new URI("http://www.baidu.com/a/bc/dce?dext=233");
			System.out.println(uri.getPath());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
