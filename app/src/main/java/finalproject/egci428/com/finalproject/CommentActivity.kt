package finalproject.egci428.com.finalproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_comment.*

class CommentActivity : AppCompatActivity() {
    lateinit var dataReference: DatabaseReference
    lateinit var msgList: MutableList<Message>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        dataReference = FirebaseDatabase.getInstance().getReference("dataMsg")
        //msgList = mutableListOf()

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
                     val adapter = MessageAdapter(applicationContext, R.layout.message, msgList)
                     commentTxt.adapter = adapter
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if(id == R.id.action_add){
            var add_action = Intent(applicationContext,RatingActivity::class.java)
            startActivity(add_action)
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
