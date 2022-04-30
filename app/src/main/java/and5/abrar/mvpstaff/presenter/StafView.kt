package and5.abrar.mvpstaff.presenter

import and5.abrar.mvpstaff.model.getAllStaffItem

interface StafView {
    fun onSuccess(pesan:String,staf:List<getAllStaffItem>)
    fun onError(pesan: String)
}