package and5.abrar.mvpstaff.presenter

import and5.abrar.mvpstaff.model.getAllStaffItem
import and5.abrar.mvpstaff.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StaffPresenter(val stafView: StafView) {
    fun getDataStaf(){
        ApiClient.instance.getAllStaff()
            .enqueue(object : Callback<List<getAllStaffItem>> {
                override fun onResponse(
                    call: Call<List<getAllStaffItem>>,
                    response: Response<List<getAllStaffItem>>
                ) {
                    if (response.isSuccessful){
                        stafView.onSuccess(response.message(),response.body()!!)
                    }else{
                        stafView.onError(response.message())

                    }

                }

                override fun onFailure(call: Call<List<getAllStaffItem>>, t: Throwable) {
                    stafView.onError(t.message!!)
                }

            })
    }
}