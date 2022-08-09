package br.com.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.data.room.TableImagemRoom

@Database(entities = [TableImagemRoom::class], version = 1, exportSchema = false)
abstract class DataBaseRoom: RoomDatabase() {


//    abstract val metodosDao: MetodosDao
//    companion object {
//        @Volatile
//        private var INSTANCE: DataBaseRoom? = null
//        fun getInstance(context: Context): DataBaseRoom {
//            synchronized(this){
//                var instance = INSTANCE
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        DataBaseRoom::class.java,
//                        "image_database")
//                        .fallbackToDestructiveMigration().build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
}