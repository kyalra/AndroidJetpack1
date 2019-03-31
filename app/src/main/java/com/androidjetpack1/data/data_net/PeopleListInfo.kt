package com.androidjetpack1.data.data_net

import com.androidjetpack1.data.data_model.People

class PeopleListInfo {
    companion object {
        var peopleList=initPeopleList()

        /**
         * add dummy data
         */

        private fun initPeopleList():MutableList<People>{
            var po_peoples= mutableListOf<People>()
            po_peoples.add(People(
                "Rizky",
                "Bekasi",
                "081381116275",
                "rizkyaldi0101@gmail.com",
                "fb.com/rials26",
                "gapunya",
                1))
            po_peoples.add(People(
                "Aldi",
                "Bekasi",
                "081381116275",
                "rizkyaldi0101@gmail.com",
                "fb.com/rials26",
                "gapunya",
                2))

            po_peoples.add(People(
                "Saputra",
                "Bekasi",
                "081381116275",
                "rizkyaldi0101@gmail.com",
                "fb.com/rials26",
                "gapunya",
                3))


            return  po_peoples
        }
    }
}