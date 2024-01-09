package com.manish.exposys.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.manish.exposys.R


class SubmitFragment : Fragment() {

    lateinit var btnDone:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_submit, container, false)

        btnDone=view.findViewById(R.id.btnDone)

        btnDone.setOnClickListener {

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameLayout,DashboardFragment())?.commit()
        }

        return view
    }


}