package com.meli.challenge.data.network

import com.meli.challenge.data.models.ResponseSearchModel
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {

    @GET("sites/{site}/search")
    suspend fun searchItemsByQuery(
        @Path("site") site: String,
        @Query("q") search: String
    ): ApiResponse<ResponseSearchModel>

}
