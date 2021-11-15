package com.example.weekfour_ui_viewpager_recyclerview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.weekfour_ui_viewpager_recyclerview.Model
import com.example.weekfour_ui_viewpager_recyclerview.R
import com.example.weekfour_ui_viewpager_recyclerview.RecyclerViewAdapter
import com.example.weekfour_ui_viewpager_recyclerview.ViewPagerAdapter

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.xml_test_activity, container, false)

//        val button = view.findViewById<Button>(R.id.start_animation)
//        val slider = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
//        val slided = view.findViewById<View>(R.id.slieded)
//
//        button.setOnClickListener {
//            slided.startAnimation(slider)
//        }

        val theImages =
            listOf( // This list contains the images that would be displayed as you scroll the view pager
                R.drawable.microsoftteams_image,
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.lion,
                R.drawable.image3,
                R.drawable.image5,
                R.drawable.image6
            )
        // setting the ViewPager2 widget to the variable viewpager using findViewById
        val viewPager = view.findViewById<ViewPager2>(R.id.viewpager)
        viewPager.adapter = ViewPagerAdapter(theImages)
        viewPager.setPadding(150, 0, 150, 0)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
//setting viewpager transformation
        val viewPageTransformer = CompositePageTransformer()
        viewPageTransformer.addTransformer(MarginPageTransformer(45))
        viewPageTransformer.addTransformer { page, position ->
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }
        viewPager.setPageTransformer(viewPageTransformer)

        val adapter = ViewPagerAdapter(theImages)
        view.findViewById<ViewPager2>(R.id.viewpager).adapter = adapter

// This arrayList holds the images and names of the recyclerView items.
        val arrayList = ArrayList<Model>()
        arrayList.add(Model(image = R.drawable.profile_1, name = "Ola Machiavllei"))
        arrayList.add(Model(image = R.drawable.profile_2, name = "Seun"))
        arrayList.add(Model(image = R.drawable.profile_4, name = "Ayodele"))
        arrayList.add(Model(image = R.drawable.profile_3png, name = "Festus"))

        val myAdapter = this.context?.let { RecyclerViewAdapter(arrayList, it) }
        view.findViewById<RecyclerView>(R.id.recyclerview).layoutManager =
            LinearLayoutManager(this.context)
        view.findViewById<RecyclerView>(R.id.recyclerview).adapter = myAdapter

        return view // view has to me returned so that the findViewById will be able to work in a fragment
    }
}