package com.tuwaiq.rr.data.repos

import android.service.autofill.UserData
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tuwaiq.rr.data.remote.UserDataDto
import com.tuwaiq.rr.domain.repos.ProfileRepo
import kotlinx.coroutines.tasks.await

class ProfileRepoImpl : ProfileRepo {

    private val usersCollectionRef: CollectionReference = Firebase.firestore.collection("users")


    override suspend fun addUser(userData: UserData) {
        usersCollectionRef.add(userData).await()
    }

    override suspend fun getUser(userId: String): UserDataDto {
        val users = usersCollectionRef.whereEqualTo("userId", userId).get().await()
            .toObjects(UserDataDto::class.java)
        var user = UserDataDto()
        if (!users.isNullOrEmpty()){
            user = users.first()
        }
        return user
    }
}