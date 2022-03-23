package com.example.chaptertigaparttwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_third.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val datanama = arguments?.getString("NAMA")
//
//        getnama.text = datanama

        val username = arguments?.getString("USERNAME")
        var tahun = arguments?.getString("TAHUN")
        var tahun_lahir = arguments?.getString("TAHUN_LAHIR")

        tv_username.text = username
        val umur = tahun!!.toInt() - tahun_lahir!!.toInt()
//        var umur = tahun - tahun_lahir

        tv_umur.text = umur.toString()

        fun cekUmur(umur : Int) : String{
            if(umur %2 == 0){
                return "Genap"
            }else{
                return "Ganjil"
            }
        }

        tv_cek.text = cekUmur(umur)

        gobackdua.setOnClickListener{

            val data = bundleOf("USERNAME" to username )
            Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_secondFragment, data)
        }
    }
}