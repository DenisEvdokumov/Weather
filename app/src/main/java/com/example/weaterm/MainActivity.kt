package com.example.weaterm

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var recyclerView = findViewById (R.id.rvAndroidVersions) as RecyclerView

        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerView.addItemDecoration(LinearLayoutSpaceItemDecoration(16))

        //Here we create an arraylist to store alMyAndroidOS using the data class MyAndroidOS
        var alMyAndroidOS = ArrayList<MyAndroidOS>()

        //Adding some data to the arraylist
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupcake", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupcakce", "vc1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupxcake", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupcxake", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupcacke", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupcakxe", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupcakxe", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupcazkxe", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupcaxcke", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupcaxczke", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupcakxzce", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher,"Cupcakzxce", "v1.5"))

        recyclerView.adapter = MyAndroidAdapter(alMyAndroidOS){}

        fun OnClickListener( view: MyAndroidOS){
            alMyAndroidOS.add(view)
            recyclerView.adapter = MyAndroidAdapter(alMyAndroidOS){}
        }
        return super.onOptionsItemSelected(item)
    }

}


