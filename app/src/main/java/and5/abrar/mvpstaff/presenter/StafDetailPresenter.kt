package and5.abrar.mvpstaff.presenter

import and5.abrar.mvpstaff.model.getAllStaffItem

class StafDetailPresenter(private val detailView: StafDetailView,private val detailStaf : getAllStaffItem) {
    fun getStafDetail(){
        detailView.onProcessed(detailStaf)
    }
}