package app.itakura.reirei.databaseapplication


import android.content.Context
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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false)
        return MemoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        val memo: Memo = taskList?.get(position) ?: return

//        holder.imageView.setImageResource(memo.imageId)
//        holder.contentEditText.text = memo.content
//        holder.dateTextView.text =
//            SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.JAPANESE).format(memo.createdAt)

//        val imageView = holder.itemView.findViewById<ImageView>(R.id.imageView)
//        imageView.setImageResource(memo.imageId)

        val content = holder.itemView.findViewById<TextView>(R.id.contentEditText)
        content.text = memo.content

        val date = holder.itemView.findViewById<TextView>(R.id.dateTextView)
        date.text = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.JAPANESE).format(memo.createdAt)


    }

    override fun getItemCount(): Int = taskList?.size?:0

    class MemoViewHolder(view: View): RecyclerView.ViewHolder(view){
        //val imageView: ImageView = view.imageView
        val contentTextView: TextView = view.contentTextView
        val dateTextView: TextView = view.dateTextView
    }

}