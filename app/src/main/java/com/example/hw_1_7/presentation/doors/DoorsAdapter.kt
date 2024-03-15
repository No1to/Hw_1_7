package com.example.hw_1_7.presentation.doors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.hw_1_7.databinding.ItemDoorsBinding
import com.example.hw_1_7.domain.models.door.DoorModel

class DoorsAdapter:ListAdapter<DoorModel.Data, DoorsAdapter.DoorsViewHolder>(
    DoorDiffCallback()
){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoorsViewHolder {
        return DoorsViewHolder(ItemDoorsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DoorsViewHolder(private val binding:ItemDoorsBinding):ViewHolder(binding.root){
        fun bind(item: DoorModel.Data) = with(binding){
            itemView.setOnClickListener {
                if (imgDoor.visibility == View.GONE) {
                    imgDoor.visibility =
                        View.VISIBLE; btnPlay.visibility = View.VISIBLE
                } else {
                    imgDoor.visibility = View.GONE
                    btnPlay.visibility = View.GONE
                }
            }
            tvNameDoor.text = item.name
            Glide.with(imgDoor).load(item.snapshot).into(imgDoor)
        }
    }

}

class DoorDiffCallback:DiffUtil.ItemCallback<DoorModel.Data>(){
    override fun areItemsTheSame(oldItem: DoorModel.Data, newItem: DoorModel.Data) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DoorModel.Data, newItem: DoorModel.Data) = oldItem == newItem

}
