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
            inscriptionOnClick()
        }
    }
    fun isValidEmail(target: CharSequence): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

    fun inscriptionOnClick(){
        if (!isValidEamil()) return
        if (!isLoginValid()) return
        if (!isPasswordNotEmpty()) return
        if (!isSamePassword()) return

         else {

            val login = binding.editTextTextPersonName.text.toString()
            val direction = BloggiesFragmentDirections.actionBloggiesFragmentToBoogleConnectFragment("Bonjour $login")
            findNavController().navigate(direction)
        }
    }

    fun isLoginValid(): Boolean{
        if (binding.editTextTextPersonName.text.isEmpty()){
            showErrorDialog("Erreur","Le login n'a pas été rempli.")
            return false
        }
        return true
    }

    fun isSamePassword(): Boolean{
        val mdp1 = binding.editTextTextPassword2.text.toString()
        val mdp2 = binding.editTextTextPassword3.text.toString()
        if(mdp1 != mdp2){
            showErrorDialog("Erreur", "Les mots de passe ne correspondent pas")
            return false
        }
        return true
    }

    fun isPasswordNotEmpty(): Boolean{
        val mdp1 = binding.editTextTextPassword2.text.toString()
        val mdp2 = binding.editTextTextPassword3.text.toString()
        if(mdp1.isEmpty() && mdp2.isEmpty()){
            showErrorDialog("Erreur", "Les champs mots de passe ne peuvent pas être vide")
            return false
        }
        return true
    }

    fun isValidEamil():Boolean{
        if (!isValidEmail(binding.editTextTextEmailAddress2.text)){
            showErrorDialog("Erreur","Email Incomplet")
            return false
        }
        return true
    }

    fun showErrorDialog(title : String, errorMessage : String){
        val builder = AlertDialog.Builder(context)

        with(builder) {
            setTitle(title)
            setMessage(errorMessage)
            setPositiveButton("OK", object: DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                }
            })

        }.show()
    }
}