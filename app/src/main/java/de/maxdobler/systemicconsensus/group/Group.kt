package de.maxdobler.systemicconsensus.group

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class Group {
    @PrimaryKey(autoGenerate = true) var id = 0L
    var name = ""

    constructor(name: String) {
        this.name = name
    }
}