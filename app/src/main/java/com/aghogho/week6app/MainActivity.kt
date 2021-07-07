package com.aghogho.week6app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.aghogho.week6app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myShoppingAdapter: ShoppingAdapter
    private lateinit var myShoppingList: MutableList<ShoppingModel>
    private lateinit var viewModel: ShoppingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = viewModelProvider

        myShoppingList = mutableListOf()

        myShoppingAdapter = ShoppingAdapter(myShoppingList){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("CATEGORY_KEY", it).allowMainThreadQueries().build()
        }
        binding.recyclerView2.adapter = myShoppingAdapter

        val db = Room.databaseBuilder(
            applicationContext,
            ShoppingDatabase::class.java, "shopping-database"
        ).allowMainThreadQueries().build()

            val shoppingDAO = db.shoppingDao()

        shoppingDAO.getAllShoppingItems().observe(this,{
            myShoppingAdapter = ShoppingAdapter(it)
            binding.recyclerView2.adapter = myShoppingAdapter
            myShoppingAdapter.notifyDataSetChanged()

        })
        
        binding.button.setOnClickListener {
            val category : String = binding.editCat.text.toString()
            val description : String = binding.editDes.text.toString()
            val shoppingItem = ShoppingModel(category,description)
        }

        val shoppingItem = ShoppingModel(category,description)
        myShoppingList.add(shoppingItem)
        myShoppingAdapter.notifyDataSetChanged()
    }


}



}
