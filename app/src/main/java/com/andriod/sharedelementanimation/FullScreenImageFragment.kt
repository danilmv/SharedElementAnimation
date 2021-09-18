package com.andriod.sharedelementanimation

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.andriod.sharedelementanimation.databinding.FragmentFullscreenImageBinding

class FullScreenImageFragment : Fragment() {
    private var _binding: FragmentFullscreenImageBinding? = null
    private val binding: FragmentFullscreenImageBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFullscreenImageBinding.inflate(inflater)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_element)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageId = arguments?.getInt(KEY_IMAGE_ID) ?: 0

        binding.imageView.apply {
            setImageDrawable(AppCompatResources.getDrawable(requireContext(), imageId))
            transitionName = imageId.toString()
        }
    }

    companion object {
        const val KEY_IMAGE_ID = "image_id"
        fun newInstance(imageId: Int) =
            FullScreenImageFragment().apply {
                arguments = Bundle().apply { putInt(KEY_IMAGE_ID, imageId) }
            }
    }
}