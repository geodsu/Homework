package com.example.scrolablefragments.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.scrolablefragments.fragments.FragmentOne
import com.example.scrolablefragments.fragments.FragmentThree
import com.example.scrolablefragments.fragments.FragmentTwo

class ViewPagerFragmentsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity){
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentOne()
            1 -> FragmentTwo()
            2 -> FragmentThree()
            else -> FragmentOne()
        }
    }
}