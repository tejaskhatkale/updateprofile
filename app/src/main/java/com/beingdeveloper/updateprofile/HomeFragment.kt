package com.beingdeveloper.updateprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.beingdeveloper.updateprofile.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.personalDetailsButton.setOnClickListener {
            (activity as MainActivity).navigateToFragment(PersonalDetailsFragment(), true)
        }
        binding.kycUpdateButton.setOnClickListener {
            (activity as MainActivity).navigateToFragment(KYCUpdateFragment(), true)
        }
        binding.bankDetailsButton.setOnClickListener {
            (activity as MainActivity).navigateToFragment(BankDetailsFragment(), true)
        }
        binding.nomineeDetailsButton.setOnClickListener {
            (activity as MainActivity).navigateToFragment(NomineeDetailsFragment(), true)
        }
        binding.manageContactButton.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ManageContactFragment(), true)
        }
        binding.passwordButton.setOnClickListener {
            (activity as MainActivity).navigateToFragment(PasswordFragment(), true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
