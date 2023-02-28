package com.apps.base

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * Base application `Fragment` class with overridden [onCreateView] that inflates the view
 * based on the [VB] type argument and set the [binding] property.
 *
 * @param VB The type of the View Binding class.
 */

@Suppress("MemberVisibilityCanBePrivate", "unused")
abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    private var _loading: LoadingDialog? = null

    // Binding can access by public
    val binding get() = _binding ?: throw RuntimeException(
        "Should only use binding after onCreateView and before onDestroyView"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = createBindingInstance(inflater, container)
        _loading = LoadingDialog(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitializeView(savedInstanceState)
        onObserveViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _loading?.dismiss()
        _loading = null
    }

    abstract fun onInitializeView(savedInstanceState: Bundle?)

    open fun onObserveViewModel() { }

    protected fun showLoading() {
        _loading?.show()
    }

    protected fun hideLoading() {
        _loading?.dismiss()
    }

    /** Creates new [VB] instance using reflection. */
    @Suppress("UNCHECKED_CAST")
    private fun createBindingInstance(inflater: LayoutInflater, container: ViewGroup?): VB {
        val vbType = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        val vbClass = vbType as Class<VB>
        val method = vbClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        return method.invoke(null, inflater, container, false) as VB
    }
}