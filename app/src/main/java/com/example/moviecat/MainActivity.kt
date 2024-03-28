package com.example.moviecat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.moviecat.Data.DataClassItem
import com.example.moviecat.Repo.url_apiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// a constant variable which is the base url
const val base_url = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        dataretrofit.enqueue(object : Callback<List<DataClassItem>?>{
            override fun onResponse(
                call: Call<List<DataClassItem>?>,
                response: Response<List<DataClassItem>?>
            ) {
                val textView : TextView = findViewById(R.id.txt_display) as TextView

                val responseB = response.body()!!

                val mystringBuilder = StringBuilder()
                for (DataClass in responseB ){
                    mystringBuilder.append(DataClass.title)
                    mystringBuilder.append("\n")

                }
                textView.text = mystringBuilder

            }

            override fun onFailure(call: Call<List<DataClassItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}