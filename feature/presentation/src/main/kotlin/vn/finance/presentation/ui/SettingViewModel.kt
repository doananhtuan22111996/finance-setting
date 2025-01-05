package vn.finance.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import vn.core.domain.ResultModel
import vn.finance.business.domain.usecase.GetCardDeactivatedUseCase
import vn.finance.business.domain.usecase.GetCardLockedUseCase
import vn.finance.business.domain.usecase.GetDarkModeEnabledUseCase
import vn.finance.business.domain.usecase.GetPopUpNotificationEnabledUseCase
import vn.finance.business.domain.usecase.PutCardDeactivatedUseCase
import vn.finance.business.domain.usecase.PutCardLockedUseCase
import vn.finance.business.domain.usecase.PutDarkModeEnabledUseCase
import vn.finance.business.domain.usecase.PutPopUpNotificationEnabledUseCase
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val getCardLockedUseCase: GetCardLockedUseCase,
    private val getCardDeactivatedUseCase: GetCardDeactivatedUseCase,
    private val getPopUpNotificationEnabledUseCase: GetPopUpNotificationEnabledUseCase,
    private val getDarkModeEnabledUseCase: GetDarkModeEnabledUseCase,
    private val putCardLockedUseCase: PutCardLockedUseCase,
    private val putCardDeactivatedUseCase: PutCardDeactivatedUseCase,
    private val putPopUpNotificationEnabledUseCase: PutPopUpNotificationEnabledUseCase,
    private val putDarkModeEnabledUseCase: PutDarkModeEnabledUseCase,
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _appException = MutableStateFlow<ResultModel.AppException?>(null)
    val appException = _appException.asStateFlow()

    private val _isLocked = MutableStateFlow(false)
    val isLocked = _isLocked.asStateFlow()

    private val _isDeactivated = MutableStateFlow(false)
    val isDeactivated = _isDeactivated.asStateFlow()

    private val _isNotifications = MutableStateFlow(false)
    val isNotifications = _isNotifications.asStateFlow()

    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode = _isDarkMode.asStateFlow()

    init {
        onGetSettingStatus()
    }

    fun onLockChanged(value: Boolean) {
        viewModelScope.launch {
            putCardLockedUseCase.execute(params = arrayOf(value)).collect {
                when (it) {
                    is ResultModel.Success -> {
                        _isLocked.emit(value)
                    }

                    is ResultModel.AppException -> {
                        _appException.emit(it)
                    }

                    else -> {
                        // Do nothing
                    }
                }
            }
        }
    }

    fun onDeactivateChanged(value: Boolean) {
        viewModelScope.launch {
            putCardDeactivatedUseCase.execute(params = arrayOf(value)).collect {
                when (it) {
                    is ResultModel.Success -> _isDeactivated.emit(value)

                    is ResultModel.AppException -> _appException.emit(it)

                    else -> {
                        // Do nothing
                    }
                }
            }
        }
    }

    fun onNotificationsChanged(value: Boolean) {
        viewModelScope.launch {
            putPopUpNotificationEnabledUseCase.execute(params = arrayOf(value)).collect {
                when (it) {
                    is ResultModel.Success -> _isNotifications.emit(value)

                    is ResultModel.AppException -> _appException.emit(it)

                    else -> {
                        // Do nothing
                    }
                }
            }
        }
    }

    fun onDarkModeChanged(value: Boolean) {
        viewModelScope.launch {
            putDarkModeEnabledUseCase.execute(params = arrayOf(value)).collect {
                when (it) {
                    is ResultModel.Success -> {
                        _isDarkMode.emit(value)
                    }

                    is ResultModel.AppException -> _appException.emit(it)

                    else -> {
                        // Do nothing
                    }
                }
            }
        }
    }

    fun onDismissAppException() {
        viewModelScope.launch {
            _appException.emit(null)
        }
    }

    private fun onGetSettingStatus() {
        viewModelScope.launch {
            combine(
                getCardLockedUseCase.execute(),
                getCardDeactivatedUseCase.execute(),
                getPopUpNotificationEnabledUseCase.execute(),
                getDarkModeEnabledUseCase.execute(),
            ) { locked, deactivated, popupNotification, darkMode ->
                SettingModel(
                    locked = locked,
                    deactivated = deactivated,
                    popupNotification = popupNotification,
                    darkMode = darkMode,
                )
            }.onStart { _isLoading.emit(true) }.onCompletion { _isLoading.emit(false) }
                .collect { model ->
                    if (model.locked is ResultModel.Success) {
                        _isLocked.emit(model.locked.data ?: false)
                    }
                    if (model.deactivated is ResultModel.Success) {
                        _isDeactivated.emit(model.deactivated.data ?: false)
                    }
                    if (model.popupNotification is ResultModel.Success) {
                        _isNotifications.emit(model.popupNotification.data ?: false)
                    }
                    if (model.darkMode is ResultModel.Success) {
                        _isDarkMode.emit(model.darkMode.data ?: false)
                    }
                    if (model.locked is ResultModel.AppException || model.deactivated is ResultModel.AppException || model.popupNotification is ResultModel.AppException || model.darkMode is ResultModel.AppException) {
                        _appException.emit(
                            (model.locked as? ResultModel.AppException)
                                ?: (model.deactivated as? ResultModel.AppException)
                                ?: (model.popupNotification as? ResultModel.AppException)
                                ?: (model.darkMode as ResultModel.AppException),
                        )
                    }
                }
        }
    }

    inner class SettingModel(
        val locked: ResultModel<Boolean>,
        val deactivated: ResultModel<Boolean>,
        val popupNotification: ResultModel<Boolean>,
        val darkMode: ResultModel<Boolean>,
    )
}
