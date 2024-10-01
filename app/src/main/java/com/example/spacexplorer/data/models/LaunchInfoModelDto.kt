package com.example.spacexplorer.data.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

data class LaunchInfoModelDto(
    val name: String,
    val time: LocalDateTime,
    val details: String,
    var status: String?
)

@RequiresApi(Build.VERSION_CODES.O)
val myList = listOf(
    LaunchInfoModelDto(
        "Flacon 9",
        LocalDateTime.of(2024, 12, 20, 12, 43, 23),        "some description",
        "active"
    ),
    LaunchInfoModelDto(
        "Flacon 9",
        LocalDateTime.of(2024, 12, 20, 12, 43, 23),        "some description",
        "active"
    ),
    LaunchInfoModelDto(
        "Flacon 9",
        LocalDateTime.of(2024, 12, 20, 12, 43, 23),        "some description",
        "active"
    ),
    LaunchInfoModelDto(
        "Flacon 9",
        LocalDateTime.of(2024, 12, 20, 12, 43, 23),        "some description",
        "active"
    ),
    LaunchInfoModelDto(
        "Flacon 9",
        LocalDateTime.of(2024, 12, 20, 12, 43, 23),        "some description",
        "active"
    ),
    LaunchInfoModelDto(
        "Flacon 9",
        LocalDateTime.of(2024, 12, 20, 12, 43, 23),        "some description",
        "active"
    ),
    LaunchInfoModelDto(
        "Flacon 9",
        LocalDateTime.of(2024, 12, 20, 12, 43, 23),        "some description",
        "active"
    ),
    LaunchInfoModelDto(
        "Flacon 9",
        LocalDateTime.of(2024, 12, 20, 12, 43, 23),        "some description",
        "active"
    )
)
