package com.anushka.navdemo5


import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.anushka.navdemo5.databinding.FragmentNameBinding


/**
 * A simple [Fragment] subclass.
 */
class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        binding.nextButton.setOnClickListener{
            if(!TextUtils.isEmpty(binding.nameEditText.text.toString())){
                val bundle = bundleOf("user_name" to binding.nameEditText.text.toString())
                it.findNavController().navigate(R.id.emailFragment,bundle)
            }else{
                Toast.makeText(activity, "Fucker enter the text first", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}
