package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lovecalculator.databinding.FragmentMainBinding
import com.example.lovecalculator.network.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentMainBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App().onCreate()
        clicker()
    }

    private fun clicker() {
        with(binding) {
            calcBtn.setOnClickListener {
                App.api.calculateLove(
                    firstName = firstName.text.toString(), secondName = secondName.text.toString()
                ).enqueue(
                    object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            val resFragment = ResultFragment()
                            val bundle = Bundle()
                            bundle.putString("percentage", response.body()?.percentage)
                            resFragment.arguments = bundle

                            val fragmentManager = activity?.supportFragmentManager
                            val transaction = fragmentManager?.beginTransaction()
                            transaction?.replace(R.id.fragment_container_view, resFragment)
                            transaction?.addToBackStack(null)
                            transaction?.commit()
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.e("ERROR", "Operation is failed.")
                        }

                    })
            }
        }


    }
}