package com.android.saturday.restclient;

import com.android.saturday.restclient.service.GettyImagesAPI;
import com.android.saturday.util.AppConfiguration;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by bhavdip on 9/3/16.
 */
public class RetrofitClient {

    private Retrofit mRetrofitBuilder;

    public RetrofitClient() {
        buildRestAdapter();
    }

    public static RequestBody TypedString(String value) {
        return RequestBody.create(MediaType.parse("text/plain"), value);
    }

    public static RequestBody TypedImageFile(File file) {
        return RequestBody.create(MediaType.parse("image/*"), file);
    }

    private Retrofit getRestAdapter() {
        return mRetrofitBuilder;
    }

    private boolean hasAdapterAvailable() {
        return mRetrofitBuilder != null;
    }

    private void buildRestAdapter() {
        if (mRetrofitBuilder == null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.interceptors().add(new LoggingInterceptor());
            mRetrofitBuilder = new Retrofit.Builder()
                    .baseUrl(AppConfiguration.getBaseHost())
                    .client(okHttpClient)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
    }

    public GettyImagesAPI searchImagesAPI() {
        buildRestAdapter();
        if (hasAdapterAvailable()) {
            return getRestAdapter().create(GettyImagesAPI.class);
        }
        return null;
    }
}
