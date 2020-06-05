package com.firozanwar.basicmvvm.data

class FakeDatabase private constructor() {

    var quoteeDao = FakeQuoteDao()
        private set

    companion object {
        @Volatile
        private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(lock = this) {
            instance ?: FakeDatabase().also {
                instance = it
            }
        }
    }
}