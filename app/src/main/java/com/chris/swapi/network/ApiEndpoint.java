package com.chris.swapi.network;

import com.chris.swapi.model.SWModelList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *  Define endpoint-> ex: https://swapi.dev/api/people/
 */
public interface ApiEndpoint {

    @GET("people/")
    Call<SWModelList> getAllPeople(@Query("page") int page);

}
