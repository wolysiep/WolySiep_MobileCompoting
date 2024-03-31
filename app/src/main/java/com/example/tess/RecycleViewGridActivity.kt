import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tess.AdapterKu
import com.example.tess.ItemsGrid
import com.example.tess.R

class RecycleViewGridActivity : AppCompatActivity() {

    private lateinit var photoAdapter: AdapterKu
    private var dataList: ArrayList<ItemsGrid> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Inisialisasi adapter
        photoAdapter = AdapterKu(dataList)

        // Set layout manager menjadi GridLayoutManager
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)

        // Set adapter ke recyclerView
        recyclerView.adapter = photoAdapter

        // Tambahkan data ke dataList
        dataList.add(ItemsGrid("Title", "Desc", R.drawable.mahakota3))
        dataList.add(ItemsGrid("Title", "Desc", R.drawable.mahakota3))
        dataList.add(ItemsGrid("Title", "Desc", R.drawable.mahakota3))
        dataList.add(ItemsGrid("Title", "Desc", R.drawable.mahakota3))
        dataList.add(ItemsGrid("Title", "Desc", R.drawable.mahakota3))

        // Perbarui tampilan RecyclerView
        photoAdapter.notifyDataSetChanged()
    }
}
