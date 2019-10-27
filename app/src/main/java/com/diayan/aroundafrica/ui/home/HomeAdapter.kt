package com.diayan.aroundafrica.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.diayan.aroundafrica.data.Places
import com.diayan.aroundafrica.databinding.ItemLocationBinding

class HomeAdapter: ListAdapter<Places, HomeAdapter.LocationViewHolder>(DiffCallback) {

    class LocationViewHolder(private val binding: ItemLocationBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(places: Places){
            binding.place = places
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Places>(){
        override fun areItemsTheSame(oldItem: Places, newItem: Places): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Places, newItem: Places): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LocationViewHolder {
        return LocationViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val place =getItem(position)
        holder.bind(place)
    }
}