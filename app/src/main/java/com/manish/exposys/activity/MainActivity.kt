package com.manish.exposys.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.RelativeLayout

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.manish.exposys.R

import com.manish.exposys.fragment.AppdevFragment
import com.manish.exposys.fragment.BusinessdevFragment
import com.manish.exposys.fragment.ContentFragment
import com.manish.exposys.fragment.CyberFragment
import com.manish.exposys.fragment.DashboardFragment
import com.manish.exposys.fragment.DatascienceFragment
import com.manish.exposys.fragment.DigitalFragment
import com.manish.exposys.fragment.DigitalMediaFragment
import com.manish.exposys.fragment.FullstackFragment
import com.manish.exposys.fragment.IotFragment
import com.manish.exposys.fragment.SoftwaredevFragment
import com.manish.exposys.fragment.UiUxFragment
import com.manish.exposys.fragment.WebdevFragment

class MainActivity : AppCompatActivity() {

    lateinit var topmenu:NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var relativeLayout: RelativeLayout
    lateinit var frameLayout: FrameLayout
    lateinit var toolbar: Toolbar
    lateinit var sp:SharedPreferences


    var previousMenuItem:MenuItem?=null

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topmenu = findViewById(R.id.topMenu)
        drawerLayout = findViewById(R.id.drawerLayout)
        relativeLayout = findViewById(R.id.relativeLayout)
        frameLayout = findViewById(R.id.frameLayout)
        toolbar = findViewById(R.id.toolbar)

        sp=getSharedPreferences("Exposys",Context.MODE_PRIVATE)

        setUpToolbar()
        openDashboard()


        val actionBarDrawerToggle= ActionBarDrawerToggle(this@MainActivity,drawerLayout,
            R.string.nav_open,R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()


        topmenu.setNavigationItemSelectedListener {
            if (previousMenuItem != null) {
                previousMenuItem?.isChecked = false
            }
            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when(it.itemId)
            {
                R.id.dashboard ->
                {
                    openDashboard()
                    drawerLayout.closeDrawers()
                }
                R.id.dataScience ->
                {
                    supportActionBar?.title="DATA SCIENCE"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,DatascienceFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.webDev ->
                {
                    supportActionBar?.title="WEB DEVELOPMENT"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,WebdevFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.fullStack ->
                {
                    supportActionBar?.title="FULL STACK DEVELOPMENT"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,FullstackFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.appDev ->
                {
                    supportActionBar?.title="APP DEVELOPMENT"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,AppdevFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.softwareDev ->
                {
                    supportActionBar?.title="SOFTWARE DEVELOPMENT"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,SoftwaredevFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.iot ->
                {
                    supportActionBar?.title="IOT ( INTERNET OF THINGS )"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,IotFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.uiux ->
                {
                    supportActionBar?.title="UI/UX DESIGN"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,UiUxFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.cyber ->
                {
                    supportActionBar?.title="CYBER SECURITY"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,CyberFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.digital ->
                {
                    supportActionBar?.title="DIGITAL MARKETING"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,DigitalFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.digitalmedia ->
                {
                    supportActionBar?.title="DIGITAL MEDIA PROMOTER"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,DigitalMediaFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.contentWriting ->
                {
                    supportActionBar?.title="CONTENT WRITING"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,ContentFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.businessDev ->
                {
                    supportActionBar?.title="BUSINESS DEVELOPMENT"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,BusinessdevFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.logout->
                {
                    sp.edit().clear().apply()
                    val intent=Intent(this@MainActivity,LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }


            return@setNavigationItemSelectedListener true
        }
    }
    fun setUpToolbar()
    {
        setSupportActionBar(toolbar)
        supportActionBar?.title=" Exposys Data Labs Internships  "
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun openDashboard(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout,DashboardFragment()).commit()
        supportActionBar?.title="DASHBOARD"
        topmenu.setCheckedItem(R.id.dashboard)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home)
        {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.frameLayout)
        when(frag)
        {
            !is DashboardFragment -> openDashboard()
            else -> super.onBackPressed()
        }
    }
}