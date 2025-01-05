package kmp.project.demo.db

import androidx.room.*
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kmp.project.demo.di.platformModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import org.koin.core.logger.Level
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

@Database(entities = [Car::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): CarDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

@Dao
interface CarDao {
    @Insert
    suspend fun insert(item: Car)

    @Query("SELECT count(*) FROM Car")
    suspend fun count(): Int

    @Query("SELECT * FROM Car")
    fun getAllAsFlow(): Flow<List<Car>>

    @Delete
    suspend fun delete(item:Car)
}

@Entity
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val number: String,
)

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(driver = BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()

}



fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
           platformModule
        )
    }

