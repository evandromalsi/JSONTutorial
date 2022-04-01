package com.example.jsontutorial.api;

import com.example.jsontutorial.model.ResponseContacts;

import retrofit2.Call;
import retrofit2.http.GET;


public interface Api {
    String BASE_URL = "https://api.androidhive.info/";
    @GET("contacts/")
    Call<ResponseContacts> getContact();
}
