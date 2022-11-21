package lx.com.kocoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import lx.com.kocoa.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    lateinit var binding: ActivitySearchBinding

    var searchAdapter:SearchAdapter? = null

    val searchInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.searchContainer, SearchFragment()).commit()

            binding.searchButton2.setOnClickListener {
                if(binding.searchInput.text.toString() == "2022") {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.searchContainer, AfterSearchFragment()).commit()
                }
            }


    }


}