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
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    var alMyAndroidOS = ArrayList<MyAndroidOS>()
    var weater = ""
    val KEY = "2c1f6498eead4bab9e800226173010"
    val weatherApiServe by lazy {
        WeatherApiService.create()
    }

    var disposable: Disposable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(edit_city.text.toString().isNotEmpty()) {

                beginSearch(edit_city.text.toString())



            var recyclerView = findViewById(R.id.rvAndroidVersions) as RecyclerView

            recyclerView.setHasFixedSize(true)

            recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
            //recyclerView.addItemDecoration(LinearLayoutSpaceItemDecoration(16))


            recyclerView.adapter = MyAndroidAdapter(alMyAndroidOS) {}}


        return super.onOptionsItemSelected(item)
    }

    private fun beginSearch(searchCity:String){
        disposable =
                weatherApiServe.hitCountCheck(KEY,searchCity)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result -> run  {
                                    alMyAndroidOS.add(MyAndroidOS(("${result.current.condition.icon}").toString(),("${result.current.temp_c}").toString(), "v1.5"))


                                } },
                                { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
        )

    }
//
//    override fun onPause() {
//        super.onPause()
//        disposable?.dispose()
//    }

}


