package com.mnf.raisoniworkshop30012021;

public class AppConstant {

    public static final String LOGINID_KEY="LOGINID";
    public static final String PASSWORD_KEY="PASSWORD";
    public static final String LOGIN_SHAREDPREFRECES="LOGIN";
    public static final String NAME="Name";
    public static final String EMAILID="EmailId";
    public static final String PASSWORD="Password";

    public static boolean isEmptyField(String valueString){
        if (valueString!=null && !valueString.trim().isEmpty()){
            return false;
        }
        return true;
    }
}
