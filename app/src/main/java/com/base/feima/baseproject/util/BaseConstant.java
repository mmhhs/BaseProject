package com.base.feima.baseproject.util;

import android.os.Environment;


public class BaseConstant
{
	public enum TaskResult 
	{
		OK, 
		ERROR, 
		CANCELLED,
		NETERROR,
		NOTHING
	}
	
	public static final String IMAGETAMPPATH = Environment.getExternalStorageDirectory() + "/company/test/cache/tamp/";
	public static final String IMAGESAVEPATH = Environment.getExternalStorageDirectory() + "/company/test/cache/image/";
	public static final String IMAGETAMPFOLDER = "company/test/cache/tamp";
	
	public final static int PAGER_START									=  1;
	
	public final static int REQUEST_REFRESH									=  9999;
	
	
	public static String INTENT_ID								=  "INTENT_ID";
	public static String INTENT_TYPE								=  "INTENT_TYPE";
	public static String INTENT_CHOOSE								=  "INTENT_CHOOSE";
	public static String INTENT_CLASS								=  "INTENT_CLASS";
	
	//real
	public final static String SERVICE_HOST_IP_LAN		     = "http://www.meijiab.cn/admin/index.php/Api/";
	public final static String SERVICE_HOST_IP_LAN_IMG	 = "http://www.meijiab.cn/admin/";
	
	//test
//	public final static String SERVICE_HOST_IP_LAN		     = "http://www.meijiab.cn/test/index.php/Api/";
//	public final static String SERVICE_HOST_IP_LAN_IMG	 = "http://www.meijiab.cn/test/";

	public static String VERSION									=  "Version/getVersion";
	public static String LOGIN									=  "User/login";

	
}
