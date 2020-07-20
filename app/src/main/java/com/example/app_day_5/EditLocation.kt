package com.example.app_day_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import kotlinx.android.synthetic.main.activity_edit_location.*
import java.util.*

class EditLocation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_location)
        val locationData: LocationData = intent.getSerializableExtra("edit_data") as LocationData
        edit_date.setText(locationData.locaDate)
        edit_full_date.setText(locationData.locaFullDate)
        edit_location_name.setText(locationData.locaName)
        edit_location_description.setText(locationData.locaDescription)
        edit_location_feedback.setText(locationData.locaFeedBack)
        edit_image_url.setText(locationData.locaIamge)

    }

}