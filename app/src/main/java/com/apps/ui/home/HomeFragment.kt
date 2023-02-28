package com.apps.ui.home

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.apps.base.BaseFragment
import com.apps.constants.RequestKey
import com.apps.databinding.FragmentHomeBinding
import com.apps.extensions.getFragmentResult
import com.apps.extensions.observeFlow
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel by viewModel<HomeViewModel>()

    override fun onInitializeView(savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        getFragmentResult(RequestKey.login, ::onReceiveStatusLogin)
    }

    override fun onObserveViewModel() {
        with(viewModel) {
            observeFlow(userHasLogin, ::handleUserLogin)
        }
    }

    private fun handleUserLogin(isHasLogin: Boolean) {
        if (isHasLogin) setupDataHomePage() else navigateToLogin()
    }

    private fun navigateToLogin() {
        findNavController().navigate(HomeFragmentDirections.login())
    }

    private fun setupDataHomePage() {

    }

    private fun onReceiveStatusLogin(bundle: Bundle) {
        bundle.getBoolean(RequestKey.BundleKey.hasLogin).also { hasLogin ->
            if (hasLogin) viewModel.checkUserHasLogin()
        }
    }

}