package com.example.myjournal.auth.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myjournal.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Login : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return loginBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val registerLink = loginBinding.registerLink

        registerLink.setOnClickListener {
            val action = LoginDirections.actionLoginToRegister();
            val navController = findNavController()
            navController.navigate(action)

        }


    }


}