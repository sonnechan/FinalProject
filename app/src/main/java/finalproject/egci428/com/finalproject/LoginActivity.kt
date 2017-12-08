package finalproject.egci428.com.finalproject

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.app.LoaderManager.LoaderCallbacks
import android.content.CursorLoader
import android.content.Loader
import android.database.Cursor
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.TextView

import java.util.ArrayList
import android.Manifest.permission.READ_CONTACTS
import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */

    //lateinit var dataReference: DatabaseReference
    lateinit var usernameRefernece: DatabaseReference
    lateinit var passwordReference: DatabaseReference
    lateinit var idPassList: MutableList<IdPasswordReference>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Set up the login form.
        idPassList = mutableListOf()
        usernameRefernece = FirebaseDatabase.getInstance().getReference()
        sign_in_button.setOnClickListener {

            signIn()
        }

        sign_up_button.setOnClickListener {

            var signUp = Intent(applicationContext,SignUpActivity::class.java)
            startActivity(signUp)

        }
    }

    private fun signIn(){

        //compare data in Database
       // usernameReference = FirebaseDatabase.getInstance().getReference("username")
       // passwordReference = FirebaseDatabase.getInstance().getReference("password")


        for (i in idPassList) {
            if (usernameRefernece.child("username") != usernameInput || usernameRefernece.child("password") != passwordInput) {
                Toast.makeText(applicationContext, "Incorrect", Toast.LENGTH_SHORT).show()
            }

            if (idPassList == usernameInput || idPassList == passwordInput) {
                var mapIntent = Intent(applicationContext, MapsActivity::class.java)
                startActivity(mapIntent)
            }
        }

    }




}
