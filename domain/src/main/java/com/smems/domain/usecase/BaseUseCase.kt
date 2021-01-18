package com.smems.domain.usecase

abstract class BaseUseCase<in Params, R, E> {
    abstract fun execute(params: Params, onError: (E) -> Unit): R
}