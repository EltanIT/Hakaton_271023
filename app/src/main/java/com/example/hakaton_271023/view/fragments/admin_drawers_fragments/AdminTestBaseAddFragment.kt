package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.hakaton_271023.databinding.FragmentAdminTestBaseAddBinding
import com.example.hakaton_271023.domain.model.QuestionModel
import com.example.hakaton_271023.domain.model.TestModel
import com.example.hakaton_271023.domain.usecase.CreateTestUseCase
import com.example.hakaton_271023.view.adapter.TestBaseAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AdminTestBaseAddFragment : Fragment() {

    private lateinit var binding: FragmentAdminTestBaseAddBinding
    private lateinit var adapter: TestBaseAdapter
    private val modulesList = ArrayList<String>()
    private lateinit var testModel: TestModel
    private val questionList = ArrayList<QuestionModel>()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val createTestUseCase = CreateTestUseCase()

    interface TestBaseAdapterListener{
        fun execute(questionModel: QuestionModel)
    }

    lateinit var testBaseAdapterListener: TestBaseAdapterListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminTestBaseAddBinding.inflate(layoutInflater)

        binding.add.setOnClickListener{

        }

        setting()

        return binding.root
    }

    private fun setting() {
        testBaseAdapterListener = object : TestBaseAdapterListener{
            override fun execute(questionModel: QuestionModel) {

            }

        }

        modulesList.add("Выберите пункт")
        modulesList.add("module1")
        modulesList.add("module2")
        modulesList.add("module3")
        modulesList.add("module4")

        questionList.add(QuestionModel("", 0, "", "", "", "", ""))

        adapter = TestBaseAdapter(questionList, testBaseAdapterListener)

        binding.rvTests.adapter = adapter
        binding.moduleSpinner.adapter = ArrayAdapter(requireContext(), androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, modulesList)


        binding.add.setOnClickListener{
            val questions = ArrayList<Map<*,*>>()
            for (i in questionList){
                questions.add(mapOf("text" to i._text,
                    "score" to i.score,
                    "correct" to i.correct,
                    "a" to i._a,
                    "b" to i._b,
                    "c" to i._c,
                    "d" to i._d,))
            }

            testModel = TestModel(binding.name.text.toString(),
                binding.moduleSpinner.selectedItem as String, questions)
            createTestUseCase.execute(testModel = testModel, requireContext())
            adapter.addItem(QuestionModel("", 0, "", "", "", "", ""))
        }
    }

    fun postTest(){
        coroutineScope.launch {
//            val testModel = TestModel(binding.name.text.toString(), binding.moduleSpinner.selectedItem.toString(), )
//            val result = createTestUseCase.execute(,requireContext())
            withContext(Dispatchers.Main){
//                Toast.makeText(context, result.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

}