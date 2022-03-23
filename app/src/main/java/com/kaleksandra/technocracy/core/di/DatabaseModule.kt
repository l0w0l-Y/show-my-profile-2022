package com.kaleksandra.technocracy.core.di

import android.content.Context
import com.kaleksandra.technocracy.feature.data_view.di.data.db.dao.ProfileDao
import com.kaleksandra.technocracy.feature.data_view.di.data.db.dao.ProfileDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideProfileDao(appDatabase: ProfileDatabase): ProfileDao {
        return appDatabase.profileDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ProfileDatabase {
        return ProfileDatabase.getDatabase(appContext)
    }
}