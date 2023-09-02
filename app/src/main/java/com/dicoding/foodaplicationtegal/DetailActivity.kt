package com.dicoding.foodaplicationtegal

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_FOOD ="extra_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.title = "Food Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val imgFood: ImageView = findViewById(R.id.imgFood)
        val tvFood: TextView = findViewById(R.id.tv_foodName)
        val tvFoodDetail : TextView = findViewById(R.id.tv_foodDescription)
        val btnShare : Button = findViewById(R.id.action_share)


        val foods = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Food>(EXTRA_FOOD, Food::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Food>(EXTRA_FOOD)
        }
        if (foods != null) {
            imgFood.setImageResource(foods.photo)
            tvFood.text = foods.name
            tvFoodDetail.text = foods.description

            btnShare.setOnClickListener {
                Toast.makeText(this, "You Share " + foods.name, Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}