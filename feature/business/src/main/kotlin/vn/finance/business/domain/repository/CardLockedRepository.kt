package vn.finance.business.domain.repository

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel

interface CardLockedRepository {
    fun getCardLocked(): Flow<ResultModel<Boolean>>
    fun putCardLocked(value: Boolean): Flow<ResultModel<Nothing>>
}
