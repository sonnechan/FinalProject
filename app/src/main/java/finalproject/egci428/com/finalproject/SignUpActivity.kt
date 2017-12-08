package finalproject.egci428.com.finalproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_rating.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.message.*

class SignUpActivity : AppCompatActivity() {
    lateinit var idpassRef: DatabaseReference
    lateinit var usernameData: MutableList<IdPasswordReference>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        idpassRef = FirebaseDatabase.getInstance().getReference("username")
        usernameData = mutableListOf()
        sign_up_button.setOnClickListener(){
            saveData()
        }
    }

   /* private fun saveData(){
        //save into Database

        //go to map
        var mapIntent = Intent(applicationContext,MapsActivity::class.java)
        startActivity(mapIntent)
    }*/
    private fun saveData(){
       val username = usernameInput.text.toString()
       val password = passwordInput.text.toString()
       val idPass = idpassRef.push().key
       val idData = IdPasswordReference(username,password)
       //idpassRef = FirebaseDatabase.getInstance().getReference("username")

       idpassRef.child(idPass).setValue(idData).addOnCompleteListener {
           // if it complete

           Toast.makeText(applicationContext, "Sign-up Successfully", Toast.LENGTH_SHORT).show()
           var mapIntent = Intent(applicationContext,MapsActivity::class.java)
           startActivity(mapIntent)
       } //set the message that we are gonna send
   }
}
