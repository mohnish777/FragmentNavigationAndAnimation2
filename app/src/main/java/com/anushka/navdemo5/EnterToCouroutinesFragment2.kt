package com.anushka.navdemo5

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.anushka.navdemo5.databinding.FragmentEnterToCouroutinesScreen2Binding
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
class EnterToCouroutinesScreen2 : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentEnterToCouroutinesScreen2Binding
    private var i: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_enter_to_couroutines_screen2, container, false)
        binding.incrementBtn.setOnClickListener {
            binding.incrementText.text = i++.toString()
        }

        binding.dwndUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch{
                binding.userDataText.text = UserDataManager().getUserDataTotalCount().toString()
                binding.userDataText2.text = UserDataManager().getUserDataTotalCount2().toString()
            }
        }

        return binding.root
    }

}


