package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mergeViewmodel:main_viewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mergeViewmodel= ViewModelProvider(this).get(main_viewmodel::class.java)

        var list1= mutableListOf<Int>()
        list1.add(1)
        list1.add(5)
        list1.add(7)
        list1.add(8)

        var list2= mutableListOf<Int>()
        list2.add(2)
        list2.add(4)
        list2.add(6)
        list2.add(9)

        tv_list1.text= "List1= {1,5,7,8}"
        tv_list2.text= "List2= {2,4,6,9}"

        btm_merge.setOnClickListener {
            mergeViewmodel.mergelist_data(list1, list2)
        }

        var list_txt= "Finallist= {"
        mergeViewmodel.listLivedata.observe(this){
            for (i in 1..it.size-1){
                if (i!= it.size-1){
                    list_txt= list_txt+ it[i].toString()
                }else{
                    list_txt= list_txt+ it[i].toString()+"}"

                }
            }
            tv_listmain.text= list_txt
        }

    }

}