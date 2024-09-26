package com.example.kkrap

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.kkrap.databinding.ActivtiyMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(){

    private lateinit var mBinding: ActivtiyMainBinding

    //
    private lateinit var homeFragment: HomeFragment
    private lateinit var folderFragment: folderFragment
    private lateinit var chattingFragment: chattingFragment
    private lateinit var settingFragment: settingFragment

    companion object{
        const val TAG: String = "로그"
    }

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivtiyMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        Log.d(TAG,"MainActivity - onCreate() called")

    }
}