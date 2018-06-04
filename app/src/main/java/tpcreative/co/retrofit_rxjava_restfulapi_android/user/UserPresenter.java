package tpcreative.co.retrofit_rxjava_restfulapi_android.user;
import android.util.Log;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import co.tpcreative.common.presenter.Presenter;
import co.tpcreative.common.utils.NetworkUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import tpcreative.co.retrofit_rxjava_restfulapi_android.TPApplication;
import tpcreative.co.retrofit_rxjava_restfulapi_android.common.request.RegisterRequest;
import okhttp3.ResponseBody;

public class UserPresenter extends Presenter<UserView>{

    public static final String TAG = UserPresenter.class.getSimpleName();

    public void onSignUp(RegisterRequest request){
        Log.d(TAG,"info");
        UserView view = view();
        if (view == null) {
            return;
        }
        if (NetworkUtil.pingIpAddress(view.getContext())) {
            return;
        }
        if (subscriptions == null) {
            return;
        }

        Map<String,String> hash = new HashMap<>();
        hash.put("email",request.email);
        hash.put("password",request.password);
        hash.put("name",request.name);

        if (TPApplication.serverAPI == null){
            return;
        }

        subscriptions.add(TPApplication.serverAPI.onSignUP(hash)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> view.startLoading())
                .subscribe(onResponse -> {
                    view.stopLoading();
                    if (onResponse.error){
                        view.errorOccurred(onResponse.message);
                    }
                    else{
                        view.signUpSuccessful(onResponse.message);
                    }
                    Log.d(TAG, "Body : " + new Gson().toJson(onResponse));
                }, throwable -> {
                    if (throwable instanceof HttpException) {
                        ResponseBody bodys = ((HttpException) throwable).response().errorBody();
                        try {
                            Log.d(TAG,"error" +bodys.string());
                            String msg = new Gson().toJson(bodys.string());
                            Log.d(TAG, msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.d(TAG, "Can not call" + throwable.getMessage());
                    }
                    view.stopLoading();
                }));
    }

    public void onSignIn(RegisterRequest request){
        Log.d(TAG,"info");
        UserView view = view();
        if (view == null) {
            return;
        }
        if (NetworkUtil.pingIpAddress(view.getContext())) {
            return;
        }
        if (subscriptions == null) {
            return;
        }

        Map<String,String> hash = new HashMap<>();
        hash.put("email",request.email);
        hash.put("password",request.password);


        if (TPApplication.serverAPI == null){
            return;
        }

        subscriptions.add(TPApplication.serverAPI.onSignIn(hash)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> view.startLoading())
                .subscribe(onResponse -> {
                    view.stopLoading();
                    if (onResponse.error){
                        view.errorOccurred(onResponse.message);
                    }
                    else{
                        view.signInSuccessful(onResponse.message);
                    }
                    Log.d(TAG, "Body : " + new Gson().toJson(onResponse));
                }, throwable -> {
                    if (throwable instanceof HttpException) {
                        ResponseBody bodys = ((HttpException) throwable).response().errorBody();
                        try {
                            Log.d(TAG,"error" +bodys.string());
                            String msg = new Gson().toJson(bodys.string());
                            Log.d(TAG, msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.d(TAG, "Can not call" + throwable.getMessage());
                    }
                    view.stopLoading();
                }));
    }



}
