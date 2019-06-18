package com.isabelpalomar.startmultiplatform

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.serialization.json.JSON

class CountriesApi(private val engine: HttpClientEngine) {

    private val client by lazy {
        HttpClient(engine) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(JSON.nonstrict)
            }
        }
    }

    suspend fun fetchCountries(): Countries {
        return client.get {
            url("$baseUrl/rest/v2/all?fields=name;capital")
        }
    }

    companion object {
        private const val baseUrl = "https://restcountries.eu"
    }
}