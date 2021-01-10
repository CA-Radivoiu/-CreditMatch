package com.example.creditmatch.di

import com.example.creditmatch.application.creditform.data.BankRepository
import com.example.creditmatch.application.creditform.data.UserRepository
import com.example.creditmatch.dal.repository.BankRepositoryImpl
import com.example.creditmatch.dal.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module
object MainAppModule {
    @ActivityScoped
    @Provides
    fun provideUserRepository(

    ): UserRepository {
        return UserRepositoryImpl()
    }

    @ActivityScoped
    @Provides
    fun provideBankRepository(

    ): BankRepository {
        return BankRepositoryImpl()
    }


}