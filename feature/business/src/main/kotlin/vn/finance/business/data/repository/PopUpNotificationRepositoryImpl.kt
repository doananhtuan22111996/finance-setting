package vn.finance.business.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import vn.core.data.local.PreferenceWrapper
import vn.core.domain.ResultModel
import vn.core.domain.TypeException
import vn.finance.business.PreferenceKeys.KEY_POP_UP_NOTIFICATION_ENABLED
import vn.finance.business.data.di.SettingPreferenceWrapper
import vn.finance.business.domain.repository.PopUpNotificationRepository
import javax.inject.Inject

class PopUpNotificationRepositoryImpl @Inject constructor(@SettingPreferenceWrapper private val preferenceWrapper: PreferenceWrapper) : PopUpNotificationRepository {
    override fun getPopUpNotificationEnabled(): Flow<ResultModel<Boolean>> = flow {
        try {
            val result = preferenceWrapper.getBoolean(KEY_POP_UP_NOTIFICATION_ENABLED, false)
            emit(ResultModel.Success(data = result))
        } catch (e: Exception) {
            emit(ResultModel.AppException(message = e.message, type = TypeException.Local))
        }
    }

    override fun putPopUpNotificationEnabled(value: Boolean): Flow<ResultModel<Nothing>> = flow {
        try {
            preferenceWrapper.saveBoolean(KEY_POP_UP_NOTIFICATION_ENABLED, value)
            emit(ResultModel.Success())
        } catch (e: Exception) {
            emit(ResultModel.AppException(message = e.message, type = TypeException.Local))
        }
    }
}
