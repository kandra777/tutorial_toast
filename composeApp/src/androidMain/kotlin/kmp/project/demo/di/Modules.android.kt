package kmp.project.demo.di

import androidx.room.RoomDatabase
import kmp.project.demo.db.AppDatabase
import kmp.project.demo.db.getDatabaseBuilder
import kmp.project.demo.db.getRoomDatabase
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<AppDatabase>{ getRoomDatabase(getDatabaseBuilder(get())) }
}