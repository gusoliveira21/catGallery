package br.com.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_table")
data class TableImagemRoom(
    @PrimaryKey(autoGenerate = true)
    var imageId: Long = 0L,
    @ColumnInfo(name = "image_column")
    var imagem: String? = null,
)
