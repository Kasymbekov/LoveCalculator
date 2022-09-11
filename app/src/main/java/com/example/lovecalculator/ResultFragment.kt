package com.example.lovecalculator

import android.R.attr.defaultValue
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lovecalculator.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentResultBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        val bundle = this.arguments
        if (bundle != null) {
            val result = bundle.getString("percentage", "0")
            binding.result.text = "$result%"
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.retryBtn.setOnClickListener {
            val fragmentManager = activity?.supportFragmentManager
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container_view, MainFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
    }
}