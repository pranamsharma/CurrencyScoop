package com.app.currencyscoop.activity.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.currencyscoop.R
import com.app.currencyscoop.adapter.DeleteFavouritesInterface
import com.app.currencyscoop.adapter.MyFavouritesAdapter
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity
import com.app.currencyscoop.viewmodel.FavouritesViewModel
import kotlinx.android.synthetic.main.my_favourites_fragment.*


class MyFavouritesFragment : Fragment() {

    companion object {
        fun newInstance() = MyFavouritesFragment()
    }

    private lateinit var viewModel: FavouritesViewModel

    lateinit var myFavouritesAdapter: MyFavouritesAdapter

    lateinit var views:View
    lateinit var contexts:Context
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        views = inflater.inflate(R.layout.my_favourites_fragment, container, false)
        contexts=container!!.context
        return views
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavouritesViewModel::class.java)


        initRecyclerview()
        viewModel.allFavourites.observe(viewLifecycleOwner, Observer { list ->
            list?.let {
                myFavouritesAdapter.setCurrencyList(it)
            }
        })

    }

    private fun initRecyclerview(){
        favouritesRecyclerView.layoutManager= LinearLayoutManager(activity)
        myFavouritesAdapter= MyFavouritesAdapter(contexts ,object : DeleteFavouritesInterface {
            override fun onDeleteFavourite(favouritesEntity: FavouritesEntity, position: Int) {
                viewModel.deleteFavourites(favouritesEntity)
                // myFavouritesAdapter!!.notifyItemRemoved(position)
                myFavouritesAdapter!!.notifyDataSetChanged()
                Toast.makeText(activity, "${favouritesEntity.currencyCode} Deleted", Toast.LENGTH_SHORT).show()

            }

        })
        favouritesRecyclerView.adapter=myFavouritesAdapter

    }



}