package com.example.caesarciphertutorial

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.caesarciphertutorial.databinding.CipherItemBinding
import org.w3c.dom.Text
import javax.crypto.Cipher

class BruteForceAdapter(val listIs : List<TextItem>): RecyclerView.Adapter<BruteForceAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(var binding : CipherItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = CipherItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = listIs[position]
        holder.binding.planTextRviewTv.text = currentItem.key.toString()
        holder.binding.cipherTextRviewTv.text = currentItem.text
    }

    override fun getItemCount(): Int {
        return listIs.size
    }


}