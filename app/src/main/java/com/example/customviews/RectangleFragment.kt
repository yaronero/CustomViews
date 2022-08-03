package com.example.customviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.customviews.databinding.FragmentRectangleBinding

class RectangleFragment : Fragment() {

    private lateinit var binding: FragmentRectangleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRectangleBinding.inflate(inflater, container, false)
        return binding.root
    }
}