package tpcreative.co.retrofit_rxjava_restfulapi_android.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import tpcreative.co.retrofit_rxjava_restfulapi_android.home.HomeActivity;
import tpcreative.co.retrofit_rxjava_restfulapi_android.model.User;
import tpcreative.co.retrofit_rxjava_restfulapi_android.ui.user.SigninActivity;
import tpcreative.co.retrofit_rxjava_restfulapi_android.ui.user.SignupActivity;

public class Navigator {

    public static void startHome(Context context, User user){
        Intent intent = new Intent(context, HomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("user",user);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtras(bundle);
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
