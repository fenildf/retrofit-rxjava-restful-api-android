package tpcreative.co.retrofit_rxjava_restfulapi_android.common;
import java.util.Map;
import co.tpcreative.common.api.response.BaseResponse;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import tpcreative.co.retrofit_rxjava_restfulapi_android.common.response.LoginResponse;


public interface API {

    String SIGN_UP = "/task_manager/v1/register";
    String SIGN_IN = "/task_manager/v1/v2/login";

    @FormUrlEncoded
    @POST(SIGN_UP)
    Observable<BaseResponse> onSignUP(@FieldMap Map<String,String>request);

    @FormUrlEncoded
    @POST(SIGN_IN)
    Observable<LoginResponse> onSignIn(@FieldMap Map<String,String>request);

}
