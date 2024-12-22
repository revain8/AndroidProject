package com.ravanaliyev.androidtask.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ravanaliyev.androidtask.common.BaseAdapter
import com.ravanaliyev.androidtask.data.model.ProductModel
import com.ravanaliyev.androidtask.databinding.ItemProductBinding

class ProductAdapter : BaseAdapter<ProductModel>() {

    lateinit var onClickItem: (item: ProductModel) -> Unit
    lateinit var onClickShare: () -> Unit
    lateinit var onClickLike: () -> Unit

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductModel) {
            with(binding) {
                ivItem.setImageResource(item.image)
                tvTitle.text = item.title
                tvDescription.text = item.description

                buttonLike.setOnClickListener {
                    if (this@ProductAdapter::onClickLike.isInitialized) onClickLike.invoke()
                }

                buttonShare.setOnClickListener {
                    if (this@ProductAdapter::onClickShare.isInitialized) onClickShare.invoke()
                }

                rootConstraint.setOnClickListener {
                    if (this@ProductAdapter::onClickItem.isInitialized) onClickItem.invoke(item)
                }

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder =
        ProductViewHolder(ItemProductBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductViewHolder -> {
                items.getOrNull(position)?.let {
                    holder.bind(it)
                }
            }
        }
    }


}