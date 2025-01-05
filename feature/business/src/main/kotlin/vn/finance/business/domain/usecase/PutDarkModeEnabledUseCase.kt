package vn.finance.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.business.domain.repository.ThemeRepository
import javax.inject.Inject

class PutDarkModeEnabledUseCase @Inject constructor(private val repository: ThemeRepository) : BaseUseCase<Boolean, ResultModel<Nothing>>() {
    override fun execute(vararg params: Boolean?): Flow<ResultModel<Nothing>> = repository.putDarkModeEnabled(value = params[0] ?: false)
}
