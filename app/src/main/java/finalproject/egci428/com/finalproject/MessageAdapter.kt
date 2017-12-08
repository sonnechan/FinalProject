package finalproject.egci428.com.finalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Created by Dell on 12/5/2017.
 */
class MessageAdapter(val mContext: Context, val layoutResId: Int, val messageList: List<Message>): ArrayAdapter<Message>(mContext, layoutResId, messageList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflator: LayoutInflater = LayoutInflater.from(mContext)
        val view: View = layoutInflator.inflate(layoutResId, null)
        val msgTextView = view.findViewById<TextView>(R.id.commentTxt)
        val msg = messageList[position]

        msgTextView.text = msg.message
        return view
    }
}