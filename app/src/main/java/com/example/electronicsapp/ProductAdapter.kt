package com.example.electronicsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val products: List<Product>,
    private val listener: OnProductClickListener
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.productImage)
        val nameTextView: TextView = itemView.findViewById(R.id.tvProductName)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tvProductDescription)
        val costTextView: TextView = itemView.findViewById(R.id.tvCost)
        val addButton: Button = itemView.findViewById(R.id.addButton)

        init {
            addButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onAddProduct(products[position])
                }
            }
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(products[position])
                }
            }
        }
    }


    interface OnProductClickListener {
        fun onAddProduct(product: Product)
        fun onItemClick(product: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.nameTextView.text = product.productName
        holder.descriptionTextView.text = product.productDescription
        holder.costTextView.text = "$${product.cost}"
        holder.imageView.setImageResource(product.imageResId)
    }

    override fun getItemCount() = products.size
}
