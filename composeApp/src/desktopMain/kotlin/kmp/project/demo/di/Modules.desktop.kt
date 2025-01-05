package kmp.project.demo.di

import androidx.room.RoomDatabase
import kmp.project.demo.db.AppDatabase
import kmp.project.demo.db.getDatabaseBuilder
import kmp.project.demo.db.getRoomDatabase
import org.koin.dsl.module

actual val platformModule = module {
    single<AppDatabase> { getRoomDatabase(getDatabaseBuilder()) }
}
