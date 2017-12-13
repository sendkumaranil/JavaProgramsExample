package com.example.serialization;

import java.util.ArrayList;
import java.util.List;

public class DemoProxyPattern {
	public static void main(String[] args) {
		String domainaddress1="www.timesofindia.com";
		String domainaddress2="www.youtube.com";
		try{
			InternetAccessProxyImpl internetProxy=new InternetAccessProxyImpl();
			internetProxy.getAccess(domainaddress1);
			internetProxy.getAccess(domainaddress2);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

interface InternetAccess{
	public void getAccess(String domainaddress) throws Exception;
}

class InternetAccessImpl implements InternetAccess{
	
	@Override
	public void getAccess(String domainaddress){
		System.out.println("Hi Welcome to host:"+domainaddress);
	}
}
class InternetAccessProxyImpl implements InternetAccess{

	private InternetAccessImpl realObj=null;
	private static List<String> blockedHostList=null;
	
	static{
		blockedHostList=new ArrayList<String>();
		blockedHostList.add("www.googleplus.com");
		blockedHostList.add("www.facebook.com");
		blockedHostList.add("www.youtube.com");
	}
	
	@Override
	public void getAccess(String domainaddress)throws Exception {
				
		if(blockedHostList.contains(domainaddress.toLowerCase())){			
			throw new Exception("Access Denied this host:"+domainaddress);			
		}else{
			realObj=new InternetAccessImpl();
			realObj.getAccess(domainaddress);//original object task here.
		}		
	}
}

