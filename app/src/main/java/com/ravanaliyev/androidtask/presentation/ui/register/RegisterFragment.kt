package com.ravanaliyev.androidtask.presentation.ui.register

import com.ravanaliyev.androidtask.common.BaseFragment
import com.ravanaliyev.androidtask.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    override fun onViewCreateFinish() {
        binding.buttonLogin.setOnClickListener {
            navigateBack()
        }
    }

}