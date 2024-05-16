package com.example.horoscopoapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.horoscopoapp.adapters.SignoZodiacoMenuAdapter
import com.example.horoscopoapp.adapters.SignoZodiacoPagerAdapter
import com.example.horoscopoapp.dao.DataBaseMain
import com.example.horoscopoapp.databinding.FragmentSignoZodiacoMenuBinding
import com.example.horoscopoapp.models.SignoZodiaco
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SignoZodiacoMenuFragment : Fragment() {

    private var _binding: FragmentSignoZodiacoMenuBinding? = null
    val binding get() = _binding!!

    private var items: List<SignoZodiaco> = listOf()
    private lateinit var adapter: SignoZodiacoPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Fragmento 'SignoZodiacoMenuFragment'", "Creado")
        _binding = FragmentSignoZodiacoMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.mainMenuRv
        if(recyclerView != null){
            Log.d("RecyclerView", "Creado en onViewCreated")
            getItems()
            //recyclerView.adapter = SignoZodiacoAdapter(items)
            //recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        }else{
            Log.d("RecyclerView", "Esta 'null'")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*
    private fun getItems(){
        lifecycleScope.launch{
            val db: DataBaseMain = DataBaseMain.getDatabase(requireContext())
            val signos = db.SignoZodiacoDao().getAllSignoZodiaco()
            items = signos
        }
    }
*/
    private fun getItems(){
        lifecycleScope.launch {
            val deferredSignos = lifecycleScope.async {
                val db: DataBaseMain = DataBaseMain.getDatabase(requireContext())
                val signos = db.SignoZodiacoDao().getAllSignoZodiaco()
                signos
            }
            items = deferredSignos.await()

            val deferredDesc = lifecycleScope.async {
                val db: DataBaseMain = DataBaseMain.getDatabase(requireContext())
                //val desc = db.SignoZodiacoDescripcionDao().getDescripcionLastUnique()
            }

            //TODO: eh aquí el temita... la imagen está en la descripción, quizá debería estar en el signo como tal
            // no añadiría más complejidad que la de cambiar una entrada de BD si hubiera que cambiar las imágenes
            // también tengo que cambiar el fondo según el color elemento dle signo
            val recyclerView = binding.mainMenuRv
            recyclerView.adapter = SignoZodiacoMenuAdapter(requireContext(), items, listOf(), findNavController())
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        }
    }

}