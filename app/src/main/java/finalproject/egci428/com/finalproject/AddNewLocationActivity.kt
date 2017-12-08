package finalproject.egci428.com.finalproject

import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_add_new_location.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class AddNewLocationActivity : AppCompatActivity() {
    lateinit var locationlist: MutableList<LocationList>
    private var locationManager: LocationManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_location)

        locationlist = mutableListOf()

        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?



        saveBtn.setOnClickListener{ view ->
            try{
                //request location updates
                locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener)

                //saveData()

            }catch (ex: SecurityException){
                Log.d("myTag","Security Exception, no location available")
            }

            //saveLocation()
        }
    }


    //location listener
    private val locationListener: LocationListener = object : LocationListener{
        override fun onLocationChanged(location: Location) {
            val lat = location.latitude.toString()
            val lng = location.longitude.toString()
            Log.d("Location", lat)

            /*   locationReference = FirebaseDatabase.getInstance().getReference("username")
               val idpassRef = locationReference.child("id")
               val usernameRef = idpassRef.toString()

               val addLo = locationReference.push().key
               val loData = LocationList(usernameRef,latitude,longtitude)
               //idpassRef = FirebaseDatabase.getInstance().getReference("username")

               locationReference.child(addLo).setValue(loData).addOnCompleteListener {
                   // if it complete


                   //var mapIntent = Intent(applicationContext,MapsActivity::class.java)
                   //startActivity(mapIntent)
               } //set the message that we are gonna send*/
            //textView.text = latitude+","+longtitude
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}



        /*private val saveData(){

        }*/
    }





}
