package com.example.aplicaciontaller.Data.database

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.room3.ColumnTypeConverter
import androidx.room3.ColumnTypeConverters
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.example.aplicaciontaller.Data.dao.CartDao
import com.example.aplicaciontaller.Data.dao.CategoryDao
import com.example.aplicaciontaller.Data.dao.ProductDao
import com.example.aplicaciontaller.Data.model.CartItem
import com.example.aplicaciontaller.Data.model.Category
import com.example.aplicaciontaller.Data.model.Product

object ColorConverter {
    @ColumnTypeConverter
    fun fromColor(color: Color): Int {
        return color.toArgb()
    }

    @ColumnTypeConverter
    fun toColor(colorInt: Int): Color {
        return Color(colorInt)
    }
}

@Database(
    entities = [
        Category::class,
        Product::class,
        CartItem::class,
    ],
    version = 3,
    exportSchema = false
)
@ColumnTypeConverters(ColorConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductDao
    abstract fun cartItemDao(): CartDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration(true)
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}
