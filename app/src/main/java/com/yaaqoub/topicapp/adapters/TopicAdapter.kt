package com.yaaqoub.topicapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yaaqoub.topicapp.R
import com.yaaqoub.topicapp.model.Topic
import org.jetbrains.anko.find

class TopicAdapter(val list: List<Topic>, val context: Context) : RecyclerView.Adapter<TopicAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_post, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val post = list[position]
        holder.bind(post)
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView = itemView.find<TextView>(R.id.tv_title)
        private val bodyTextView = itemView.find<TextView>(R.id.tv_text)

        fun bind(post: Topic) {
            titleTextView.text = post.topic_title
            bodyTextView.text = post.topic_content
        }
    }
}