package com.example.chaptertigaparttwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_second.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = arguments?.getString("USERNAME")

        tv_nama.text = "Hallo $username"

        gototiga.setOnClickListener {
            if(input_tahun != null && input_tahun_lahir != null){
                val tahun = input_tahun.text.toString()
                val tahun_lahir = input_tahun_lahir.text.toString()
                val data = bundleOf("TAHUN" to tahun, "TAHUN_LAHIR" to tahun_lahir, "USERNAME" to username)

                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment, data)

            }else{
                tv_error.text = "format umur salah"
            }

        }
    }
}