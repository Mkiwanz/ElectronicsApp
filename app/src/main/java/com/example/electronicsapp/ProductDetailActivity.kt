package com.example.electronicsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productName = intent.getStringExtra("PRODUCT_NAME")
        val productDescription = intent.getStringExtra("PRODUCT_DESC")
        val productCost = intent.getDoubleExtra("PRODUCT_COST", 0.0)

        findViewById<TextView>(R.id.productNameTextView).text = productName
        findViewById<TextView>(R.id.productDescriptionTextView).text = productDescription
        findViewById<TextView>(R.id.productCostTextView).text =
            getString(R.string.product_cost, productCost)

        findViewById<Button>(R.id.homeButton).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}


