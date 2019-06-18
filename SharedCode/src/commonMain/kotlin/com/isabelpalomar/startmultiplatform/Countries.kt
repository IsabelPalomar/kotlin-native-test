package com.isabelpalomar.startmultiplatform

import kotlinx.serialization.*

@Serializable
class Countries(
    val countries: List<Country>
) {

    @Serializer(Countries::class)
    companion object : KSerializer<Countries> {

        override fun serialize(output: Encoder, obj: Countries) {
            Country.serializer().list.serialize(output, obj.countries)
        }

        override fun deserialize(input: Decoder): Countries {
            return Countries(Country.serializer().list.deserialize(input))
        }
    }
}
