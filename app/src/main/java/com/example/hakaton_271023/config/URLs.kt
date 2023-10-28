package com.example.hakaton_271023.config

import java.net.URL

class URLs {
    private val mainURL = "https://0435-176-28-64-201.ngrok-free.app/api/"

    val registrationUserUrl = URL(mainURL+ "signup")
    val loginUserURL = URL(mainURL+"signin")
    val getProfileURL = URL(mainURL+"profile")

    val simpleGetURL = URL(mainURL+"simple_get")
    val withQueryParamURL = URL(mainURL+"with_query_param/")
}