package com.example.hakaton_271023.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.ViewCommonStudyMaterialsBinding
import com.example.hakaton_271023.databinding.ViewCommonStudyMaterialsOneBinding
import com.example.hakaton_271023.domain.model.StudyMaterialsModel
import com.example.hakaton_271023.domain.model.TestModel

class CommonStudyMaterialOneAdapter(_testList: ArrayList<TestModel>): RecyclerView.Adapter<CommonStudyMaterialOneAdapter.ViewHolder>() {

    private val testList = _testList

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ViewCommonStudyMaterialsOneBinding.bind(itemView)
        val resources = itemView.resources

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_common_study_materials_one, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return testList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val testModel = testList.get(position)

        if (position%2 != 0 && !holder.binding.view.isSelected){
            holder.binding.view.setBackgroundColor(holder.resources.getColor(R.color.Neutral_0))
        }

    }
}