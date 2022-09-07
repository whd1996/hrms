package com.xpu.hrms.utils;

import org.springframework.util.DigestUtils;
/**
 * MD5加密 用户密码
 * @author whd
 *
 */
public class MD5Utils {

    //盐
    private static final String salt = "这个串是xpuHrms系统Md5加密所用盐值-万鸿达、李新宇、凌代涛、付利文、梁帅";

    public static String getMD5(String string){
        String val = string+salt;
        return DigestUtils.md5DigestAsHex(val.getBytes());
    }
    public static void main(String[] args) {
    	System.out.println(getMD5("123"));
	}

}
