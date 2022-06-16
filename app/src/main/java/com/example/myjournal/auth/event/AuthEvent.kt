package com.example.myjournal.auth.event

import com.example.myjournal.data.model.RegistrationRequest

sealed class AuthEvent{
    data class RegistrationEvent(val request: RegistrationRequest): AuthEvent()
}
