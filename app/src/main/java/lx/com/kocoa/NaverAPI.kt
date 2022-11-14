package lx.com.kocoa

import android.text.Editable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverAPI {
    //길찾기
    @GET("map-direction/v1/driving")
    fun getPath(
        @Header("X-NCP-APIGW-API-KEY-ID") apiKeyID: String,
        @Header("X-NCP-APIGW-API-KEY") apiKey: String,
        @Query("start") start: String,
        @Query("goal") goal: String
    ): Call<RouteResponse>

    //지도 이동
    @GET("map-geocode/v2/geocode")
    fun getMap(
        @Header("X-NCP-APIGW-API-KEY-ID") apiKeyID: String,
        @Header("X-NCP-APIGW-API-KEY") apiKey: String,
        @Query("query") query: String
    ): Call<MapResponse>
}