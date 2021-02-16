package app.itakura.reirei.databaseapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val realm:Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val memo:Memo? = read()

        if (memo != null){
            contentEditText.setText(memo.content)
        }

        saveButton.setOnClickListener {
            val content:String = contentEditText.text.toString()
            save(content)

            val intent = Intent(this, RecyclerViewActivity::class.java)
            intent.putExtra("content", content.toString())
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun read():Memo?{
        return realm.where(Memo::class.java).findFirst()
    }

    fun save(content: String){
        val memo:Memo? = read()

        realm.executeTransaction {
            if (memo  != null){
                memo.content = content
            }else{
                val newMemo:Memo = it.createObject(Memo::class.java)
                newMemo.content = content
            }

            Snackbar.make(container, "保存しました！", Snackbar.LENGTH_SHORT).show()
        }
    }

}