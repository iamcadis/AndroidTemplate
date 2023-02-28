package com.apps.ui.login

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.apps.base.BaseFragment
import com.apps.constants.RequestKey
import com.apps.databinding.FragmentLoginBinding
import com.apps.extensions.addOnBackPressedDispatcher
import com.apps.extensions.observeFlow
import com.apps.extensions.sendDataToPrevFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addOnBackPressedDispatcher { activity?.finish() }
    }

    override fun onInitializeView(savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    override fun onObserveViewModel() {
        with(viewModel) {
            observeFlow(actionClick, ::handleOnClickEvent)
        }
    }

    private fun handleOnClickEvent(actionClick: LoginActionClick) {
        when(actionClick) {
            is LoginActionClick.ForgotPassword -> {
                findNavController().navigate(LoginFragmentDirections.forgot())
            }
        }
    }

    private fun handleUserSuccessLogin() {
        val bundle = bundleOf(RequestKey.BundleKey.hasLogin to true)
        sendDataToPrevFragment(RequestKey.login, bundle)
    }

}