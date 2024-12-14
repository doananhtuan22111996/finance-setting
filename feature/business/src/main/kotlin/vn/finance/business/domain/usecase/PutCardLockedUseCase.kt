package vn.finance.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.business.domain.repository.CardLockedRepository
import javax.inject.Inject

class PutCardLockedUseCase @Inject constructor(private val repository: CardLockedRepository) :
    BaseUseCase<Boolean, ResultModel<Nothing>>() {
    override fun execute(vararg params: Boolean?): Flow<ResultModel<Nothing>> {
        return repository.putCardLocked(value = params[0] ?: false)
    }
}