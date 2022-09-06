package com.technipixl.eval2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technipixl.eval2.databinding.FragmentConnectionBinding
import com.technipixl.eval2.databinding.FragmentFacebookBinding


class FacebookFragment : Fragment() {


    private lateinit var binding: FragmentFacebookBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFacebookBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.connexionButtonF.setOnClickListener {
        if (isValidEmail(binding.editTextTextEmailAddress.text)){
            val action = R.id.action_facebookFragment_to_facebookConnectFragment
            findNavController().navigate(action)
        } else {
            val builder = AlertDialog.Builder(context)
            with(builder) {
                setTitle("Erreur")
                setMessage("Login Incomplet")
                setPositiveButton("OK", object:DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                    }
                })

            }.show()

        }

        }
    }

    fun isValidEmail(target: CharSequence): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }
}