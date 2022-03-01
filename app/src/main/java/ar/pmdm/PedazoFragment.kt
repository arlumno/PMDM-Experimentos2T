package ar.pmdm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import ar.pmdm.databinding.FragmentPedazoBinding

// TODO: Rename parameter arguments, choose names that match


/**
 * A simple [Fragment] subclass.
 * Use the [PedazoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PedazoFragment : Fragment() {


    private var _binding: FragmentPedazoBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPedazoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imEstrella.setOnClickListener(){
            findNavController().navigate(PedazoFragmentDirections.actionPedazoFragmentToTrozoFragment(binding.tvPaquete.text.toString()))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}