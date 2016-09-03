package com.android.saturday;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.android.saturday.adapter.ImagesGridAdapter;
import com.android.saturday.databinding.PhotosDataBinding;
import com.android.saturday.restclient.RetrofitClient;
import com.android.saturday.restclient.pojo.ImagesDao;
import com.android.saturday.restclient.service.GettyImagesAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class PhotosActivity extends AppCompatActivity {

    private GettyImagesAPI mGettyImagesAPI;
    private PhotosDataBinding mPhotosDataBinding;
    private ImagesGridAdapter mImagesGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPhotosDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_photos);
        defineHttpAdapter();
        setUpRecyclerView();
        startFetchingImages();
    }

    private void defineHttpAdapter() {
        RetrofitClient mRetrofitClient = new RetrofitClient();
        mGettyImagesAPI = mRetrofitClient.searchImagesAPI();
    }

    private void setUpRecyclerView() {
        mImagesGridAdapter = new ImagesGridAdapter();
        mPhotosDataBinding.imagesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mPhotosDataBinding.imagesRecyclerView.setHasFixedSize(true);
        mPhotosDataBinding.imagesRecyclerView.setAdapter(mImagesGridAdapter);
    }

    private void startFetchingImages() {
        mPhotosDataBinding.emptyView.setVisibility(View.VISIBLE);
        mPhotosDataBinding.errorHandler.setVisibility(View.GONE);
        Observable<ImagesDao> searchImageCall = mGettyImagesAPI.searchGettyImages("Google");
        searchImageCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ImagesDao>() {
                    @Override
                    public void onCompleted() {
                        mPhotosDataBinding.emptyView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mPhotosDataBinding.emptyView.setVisibility(View.GONE);
                        mPhotosDataBinding.errorHandler.setVisibility(View.VISIBLE);
                        Toast.makeText(PhotosActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ImagesDao imagesDao) {
                        mImagesGridAdapter.addImageItem(imagesDao.getImages());
                        mImagesGridAdapter.notifyDataSetChanged();
                    }
                });
    }
}
