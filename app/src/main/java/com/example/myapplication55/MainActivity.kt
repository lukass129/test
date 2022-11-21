package com.example.myapplication55

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication55.data.ApiInterface
import com.example.myapplication55.data.DataItem
import com.example.myapplication55.databinding.ActivityMainBinding
import com.example.myapplication55.presentation.myAdapter
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BaseUrl = "https://jsonplaceholder.typicode.com/"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: myAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        getData()


    }
    private fun getData(){
       val retrofitBuilder = Retrofit.Builder()
           .addConverterFactory(GsonConverterFactory.create())
           .baseUrl(BaseUrl)
           .build()
           .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<DataItem>?> {
            override fun onResponse(
                call: Call<List<DataItem>?>,
                response: Response<List<DataItem>?>
            ) {
                val responceBody = response.body()!!
                adapter = myAdapter(baseContext, responceBody)
                adapter.notifyDataSetChanged()
                binding.recyclerView.adapter = adapter

            }

            override fun onFailure(call: Call<List<DataItem>?>, t: Throwable) {
                Log.d("Main", "onFailiure" + t.message)
            }
        })

    }

}