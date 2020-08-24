package com.chris.swapi.network;

import com.chris.swapi.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create a Retrofit Instance
 */
public class RetrofitInstance {

    private static Retrofit retrofit;
    private static RetrofitInstance retrofitInstance;

    private RetrofitInstance()
    {
        // HTTP interceptor for debugging purposes
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().
                addInterceptor(interceptor).
                build();

        if(retrofit==null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public static synchronized RetrofitInstance getRetrofitInstance()
    {
        if(retrofitInstance==null)
        {
            retrofitInstance=new RetrofitInstance();
        }
        return retrofitInstance;
    }

    public ApiEndpoint getStarWarsAPI()
    {
        return retrofit.create(ApiEndpoint.class);
    }

}
