package com.chris.swapi.network;

import com.chris.swapi.model.SWModelList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 *  Define endpoint-> ex: https://swapi.dev/api/people/
 */
public interface StarWarsApiEndpoint {

    @GET("people/")
    Call<SWModelList> getAllPeople();
}
