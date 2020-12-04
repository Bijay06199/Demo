package com.example.gyankunj.ui.home.noticeBoard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityNoticeBoardBinding
import com.example.gyankunj.ui.home.MainActivity
import com.example.gyankunj.ui.home.noticeBoard.adapter.NoticeBoardAdapter
import com.example.gyankunj.ui.home.noticeBoard.model.NoticeBoardModel
import kotlinx.android.synthetic.main.activity_notice_board.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoticeBoardActivity :BaseActivity<ActivityNoticeBoardBinding,NoticeBoardViewModel>(),NoticeBoardAdapter.OnItemClickListener {
    override fun getLayoutId(): Int =R.layout.activity_notice_board
    override fun getViewModel(): NoticeBoardViewModel =noticeBoardViewModel
    private val noticeBoardViewModel:NoticeBoardViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    lateinit var noticeBoardAdapter: NoticeBoardAdapter

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
            noticeBoardAdapter= NoticeBoardAdapter(this@NoticeBoardActivity)
            recyclerviewNoticeboard.adapter=noticeBoardAdapter
            var itemList=ArrayList<NoticeBoardModel>()
            itemList.add(NoticeBoardModel("Lok-sewa form fill-up","Yesterday"))
            itemList.add(NoticeBoardModel("Class 11 exam has been postponed for 4 months ","23 July"))
            itemList.add(NoticeBoardModel("Class 11 exam has been postponed for 4 months ","23 July"))
            itemList.add(NoticeBoardModel("Class 11 exam has been postponed for 4 months ","23 July"))
            itemList.add(NoticeBoardModel("Class 11 exam has been postponed for 4 months ","23 July"))
            itemList.add(NoticeBoardModel("Class 11 exam has been postponed for 4 months ","23 July"))
            itemList.add(NoticeBoardModel("Class 11 exam has been postponed for 4 months ","23 July"))
            itemList.add(NoticeBoardModel("Class 11 exam has been postponed for 4 months ","23 July"))
            itemList.add(NoticeBoardModel("Class 11 exam has been postponed for 4 months ","23 July"))
            itemList.add(NoticeBoardModel("Class 11 exam has been postponed for 4 months ","23 July"))
            itemList.add(NoticeBoardModel("Class 11 exam has been postponed for 4 months ","23 July"))

            noticeBoardAdapter.addAll(itemList)

        }
    }

    override fun onBoardItemClickListener(position: Int, itemList: NoticeBoardModel) {
      with(viewDataBinding){
          popUpWindow(rootLayout,rootLayout,R.layout.notice_board_popup)

          var cross=layoutView?.findViewById<ImageView>(R.id.iv_cross)
          cross?.setOnClickListener{
              popupWindow?.dismiss()
          }
      }
    }
}