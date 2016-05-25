package com.wqw.callback;

public class ResponseImpl implements OnResponseListener {

	@Override
	public void onReceive(Object result) {
		//use response
		System.out.println(result);
	}

	@Override
	public void onError() {
		// TODO Auto-generated method stub
		
	}

}
