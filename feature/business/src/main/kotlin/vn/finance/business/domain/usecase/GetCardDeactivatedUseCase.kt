package vn.finance.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.business.domain.repository.CardDeactivatedRepository
import javax.inject.Inject

class GetCardDeactivatedUseCase @Inject constructor(private val repository: CardDeactivatedRepository) : BaseUseCase<Unit, ResultModel<Boolean>>() {
    override fun execute(vararg params: Unit?): Flow<ResultModel<Boolean>> = repository.getCardDeactivated()
}
