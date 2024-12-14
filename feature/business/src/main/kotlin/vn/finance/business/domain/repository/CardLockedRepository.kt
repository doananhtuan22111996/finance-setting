package vn.finance.business.domain.repository

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import java.io.Serializable

interface CardLockedRepository {
    fun getCardLocked(): Flow<ResultModel<Boolean>>
    fun putCardLocked(value: Boolean): Flow<ResultModel<Nothing>>
}