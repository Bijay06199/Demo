package com.example.gyankunj.ui.home.practiceSet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.ui.home.practiceSet.adapter.PracticeSetQuestionsAdapter
import com.example.gyankunj.ui.home.practiceSet.model.PracticeSetQuestionsModel
import kotlinx.android.synthetic.main.activity_random_quiz.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PracticeSetActivity : BaseActivity<com.example.gyankunj.databinding.ActivityPracticeSetBinding,PracticeSetViewModel>() {
    override fun getLayoutId(): Int =R.layout.activity_practice_set
    override fun getViewModel(): PracticeSetViewModel =practicesetViewModel
    private val practicesetViewModel:PracticeSetViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
    lateinit var practiceSetQuestionsAdapter: PracticeSetQuestionsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpRecyclerView()
        initView()

    }

    private fun initView() {
        with(viewDataBinding){
          topAppBar.setNavigationOnClickListener {
              finish()
          }
        }
    }

    private fun setUpRecyclerView() {
        with(viewDataBinding){
            practiceSetQuestionsAdapter= PracticeSetQuestionsAdapter()
            recyclerViewPracticeSetQuestions.adapter=practiceSetQuestionsAdapter
            var itemList=ArrayList<PracticeSetQuestionsModel>()

            itemList.add(PracticeSetQuestionsModel("1","Which one of these dont affect the exposure of a digital photography","ISO",
            "Aperture","RAW","Shutter Speed"))

            itemList.add(PracticeSetQuestionsModel("1","Which one of these dont affect the exposure of a digital photography","ISO",
                "Aperture","RAW","Shutter Speed"))
            itemList.add(PracticeSetQuestionsModel("1","Which one of these dont affect the exposure of a digital photography","ISO",
                "Aperture","RAW","Shutter Speed"))
            itemList.add(PracticeSetQuestionsModel("1","Which one of these dont affect the exposure of a digital photography","ISO",
                "Aperture","RAW","Shutter Speed"))
            itemList.add(PracticeSetQuestionsModel("1","Which one of these dont affect the exposure of a digital photography","ISO",
                "Aperture","RAW","Shutter Speed"))

            practiceSetQuestionsAdapter.addAll(itemList)



        }
    }
}