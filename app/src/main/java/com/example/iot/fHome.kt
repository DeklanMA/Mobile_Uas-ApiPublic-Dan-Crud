package com.example.iot

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.iot.BMKG.BMKGActivity
import com.example.iot.BMKG.BMKGActivityList
import com.example.iot.config.DataConfigWaterR
import com.example.iot.databinding.FragmentFHomeBinding
import com.example.iot.model.Modelwaterreservoir
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable.isActive
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fHome.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("UNREACHABLE_CODE")
class fHome : Fragment() {

    // Deklarasi variabel lainnya

    private var calculateImageView: ImageView? = null
    private var profileImageView: ImageView? = null
    private  var BMIKalkulatorImageView: ImageView? = null
    private  var SuhuImageView: ImageView? = null
    private  var ConvertImageView: ImageView? = null
    lateinit var auth : FirebaseAuth

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentFHomeBinding? = null
    private val binding get() = _binding !!
    private val handler = Handler()


    private val scope = CoroutineScope(Dispatchers.Main + Job())

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

        _binding = FragmentFHomeBinding.inflate(layoutInflater)
        return binding.root


        auth = FirebaseAuth.getInstance()



        val profileImageView: ImageView? = view?.findViewById(R.id.profile)

        profileImageView?.setOnClickListener {
            val intent = Intent(activity, Main2Activity::class.java)
            startActivity(intent)
        }


        val logoutImageView: ImageView = requireView().findViewById(R.id.logout)

        logoutImageView.setOnClickListener {
            // Lakukan logout dari Firebase
            auth.signOut()

            // Redirect ke halaman login (atau halaman awal setelah logout)
            // Ganti LoginActivity::class.java dengan kelas aktivitas yang sesuai
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }



        // Inisialisasi view, binding, dan lainnya


        // Menambahkan OnClickListener ke calculateImageView
        val bmkg: ImageView = requireView().findViewById(R.id.bmkg)

        bmkg.setOnClickListener {
            val intent = Intent(activity, BMKGActivity::class.java)
            startActivity(intent)
        }
        val bmkglist: ImageView = requireView().findViewById(R.id.bmkglist)

        bmkg.setOnClickListener {
            val intent = Intent(activity, BMKGActivityList::class.java)
            startActivity(intent)
        }


        return view
    }
}