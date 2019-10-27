package com.diayan.aroundafrica.constants

import com.google.firebase.database.FirebaseDatabase

object AppConstants {
    val LOCATIONS_REF = FirebaseDatabase.getInstance().getReference("/locations")

}