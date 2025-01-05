package vn.finance.business.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import vn.core.data.local.PreferenceWrapper
import vn.finance.setting.business.BuildConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    @SettingPreferenceWrapper
    fun providePreferenceWrapper(@ApplicationContext context: Context): PreferenceWrapper = PreferenceWrapper(context = context, name = BuildConfig.LIBRARY_PACKAGE_NAME)
}
