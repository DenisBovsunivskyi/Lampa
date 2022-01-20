package com.example.lampa.injection.modules

import android.content.Context
import com.example.lampa.network.NewsApi
import com.example.lampa.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideNewsRepository(
        authApi: NewsApi,
    ) = NewsRepository(authApi)

}
