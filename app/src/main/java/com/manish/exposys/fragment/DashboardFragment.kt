package com.manish.exposys.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.manish.exposys.R


class DashboardFragment : Fragment() {
    lateinit var txtcurrent:TextView
    lateinit var dataScience:CardView
    lateinit var webDevelopment:CardView
    lateinit var fullStack:CardView
    lateinit var appDeveloper:CardView
    lateinit var softwareDevelopment:CardView
    lateinit var uiuxDesign:CardView
    lateinit var iot:CardView
    lateinit var cyberSecurity:CardView
    lateinit var digitalMarketing:CardView
    lateinit var contentWriting:CardView
    lateinit var digitalMedia:CardView
    lateinit var businessDevelopment:CardView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_dashboard, container, false)

        txtcurrent = view.findViewById(R.id.txtcurrent)
        txtcurrent.isSelected=true

        dataScience = view.findViewById(R.id.carddatascience)
        webDevelopment= view.findViewById(R.id.cardwebDevlopment)
        fullStack = view.findViewById(R.id.cardFullStack)
        appDeveloper = view.findViewById(R.id.cardAppDevelopment)
        softwareDevelopment = view.findViewById(R.id.cardSoftwareDevelopment)
        uiuxDesign = view.findViewById(R.id.carduiux)
        iot = view.findViewById(R.id.cardIot)
        cyberSecurity = view.findViewById(R.id.cardCyberSecurity)
        digitalMarketing = view.findViewById(R.id.cardDigitalMarketing)
        contentWriting = view.findViewById(R.id.cardContentWriting)
        digitalMedia = view.findViewById(R.id.cardDigitalMediaPromotor)
        businessDevelopment = view.findViewById(R.id.cardBusinessDevelopment)

        val toolbar=requireActivity().findViewById<Toolbar>(R.id.toolbar)



        dataScience.setOnClickListener {
            toolbar.title="DATA SCIENCE"
            activity?.supportFragmentManager?.beginTransaction()?.
                    replace(R.id.frameLayout,DatascienceFragment())?.commit()
        }
        webDevelopment.setOnClickListener {
            toolbar.title="WEB DEVELOPMENT"
            activity?.supportFragmentManager?.beginTransaction()?.
            replace(R.id.frameLayout,WebdevFragment())?.commit()
        }
        fullStack.setOnClickListener {
            toolbar.title="FULL STACK DEVELOPEMENT"
            activity?.supportFragmentManager?.beginTransaction()?.
            replace(R.id.frameLayout,FullstackFragment())?.commit()
        }
        appDeveloper.setOnClickListener {
            toolbar.title="APP DEVELOPER"
            activity?.supportFragmentManager?.beginTransaction()?.
            replace(R.id.frameLayout,AppdevFragment())?.commit()
        }
        softwareDevelopment.setOnClickListener {
            toolbar.title="SOFTWARE DEVELOPMENT"
            activity?.supportFragmentManager?.beginTransaction()?.
            replace(R.id.frameLayout,SoftwaredevFragment())?.commit()
        }
        uiuxDesign.setOnClickListener {
            toolbar.title="UI UX DESIGN"
            activity?.supportFragmentManager?.beginTransaction()?.
            replace(R.id.frameLayout,UiUxFragment())?.commit()
        }
        iot.setOnClickListener {
            toolbar.title="IOT "
            activity?.supportFragmentManager?.beginTransaction()?.
            replace(R.id.frameLayout,IotFragment())?.commit()
        }
        cyberSecurity.setOnClickListener {
            toolbar.title="CYBER SECURITY"
            activity?.supportFragmentManager?.beginTransaction()?.
            replace(R.id.frameLayout,CyberFragment())?.commit()
        }
        digitalMarketing.setOnClickListener {
            toolbar.title="DIGITAL MARKETING"
            activity?.supportFragmentManager?.beginTransaction()?.
            replace(R.id.frameLayout,DigitalFragment())?.commit()
        }
        digitalMedia.setOnClickListener {
            toolbar.title="DEGITAL MEDIA PROMOTER"
            activity?.supportFragmentManager?.beginTransaction()?.
            replace(R.id.frameLayout,DigitalMediaFragment())?.commit()
        }
        contentWriting.setOnClickListener {
            toolbar.title="CONTENT WRITING"
            activity?.supportFragmentManager?.beginTransaction()?.
            replace(R.id.frameLayout,ContentFragment())?.commit()
        }
        businessDevelopment.setOnClickListener {
            toolbar.title="BUSINESS DEVELOPMENT"
            activity?.supportFragmentManager?.beginTransaction()?.
            replace(R.id.frameLayout,BusinessdevFragment())?.commit()
        }


        return view
    }

}