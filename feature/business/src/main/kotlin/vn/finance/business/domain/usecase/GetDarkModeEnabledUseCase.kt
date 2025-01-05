package vn.finance.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.business.domain.repository.ThemeRepository
import javax.inject.Inject

class GetDarkModeEnabledUseCase @Inject constructor(private val repository: ThemeRepository) : BaseUseCase<Unit, ResultModel<Boolean>>() {
    override fun execute(vararg params: Unit?): Flow<ResultModel<Boolean>> = repository.getDarkModeEnabled()
}
