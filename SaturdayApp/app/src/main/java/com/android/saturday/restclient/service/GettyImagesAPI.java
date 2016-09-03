package com.android.saturday.restclient.service;

import com.android.saturday.restclient.pojo.ImagesDao;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bhavdip on 9/3/16.
 */
public interface GettyImagesAPI {

    @GET("/v3/search/images")
    Observable<ImagesDao> searchGettyImages(@Query("phrase") String phase);

    @GET("/v3/search/images?phrase=google")
    Call<ImagesDao> searchGettyImages2();
}
