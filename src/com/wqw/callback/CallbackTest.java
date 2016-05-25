package com.wqw.callback;

public class CallbackTest {

	static void sendRequest(String url, OnResponseListener callback){
		
		// do send action
		
		String result = "mock result";
		
		callback.onReceive(result);
	}
	
	public static void main(String[] args) {
		String url1 = "";
		String url2 = "";
		
		
		sendRequest(url1, new OnResponseListener(){

			@Override
			public void onReceive(Object result) {
				
				//use response
				System.out.println(result);
			}

			@Override
			public void onError() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		OnResponseListener listener = new OnResponseListener(){

			@Override
			public void onReceive(Object result) {
				//use response
				System.out.println(result);
			}

			@Override
			public void onError() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		sendRequest(url1, listener);
		
		
		ResponseImpl impl = new ResponseImpl();
		sendRequest(url2, impl);
	}
}
