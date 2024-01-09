package com.manish.exposys.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.w3c.dom.Text

class DBHelper (context:Context,factory:SQLiteDatabase.CursorFactory?) :
        SQLiteOpenHelper(context, DATABASE_NAME,factory, DATABASE_VERSION){


    override fun onCreate(db: SQLiteDatabase?) {
        //This function create table with the given table name.
        val query=("CREATE TABLE "+ TABLE_NAME + " (" + COL_ID + "INTEGER PRIMARY KEY," +
                NAME + " TEXT,"+ BRANCH + " TEXT," + EMAIL + " TEXT,"+ COLLEGE + " TEXT," +
                PHONE_NUMBER + " TEXT," + SKILL + " TEXT," +  TENTH + " TEXT," + TWELFTH +
                " TEXT," + UG + " TEXT," + PG + " TEXT," + LOCATION + " TEXT)")

        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, v1: Int, v2: Int) {
       //This function upgrade the database by deleting the previous database.
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    fun addDetails(name:String,branch:String,email:String,college:String,phone:String,skill:String,
                   tenth:String,twelfth :String,ug:String,pg:String,location:String){

        val values=ContentValues()
        values.put(NAME,name)
        values.put(BRANCH,branch)
        values.put(EMAIL,email)
        values.put(COLLEGE,college)
        values.put(PHONE_NUMBER,phone)
        values.put(SKILL,skill)
        values.put(TENTH,tenth)
        values.put(TWELFTH,twelfth)
        values.put(UG,ug)
        values.put(PG,pg)
        values.put(LOCATION,location)

        val db=this.writableDatabase
        db.insert(TABLE_NAME,null,values)
        db.close()
    }

    fun displayAll():Cursor{
        val query="SELECT * FROM $TABLE_NAME"
        val db=this.readableDatabase
        val cursor:Cursor= db.rawQuery(query,null)
        return cursor
    }


    companion object{
        val DATABASE_NAME="INFORMATION_DATABASE"
        val TABLE_NAME="STUDENTS_DETAILS"
        val DATABASE_VERSION=1
        val COL_ID="id"
        val NAME="name"
        val BRANCH="branch"
        val EMAIL="email"
        val COLLEGE="college"
        val PHONE_NUMBER="phone"
        val SKILL="skill"
        val TENTH="tenth"
        val TWELFTH="inter"
        val UG="undergraduation"
        val PG="postgraduation"
        val LOCATION="location"
    }


}