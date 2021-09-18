package com.andriod.sharedelementanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andriod.sharedelementanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showList()
    }

    private fun showList() {
        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, ListFragment())
            .commit()
    }
}