package com.isabelpalomar.startmultiplatform

class CountriesRepository(
    private val countriesApi: CountriesApi
) {

    suspend fun fetchCountries(): Countries {
        return countriesApi.fetchCountries()
    }

}