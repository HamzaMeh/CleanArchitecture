package com.archestro.cleanarchitecture.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.fragment.app.Fragment


abstract class BaseFragment : Fragment() {
    private var baseViewModel: BaseViewModel? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        baseViewModel = getViewModel()
        baseViewModel?.outcomeLiveData?.observe(viewLifecycleOwner) {
            when (it) {
                is Outcome.Start -> {
                    //  (activity as BaseActivity).displayProgressBar(true)
                }
                is Outcome.End -> {
                    //  (activity as BaseActivity).displayProgressBar(false)
                }
                is Outcome.Success -> {
                    //  (activity as BaseActivity).displayProgressBar(false)
                }
                is Outcome.Failure -> {
                    // (activity as BaseActivity).displayProgressBar(false)



                }
                is Outcome.NetworkError -> {
                    // (activity as BaseActivity).displayProgressBar(false)
                    // Toast.makeText(requireContext(), baseViewModel!!.outcomeLiveData.value.toString(), Toast.LENGTH_SHORT).show()
                    /* showSnackBarOnViews(
                         requireActivity(),
                         requireContext(),
                         baseViewModel!!.outcomeLiveData.value.toString(),
                         Gravity.TOP
                     )*/
                }
                else -> {}
            }

        }
    }

    abstract fun getViewModel(): BaseViewModel?
}