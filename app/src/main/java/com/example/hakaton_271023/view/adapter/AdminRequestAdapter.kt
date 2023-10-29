package com.example.hakaton_271023.view.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.ViewAdminRequestBinding
import com.example.hakaton_271023.domain.model.RequestModel

class AdminRequestAdapter(_requestList: List<RequestModel>): RecyclerView.Adapter<AdminRequestAdapter.ViewHolder>() {

    private val requestList = _requestList

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ViewAdminRequestBinding.bind(itemView)

        val resource: Resources = itemView.resources

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_admin_request, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return requestList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val requestModel = requestList[position]

        holder.binding.name.text = requestModel.name

        if (!requestModel.state){
            holder.binding.stateIc.setImageDrawable(holder.resource.getDrawable(R.drawable.state_request_ic))
            holder.binding.state.setTextColor(holder.resource.getColor(R.color.Neutral_400))
        }
        else{
            holder.binding.stateIc.setImageDrawable(holder.resource.getDrawable(R.drawable.state_request_ic))
            holder.binding.state.setTextColor(holder.resource.getColor(R.color.Neutral_800))
        }


    }
}