package de.maxdobler.systemicconsensus.team

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class Team {
    @PrimaryKey(autoGenerate = true) var id = 0L
    var name = ""

    constructor(name: String) {
        this.name = name
    }
}