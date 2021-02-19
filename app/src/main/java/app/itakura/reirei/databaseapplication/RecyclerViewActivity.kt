package app.itakura.reirei.databaseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_recycler_view.*
import java.util.*

class RecyclerViewActivity : AppCompatActivity() {

    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    private lateinit var adapter: MemoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val memoList = readAll()

        val content = intent.getStringExtra("content")
        Log.d("content",content.toString())

        // タスクリストが空だったときにダミーデータを生成する
        if (memoList.isEmpty()) {
            createDummyData()
        }
        else{
            create(content.toString())
        }

        val adapter = MemoListAdapter(this, memoList, true)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

//        adapter.addAll(memoList)
//        Log.d("memolist",memoList.toString())


    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun createDummyData() {
        for (i in 0..10) {
            create( "やること $i")
        }
    }

    fun create(content: String) {
        realm.executeTransaction {
            val memo = it.createObject(Memo::class.java, UUID.randomUUID().toString())
            memo.content = content
        }
    }

    fun readAll(): RealmResults<Memo> {
        return realm.where(Memo::class.java).findAll().sort("createdAt", Sort.ASCENDING)
    }



}