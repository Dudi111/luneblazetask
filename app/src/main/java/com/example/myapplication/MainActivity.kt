package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var mergeViewmodel:main_viewmodel
    private var lastList1num=0
    private var lastList2num=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mergeViewmodel= ViewModelProvider(this).get(main_viewmodel::class.java)

        var list1= mutableListOf<Int>()


        var list2= mutableListOf<Int>()


        tv_list1.text= "List1= {}"
        tv_list2.text= "List2= {}"

        btn_list1.setOnClickListener {
            if (et_list1.text.length>0){
                if (et_list1.text.toString().toInt()>=lastList1num) {
                    var listdata = et_list1.text.toString().toInt()
                    list1.add(listdata)
                    var newtext = "list1 ={"
                    for (i in 0..list1.size - 1) {
                        if (i != list1.size - 1) {
                            newtext = newtext + list1[i].toString() + ", "
                        } else {
                            newtext = newtext + list1[i].toString() + "}"

                        }
                    }
                    lastList1num= et_list1.text.toString().toInt()
                    tv_list1.text = newtext
                }else{
                    Toast.makeText(this, "Input a number greater than ${lastList1num}", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Input a number", Toast.LENGTH_SHORT).show()
            }

        }

        btn_list2.setOnClickListener {
            if (et_list2.text.length>0){
                if (et_list2.text.toString().toInt()>=lastList2num) {
                    var listdata = et_list2.text.toString().toInt()
                    list2.add(listdata)
                    var newtext = "list2 ={"
                    for (i in 0..list2.size - 1) {
                        if (i != list2.size - 1) {
                            newtext = newtext + list2[i].toString() + ", "
                        } else {
                            newtext = newtext + list2[i].toString() + "}"

                        }
                    }
                    lastList2num= et_list2.text.toString().toInt()
                    tv_list2.text = newtext
                }else{
                    Toast.makeText(this, "Input a number greater than ${lastList2num}", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Input a number", Toast.LENGTH_SHORT).show()
            }
        }

        btm_merge.setOnClickListener {

            if (list1.size==0 && list2.size==0){
                Toast.makeText(this, "Both lists are Empty", Toast.LENGTH_SHORT).show()
            }else {
                mergeViewmodel.mergelist_data(list1, list2)
            }
        }

        var list_txt= "Finallist= {"
        mergeViewmodel.listLivedata.observe(this){
            for (i in 1..it.size-1){
                if (i!= it.size-1){
                    list_txt= list_txt+ it[i].toString()+", "
                }else{
                    list_txt= list_txt+ it[i].toString()+"}"

                }
            }
            tv_listmain.text= list_txt
        }

    }

}