package and5.abrar.mvpstaff.view

import and5.abrar.mvpstaff.R
import and5.abrar.mvpstaff.model.getAllStaffItem
import and5.abrar.mvpstaff.presenter.StafDetailPresenter
import and5.abrar.mvpstaff.presenter.StafDetailView
import and5.abrar.mvpstaff.presenter.StafView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_actvty.*

class DetailActvty : AppCompatActivity(),StafDetailView {
    private lateinit var presenter : StafDetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_actvty)
        val detailstaf = intent.getSerializableExtra("detailstaf") as getAllStaffItem
        presenter = StafDetailPresenter(this,detailstaf)
        presenter.getStafDetail()
    }

    override fun onProcessed(detail: getAllStaffItem) {
        tvEmail.text = detail.email
        tvNama.text = detail.name
        tvTgl.text = detail.createdAt
        Glide.with(this).load(detail.image).into(imgdetail)
    }
}