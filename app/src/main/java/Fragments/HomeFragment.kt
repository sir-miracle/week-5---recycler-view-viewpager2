package Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.weekfour_ui_viewpager_recyclerview.Model
import com.example.weekfour_ui_viewpager_recyclerview.R
import com.example.weekfour_ui_viewpager_recyclerview.RecyclerViewAdapter
import com.example.weekfour_ui_viewpager_recyclerview.ViewPagerAdapter

//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
//    private var param1: String? = null
//    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         val view =inflater!!.inflate(R.layout.fragment_home_, container, false)
        val theImages = listOf(
            R.drawable.microsoftteams_image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.lion,
            R.drawable.image3,
            R.drawable.image5,
            R.drawable.image6
        )
        val adapter = ViewPagerAdapter(theImages)
        view.findViewById<ViewPager2>(R.id.viewpager).adapter = adapter


        val arrayList = ArrayList<Model>()
        arrayList.add(Model(image = R.drawable.profile_1, name = "Ola Machiavllei"))
        arrayList.add(Model(image = R.drawable.profile_2, name = "Seun"))
        arrayList.add(Model(image = R.drawable.profile_4, name = "Ayodele"))
        arrayList.add(Model(image = R.drawable.profile_3png, name = "Festus"))

        val myAdapter = this.context?.let { RecyclerViewAdapter(arrayList, it) }
        view.findViewById<RecyclerView>(R.id.recyclerview).layoutManager = LinearLayoutManager(this.context)
        view.findViewById<RecyclerView>(R.id.recyclerview).adapter = myAdapter

        return view
    }
}