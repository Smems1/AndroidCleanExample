package com.smems.domain.usecase

import androidx.lifecycle.LiveData
import com.smems.domain.entity.Detail
import com.smems.domain.repository.DetailsRepository
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(private val detailsRepository: DetailsRepository) :
    BaseUseCase<Any?, LiveData<List<Detail>>, Any?>() {
    override fun execute(params: Any?, onError: (Any?) -> Unit): LiveData<List<Detail>> =
        detailsRepository.getAll()
}