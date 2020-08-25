package com.chris.swapi.network;

import com.chris.swapi.model.SWModelList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *  Define endpoint
 */
public interface ApiEndpoint {

    // ex: https://swapi.dev/api/people/?page
    @GET("people/")
    Call<SWModelList> getAllPeople(@Query("page") int page);

}
