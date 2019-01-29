package com.yaaqoub.topicapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.yaaqoub.topicapp.adapters.TopicAdapter
import com.yaaqoub.topicapp.model.Topic
import com.yaaqoub.topicapp.network.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitFactory.makeRetrofitService()
        GlobalScope.launch(Dispatchers.Main) {
            val request = service.getPosts()
            try {
                val response = request.await()
                response.body()?.let { initRecyclerView(it) }
            } catch (e: HttpException) {
                toast(e.code())
            } catch (e: Throwable) {
                toast("Ooops: Something else went wrong")
            }
        }
    }

    private fun initRecyclerView(list:List<Topic>) {
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = TopicAdapter(list,this)
    }
}
