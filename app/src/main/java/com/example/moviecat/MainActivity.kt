package com.example.moviecat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecat.Data.DataClassItem
import com.example.moviecat.Repo.url_apiInterface
import com.example.moviecat.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// a constant variable which is the base url
const val base_url = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: myAdapter
    lateinit var recyVieww : RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyVieww = binding.recyclerciew
        recyVieww.setHasFixedSize(true)
        binding.recyclerciew.adapter
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerciew.layoutManager = linearLayoutManager

// calling the method for getting data
        getApiData()
    }

    // the function for getting data
    private fun getApiData() {
        //retrofit builder
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(base_url)
            .build()
            .create(url_apiInterface::class.java)    //taking referrence of the interface using the double collon

        //getting data from the retrofit builder
        val dataretrofit = retrofitBuilder.getData()
        dataretrofit.enqueue(object : Callback<List<DataClassItem>?> {
            override fun onResponse(
                call: Call<List<DataClassItem>?>,
                response: Response<List<DataClassItem>?>
            ) {

               val responsebody = response.body()!!

                adapter = myAdapter(baseContext,responsebody)
                adapter.notifyDataSetChanged()
                recyVieww.adapter = adapter

                Log.d("data",responsebody.toString())
            }

            override fun onFailure(call: Call<List<DataClassItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}
