package and5.abrar.mvpstaff.adapter

import and5.abrar.mvpstaff.R
import and5.abrar.mvpstaff.model.getAllStaffItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_staff.view.*

class AdapterStaff(private val dataStaff : List<getAllStaffItem>,
    private var onclick :(getAllStaffItem)->Unit): RecyclerView.Adapter<AdapterStaff.ViewHolder>() {
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewitem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_staff,parent, false)
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.cardStaff.setOnClickListener {
            onclick(dataStaff!![position])
        }
        Glide.with(holder.itemView.context)
            .load(dataStaff!![position].image)
            .into(holder.itemView.gambarStaff)
        holder.itemView.namaStaff.text = dataStaff!![position].name
        holder.itemView.emailStaff.text = dataStaff!![position].email
    }

    override fun getItemCount(): Int {
       return dataStaff.size
    }
}