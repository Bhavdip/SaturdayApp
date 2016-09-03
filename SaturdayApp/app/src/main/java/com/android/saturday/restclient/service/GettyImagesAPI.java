package com.android.saturday.restclient.service;

import com.android.saturday.restclient.pojo.ImagesDao;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by bhavdip on 9/3/16.
 */
public interface GettyImagesAPI {

    @FormUrlEncoded
    @GET("v3/search/images?phrase=google")
    Observable<ImagesDao> searchGettyImages(@FieldMap Map<String, Object> params);
}
