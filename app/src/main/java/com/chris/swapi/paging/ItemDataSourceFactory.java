package com.chris.swapi.paging;

import com.chris.swapi.model.People;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class ItemDataSourceFactory extends DataSource.Factory<Integer,People> {

    public MutableLiveData<SwapiPeopleDataSource> getItemLiveDataSource() {
        return itemLiveDataSource;
    }

    private MutableLiveData<SwapiPeopleDataSource> itemLiveDataSource=new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource<Integer,People> create() {

        SwapiPeopleDataSource swapiPeopleDataSource=new SwapiPeopleDataSource();

        itemLiveDataSource.postValue(swapiPeopleDataSource);

        return swapiPeopleDataSource;
    }
}
