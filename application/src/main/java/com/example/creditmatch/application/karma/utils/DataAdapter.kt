package com.example.creditmatch.application.karma.utils

import androidx.recyclerview.widget.RecyclerView

abstract class DataAdapter<T>(
    protected val data: MutableList<T> = mutableListOf()
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    fun updateList(data: List<T>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size
}