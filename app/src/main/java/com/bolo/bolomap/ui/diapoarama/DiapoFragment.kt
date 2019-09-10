package com.bolo.bolomap.ui.diapoarama

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bolo.bolomap.R
import com.bolo.bolomap.db.entities.Media
import com.bolo.bolomap.ui.travelog.TravelogViewModel
import kotlin.random.Random

class DiapoFragment : Fragment() {

    private lateinit var travelogViewModel: TravelogViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        travelogViewModel =
            ViewModelProviders.of(this).get(TravelogViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all_diapo, container, false)
        val localRecycler:RecyclerView = root.findViewById(R.id.myrecycler)

        val photos0 = "https://s3.amazonaws.com/ceblog/wp-content/uploads/2012/05/20172622/ce-travel.jpg"
        val photos1 =  "https://miro.medium.com/max/2660/1*_6EdJgpcWyeWne36eFH7eA@2x.jpeg"
        val photos2 = "https://mcdaniel.hu/wp-content/uploads/2015/02/globe-map-suitcase-travel-1176x445.jpg"
        val photos3 = "https://www.backpackerguide.nz/wp-content/uploads/2017/10/new-zealand-1882703_1280.jpg"
        val photos4 = "https://www.abc.net.au/cm/rimage/10900134-16x9-xlarge.jpg?v=2"

        val media0 = Media(Random.nextInt(),null,"label1",null,null,photos0,null)
        val media1 = Media(Random.nextInt(),null,"label1",null,null,photos1,null)
        val media2 = Media(Random.nextInt(),null,"label1",null,null,photos2,null)
        val media3 = Media(Random.nextInt(),null,"label1",null,null,photos3,null)
        val media4 = Media(Random.nextInt(),null,"label1",null,null,photos4,null)

        val arrayMedias = ArrayList<Media>()
        arrayMedias.add(media0)
        arrayMedias.add(media1)
        arrayMedias.add(media2)
        arrayMedias.add(media3)
        arrayMedias.add(media4)

        localRecycler.adapter = DiapoAdapter(this,arrayMedias + arrayMedias + arrayMedias
                + arrayMedias+arrayMedias+arrayMedias+arrayMedias+arrayMedias+arrayMedias
                +arrayMedias+arrayMedias+arrayMedias+arrayMedias+arrayMedias
                +arrayMedias+arrayMedias+arrayMedias+arrayMedias+arrayMedias)
        localRecycler.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

        return root
    }

    fun navDetails(bundle: Bundle) {
        view?.findNavController()?.navigate(R.id.action_navigation_diapo_to_navigation_detail,bundle)
    }


}