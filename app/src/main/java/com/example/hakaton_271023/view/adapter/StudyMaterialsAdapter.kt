package com.example.hakaton_271023.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.ViewStudyMaterialsBinding
import com.example.hakaton_271023.domain.model.StudyMaterialsModel

class StudyMaterialsAdapter(_studyMaterialsList: List<StudyMaterialsModel>): RecyclerView.Adapter<StudyMaterialsAdapter.ViewHolder>() {

    private val studyMaterialList = _studyMaterialsList

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ViewStudyMaterialsBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_study_materials, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studyMaterialList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val studyMaterialsModel = studyMaterialList.get(position)


    }
}