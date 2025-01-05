package vn.finance.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.business.domain.repository.CardLockedRepository
import javax.inject.Inject

class GetCardLockedUseCase @Inject constructor(private val repository: CardLockedRepository) : BaseUseCase<Unit, ResultModel<Boolean>>() {
    override fun execute(vararg params: Unit?): Flow<ResultModel<Boolean>> = repository.getCardLocked()
}
