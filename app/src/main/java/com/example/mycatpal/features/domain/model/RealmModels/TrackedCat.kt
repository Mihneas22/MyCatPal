package com.example.mycatpal.features.domain.model.RealmModels

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class TrackedCat: RealmObject {
    @PrimaryKey var _id: ObjectId = ObjectId()
    var name: String = ""
    var age: String = ""
    var gender: String = ""
    var breed: String = ""
    var birthday: String = ""
    var image: String = ""
}