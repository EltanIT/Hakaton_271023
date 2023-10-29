package com.example.hakaton_271023.view.adapter

import android.annotation.SuppressLint
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.ViewTestBaseBinding
import com.example.hakaton_271023.domain.model.QuestionModel
import com.example.hakaton_271023.domain.model.TestModel
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminTestBaseAddFragment

class TestBaseAdapter(_testsList: ArrayList<QuestionModel>, _testBaseAdapterListener: AdminTestBaseAddFragment.TestBaseAdapterListener): RecyclerView.Adapter<TestBaseAdapter.ViewHolder>() {

    private val testsList = _testsList

    private val correct = -1

    private var state_a = false
    private var state_b = false
    private var state_c = false
    private var state_d = false

    val testBaseAdapterListener = _testBaseAdapterListener

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ViewTestBaseBinding.bind(itemView)
        val resources = itemView.resources
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_test_base, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return testsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(testModel: QuestionModel){
        testsList.add(testModel)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val studyMaterialsModel = testsList[position]

        holder.binding.answer1.setOnTouchListener(OnTouchListener { view, motionEvent ->
            val DRAWABLE_RIGHT = 2
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                if (motionEvent.rawX >= holder.binding.answer1.right - holder.binding.answer1.compoundDrawables[DRAWABLE_RIGHT].bounds.width()
                ) {
                    if (!holder.binding.answer1.isSelected) {
                        holder.binding.answer1.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_true_ic),
                            null
                        )
                        holder.binding.answer2.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer3.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer4.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer1.transformationMethod = null
                        holder.binding.answer1.isSelected = true
                        holder.binding.answer2.isSelected = false
                        holder.binding.answer3.isSelected = false
                        holder.binding.answer4.isSelected = false

                        studyMaterialsModel.correct = holder.binding.answer1.text.toString()
                    }
                    return@OnTouchListener true
                }
            }
            false
        })
        holder.binding.answer2.setOnTouchListener(OnTouchListener { view, motionEvent ->
            val DRAWABLE_RIGHT = 2
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                if (motionEvent.rawX >= holder.binding.answer2.right - holder.binding.answer2.compoundDrawables[DRAWABLE_RIGHT].bounds.width()
                ) {
                    if (!holder.binding.answer2.isSelected) {
                        holder.binding.answer2.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_true_ic),
                            null
                        )
                        holder.binding.answer1.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer3.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer4.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer2.transformationMethod = null

                        holder.binding.answer2.isSelected = true
                        holder.binding.answer1.isSelected = false
                        holder.binding.answer3.isSelected = false
                        holder.binding.answer4.isSelected = false

                    }
                    return@OnTouchListener true
                }
            }
            false
        })
        holder.binding.answer3.setOnTouchListener(OnTouchListener { view, motionEvent ->
            val DRAWABLE_RIGHT = 2
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                if (motionEvent.rawX >= holder.binding.answer3.right - holder.binding.answer3.compoundDrawables[DRAWABLE_RIGHT].bounds.width()
                ) {
                    if (!holder.binding.answer3.isSelected) {
                        holder.binding.answer3.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_true_ic),
                            null
                        )
                        holder.binding.answer1.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer2.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer4.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer3.transformationMethod = null
                        holder.binding.answer3.isSelected = true
                        holder.binding.answer2.isSelected = false
                        holder.binding.answer1.isSelected = false
                        holder.binding.answer4.isSelected = false

                    }
                    return@OnTouchListener true
                }
            }
            false
        })
        holder.binding.answer4.setOnTouchListener(OnTouchListener { view, motionEvent ->
            val DRAWABLE_RIGHT = 2
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                if (motionEvent.rawX >=  holder.binding.answer4.right -  holder.binding.answer4.compoundDrawables[DRAWABLE_RIGHT].bounds.width()
                ) {
                    if (!holder.binding.answer4.isSelected) {
                        holder.binding.answer4.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_true_ic),
                            null
                        )
                        holder.binding.answer1.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer2.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer1.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            holder.resources.getDrawable(R.drawable.alert_succes_ic),
                            null
                        )
                        holder.binding.answer4.transformationMethod = null
                        holder.binding.answer4.isSelected = true
                        holder.binding.answer2.isSelected = false
                        holder.binding.answer3.isSelected = false
                        holder.binding.answer1.isSelected = false

                    }
                    return@OnTouchListener true
                }
            }
            false
        })

        holder.binding.numQ.text = "Вопрос ${position+1}"
    }
}