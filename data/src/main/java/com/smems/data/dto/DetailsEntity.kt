package com.smems.data.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.smems.data.dao.DetailsDao
import com.smems.domain.entity.Detail
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = DetailsDao.TABLE_NAME
)
data class DetailsEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val address: String
) : Parcelable {

    object Mapper {
        fun transform(model: Detail) = DetailsEntity(
            model.id,
            model.title,
            model.description,
            model.address
        )

        fun transform(entity: DetailsEntity) = Detail(
            entity.id,
            entity.title,
            entity.description,
            entity.address
        )
    }
}