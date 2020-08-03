package com.padcmyanmar.androidftc.padcx_movieappassignment_nct.dummy

import com.padcmyanmar.androidftc.padcx_movieappassignment_nct.data.vos.PersonVO

fun getDummyPerson():List<PersonVO> {
    val personOne = PersonVO()
    personOne.id = 1
    personOne.name = "First Person"
    personOne.profilePath = "/p3wxUblbPwRVzTp7jW1lXISKIob.jpg"
    val personTwo = PersonVO()
    personTwo.id = 2
    personTwo.name = "Second Person"
    personTwo.profilePath = "/p3wxUblbPwRVzTp7jW1lXISKIob.jpg"

    return arrayListOf(personOne,personTwo)
}