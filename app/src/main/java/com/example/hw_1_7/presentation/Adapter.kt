package com.example.hw_1_7.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hw_1_7.presentation.cameras.CameraFragment
import com.example.hw_1_7.presentation.doors.DoorsFragment

class Adapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            CameraFragment()
        else
            DoorsFragment()
    }
}