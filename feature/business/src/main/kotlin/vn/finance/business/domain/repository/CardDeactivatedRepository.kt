package vn.finance.business.domain.repository

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel

interface CardDeactivatedRepository {
    fun getCardDeactivated(): Flow<ResultModel<Boolean>>
    fun putCardDeactivated(value: Boolean): Flow<ResultModel<Nothing>>
}
