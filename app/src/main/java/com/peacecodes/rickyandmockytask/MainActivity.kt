package com.peacecodes.rickyandmockytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.peacecodes.rickyandmockytask.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Ricky and Morty"

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        setupRetrofitAndMakeRequest()
    }

    private fun setupRetrofitAndMakeRequest() {
        val retro = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service = retro.create(ApiService::class.java)
        val characterRequest = service.getAllCharacters()
        characterRequest.enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val adapter = CharactersAdapter(response.body()!!.results)
                binding.recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error encountered: \n${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}