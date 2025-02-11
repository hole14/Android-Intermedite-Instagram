package com.example.myinstagram.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstagram.R
import de.hdodenhof.circleimageview.CircleImageView

class AdapterStatus(private val list: ArrayList<tampilan>): RecyclerView.Adapter<AdapterStatus.listViewHolder>() {

    interface itemDiklik{
        fun clikItem(data: tampilan)
    }

    private var click: itemDiklik? = null

    fun set(itemAja: itemDiklik){
        this.click = itemAja
    }

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
    }

    class listViewHolder(lihat: View): RecyclerView.ViewHolder(lihat) {
        val judul: TextView = lihat.findViewById(R.id.judul)
        val pp: CircleImageView = lihat.findViewById(R.id.pp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listViewHolder {
        val tampil: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_status, parent, false)
        return listViewHolder(tampil)
    }

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        val (judul, image) = list[position]
        holder.judul.text = judul
        holder.pp.setImageResource(image)
    }

    override fun getItemCount(): Int = list.size
}
data class tampilan(
    val judul: String,
    val image: Int
)