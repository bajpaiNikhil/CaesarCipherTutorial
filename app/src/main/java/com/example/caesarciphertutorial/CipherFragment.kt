package com.example.caesarciphertutorial

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.caesarciphertutorial.databinding.FragmentCipherBinding


class CipherFragment : Fragment() {

    private lateinit var itemIs : TextItem
    private var _binding : FragmentCipherBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itemIs = it.getParcelable<TextItem>("Item")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_cipher, container, false)
        _binding = FragmentCipherBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("CipherFragment" , itemIs.toString())
        val plainText = itemIs.text
        val cipherKey = itemIs.key

        val cipherText = CaesarCipherObject.caesarCipherEncryption(plainText ,cipherKey)

        binding.PlainTextTv.text = plainText
        binding.cipherTv.text = cipherText

        val cipherFrequency = CaesarCipherObject.caesarCipherFrequency(cipherText)
        binding.cipherBruteForce.setOnClickListener {
            val cipherTextToPass = bundleOf("cipherText" to cipherText)
            findNavController().navigate(R.id.action_cipherFragment_to_bruteForceListFragment , cipherTextToPass)
        }
        binding.cipherFrequencyAnalysis.setOnClickListener {
            Log.d("CipherFragment" , "this is the cipherFrequency $cipherFrequency")
            binding.cipherFrequencyAnalysis.text = cipherFrequency
        }

    }

}