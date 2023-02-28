package com.apps.ui.forgot

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.apps.base.BaseFragment
import com.apps.databinding.FragmentForgotBinding
import com.apps.extensions.observeFlow
import org.koin.android.ext.android.inject

class ForgotFragment : BaseFragment<FragmentForgotBinding>() {

    private val viewModel by inject<ForgotViewModel>()

    override fun onInitializeView(savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    override fun onObserveViewModel() {
        with(viewModel) {
            observeFlow(actionClick, ::handleOnClickEvent)
        }
    }

    private fun handleOnClickEvent(actionClick: ForgotActionClick) {
        when(actionClick) {
            is ForgotActionClick.Back -> {
                findNavController().popBackStack()
            }
        }
    }

}