package com.apps.ui.reset

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.apps.base.BaseFragment
import com.apps.databinding.FragmentResetBinding
import com.apps.extensions.observeFlow
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResetFragment : BaseFragment<FragmentResetBinding>() {

    private val viewModel by viewModel<ResetViewModel>()

    override fun onInitializeView(savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    override fun onObserveViewModel() {
        with(viewModel) {
            observeFlow(actionClick, ::handleOnClickEvent)
        }
    }

    private fun handleOnClickEvent(actionClick: ResetActionClick) {
        when(actionClick) {
            is ResetActionClick.Back -> {
                findNavController().popBackStack()
            }
        }
    }

}