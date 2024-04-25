package com.example.horoscopoapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.horoscopoapp.activity.adapters.SignoZodiacoAdapterPager
import com.example.horoscopoapp.adapters.SignoZodiacoAdapter
import com.example.horoscopoapp.dao.DataBaseMain
import com.example.horoscopoapp.databinding.FragmentSignoZodiacoMenuBinding
import com.example.horoscopoapp.models.SignoZodiaco
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SignoZodiacoMenuFragment : Fragment() {

    private var _binding: FragmentSignoZodiacoMenuBinding? = null
    val binding get() = _binding!!

    private var items: List<SignoZodiaco> = listOf()
    private lateinit var adapter: SignoZodiacoAdapterPager

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
            val deferred = lifecycleScope.async {
                val db: DataBaseMain = DataBaseMain.getDatabase(requireContext())
                val signos = db.SignoZodiacoDao().getAllSignoZodiaco()
                signos
            }

            items = deferred.await()

            val recyclerView = binding.mainMenuRv
            recyclerView.adapter = SignoZodiacoAdapter(items)
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
            // Después de inicializar items, configura el RecyclerView y el adaptador
            //setupRecyclerView()
        }
    }

}