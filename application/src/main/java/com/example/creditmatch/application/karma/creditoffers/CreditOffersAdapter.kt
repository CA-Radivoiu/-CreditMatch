package com.example.creditmatch.application.karma.creditoffers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.creditmatch.application.R
import com.example.creditmatch.application.karma.utils.DataAdapter

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
data class CreditOffer(val amount: String, val interesetRate: String)
class CreditOffersAdapter(
    data: MutableList<CreditOffer> = mutableListOf()
) : DataAdapter<CreditOffer>(data) {

    //region Interaction
    private var context: Context? = null
    interface Interaction {
        fun selectAlternativeRecipe(pos: Int)
        fun showSubscription()
    }
    //endregion

    //region RecyclerView Implementation
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return ViewHolder(parent.inflate(R.layout.layout_creditoffer_item))
    }
    //endregion

    //region ViewHolder
    private inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {
         fun bind(pos: Int) = with(itemView) {

            findViewById<TextView>(R.id.amount).text = data[pos].amount
            findViewById<TextView>(R.id.amount2).text = data[pos].interesetRate
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder)
            holder.bind(position)
    }
    //endregion
}