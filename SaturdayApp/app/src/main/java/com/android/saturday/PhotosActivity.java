package com.android.saturday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.saturday.restclient.RetrofitClient;
import com.android.saturday.restclient.pojo.ImagesDao;
import com.android.saturday.restclient.service.GettyImagesAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class PhotosActivity extends AppCompatActivity {

    private GettyImagesAPI mGettyImagesAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        setUpRecyclerView();
        setUpAdapter();
    }

    private void setUpAdapter() {
        RetrofitClient mRetrofitClient = new RetrofitClient();
        mGettyImagesAPI = mRetrofitClient.searchImagesAPI();
    }

    private void setUpRecyclerView() {

    }

    private void startFetchingImages() {
        Map<String, Object> requestHeader = new HashMap<>();
        Observable<ImagesDao> searchImageCall = mGettyImagesAPI.searchGettyImages(requestHeader);
        searchImageCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ImagesDao>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ImagesDao imagesDao) {

                    }
                });
    }
}
