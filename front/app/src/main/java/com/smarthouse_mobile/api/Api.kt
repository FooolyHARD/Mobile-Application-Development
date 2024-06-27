package com.smarthouse_mobile.api

import com.smarthouse_mobile.api.model.DeviceModelApi
import com.smarthouse_mobile.api.model.HouseModelApi
import com.smarthouse_mobile.api.model.RoomModelApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.UUID

interface Api {
    @GET("")
    fun healthCheck(): Call<Void>

    @GET("houses/")
    fun fetchAllHouses(): Call<List<HouseModelApi>>

    @GET("houses/{houseId}/rooms")
    fun fetchAllRooms(houseId: UUID): Call<List<RoomModelApi>>

    @GET("houses/{houseId}/rooms/{roomdId}/devices/")
    fun fetchAllDevices(houseId: UUID, roomId: UUID): Call<List<DeviceModelApi>>

    @POST("houses/")
    fun addHouse(houseModelApi: HouseModelApi): Call<Void>

    @POST("houses/{houseId}/rooms")
    fun addRoom(houseId: UUID, roomModelApi: RoomModelApi): Call<Void>

    @POST("houses/{houseId}/rooms/{roomdId}/devices/")
    fun addDevice(houseId: UUID, roomId: UUID, deviceModelApi: DeviceModelApi): Call<Void>
}