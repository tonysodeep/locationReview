package com.example.app_day_5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

var locationArray = ArrayList<LocationData>()
private lateinit var linearLayoutManager: LinearLayoutManager
private var addLocationCode : Int = 1
class MainActivity : AppCompatActivity(),onItemClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(my_toolbar)
        supportActionBar?.apply {
            title = "TourNote"
        }
        linearLayoutManager = LinearLayoutManager(this)
        tour_rv.layoutManager = linearLayoutManager
        var tourAdapter: LocationAdapter = LocationAdapter(createLocation(), this)
        tour_rv.adapter = tourAdapter
        tourAdapter.setLocationInterFace(this)
        tour_rv.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_paste){
            val intent = Intent(this,AddLocation::class.java)
            startActivityForResult(intent, addLocationCode)
            return true
        }
    return super.onOptionsItemSelected(item)
    }

    fun createLocation(): ArrayList<LocationData> {
        var location: LocationData
        for (i in 1..10) {
            location = LocationData(
                "05/03",
                "da lat",
                "da lat tren vui" +
                        "\nciliekc me" +
                        "cuoc phieu luu ky thu",
                "https://akisoto.com/wp-content/uploads/2019/06/Canva-night-light-dalat-city-vietnam-landmark-city-center-1024x683.jpg",
                "05/03/2000",
                "toi" +
                        "\n rat la" +
                        "\n vui",
                R.drawable.editblue,
                R.drawable.shareblue,
                R.drawable.deletblue

            )
            locationArray.add(location)
        }
        return locationArray
    }

    override fun onLocationClick(data: LocationData) {
        val intent = Intent(this,LocationDetail::class.java)
        intent.putExtra("data",data)
        startActivity(intent)
    }

    override fun onDeletItemClick() {
        Toast.makeText(this,"item deleted",Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if (resultCode == Activity.RESULT_OK) {
                val location : LocationData = data.getSerializableExtra("return_location") as LocationData
                locationArray.add(0,location)
                var touradapter = LocationAdapter(locationArray,this)
                tour_rv.adapter = touradapter
                touradapter.setLocationInterFace(this)

            } else {
                Log.d("AAA","CANCEL")
            }
        }
    }
}