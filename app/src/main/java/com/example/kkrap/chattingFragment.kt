package com.example.kkrap_team

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kkrap.R
import com.example.kkrap.chattingFragment

class ChattingFragment<FragmentChattingBinding>: Fragment() {
    private var binding : FragmentChattingBinding? = null

    companion object {
        const val TAG : String = "로그"

        fun newInstance() : chattingFragment {
            return chattingFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "chattingFragment - onAttach() called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "chattingFragment - onAttach() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG, "chattingFragmentt - onCreateView() called")
        val view : View = inflater.inflate(R.layout.fragment_chatting, container, false)
        return view
    }
}