package com.manish.exposys.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.manish.exposys.R
import com.manish.exposys.database.DBHelper


class CyberFragment : Fragment() {

    lateinit var etName: EditText
    lateinit var etBranch: EditText
    lateinit var etEmail: EditText
    lateinit var etCollege: EditText
    lateinit var etPhone: EditText
    lateinit var etTenth: EditText
    lateinit var etTwelfth: EditText
    lateinit var etUG: EditText
    lateinit var etPG: EditText
    lateinit var etLocation: EditText
    lateinit var btnApply: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_cyber, container, false)

        etName=view.findViewById(R.id.etEnterName)
        etBranch=view.findViewById(R.id.etEnterBranch)
        etEmail=view.findViewById(R.id.etEnterEmail)
        etCollege=view.findViewById(R.id.etEnterCollege)
        etPhone=view.findViewById(R.id.etEnterPhone)
        etTenth=view.findViewById(R.id.etEnter10)
        etTwelfth=view.findViewById(R.id.etEnter12)
        etUG=view.findViewById(R.id.etEnterUG)
        etPG=view.findViewById(R.id.etEnterPG)
        etLocation=view.findViewById(R.id.etEnterLocation)
        btnApply=view.findViewById(R.id.btnApply4)

        btnApply.setOnClickListener {
            val checkAllField=isAllFieldChecked()
            if(checkAllField){
                val name=etName.text.toString()
                val branch=etBranch.text.toString()
                val email=etEmail.text.toString()
                val college=etCollege.text.toString()
                val phone=etPhone.text.toString()
                val tenth=etTenth.text.toString()
                val twelfth=etTwelfth.text.toString()
                val ug=etUG.text.toString()
                val pg=etPG.text.toString()
                val location=etLocation.text.toString()
                val skills="Cyber Security"

                val db= DBHelper(activity as Context,null)
                db.addDetails(name,branch,email,college,phone,skills,tenth,twelfth,ug,pg,location)
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.frameLayout,SubmitFragment())?.commit()
                Toast.makeText(activity as Context,"Applied Successfully",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(activity as Context,"Failed",Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    fun isAllFieldChecked():Boolean{

        if(etName.length()==0 || etBranch.length()==0|| etEmail.length()==0|| etCollege.length()==0||
            etPhone.length()==0||etTenth.length()==0||etTwelfth.length()==0||etUG.length()==0||
            etPG.length()==0||etLocation.length()==0){

            if(etName.length()==0){
                etName.error="Enter Your Name"
            }
            if(etBranch.length()==0)
            {
                etBranch.error="Enter Your Branch"
            }
            if(etEmail.length()==0){
                etEmail.error="Enter Your Email Address"
            }
            if(etCollege.length()==0){
                etCollege.error="Enter your College name"
            }
            if(etPhone.length()==0)
            {
                etPhone.error="Enter your phone number"
            }
            if(etTenth.length()==0){
                etTenth.error="Enter Your class 10th percentage"
            }
            if(etTwelfth.length()==0)
            {
                etTwelfth.error="Enter Your class 12th percentage"
            }
            if(etUG.length()==0){
                etUG.error="Enter Your UG percentage"
            }
            if(etPG.length()==0)
            {
                etPG.error="Enter your PG percentage"
            }
            if(etLocation.length()==0)
            {
                etLocation.error="Enter Your current location"
            }
            Toast.makeText(activity as Context,"Enter your complete details", Toast.LENGTH_SHORT).show()
            return false
        }
        else{
            return true
        }
    }

}