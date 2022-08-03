package com.example.customviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.customviews.databinding.FragmentCustomLayoutBinding

class CustomLayoutFragment : Fragment() {

    private lateinit var binding: FragmentCustomLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.verticalCustomLayout.addItem("Set text")
        binding.verticalCustomLayout.addItem("Random text")
        binding.verticalCustomLayout.addItem("Text")
    }
}