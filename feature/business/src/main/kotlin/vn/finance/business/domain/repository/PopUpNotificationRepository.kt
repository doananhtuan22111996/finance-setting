package vn.finance.business.domain.repository

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel

interface PopUpNotificationRepository {
    fun getPopUpNotificationEnabled(): Flow<ResultModel<Boolean>>
    fun putPopUpNotificationEnabled(value: Boolean): Flow<ResultModel<Nothing>>
}
