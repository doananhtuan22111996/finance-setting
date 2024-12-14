package vn.finance.business.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import vn.core.data.local.PreferenceWrapper
import vn.core.domain.ResultModel
import vn.core.domain.TypeException
import vn.finance.business.PreferenceKeys.KEY_CARD_DEACTIVATED
import vn.finance.business.data.di.SettingPreferenceWrapper
import vn.finance.business.domain.repository.CardDeactivatedRepository
import javax.inject.Inject

class CardDeactivatedRepositoryImpl @Inject constructor(@SettingPreferenceWrapper private val preferenceWrapper: PreferenceWrapper) :
    CardDeactivatedRepository {
    override fun getCardDeactivated(): Flow<ResultModel<Boolean>> = flow {
        try {
            val result = preferenceWrapper.getBoolean(KEY_CARD_DEACTIVATED, false)
            emit(ResultModel.Success(data = result))
        } catch (e: Exception) {
            emit(ResultModel.AppException(message = e.message, type = TypeException.Local))
        }
    }

    override fun putCardDeactivated(value: Boolean): Flow<ResultModel<Nothing>> = flow {
        try {
            preferenceWrapper.saveBoolean(KEY_CARD_DEACTIVATED, value)
            emit(ResultModel.Success())
        } catch (e: Exception) {
            emit(ResultModel.AppException(message = e.message, type = TypeException.Local))
        }
    }

}