package tpcreative.co.retrofit_rxjava_restfulapi_android.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.util.Log;

import java.util.HashMap;

import co.tpcreative.common.application.BaseApplication;
import co.tpcreative.common.controller.PrefsController;
import co.tpcreative.common.network.Dependencies;
import tpcreative.co.retrofit_rxjava_restfulapi_android.common.API;

public class TPApplication extends BaseApplication implements Dependencies.DependenciesListener,  Application.ActivityLifecycleCallbacks{

    private String url = " http://tpalwayscreative.esy.es" ;
    private static int resumed;
    private static int paused;
    private static int started;
    private static int stopped;
    protected static Dependencies dependencies;
    public static API serverAPI ;
    public static String authorization = null ;
    private static String TAG = TPApplication.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        dependencies = Dependencies.getsInstance(getApplicationContext(),url);
        dependencies.dependenciesListener(this);
        dependencies.init();
        serverAPI = (API) Dependencies.serverAPI;

        /*Init SharePreference*/
        new PrefsController.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();



    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }


    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        ++resumed;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        ++paused;
        Log.d(TAG, "application is in foreground: " + (resumed > paused));
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        ++started;
    }

    @Override
    public void onActivityStopped(Activity activity) {
        ++stopped;
        Log.d(TAG, "application is visible: " + (started > stopped));
    }

    // If you want a static function you can use to check if your application is
    // foreground/background, you can use the following:
    //
    // Replace the four variables above with these four
    // And these two public static functions

    public boolean isApplicationVisible() {
        return started > stopped;
    }

    public boolean isApplicationInForeground() {
        return resumed > paused;
    }

    public static void onSetAuthor(String authors){
        authorization = authors;
    }

    @Override
    public String onAuthorToken() {
        return authorization;
    }

    @Override
    public HashMap<String, String> onCustomHeader() {
        HashMap<String,String>hashMap = new HashMap<>();
        hashMap.put("Content-Type","application/json");
        if (authorization!=null){
            hashMap.put("Authorization",authorization);
        }
        return hashMap;
    }

    @Override
    public Class onObject() {
        return API.class;
    }

    @Override
    public boolean isXML() {
        return false;
    }

    private static TPApplication sInstance;


    public TPApplication() {
        sInstance = this;
    }

    public static TPApplication get() {
        return sInstance;
    }


    public String getUrl(){
        return url;
    }
}