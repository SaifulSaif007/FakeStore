package com.saiful.fakestore.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

private const val NETWORK_TIME_OUT = 6_000L

val ktorClient = HttpClient(Android) {

}