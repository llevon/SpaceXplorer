package com.example.spacexplorer.presentation.screen.adapters
import androidx.recyclerview.widget.DiffUtil
import com.example.spacexplorer.domain.models.LaunchInfoModel

class DiffUtilCallback:DiffUtil.ItemCallback<LaunchInfoModel>() {

    override fun areItemsTheSame(oldItem: LaunchInfoModel, newItem: LaunchInfoModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: LaunchInfoModel, newItem: LaunchInfoModel): Boolean {
        return oldItem == newItem
    }

}