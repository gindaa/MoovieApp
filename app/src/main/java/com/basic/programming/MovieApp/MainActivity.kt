package com.basic.programming.MovieApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.basic.programming.MovieApp.Services.GenreServices
import com.basic.programming.MovieApp.Services.ServiceBuilder
import com.basic.programming.MovieApp.adapters.GenreAdapters
import com.basic.programming.MovieApp.model.GenreList
import com.basic.programming.MovieApp.model.Genre
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {



    private var recyclerView: RecyclerView? = null
    private var genreItem: ArrayList<Genre>? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var alphaAdapters: GenreAdapters? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.buildService(GenreServices::class.java)
        val call = request.getGenre(getString(R.string.api_key))

        call.enqueue(object : Callback<GenreList>{
                override fun onResponse(call: Call<GenreList>, response: Response<GenreList>) {
                    if (response.isSuccessful){
                        Toast.makeText(this@MainActivity,"Hello ",Toast.LENGTH_SHORT).show()
                        val data = response.body()?.GenreList?.get(0)?.genre
                        Log.d("Isi", "respon Server ${data.toString()}")
                        Toast.makeText(this@MainActivity,data.toString(),Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<GenreList>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })

        recyclerView = findViewById(R.id.recycler_view_item)
        gridLayoutManager =
            GridLayoutManager(applicationContext, 4, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)

        genreItem = ArrayList()
        genreItem = setAlphas()
        alphaAdapters = GenreAdapters(applicationContext, genreItem!!)
        recyclerView?.adapter = alphaAdapters

    }

    private fun setAlphas(): ArrayList<Genre> {

        var arrayList: ArrayList<Genre> = ArrayList()

        arrayList.add(Genre(1,"Genre 1"))


        return arrayList
    }

}
