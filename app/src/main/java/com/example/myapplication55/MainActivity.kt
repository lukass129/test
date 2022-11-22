package com.example.myapplication55

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication55.data.ApiInterface
import com.example.myapplication55.data.DataItem
import com.example.myapplication55.databinding.ActivityMainBinding
import com.example.myapplication55.presentation.myAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BaseUrl = "https://jsonplaceholder.typicode.com/"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: myAdapter
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        database = FirebaseDatabase.getInstance().getReference("data")
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
                adapter.setOnClickListener(object :myAdapter.onClickListener{
                    override fun onClick(position: Int) {
//                        Toast.makeText(this@MainActivity, "clicked at an item at position $position",
//                            Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity,Activity2::class.java)
                        intent.putExtra("data",position)
                        startActivity(intent)
                    }
                })
                adapter.notifyDataSetChanged()
                binding.recyclerView.adapter = adapter

                database.push().setValue(responceBody)


            }

            override fun onFailure(call: Call<List<DataItem>?>, t: Throwable) {
                Log.d("Main", "onFailiure" + t.message)
            }
        })

    }


}