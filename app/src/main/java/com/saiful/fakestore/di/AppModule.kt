package com.saiful.fakestore.di

import com.saiful.fakestore.data.repository.RepositoryImpl
import com.saiful.fakestore.domain.repository.Repository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::RepositoryImpl) { bind<Repository>() }
}