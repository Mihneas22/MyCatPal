package com.example.mycatpal.features.domain.model.RealmModels

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class TrackedUser: RealmObject {
    @PrimaryKey var _id: ObjectId = ObjectId()
    var email: String? = ""
    var password: String = ""
    var username: String = ""
    var cats: RealmList<TrackedCat> = realmListOf()
}