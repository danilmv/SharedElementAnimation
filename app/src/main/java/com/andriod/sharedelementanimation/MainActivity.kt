package com.andriod.sharedelementanimation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.andriod.sharedelementanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ListFragment.Contract {
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

    override fun onClick(imageId: Int, view: View) {
        supportFragmentManager.beginTransaction()
            .addSharedElement(view, view.transitionName)
            .replace(binding.container.id, FullScreenImageFragment.newInstance(imageId))
            .addToBackStack(null)
            .commit()
    }
}