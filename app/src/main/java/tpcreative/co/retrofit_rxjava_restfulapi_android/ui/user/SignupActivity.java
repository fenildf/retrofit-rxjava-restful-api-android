package tpcreative.co.retrofit_rxjava_restfulapi_android.ui.user;
import android.content.Context;
import android.support.v7.app.ActionBar;
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
import tpcreative.co.retrofit_rxjava_restfulapi_android.common.request.RegisterRequest;

public class SignupActivity extends BaseActivity implements UserView {

    private ActionBar actionBar;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private UserPresenter presenter;
    @BindView(R.id.edtEmail)
    FontEditText edtEmail;
    @BindView(R.id.edtPassword)
    FontEditText edtPassword;
    @BindView(R.id.edtName)
    FontEditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setChangeFontTitle(getResources().getString(R.string.lbSignUp));
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        presenter = new UserPresenter();
        presenter.bindView(this);

    }

    @OnClick(R.id.btnSignUp)
    public void onClickSignUp(){
        if (!edtEmail.getText().toString().equals("") && !edtPassword.getText().toString().equals("") && !edtName.getText().toString().equals("")){
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.email = edtEmail.getText().toString();
            registerRequest.password = edtPassword.getText().toString();
            registerRequest.name = edtName.getText().toString();
            presenter.onSignUp(registerRequest);
        }
    }

    @Override
    public void signUpSuccessful(String message) {
        Toast.makeText(SignupActivity.this,message,Toast.LENGTH_SHORT).show();
        finish();
    }


    @Override
    public void signInSuccessful(String message) {

    }

    @OnClick(R.id.btnSignIn)
    public void onClickSignIn(){
        finish();
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
    public void errorOccurred(String message) {
        Toast.makeText(SignupActivity.this,message,Toast.LENGTH_SHORT).show();
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
