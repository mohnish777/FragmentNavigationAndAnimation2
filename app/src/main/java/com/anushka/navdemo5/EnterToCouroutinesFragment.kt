package com.anushka.navdemo5

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.anushka.navdemo5.databinding.FragmentEnterToCouroutinesScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EnterToCouroutinesScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class EnterToCouroutinesScreen : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentEnterToCouroutinesScreenBinding
    private var param1: String? = null
    private var param2: String? = null
    private var i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_enter_to_couroutines_screen, container, false)
        binding.incrementBtn.setOnClickListener {
            binding.incrementText.text = i++.toString()
        }

        binding.dwndUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
                downloadUserData()
            }
        }

        binding.fragNavigateto2nd.setOnClickListener {
            it.findNavController().navigate(R.id.enterToCouroutinesFragment2)
        }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    suspend fun downloadUserData(){
        for (i in 1..200000) {
            withContext(Dispatchers.Main){
                // Log.i("downloadUserData", "Download User $i in ${Thread.currentThread().name}")
                binding.userDataText.text = "Download user $i in ${Thread.currentThread().name}"
                delay(100)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EnterToCouroutinesScreen.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EnterToCouroutinesScreen().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


