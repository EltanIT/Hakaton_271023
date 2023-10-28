package com.example.hakaton_271023.view.adapter

import android.annotation.SuppressLint
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.ViewTestBaseBinding
import com.example.hakaton_271023.domain.model.TestModel

class TestBaseAdapter(_testsList: ArrayList<TestModel>): RecyclerView.Adapter<TestBaseAdapter.ViewHolder>() {

    private val testsList = _testsList

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ViewTestBaseBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_test_base, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return testsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(testModel: TestModel){
        testsList.add(testModel)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val studyMaterialsModel = testsList[position]
//        holder.binding.numQ.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
//            val DRAWABLE_RIGHT = 2
//            if (motionEvent.action == MotionEvent.ACTION_UP) {
//                if (motionEvent.rawX >= holder.binding.numQ.right - holder.binding.numQ.compoundDrawables[DRAWABLE_RIGHT].bounds.width()
//                ) {
//                    if (!checkPassword) {
//                        binding.password.setCompoundDrawablesWithIntrinsicBounds(
//                            null,
//                            null,
//                            resources.getDrawable(R.drawable.eye_ic),
//                            null
//                        )
//                        binding.password.transformationMethod = null
//                        checkPassword = true
//                    } else {
//                        binding.password.setCompoundDrawablesWithIntrinsicBounds(
//                            null,
//                            null,
//                            resources.getDrawable(R.drawable.eye_slash_ic),
//                            null
//                        )
//                        binding.password.transformationMethod = PasswordTransformationMethod()
//                        checkPassword = false
//                    }
//                    return@OnTouchListener true
//                }
//            }
//            false
//        })

        holder.binding.numQ.text = "Вопрос ${position+1}"
    }
}