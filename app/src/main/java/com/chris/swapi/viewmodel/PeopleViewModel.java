package com.chris.swapi.viewmodel;

import android.app.Application;

import com.chris.swapi.adapter.ItemDataSourceFactory;
import com.chris.swapi.adapter.SwapiPeopleDataSource;
import com.chris.swapi.model.People;
import com.chris.swapi.model.SWModelList;
import com.chris.swapi.network.ServiceRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class PeopleViewModel extends AndroidViewModel {

    private ServiceRepository serviceRepository;
    private LiveData<SWModelList> swModelListLiveData;
    private int DEFAULT_PAGE=1;
    private int page=DEFAULT_PAGE;

    public LiveData<PagedList<People>> itemPagedList;
    LiveData<SwapiPeopleDataSource> swapiPeopleDataSourceLiveData;

    public PeopleViewModel(@NonNull Application application)
    {
        super(application);
       /* serviceRepository =new ServiceRepository();
        swModelListLiveData= serviceRepository.showCharacters(page);*/

        ItemDataSourceFactory itemDataSourceFactory=new ItemDataSourceFactory();

        swapiPeopleDataSourceLiveData=itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config pagedListConfig=(new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(20).build();

        itemPagedList=(new LivePagedListBuilder(itemDataSourceFactory,pagedListConfig))
                .build();


    }
    public LiveData<SWModelList> getSWModelListResponseLiveData()
    {
        return swModelListLiveData;
    }

}
