package com.example.gyankunj.ui.home.mycourse.chapter.topics.formulas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseFragment
import com.example.gyankunj.databinding.FragmentFormulaBinding
import com.example.gyankunj.ui.home.mycourse.chapter.topics.formulas.adapter.FormulaAdapter
import com.example.gyankunj.ui.home.mycourse.chapter.topics.formulas.model.FormulaModel
import kotlinx.coroutines.channels.BroadcastChannel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Math.pow
import java.text.Normalizer


class FormulaFragment : BaseFragment<FragmentFormulaBinding,FormulaViewModel>() {
    override fun getLayoutId(): Int =R.layout.fragment_formula
    override fun getViewModel(): FormulaViewModel =formulaViewModel
    private val formulaViewModel:FormulaViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
    lateinit var formulaAdapter: FormulaAdapter





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        with(viewDataBinding){


            formulaAdapter= FormulaAdapter()
            recyclerviewFormula.adapter=formulaAdapter
            var itemList=ArrayList<FormulaModel>()
            itemList.add(FormulaModel(R.drawable.square_image,"Square","Length(l)*Lenght(l)","4* Length(l)"))
            itemList.add(FormulaModel(R.drawable.square_image,"Rectangle","Length(l)*breadth(b)","4* Length(l)"))
            itemList.add(FormulaModel(R.drawable.square_image,"Triangle","Length(l)*breadth(b)","4* Length(l)"))
            itemList.add(FormulaModel(R.drawable.square_image,"Pentagon","Length(l)*breadth(b)","4* Length(l)"))

            formulaAdapter.addAll(itemList)
        }
    }

    companion object{

        fun start(activity:FragmentActivity,containerId:Int){
            val fragment=FormulaFragment()
                activity.supportFragmentManager.beginTransaction()
                    .replace(containerId,fragment)
                    .addToBackStack("TAG")
                    .commit()
        }
    }

}