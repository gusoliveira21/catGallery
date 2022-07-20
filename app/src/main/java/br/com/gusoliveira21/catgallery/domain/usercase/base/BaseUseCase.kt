package br.com.gusoliveira21.catgallery.domain.usercase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.withContext

abstract class BaseUseCase<in Params, out R> {

    private val superVisorJob = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + superVisorJob)

    protected abstract suspend fun doWork(params: Params): R

    suspend fun execute(params: Params): DataResult<R> {
        return withContext(scope.coroutineContext) {
            try {
                val result = withContext(Dispatchers.IO) { doWork(params) }
                DataResult.Success(result)
            } catch (e: Throwable) {
                DataResult.Failure
            }
        }
    }

    fun cancelWork() = scope.coroutineContext.cancelChildren()

}