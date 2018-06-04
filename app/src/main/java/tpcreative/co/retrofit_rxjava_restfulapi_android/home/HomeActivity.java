package tpcreative.co.retrofit_rxjava_restfulapi_android.home;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.OnClick;
import co.tpcreative.common.activity.BaseActivity;
import co.tpcreative.common.ui.FontTextView;
import tpcreative.co.retrofit_rxjava_restfulapi_android.R;
import tpcreative.co.retrofit_rxjava_restfulapi_android.common.Navigator;
import tpcreative.co.retrofit_rxjava_restfulapi_android.model.User;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.tvWelcome)
    FontTextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setChangeFontTitle(getResources().getString(R.string.lbHomePage));
        Bundle bundle = getIntent().getExtras();
        User user = (User) bundle.get("user");
        if (user!=null){
            tvWelcome.setText("Hi "+user.name.toUpperCase() +" Welcome To TPCreative");
        }
    }

    @OnClick(R.id.btnLogOut)
    public void onClickSignOut(){
        Navigator.startSignIn(this);
        finish();
    }

}
