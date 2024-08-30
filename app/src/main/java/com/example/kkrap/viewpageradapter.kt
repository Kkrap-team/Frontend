package com.example.kkrap

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class viewpageradapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity)


//프래그먼트들 연결시키기
{private val fragments = listOf(
        frag1(),
        frag2(),
        frag3(),
        frag4()
)
                override fun getItemCount(): Int = fragments.size

                override fun createFragment(position: Int): Fragment = fragments[position]
        }