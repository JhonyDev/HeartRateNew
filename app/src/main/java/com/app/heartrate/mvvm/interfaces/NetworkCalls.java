package com.app.heartrate.mvvm.interfaces;


import com.app.heartrate.mvvm.capsules.request.PostFormData;
import com.app.heartrate.mvvm.capsules.request.PostLoginPojo;
import com.app.heartrate.mvvm.capsules.request.PostRegPojo;
import com.app.heartrate.mvvm.capsules.response.HistoryPojo;
import com.app.heartrate.mvvm.capsules.response.PredicationRespCapsule;
import com.app.heartrate.mvvm.capsules.response.RegResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface NetworkCalls {

    @POST(Urls.URL_LOGIN)
    Call<RegResponse> postLogin(@Body PostLoginPojo postRegPojo);

    @POST(Urls.URL_REG)
    Call<RegResponse> postAuth(@Body PostRegPojo postRegPojo);

    @GET(Urls.URL_PREV_HISTORY)
    Call<List<HistoryPojo>> getHistory(@Header("Authorization") String token);

    @POST(Urls.URL_PREV_HISTORY)
    Call<PredicationRespCapsule> postPrediction(@Header("Authorization") String token,
                                                @Body PostFormData postFormData);

}
