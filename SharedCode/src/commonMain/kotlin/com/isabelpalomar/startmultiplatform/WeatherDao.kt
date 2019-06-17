package com.isabelpalomar.startmultiplatform

import com.isabelpalomar.startmultiplatform.db.model.WeatherModel


class WeatherDao(database: WeatherDatabase) {

    private val db = database.weatherModelQueries

    internal fun insert(item: Weather) {
        db.insertItem(
            base = item.base,
            coordinate = item.coord
        )
    }

    internal fun select():List<WeatherModel> = db.selectAll().executeAsList()
}