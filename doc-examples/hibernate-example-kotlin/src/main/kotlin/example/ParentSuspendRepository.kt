package example

import io.micronaut.core.annotation.NonNull
import io.micronaut.data.annotation.Join
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.GenericRepository
import java.util.*
import javax.transaction.Transactional

@Repository
interface ParentSuspendRepository : GenericRepository<Parent, Int> {

    @Join(value = "children", type = Join.Type.FETCH)
    suspend fun findById(id: Int): Optional<Parent>

    @Transactional(Transactional.TxType.MANDATORY)
    suspend fun queryById(id: Int): Optional<Parent>

    suspend fun save(@NonNull entity: Parent): Parent

    suspend fun update(@NonNull entity: Parent): Parent

}
