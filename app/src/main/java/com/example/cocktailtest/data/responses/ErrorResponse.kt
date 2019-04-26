package com.example.cocktailtest.data.responses

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
        @SerializedName("message") val error: String
)
