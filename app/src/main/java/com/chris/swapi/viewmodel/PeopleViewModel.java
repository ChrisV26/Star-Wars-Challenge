package com.chris.swapi.viewmodel;

import android.app.Application;

import com.chris.swapi.model.SWModelList;
import com.chris.swapi.network.StarWarsRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class PeopleViewModel extends AndroidViewModel {

    private StarWarsRepository starWarsRepository;
    private LiveData<SWModelList> swModelListLiveData;
    private int DEFAULT_PAGE=1;
    private int page=DEFAULT_PAGE;


    public PeopleViewModel(@NonNull Application application)
    {
        super(application);
        starWarsRepository=new StarWarsRepository();
        swModelListLiveData=starWarsRepository.showCharacters();

    }
    public LiveData<SWModelList> getSWModelListResponseLiveData()
    {
        return swModelListLiveData;
    }

}
