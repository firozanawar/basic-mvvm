package com.firozanwar.basicmvvm.ui

import androidx.lifecycle.ViewModel
import com.firozanwar.basicmvvm.data.Quote
import com.firozanwar.basicmvvm.data.QuoteRepository

class QuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}