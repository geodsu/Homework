package com.example.scrolablefragments.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.scrolablefragments.fragments.Fragment1
import com.example.scrolablefragments.fragments.Fragment3
import com.example.scrolablefragments.fragments.Fragment2

class ViewPagerFragmentsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity){
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Fragment1()
            1 -> Fragment2()
            2 -> Fragment3()
            else -> Fragment1()
        }
    }
}