package finalproject.egci428.com.finalproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Message (val id:String, val message:String, val rating: Int) {
    constructor(): this("","",0)
}