package ar.pmdm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ar.pmdm.databinding.FragmentTrozoBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TrozoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrozoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentTrozoBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTrozoBinding.inflate(inflater,container,false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etConsigna.asingarTexto(TrozoFragmentArgs.fromBundle(requireArguments()).elPaquete)

        binding.imEstrellaTrozo.setOnClickListener(){
            Snackbar.make(view,"clikeado",Snackbar.LENGTH_SHORT).show()
            findNavController().navigate(TrozoFragmentDirections.actionTrozoFragmentToPedazoFragment())
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}