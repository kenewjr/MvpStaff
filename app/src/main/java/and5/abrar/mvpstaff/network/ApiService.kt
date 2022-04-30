package and5.abrar.mvpstaff.network

import and5.abrar.mvpstaff.model.getAllStaffItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("staf")
    fun getAllStaff(): Call<List<getAllStaffItem>>
}