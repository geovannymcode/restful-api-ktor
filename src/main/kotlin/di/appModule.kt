package com.geovannycode.di

import com.geovannycode.repository.SpeakerRepository
import com.geovannycode.services.SpeakerService
import org.koin.dsl.module

val appModule = module {
    single { SpeakerRepository() }
    single { SpeakerService(get()) }
}