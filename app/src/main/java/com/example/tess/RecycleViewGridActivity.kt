import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tess.AdapterKu
import com.example.tess.ItemsGrid
import com.example.tess.R

class RecycleViewGridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_grid)

        val itemsList = generateDummyItems()
        val adapter = AdapterKu(itemsList)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    private fun generateDummyItems(): List<ItemsGrid> {
        val itemList = mutableListOf<ItemsGrid>()
        for (i in 1..20) {
            val item = ItemsGrid(R.drawable.mahakota3, "Item $i", "Description for item $i", "$10", "5 km")
            itemList.add(item)
        }
        return itemList
    }
}
