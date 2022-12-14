package com.emdasoft.myrates.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emdasoft.myrates.R
import com.emdasoft.myrates.databinding.RateItemBinding
import com.emdasoft.myrates.domain.models.Rate

class MainAdapter : RecyclerView.Adapter<MainAdapter.RateViewHolder>() {

    private var ratesList = emptyList<Rate>()

    class RateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = RateItemBinding.bind(itemView)
        fun bind(rate: Rate) = with(binding) {
            tvDate.text = rate.date
            if (rate.name == "российских рублей") {
                tvName.text = buildString {
                    append("100 ")
                    append(rate.name)
                }
            } else tvName.text = rate.name
            tvBuy.text = rate.buyRate.toString()
            tvSale.text = rate.sellRate.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rate_item, parent, false)
        return RateViewHolder(view)
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        holder.bind(ratesList[position])
    }

    override fun getItemCount(): Int {
        return ratesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Rate>) {
        ratesList = list
        notifyDataSetChanged()
    }
}