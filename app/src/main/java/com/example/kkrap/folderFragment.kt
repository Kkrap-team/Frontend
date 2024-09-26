package com.example.kkrap

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kkrap.folderFragment
import com.example.kkrap.R

class FolderFragment<FragmentFolderBinding> : Fragment() {
    private var binding : FragmentFolderBinding? = null

    companion object {
        const val TAG : String = "로그"

        fun newInstance() :folderFragment {
            return folderFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "folderFragment - onAttach() called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "folderFragment - onAttach() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG, "folderFragment - onCreateView() called")
        val view : View = inflater.inflate(R.layout.fragment_folder, container, false)
        return view
    }
}