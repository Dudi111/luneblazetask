package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class main_viewmodel: ViewModel() {

    private var mergedlistmain = MutableLiveData<List<Int>>()
    var listLivedata: LiveData<List<Int>> = mergedlistmain



    fun mergelist_data(list1:List<Int>, list2:List<Int>){
        var pointer1=0
        var pointer2=0
        var indexpath=0
        var size1= list1.size
        var size2= list2.size
        var mergedlist: MutableList<Int> = (arrayListOf(Int) as List<Int>).toMutableList()



        while (indexpath<size1+size2){
            if (pointer1<size1 && pointer2<size2) {
                if (list1[pointer1] <= list2[pointer2]) {
                    mergedlist.add(list1[pointer1])
                    pointer1++
                    indexpath++
                } else {
                    mergedlist.add(list2[pointer2])
                    pointer2++
                    indexpath++
                }
            }else if (pointer1== size1 && pointer2<size2){
                mergedlist.add(list2[pointer2])
                pointer2++
                indexpath++
            }else if (pointer1< size1 && pointer2== size2){
                mergedlist.add(list1[pointer1])
                pointer2++
                indexpath++
            }
        }
        mergedlistmain.postValue(mergedlist)



    }




}