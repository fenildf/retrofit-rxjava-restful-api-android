package tpcreative.co.retrofit_rxjava_restfulapi_android.common;

import android.content.Context;
import android.content.Intent;

import tpcreative.co.retrofit_rxjava_restfulapi_android.home.HomeActivity;
import tpcreative.co.retrofit_rxjava_restfulapi_android.user.SigninActivity;
import tpcreative.co.retrofit_rxjava_restfulapi_android.user.SignupActivity;

public class Navigator {

    public static void startHome(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    public static void startSignUp(Context context){
        Intent intent = new Intent(context, SignupActivity.class);
        context.startActivity(intent);
    }

    public static void startSignIn(Context context){
        Intent intent = new Intent(context, SigninActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

}
