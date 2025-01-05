package vn.finance.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import vn.finance.business.domain.repository.CardDeactivatedRepository
import vn.finance.business.domain.repository.CardLockedRepository
import vn.finance.business.domain.repository.PopUpNotificationRepository
import vn.finance.business.domain.repository.ThemeRepository
import vn.finance.business.domain.usecase.GetCardDeactivatedUseCase
import vn.finance.business.domain.usecase.GetCardLockedUseCase
import vn.finance.business.domain.usecase.GetDarkModeEnabledUseCase
import vn.finance.business.domain.usecase.GetPopUpNotificationEnabledUseCase
import vn.finance.business.domain.usecase.PutCardDeactivatedUseCase
import vn.finance.business.domain.usecase.PutCardLockedUseCase
import vn.finance.business.domain.usecase.PutDarkModeEnabledUseCase
import vn.finance.business.domain.usecase.PutPopUpNotificationEnabledUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    @ViewModelScoped
    fun provideGetCardLockedUseCase(repository: CardLockedRepository): GetCardLockedUseCase = GetCardLockedUseCase(repository = repository)

    @Provides
    @ViewModelScoped
    fun provideGetCardDeactivatedUseCase(repository: CardDeactivatedRepository): GetCardDeactivatedUseCase = GetCardDeactivatedUseCase(repository = repository)

    @Provides
    @ViewModelScoped
    fun provideGetPopUpNotificationEnabledUseCase(repository: PopUpNotificationRepository): GetPopUpNotificationEnabledUseCase = GetPopUpNotificationEnabledUseCase(repository = repository)

    @Provides
    @ViewModelScoped
    fun providePutCardLockedUseCase(repository: CardLockedRepository): PutCardLockedUseCase = PutCardLockedUseCase(repository = repository)

    @Provides
    @ViewModelScoped
    fun providePutCardDeactivatedUseCase(repository: CardDeactivatedRepository): PutCardDeactivatedUseCase = PutCardDeactivatedUseCase(repository = repository)

    @Provides
    @ViewModelScoped
    fun providePutPopUpNotificationEnabledUseCase(repository: PopUpNotificationRepository): PutPopUpNotificationEnabledUseCase = PutPopUpNotificationEnabledUseCase(repository = repository)

    @Provides
    @ViewModelScoped
    fun provideGetDarkModeEnabledUseCase(repository: ThemeRepository): GetDarkModeEnabledUseCase = GetDarkModeEnabledUseCase(repository = repository)

    @Provides
    @ViewModelScoped
    fun providePutDarkModeEnabledUseCase(repository: ThemeRepository): PutDarkModeEnabledUseCase = PutDarkModeEnabledUseCase(repository = repository)
}
