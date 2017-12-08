package finalproject.egci428.com.finalproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_rating.*

class RatingActivity : AppCompatActivity() {
    lateinit var dataReference: DatabaseReference
    lateinit var msgList: MutableList<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        dataReference = FirebaseDatabase.getInstance().getReference("dataMsg")
        msgList = mutableListOf()

        dataReference.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()) {
                    msgList.clear()
                    for (i in p0.children) {
                        val message = i.getValue(Message::class.java)
                        msgList.add(message!!)
                    }
                   /* val adapter = MessageAdapter(applicationContext, R.layout.message, msgList)
                    listView.adapter = adapter*/
                }
            }
        })

        ratingBtn.setOnClickListener(){
            saveData()
        }
    }

    private fun saveData(){
        val msg = editComment.text.toString()
        if(msg.isEmpty()){
            editComment.error = "Please enter data"
            return
        }

        val messageId = dataReference.push().key
        val messageData = Message(messageId, msg, ratingBar.rating.toInt())
        dataReference.child(messageId).setValue(messageData).addOnCompleteListener {
            // if it complete
            Toast.makeText(applicationContext, "Comment saved succesfully", Toast.LENGTH_SHORT).show()
        } //set the message that we are gonna send

        finish()
    }

}
