package com.chris.swapi.network;

import android.util.Log;
import com.chris.swapi.model.SWModelList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Service Repository for loading data from SWAPI
 */

public class ServiceRepository {

    private static final String TAG= ServiceRepository.class.getSimpleName();

    private ApiEndpoint apiEndpoint;
    private MutableLiveData<SWModelList> swModelListMutableLiveData;

    public ServiceRepository(){
        apiEndpoint =RetrofitInstance.getRetrofitInstance().getStarWarsAPI();
    }

    /**
     *  Async request and Observe the response with Live Data
     */
    public LiveData<SWModelList> showCharacters(int page)
    {
        swModelListMutableLiveData=new MutableLiveData<>();
        apiEndpoint.getAllPeople(page)
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
