package com.app.currencyscoop.roomdatabase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "base_currency")


class BaseCurrencyEntity (@ColumnInfo(name = "base_currency")val base_currency :String,@ColumnInfo(name = "conversion_list")val conversion_list :String) {

    @PrimaryKey(autoGenerate = true) var id = 0
}