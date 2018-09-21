package com.example.konye.lingo.di.module;

import android.content.Context;

import com.example.konye.lingo.data.ApiService;
import com.example.konye.lingo.di.qaulifier.AppContext;
import com.example.konye.lingo.di.scope.AppScope;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private Context context;


    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @AppScope
    @AppContext
    public Context providesContext() {
        return context;
    }

    @Provides
    @AppScope
    Retrofit getRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(ApiService.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient(getHttpLoggingInterceptor()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @AppScope
    OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(chain -> {
                    Request request = chain.request().newBuilder().addHeader("Connection",
                            "close").build();
                    return chain.proceed(request);
                })
                .readTimeout(150, TimeUnit.SECONDS)
                .connectTimeout(150, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @AppScope
    HttpLoggingInterceptor getHttpLoggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @AppScope
    public ApiService providesApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }
}
