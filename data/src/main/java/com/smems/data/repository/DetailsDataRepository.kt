package com.smems.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.smems.data.ICoroutines
import com.smems.data.R
import com.smems.data.dao.DetailsDao
import com.smems.data.dto.DetailsEntity
import com.smems.domain.entity.Detail
import com.smems.domain.repository.DetailsRepository
import kotlinx.coroutines.Job
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsDataRepository @Inject constructor(
    private val context: Context,
    private val detailsDao: DetailsDao
) :
    DetailsRepository, ICoroutines {

    override val jobs: MutableSet<Job> = mutableSetOf()

    override fun getAll(): LiveData<List<Detail>> {
        execute {
            val inpStr: InputStream = context.resources.openRawResource(R.raw.details)
            val details = Gson().fromJson<Array<DetailsEntity>>(
                JsonReader(InputStreamReader(inpStr)),
                Array<DetailsEntity>::class.java
            )
            detailsDao.save(details.toList())
        }
        return Transformations.map(detailsDao.getAll()) { entity ->
            entity.map { DetailsEntity.Mapper.transform(it) }
        }
    }
}