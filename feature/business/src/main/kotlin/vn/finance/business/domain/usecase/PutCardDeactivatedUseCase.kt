package vn.finance.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.business.domain.repository.CardDeactivatedRepository
import javax.inject.Inject

class PutCardDeactivatedUseCase @Inject constructor(private val repository: CardDeactivatedRepository) :
    BaseUseCase<Boolean, ResultModel<Nothing>>() {
    override fun execute(vararg params: Boolean?): Flow<ResultModel<Nothing>> {
        return repository.putCardDeactivated(value = params[0] ?: false)
    }
}