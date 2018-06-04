package tpcreative.co.retrofit_rxjava_restfulapi_android.user;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import co.tpcreative.common.activity.BaseActivity;
import co.tpcreative.common.ui.FontEditText;
import tpcreative.co.retrofit_rxjava_restfulapi_android.R;
import tpcreative.co.retrofit_rxjava_restfulapi_android.common.Navigator;
import tpcreative.co.retrofit_rxjava_restfulapi_android.common.request.RegisterRequest;

public class SigninActivity extends BaseActivity implements UserView {

    private UserPresenter presenter;
    private ActionBar actionBar;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.edtEmail)
    FontEditText edtEmail;
    @BindView(R.id.edtPassword)
    FontEditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        setChangeFontTitle(getResources().getString(R.string.lbSignIn));
        presenter = new UserPresenter();
        presenter.bindView(this);
    }

    @OnClick(R.id.btnSignUp)
    public void onClickSignUp(){
        Navigator.startSignUp(this);
    }

    @OnClick(R.id.btnSignIn)
    public void onClickSignIn(){
        if (!edtEmail.getText().toString().equals("") && !edtPassword.getText().toString().equals("")){
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.email = edtEmail.getText().toString();
            registerRequest.password = edtPassword.getText().toString();
            presenter.onSignIn(registerRequest);
        }
    }

    @Override
    public void signUpSuccessful(String message) {

    }

    @Override
    public void signInSuccessful(String message) {
        Toast.makeText(SigninActivity.this,message,Toast.LENGTH_SHORT).show();
        Navigator.startHome(this);
        finish();
    }

    @Override
    public void errorOccurred(String message) {
        Toast.makeText(SigninActivity.this,message,Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbindView();
    }

    @Override
    public void startLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void showListObjects(List list) {

    }

    @Override
    public void showObjects(Object o) {

    }

    @Override
    public List getListObjects() {
        return null;
    }

    @Override
    public Object getObjects() {
        return null;
    }

}
