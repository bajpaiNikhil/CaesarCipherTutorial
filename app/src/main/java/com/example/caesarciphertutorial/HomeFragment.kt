package com.example.caesarciphertutorial

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.caesarciphertutorial.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {

    lateinit var  item : TextItem
    private var keyValue = 0
    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.numberPicker.maxValue = 30
        binding.numberPicker.minValue = 0
        binding.numberPicker.value = 1
        binding.numberPicker.setOnValueChangedListener { p0, oldValue, newValue ->
            Log.d("MainActivity", "the values are $oldValue , $newValue ,$p0")
            keyValue = newValue
        }
        binding.generatButton.setOnClickListener {
            item = TextItem( keyValue , binding.plainText.text.toString())
            val bundle = bundleOf("Item" to item)
            findNavController().navigate(R.id.action_homeFragment_to_cipherFragment , bundle)
        }
    }

}