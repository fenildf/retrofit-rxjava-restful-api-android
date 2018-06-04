package tpcreative.co.retrofit_rxjava_restfulapi_android.home;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.OnClick;
import co.tpcreative.common.activity.BaseActivity;
import tpcreative.co.retrofit_rxjava_restfulapi_android.R;
import tpcreative.co.retrofit_rxjava_restfulapi_android.common.Navigator;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setChangeFontTitle(getResources().getString(R.string.lbHomePage));
    }

    @OnClick(R.id.btnLogOut)
    public void onClickSignOut(){
        Navigator.startSignIn(this);
        finish();
    }

}
