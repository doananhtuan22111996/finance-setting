package vn.finance.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import vn.finance.api.SettingApi
import vn.finance.presentation.api.SettingApiImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
class ApiModule {

    @Provides
    @ActivityRetainedScoped
    fun provideSettingApi(): SettingApi = SettingApiImpl()
}