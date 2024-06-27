package com.smarthouse_mobile.api.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.smarthouse_mobile.api.Api
import com.smarthouse_mobile.api.model.DeviceModelApi
import com.smarthouse_mobile.api.model.HouseModelApi
import com.smarthouse_mobile.api.model.RoomModelApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.UUID

class ApiRepository(
    private val api: Api
) {
    fun fetchAllHouses(): LiveData<List<HouseModelApi>?> {
        val data = MutableLiveData<List<HouseModelApi>?>()

        api.fetchAllHouses().enqueue(object : Callback<List<HouseModelApi>> {

            override fun onFailure(call: Call<List<HouseModelApi>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<HouseModelApi>>,
                response: Response<List<HouseModelApi>>
            ) {

                val res = response.body()
                if (response.code() == 200 && res != null) {
                    data.value = res
                } else {
                    data.value = null
                }
            }
        })
        return data
    }

    fun fetchAllRooms(houseId: UUID): LiveData<List<RoomModelApi>?> {
        val data = MutableLiveData<List<RoomModelApi>?>()

        api.fetchAllRooms(houseId).enqueue(object : Callback<List<RoomModelApi>> {

            override fun onFailure(call: Call<List<RoomModelApi>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<RoomModelApi>>,
                response: Response<List<RoomModelApi>>
            ) {

                val res = response.body()
                if (response.code() == 200 && res != null) {
                    data.value = res
                } else {
                    data.value = null
                }
            }
        })
        return data
    }

    fun fetchAllDevices(houseId: UUID, roomId: UUID): LiveData<List<DeviceModelApi>?> {
        val data = MutableLiveData<List<DeviceModelApi>?>()

        api.fetchAllDevices(houseId, roomId).enqueue(object : Callback<List<DeviceModelApi>> {

            override fun onFailure(call: Call<List<DeviceModelApi>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<DeviceModelApi>>,
                response: Response<List<DeviceModelApi>>
            ) {

                val res = response.body()
                if (response.code() == 200 && res != null) {
                    data.value = res
                } else {
                    data.value = null
                }
            }
        })
        return data
    }

    fun addHouse(houseModelApi: HouseModelApi): LiveData<Void?> {
        val data = MutableLiveData<Void?>()

        api.addHouse(houseModelApi).enqueue(object : Callback<Void?> {

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<Void?>,
                response: Response<Void?>
            ) {
            }
        })
        return data
    }

    fun addRoom(houseId: UUID, roomModelApi: RoomModelApi): LiveData<Void?> {
        val data = MutableLiveData<Void?>()

        api.addRoom(houseId, roomModelApi).enqueue(object : Callback<Void?> {

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<Void?>,
                response: Response<Void?>
            ) {
            }
        })
        return data
    }
    fun addDevice(houseId: UUID, roomId: UUID, deviceModelApi: DeviceModelApi): LiveData<Void?> {
        val data = MutableLiveData<Void?>()

        api.addDevice(houseId, roomId, deviceModelApi).enqueue(object : Callback<Void?> {

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<Void?>,
                response: Response<Void?>
            ) {
            }
        })
        return data
    }                                                                                                                                           fun healthCheck() = api.healthCheck().isExecuted

}