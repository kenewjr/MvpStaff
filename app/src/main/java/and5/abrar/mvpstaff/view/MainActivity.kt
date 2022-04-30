package and5.abrar.mvpstaff.view

import and5.abrar.mvpstaff.R
import and5.abrar.mvpstaff.adapter.AdapterStaff
import and5.abrar.mvpstaff.model.getAllStaffItem
import and5.abrar.mvpstaff.presenter.StafView
import and5.abrar.mvpstaff.presenter.StaffPresenter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),StafView {
    private lateinit var presenter: StaffPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = StaffPresenter(this)
        presenter.getDataStaf()
    }

    override fun onSuccess(pesan: String, staf: List<getAllStaffItem>) {
        rvStaff.layoutManager = LinearLayoutManager(this)
        rvStaff.adapter = AdapterStaff(staf){
            val pindahdata = Intent(this, DetailActvty::class.java)
            pindahdata.putExtra("detailstaf", it)
            startActivity(pindahdata)
        }
    }

    override fun onError(pesan: String) {
        Toast.makeText(this,pesan, Toast.LENGTH_LONG).show()
    }
}