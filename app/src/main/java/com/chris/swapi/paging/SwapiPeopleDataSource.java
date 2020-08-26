package com.chris.swapi.paging;

import com.chris.swapi.model.People;
import com.chris.swapi.model.SWModelList;
import com.chris.swapi.network.RetrofitInstance;

import java.io.IOException;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *  Incremental data loader for page-keyed content,
 *  where requests return keys for next/previous pages.
 */
public class SwapiPeopleDataSource extends PageKeyedDataSource<Integer, People> {

    // variable to query the first page
    private static final int FIRST_PAGE = 1;

    /**
     * Sync request in order to load the initial page of data
     */
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, People> callback) {
       Call<SWModelList> request;
       request= RetrofitInstance.getRetrofitInstance().getStarWarsAPI().getAllPeople(FIRST_PAGE);
       try {
           Response<SWModelList> response=request.execute();
           SWModelList data=response.body();
           List<People> peopleList= data != null ? data.getResults() : null;
           callback.onResult(peopleList,null,FIRST_PAGE+1);
       } catch (IOException e) {
           e.getMessage();
       }
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, People> callback) {
        // not utilized since we append only to initial load
    }

    /**
     * Async request in order to fetch the next pages of data
     */
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, People> callback) {
        RetrofitInstance.getRetrofitInstance().getStarWarsAPI().getAllPeople(params.key)
                .enqueue(new Callback<SWModelList>() {
                    @Override
                    public void onResponse(Call<SWModelList> call, Response<SWModelList> response) {
                        if(response.body()!=null)
                        {
                            callback.onResult(response.body().getResults(),params.key+1);
                        }
                    }

                    @Override
                    public void onFailure(Call<SWModelList> call, Throwable t) {
                        t.getMessage();
                    }
                });
    }
}
