package com.firozanwar.basicmvvm.utils

import com.firozanwar.basicmvvm.data.FakeDatabase
import com.firozanwar.basicmvvm.data.QuoteRepository
import com.firozanwar.basicmvvm.ui.QuotesViewModelfactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelfactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteeDao)
        return QuotesViewModelfactory(quoteRepository)
    }
}