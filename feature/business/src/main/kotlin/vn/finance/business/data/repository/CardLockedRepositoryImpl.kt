package vn.finance.business.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import vn.core.data.local.PreferenceWrapper
import vn.core.domain.ResultModel
import vn.core.domain.TypeException
import vn.finance.business.PreferenceKeys.KEY_CARD_LOCKED
import vn.finance.business.data.di.SettingPreferenceWrapper
import vn.finance.business.domain.repository.CardLockedRepository
import java.io.Serializable
import javax.inject.Inject

class CardLockedRepositoryImpl @Inject constructor(@SettingPreferenceWrapper private val preferenceWrapper: PreferenceWrapper) :
    CardLockedRepository {
    override fun getCardLocked(): Flow<ResultModel<Boolean>> = flow {
        try {
            val result = preferenceWrapper.getBoolean(KEY_CARD_LOCKED, false)
            emit(ResultModel.Success(data = result))
        } catch (e: Exception) {
            emit(ResultModel.AppException(message = e.message, type = TypeException.Local))
        }
    }

    override fun putCardLocked(value: Boolean): Flow<ResultModel<Nothing>> = flow {
        try {
            preferenceWrapper.saveBoolean(KEY_CARD_LOCKED, value)
            emit(ResultModel.Success())
        } catch (e: Exception) {
            emit(ResultModel.AppException(message = e.message, type = TypeException.Local))
        }
    }
}