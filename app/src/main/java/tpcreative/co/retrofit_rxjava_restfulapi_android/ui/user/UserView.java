package tpcreative.co.retrofit_rxjava_restfulapi_android.ui.user;
import co.tpcreative.common.presenter.BaseView;

public interface UserView extends BaseView {
    void signInSuccessful(String message);
    void signUpSuccessful(String message);
    void errorOccurred(String message);
}
