package com.vodafone.oim.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import oracle.iam.identity.usermgmt.api.UserManager;
import oracle.iam.identity.usermgmt.vo.User;
import oracle.iam.platform.OIMClient;

public class OIMUSERUPDATION {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			OIMClient oimClient = getOIMClient("xelsysadm", "Password123","t3://16.175.217.86:14000");
			UserManager userManager = oimClient.getService(UserManager.class);
			
			
			Set<String> returnMap = new HashSet<String>();
		//	returnMap.add("Status");
			
		//	final User user = userManager.getDetails("User Login", "IBALL19", returnMap);
			
			User user1=new User("21");
			
			user1.setAttribute("User Login", "IBALL1911");
			
			userManager.modify(user1);

			
			//user disable or enable or delete method to change the status of the user. 
		   //   userManager.enable("IBALL50", true);
			
			System.out.println("HELOOOOO");
		
		}catch(Exception e){
			
			System.out.println("ERROR="+e);
			
		}

	}
	
	public static OIMClient getOIMClient(String oimUserName, String oimPassword,
            Object oimURL) throws Exception {
		System.setProperty("OIM.AppServerType", "wls");
		System.setProperty("APPSERVER_TYPE", "wls");
        java.util.Hashtable env = new java.util.Hashtable();
        env.put(oracle.iam.platform.OIMClient.JAVA_NAMING_FACTORY_INITIAL,
                oracle.iam.platform.OIMClient.WLS_CONTEXT_FACTORY);
        env.put(oracle.iam.platform.OIMClient.JAVA_NAMING_PROVIDER_URL, oimURL);
        oracle.iam.platform.OIMClient client = new oracle.iam.platform.OIMClient(
                env);
        client.login(oimUserName, oimPassword.toCharArray());
        return client;
    }

}
