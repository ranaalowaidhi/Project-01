package com.tuwaiq.rr.data.remote

import com.tuwaiq.rr.domain.models.UserData

data class UserDataDto(
    var username:String = "",
    var userId:String = "",
    var userPhoto:String = "",
    var userDesc:String = "",
    var joinedDate:String = ""
) {

    fun toUserData():UserData{
        return UserData(
            username = username,
            userId = userId,
            userPhoto = userPhoto,
            userDesc = userDesc,
            joinedDate = joinedDate
        )
    }

}