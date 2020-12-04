package com.example.gyankunj.base

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.content.Context.WINDOW_SERVICE
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.example.gyankunj.BR
import com.example.gyankunj.data.prefs.PreferenceManager
import org.koin.android.ext.android.inject

abstract class BaseFragment<DATA_BINDING: ViewDataBinding,VIEW_MODEL:BaseViewModel>: Fragment() {
    lateinit var viewDataBinding: DATA_BINDING
    private var baseViewModel: VIEW_MODEL? = null
    var layoutView:View?=null
    lateinit var popupWindow:PopupWindow
    val preferenceManager: PreferenceManager by inject()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        performDataBinding(inflater,container)
        return viewDataBinding.root
    }

    private fun performDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        viewDataBinding= DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        this.baseViewModel=baseViewModel?:getViewModel()
        viewDataBinding.apply {
            setVariable(getBindingVariable(),baseViewModel)
            setLifecycleOwner(viewLifecycleOwner)
            executePendingBindings()
        }
    }

    fun popUpWindow1(viewlayout: View, viewGroup: ViewGroup, layoutRes: Int){
        val inflater: LayoutInflater =
            context?.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate( layoutRes,null)

        layoutView=view




        popupWindow = PopupWindow(
            view, // Custom view to show in popup window
            LinearLayout.LayoutParams.MATCH_PARENT, // Width of popup window
            LinearLayout.LayoutParams.WRAP_CONTENT // Window height

        )





        popupWindow.elevation = 10.0F

        popupWindow.isTouchable=true

        popupWindow.dismiss()
        popupWindow.isOutsideTouchable = true



        TransitionManager.beginDelayedTransition(viewGroup)
        popupWindow.showAtLocation(
            viewlayout, // Location to display popup window
            Gravity.CENTER, // Exact position of layout to display popup
            0, // X offset
            0 // Y offset
        )

        var container:View=popupWindow?.contentView!!.rootView
        var windowManager: WindowManager =context?.getSystemService(WINDOW_SERVICE) as WindowManager
        var p: WindowManager.LayoutParams=container.layoutParams as WindowManager.LayoutParams
        p.flags= WindowManager.LayoutParams.FLAG_DIM_BEHIND
        p.dimAmount=0.8f
        windowManager.updateViewLayout(container,p)

    }





    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): VIEW_MODEL

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    open fun getBindingVariable(): Int = BR.viewModel

}
