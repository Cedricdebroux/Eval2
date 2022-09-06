package com.technipixl.eval2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technipixl.eval2.databinding.FragmentConnectionBinding



class ConnectionFragment : Fragment() {

    private lateinit var binding: FragmentConnectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentConnectionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonTwitter.setOnClickListener {
            val action = R.id.action_connectionFragment_to_twitterFragment
            findNavController().navigate(action)
        }
        binding.buttonFacebook.setOnClickListener {
            val action = R.id.action_connectionFragment_to_facebookFragment
            findNavController().navigate(action)
        }
        binding.buttonBloggies.setOnClickListener {
            val action = R.id.action_connectionFragment_to_bloggiesFragment
            findNavController().navigate(action)
        }
    }


}