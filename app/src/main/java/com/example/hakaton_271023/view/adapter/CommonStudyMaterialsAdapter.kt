package com.example.hakaton_271023.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.ViewCommonStudyMaterialsBinding
import com.example.hakaton_271023.domain.model.StudyMaterialsModel
import com.example.hakaton_271023.view.fragments.common_drawers_fragmnets.CommonStudyMaterialsFragment

class CommonStudyMaterialsAdapter(_studyMaterialsList: List<StudyMaterialsModel>, _studyMaterialsAdapterListener: CommonStudyMaterialsFragment.StudyMaterialsAdapterListener): RecyclerView.Adapter<CommonStudyMaterialsAdapter.ViewHolder>() {

    private val studyMaterialList = _studyMaterialsList
    private val studyMaterialsAdapterListener = _studyMaterialsAdapterListener

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ViewCommonStudyMaterialsBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_common_study_materials, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studyMaterialList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val studyMaterialsModel = studyMaterialList.get(position)



        holder.binding.showMore.setOnClickListener{
            studyMaterialsAdapterListener.execute()
        }


    }
}