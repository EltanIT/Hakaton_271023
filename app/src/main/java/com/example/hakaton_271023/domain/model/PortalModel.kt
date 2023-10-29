package com.example.hakaton_271023.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

class PortalModel(
    @JsonProperty("id_") id_: String,
    @JsonProperty("name") var name: String?,
    @JsonProperty("owner_id") var owner_id: String?,
    @JsonProperty("phone_number") var phone_number: String?,
    @JsonProperty("inn") var inn: String?,
    @JsonProperty("address") var address: String?,
    @JsonProperty("logo") var logo: String?,
    @JsonProperty("color") var color: String?,
    @JsonProperty("purpose") var purpose: String?,
    @JsonProperty("mission") var mission: String?,
    @JsonProperty("description") var description: String?

){
    val id = id_
}