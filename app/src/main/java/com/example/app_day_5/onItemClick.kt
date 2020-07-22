package com.example.app_day_5

interface onItemClick {
    fun onLocationClick(data : LocationData)
    fun onDeletItemClick()
    fun onEditLocationClick(data: LocationData,position:Int)
    fun onShareLocationName(locationName : String)
    fun onLongClickItem(position: Int , data: LocationData)
}