package com.app.currencyscoop.roomdatabase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")


class FavouritesEntity (@ColumnInfo(name = "currency_code")val currencyCode :String) {

    @PrimaryKey(autoGenerate = true) var id = 0
}