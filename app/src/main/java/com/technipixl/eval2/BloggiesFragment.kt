package com.technipixl.eval2

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technipixl.eval2.databinding.FragmentBloggiesBinding

class BloggiesFragment : Fragment() {

    private lateinit var binding: FragmentBloggiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentBloggiesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonInscription.setOnClickListener {
            if (isValidEmail(binding.editTextTextEmailAddress2.text)){
                val action = R.id.action_bloggiesFragment_to_boogleConnectFragment
                findNavController().navigate(action)
            } else {
                val builder = AlertDialog.Builder(context)
                with(builder) {
                    setTitle("Erreur")
                    setMessage("Login Incomplet")
                    setPositiveButton("OK", object: DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                        }
                    })

                }.show()

            }
            if (binding.editTextTextPersonName.text.isEmpty()){
                val builder = AlertDialog.Builder(context)
                with(builder) {
                    setTitle("Erreur")
                    setMessage("Le login n'a pas été rempli.")
                    setPositiveButton("OK", object: DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                        }
                    })

                }.show()
            } else {
                val action = R.id.action_bloggiesFragment_to_boogleConnectFragment
                findNavController().navigate(action)
            }
            if(binding.editTextTextPassword2.text == binding.editTextTextEmailAddress2.text){
                val action = R.id.action_bloggiesFragment_to_boogleConnectFragment
                findNavController().navigate(action)
            } else {
                val builder = AlertDialog.Builder(context)
                with(builder) {
                    setTitle("Erreur")
                    setMessage("Les mots de passe ne correspondent pas")
                    setPositiveButton("OK", object: DialogInterface.OnClickListener{
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