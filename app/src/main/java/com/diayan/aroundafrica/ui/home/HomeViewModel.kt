package com.diayan.aroundafrica.ui.home

import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.diayan.aroundafrica.constants.AppConstants.LOCATIONS_REF
import com.diayan.aroundafrica.data.Places
import com.diayan.aroundafrica.data.firebase.FirebaseLiveDataQuery
import com.google.firebase.database.DataSnapshot

class HomeViewModel : ViewModel() {

    private val liveData = FirebaseLiveDataQuery(LOCATIONS_REF)
    private val placesLiveData: LiveData<Places> = Transformations.map(liveData, Deserializer())

    private inner class Deserializer: Function<DataSnapshot, Places>{
        override fun apply(dataSnapshot: DataSnapshot?): Places {
            return dataSnapshot?.getValue(Places::class.java)!!
        }
    }

    fun getPlacesLiveData(): LiveData<Places>{
        return placesLiveData
    }
}
