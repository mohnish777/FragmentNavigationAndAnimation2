package com.anushka.navdemo5


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
import com.anushka.navdemo5.databinding.FragmentEmailBinding


/**
 * A simple [Fragment] subclass.
 */
class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        val name: String = requireArguments().getString("user_name").toString()
        binding.submitButton.setOnClickListener{
            if(!TextUtils.isEmpty(binding.emailText.text.toString())){
                val bundles = bundleOf(
                    "user_email" to binding.emailEditText.text.toString(),
                    "user_name" to name
                    )
                it.findNavController().navigate(R.id.welcomeFragment, bundles)
            }else{
                Toast.makeText(activity, "Dummy enter the email", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}
