package com.example.electronicsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ProductAdapter.OnProductClickListener {

    private val products = ArrayList<Product>()
    private val cart = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        products.add(Product(R.drawable.ipad, "iPad", "iPad Pro 11-inch", 400.0))
        products.add(Product(R.drawable.iphone, "iPhone", "iPhone 13 pro max", 660.0))
        products.add(Product(R.drawable.airpods, "Airpods 2", "AirPods 2", 190.0))

        val productAdapter = ProductAdapter(products, this)

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productAdapter
        }

        findViewById<Button>(R.id.btnViewCart).setOnClickListener {
            Toast.makeText(this@MainActivity, "Cart: $cart", Toast.LENGTH_LONG).show()
        }
    }

    override fun onAddProduct(product: Product) {
        cart.add(product)
        Toast.makeText(this, "${product.productName} added to cart!", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(product: Product) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("PRODUCT_NAME", product.productName)
        intent.putExtra("PRODUCT_DESC", product.productDescription)
        intent.putExtra("PRODUCT_COST", product.cost)
        startActivity(intent)
    }
}
