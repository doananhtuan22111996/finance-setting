package vn.finance.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import vn.finance.business.data.repository.CardDeactivatedRepositoryImpl
import vn.finance.business.data.repository.CardLockedRepositoryImpl
import vn.finance.business.data.repository.PopUpNotificationRepositoryImpl
import vn.finance.business.data.repository.ThemeRepositoryImpl
import vn.finance.business.domain.repository.CardDeactivatedRepository
import vn.finance.business.domain.repository.CardLockedRepository
import vn.finance.business.domain.repository.PopUpNotificationRepository
import vn.finance.business.domain.repository.ThemeRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class DataModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindCardLockedRepository(impl: CardLockedRepositoryImpl): CardLockedRepository

    @Binds
    @ActivityRetainedScoped
    abstract fun bindCardDeactivatedRepository(impl: CardDeactivatedRepositoryImpl): CardDeactivatedRepository

    @Binds
    @ActivityRetainedScoped
    abstract fun bindPopUpNotificationRepository(impl: PopUpNotificationRepositoryImpl): PopUpNotificationRepository

    @Binds
    @ActivityRetainedScoped
    abstract fun bindThemeRepository(impl: ThemeRepositoryImpl): ThemeRepository
}