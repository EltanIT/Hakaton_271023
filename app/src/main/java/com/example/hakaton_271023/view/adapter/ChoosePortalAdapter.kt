package com.example.hakaton_271023.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.ViewChoosePortalBinding
import com.example.hakaton_271023.databinding.ViewCommonStudyMaterialsBinding
import com.example.hakaton_271023.domain.model.OurPortalModel
import com.example.hakaton_271023.domain.model.PortalModel
import com.example.hakaton_271023.domain.model.StudyMaterialsModel
import com.example.hakaton_271023.view.fragments.ChoosePortalFragment
import com.example.hakaton_271023.view.fragments.common_drawers_fragmnets.CommonStudyMaterialsFragment

class ChoosePortalAdapter(_portalList: List<PortalModel>, _choosePortalAdapterListener: ChoosePortalFragment.ChoosePortalAdapterListener): RecyclerView.Adapter<ChoosePortalAdapter.ViewHolder>() {

    private val portalList = _portalList
    private val choosePortalAdapterListener = _choosePortalAdapterListener

    private val allState = false
    private var stateId = -1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ViewChoosePortalBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_choose_portal, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return portalList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val portalModel = portalList[position]

        holder.binding.clickView.isSelected = position == stateId

        holder.binding.name.text = portalModel.name

        holder.binding.clickView.setOnClickListener{
            stateId = holder.adapterPosition
            choosePortalAdapterListener.execute(portalModel)
            notifyDataSetChanged()
        }


    }
}