package com.example.app_day_5

import java.io.Serializable

data class LocationData(val locaDate: String,val locaName: String , val locaDescription: String,
                        val locaIamge : String, val locaFullDate: String, val locaFeedBack : String,
                        val btEdit : Int, val btShare: Int, val btDelet: Int) : Serializable