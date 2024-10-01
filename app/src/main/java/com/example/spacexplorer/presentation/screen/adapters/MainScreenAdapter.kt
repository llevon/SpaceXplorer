package com.example.spacexplorer.presentation.screen.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexplorer.databinding.ItemLaunchInfoBinding
import com.example.spacexplorer.domain.models.LaunchInfoModel
import java.time.format.DateTimeFormatter

class MainScreenAdapter: ListAdapter<LaunchInfoModel, MainScreenAdapter.MainScreenViewHolder>(
DiffUtilCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenViewHolder {
        val binding = ItemLaunchInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainScreenViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MainScreenViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MainScreenViewHolder(private val binding: ItemLaunchInfoBinding): RecyclerView.ViewHolder(binding.root) {

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(launch: LaunchInfoModel) = with(binding) {
            tvMissionName.text = launch.name
            tvDate.text = launch.time.format(DateTimeFormatter.ofPattern("dd.MM.yy"))
            tvDetails.text = launch.details
            tvStatus.text = launch.status
        }
    }

}