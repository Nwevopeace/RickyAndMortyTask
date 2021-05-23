package com.peacecodes.rickyandmockytask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peacecodes.rickyandmockytask.databinding.CharactersItemListBinding

class CharactersAdapter(private val characterList: List<Characters>) :
    RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            CharactersItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val characters = characterList[position]
        holder.bind(characters)
    }

    override fun getItemCount(): Int = characterList.size

    inner class CharactersViewHolder(private val binding: CharactersItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(characters: Characters) {
            Glide.with(binding.root.context)
                .load(characters.image)
                .centerCrop()
                .into(binding.imageIv)
            binding.nameTv.text = characters.name
            binding.statusTv.text = characters.status
            binding.specieTv.text = characters.species
        }
    }
}