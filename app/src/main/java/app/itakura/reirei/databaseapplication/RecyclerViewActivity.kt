package app.itakura.reirei.databaseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var adapter: MemoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        adapter = MemoListAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.adapter = adapter

    }


}