package com.example.caesarciphertutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caesarciphertutorial.databinding.FragmentBruteForceListBinding


class BruteForceListFragment : Fragment() {

    private var _binding: FragmentBruteForceListBinding? = null
    private  val binding get() = _binding!!
    private lateinit var passedCipherText : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            passedCipherText = it.getString("cipherText")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_brute_force_list, container, false)
        _binding = FragmentBruteForceListBinding.inflate(inflater , container ,  false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cipherList = CaesarCipherObject.caesarCipherBruteForce(passedCipherText)
        binding.rView.layoutManager = LinearLayoutManager(context)
        binding.rView.adapter = BruteForceAdapter(cipherList)


    }
}