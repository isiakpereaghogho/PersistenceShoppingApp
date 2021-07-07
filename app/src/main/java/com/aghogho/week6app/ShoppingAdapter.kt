package com.aghogho.week6app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aghogho.week6app.databinding.ActivityMainBinding
import com.aghogho.week6app.databinding.ShoppingItemBinding

class ShoppingAdapter(
    val shoppingItems: List<ShoppingModel>,
    val clickFnx: (ShoppingModel) -> Unit
    ): RecyclerView.Adapter<ShoppingAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ShoppingItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(shoppingItems: ShoppingModel){
            binding.category.text= shoppingItems.category
            binding.description.text= shoppingItems.description
            binding.root.setOnClickListener {
                clickFnx(shoppingItems)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
       val binding: ShoppingItemBinding= ShoppingItemBinding.inflate(LayoutInflater.from(parent.context))
                return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int): Unit {
       holder.bind(shoppingItems.get(position))
    }

    override fun getItemCount()=shoppingItems.size

}