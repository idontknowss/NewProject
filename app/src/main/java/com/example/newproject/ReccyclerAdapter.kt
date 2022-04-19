package com.example.newproject

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReccyclerAdapter(var arrayList: ArrayList<CommentsItem>):
    RecyclerView.Adapter<ReccyclerAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var emailid:TextView=view.findViewById(R.id.emailid)
        var gender:TextView=view.findViewById(R.id.gender)
        var id:TextView=view.findViewById(R.id.id)
        var names:TextView=view.findViewById(R.id.name)
        //var status:TextView=view.findViewById(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReccyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview, parent, false)
        return ViewHolder(view.rootView)
    }

    override fun onBindViewHolder(holder: ReccyclerAdapter.ViewHolder, position: Int) {
        holder.emailid.setText(arrayList.get(position).title)
        holder.gender.setText(arrayList.get(position).body)
        holder.id.setText(arrayList.get(position).id.toString())
        holder.names.setText(arrayList.get(position).userId.toString())
        //holder.status.setText(arrayList.get(position).status)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}