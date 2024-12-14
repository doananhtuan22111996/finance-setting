package vn.finance.business.domain.repository

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel

interface ThemeRepository {
    fun getDarkModeEnabled(): Flow<ResultModel<Boolean>>
    fun putDarkModeEnabled(value: Boolean): Flow<ResultModel<Nothing>>
}