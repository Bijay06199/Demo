package com.example.gyankunj.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.andrognito.flashbar.Flashbar
import com.example.gyankunj.BR
import com.example.gyankunj.R
import com.example.gyankunj.base.BaseActivity
import com.example.gyankunj.databinding.ActivityMainBinding
import com.example.gyankunj.ui.auth.AuthListenerInfo
import com.example.gyankunj.ui.auth.signIn.SignInActivity
import com.example.gyankunj.ui.home.adapter.PracticeSetAdapter
import com.example.gyankunj.ui.home.api.BannerRow
import com.example.gyankunj.ui.home.adapter.BannerAdapter
import com.example.gyankunj.ui.home.adapter.CourseAdapter
import com.example.gyankunj.ui.home.model.PracticeSetModel
import com.example.gyankunj.ui.home.mycourse.CourseActivity
import com.example.gyankunj.ui.home.practiceSet.PracticeSetActivity
import com.example.gyankunj.ui.home.profile.ProfileActivity
import com.example.gyankunj.ui.home.quiz.randomQuiz.Constants
import com.example.gyankunj.ui.home.settings.SettingsActivity
import com.example.gyankunj.utils.extentions.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    CourseAdapter.onItemClickListener,AuthListenerInfo,PracticeSetAdapter.OnItemClickListener {
    override fun getLayoutId(): Int = R.layout.activity_main
    override fun getViewModel(): MainViewModel = mainViewModel
    private val mainViewModel: MainViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    var flashbar:Flashbar?=null

    lateinit var practiceSetAdapter: PracticeSetAdapter

    lateinit var bannerAdapter: BannerAdapter
    lateinit var courseAdapter: CourseAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setUpRecyclerView()
        setUpBanner()
        setUpCourseRecyclerView()
        setUpSideItemsClick()

    }

    private fun setUpCourseRecyclerView() {
        with(mainViewModel){
            with(viewDataBinding){
            course()
           courseEvent.observe(this@MainActivity, Observer {
               courseAdapter=
                   CourseAdapter(this@MainActivity)
               recyclerviewCourse.adapter=courseAdapter
               var itemList=ArrayList<BannerRow>()
               itemsCourse?.data?.rows?.forEach{ i->
                   val name = i?.name
                   val image = i?.image
                   val isArchived = i?.isArchived
                   val id = i?.id
                   val createdAt = i?.createdAt
                   val v = i?.v

                   itemList.add(
                       BannerRow(
                           name,
                           image,
                           isArchived,
                           id,
                           createdAt,
                           v
                       )
                   )
               }
               courseAdapter.addAll(itemList)
           })

            }
        }
    }

    private fun setUpBanner() {
        with(mainViewModel) {
            with(viewDataBinding) {
                banner()

                bannerEvent.observe(this@MainActivity, Observer {
                    var rv = bannerViewPager.getChildAt(0) as RecyclerView

                    rv.clipToPadding = false
                    rv.setPadding(50, 0, 50, 0)


                    bannerAdapter =
                        BannerAdapter(this@MainActivity)
                    val itemList = ArrayList<BannerRow>()
                    itemsBanner?.data?.rows?.forEach { i ->
                        val name = i?.name
                        val image = i?.image
                        val isArchived = i?.isArchived
                        val id = i?.id
                        val createdAt = i?.createdAt
                        val v = i?.v



                        itemList.add(
                            BannerRow(
                                name,
                                image,
                                isArchived,
                                id,
                                createdAt,
                                v
                            )
                        )
                    }
                    bannerAdapter.addAll(itemList)
                    bannerViewPager.offscreenPageLimit=3
                    bannerViewPager.adapter = bannerAdapter



                    bannerViewPager.postDelayed({
                        bannerViewPager.currentItem = 1
                    }, 5)
                })


            }
        }
    }

    private fun setUpSideItemsClick() {
        with(viewDataBinding) {
            logoutGroup.setOnClickListener {
                preferenceManager.setLogged(false)
                finish()
               startActivity(Intent(this@MainActivity, SignInActivity::class.java))

            }
            navigationView.setNavigationItemSelectedListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.profile -> {
                       startActivity(Intent(this@MainActivity,ProfileActivity::class.java))
                        drawer.closeDrawers()
                        true
                    }
                    R.id.settings -> {
                       startActivity(Intent(this@MainActivity,SettingsActivity::class.java))
                        drawer.closeDrawers()
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        with(viewDataBinding) {
            practiceSetAdapter = PracticeSetAdapter(this@MainActivity)
            recyclerViewPracticeSet.adapter = practiceSetAdapter
            var itemList = ArrayList<PracticeSetModel>()
            itemList.add(PracticeSetModel("Set 1", "Chemistry", "8", "200"))
            itemList.add(PracticeSetModel("Set 1", "Chemistry", "8", "200"))
            itemList.add(PracticeSetModel("Set 1", "Chemistry", "8", "200"))
            itemList.add(PracticeSetModel("Set 1", "Chemistry", "8", "200"))
            itemList.add(PracticeSetModel("Set 1", "Chemistry", "8", "200"))

            practiceSetAdapter.addAll(itemList)
        }
    }

    private fun initView() {
        with(viewDataBinding) {
            with(mainViewModel) {
                authListenerInfo=this@MainActivity

                var name = "banner 1"
                var image =
                    "https://lh3.googleusercontent.com/proxy/EacV-CQ2-vDiZmrbTZm8Grm9r3LZszLshjcYNZueCCNCsxmYRvwHZ-R0soyEGrlg6XyFKdB880N98jUF9Yga40dxiyHHzyY"

//                viewModelScope.launch {
//                    createBannerRepository.createBanner(name, image)
//                }

                toolBar.setNavigationOnClickListener {
                    drawer.openDrawer(GravityCompat.START)
                }
            }


        }
    }

    override fun onBackPressed() {
        if (preferenceManager.getLogged()) {
            finishAffinity()
        } else {
            super.onBackPressed()

        }
    }

    override fun onCourseClickListener(position: Int, itemList: BannerRow) {

        for (i in 0..position){

            var clickedItem=itemList.name
            val intent=Intent(this,CourseActivity::class.java)
            intent.putExtra(Constants.ITEM, clickedItem)
            startActivity(intent)
        }




    }

    override fun onSuccess(message: String) {
       flashbar=successFlashBar(message)
        flashbar?.show()
    }

    override fun onStarted() {
    }

    override fun onInfo(message: String) {
       flashbar=infoFlashBar(message)
        flashbar?.show()
    }

    override fun onWarning(message: String) {
       flashbar=warningFlashBar(message)
        flashbar?.show()
    }

    override fun onDanger(message: String) {
       flashbar=dangerFlashBar(message)
        flashbar?.show()
    }

    override fun onPracticeSetClicked(position: Int, itemList: PracticeSetModel) {
        startActivity(Intent(this,PracticeSetActivity::class.java))
    }
}