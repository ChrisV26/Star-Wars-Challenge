package com.chris.swapi.network;

import android.util.Log;

import com.chris.swapi.model.SWModelList;
import com.chris.swapi.utils.Constants;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Service Repository for loading data from SWAPI
 */


public class StarWarsRepository {

    private static final String TAG=StarWarsRepository.class.getSimpleName();

    private StarWarsApiEndpoint starWarsApiEndpoint;
    private MutableLiveData<SWModelList> swModelListMutableLiveData;

    public StarWarsRepository(){
        // HTTP interceptor for debugging purposes
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        starWarsApiEndpoint=new retrofit2.Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StarWarsApiEndpoint.class);

    }

    public LiveData<SWModelList> showCharacters()
    {
        swModelListMutableLiveData=new MutableLiveData<>();
        starWarsApiEndpoint.getAllPeople()
                .enqueue(new Callback<SWModelList>() {
                    @Override
                    public void onResponse(Call<SWModelList> call, Response<SWModelList> response) {
                        if(response.body()!=null)
                        {
                            swModelListMutableLiveData.postValue(response.body());
                            Log.d(TAG, String.valueOf(response.body().getResults()));
                        }
                        else
                        {
                            Log.d(TAG, String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<SWModelList> call, Throwable t) {
                        swModelListMutableLiveData.postValue(null);
                        Log.e(TAG,t.getMessage());
                    }
                });
        return swModelListMutableLiveData;
    }

}
