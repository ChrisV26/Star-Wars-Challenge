package com.chris.swapi.viewmodel;

import android.app.Application;

import com.chris.swapi.model.People;
import com.chris.swapi.paging.ItemDataSourceFactory;
import com.chris.swapi.paging.SwapiPeopleDataSource;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class PeopleViewModel extends AndroidViewModel {

    public LiveData<PagedList<People>> itemPagedList;
    LiveData<SwapiPeopleDataSource> swapiPeopleDataSourceLiveData;

    public PeopleViewModel(@NonNull Application application)
    {
        super(application);
        ItemDataSourceFactory itemDataSourceFactory=new ItemDataSourceFactory();
        swapiPeopleDataSourceLiveData=itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config pagedListConfig=(new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(20).build();

        itemPagedList=(new LivePagedListBuilder(itemDataSourceFactory,pagedListConfig))
                .build();


    }

}
