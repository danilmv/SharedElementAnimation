package com.andriod.sharedelementanimation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.andriod.sharedelementanimation.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = RecyclerAdapter()
        }
    }
}