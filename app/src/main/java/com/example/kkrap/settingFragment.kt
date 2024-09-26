package com.example.kkrap_team

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kkrap.R
import com.example.kkrap.settingFragment

class SettingFragment<FragmentSettingBinding> : Fragment() {
    private var binding : FragmentSettingBinding? = null

    companion object {
        const val TAG : String = "로그"

        fun newInstance() : settingFragment {
            return settingFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "settingFragment - onAttach() called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "settingFragment - onAttach() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG, "settingFragment - onCreateView() called")
        val view : View = inflater.inflate(R.layout.fragment_setting, container, false)
        return view
    }
}