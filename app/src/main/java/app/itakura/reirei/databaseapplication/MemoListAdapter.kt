package app.itakura.reirei.databaseapplication


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import kotlinx.android.synthetic.main.item_memo.view.*
import java.text.SimpleDateFormat
import java.util.*

class MemoListAdapter(
    private val context: Context,
    private var taskList: OrderedRealmCollection<Memo>?,
    private val autoUpdate: Boolean
) :
    RecyclerView.Adapter<MemoListAdapter.MemoViewHolder>() {

    class MemoViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val contentTextView: TextView = view.findViewById(R.id.contentTextView)
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)


//        val imageView: ImageView = view.imageView
//        val contentTextView: TextView = view.contentTextView
//        val dateTextView: TextView = view.dateTextView
    }


    //val items:MutableList<Memo> = mutableListOf()

    override fun getItemCount(): Int = taskList?.size?:0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false)
        return MemoViewHolder(view)
    }


    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        val memo: Memo = taskList?.get(position) ?: return

        holder.imageView.setImageResource(memo.imageId)
        Log.d("imageView",holder.imageView.toString())
        holder.contentTextView.text = memo.content
        Log.d("contentTextView",holder.contentTextView.text.toString())
        holder.dateTextView.text =
            SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.JAPANESE).format(memo.createdAt)
        Log.d("dateTextView",holder.dateTextView.text.toString())




//        holder.imageView.setImageResource(memo.imageId)
//        holder.contentTextView.text = memo.content
//        holder.dateTextView.text =
//            SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.JAPANESE).format(memo.createdAt)

//        val imageView = holder.itemView.findViewById<ImageView>(R.id.imageView)
//        imageView.setImageResource(memo.imageId)

//        val content = holder.itemView.findViewById<TextView>(R.id.contentEditText)
//        content.text = memo.content
//
//        val date = holder.itemView.findViewById<TextView>(R.id.dateTextView)
//        date.text = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.JAPANESE).format(memo.createdAt)


    }

//    fun addAll(items:List<Memo>){
//        this.items.addAll(items)
//        notifyDataSetChanged()
//    }

}