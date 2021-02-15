package app.itakura.reirei.databaseapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemoListAdapter: RecyclerView.Adapter<MemoListAdapter.MemoViewHolder>() {
    val memoList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false)
        return MemoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        val textView = holder.itemView.findViewById<TextView>(R.id.memo_text_view)
        textView.text = memoList[position]
    }

    override fun getItemCount(): Int = memoList.size

    class MemoViewHolder(view: View): RecyclerView.ViewHolder(view)
}