package com.firozanwar.basicmvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.firozanwar.basicmvvm.R
import com.firozanwar.basicmvvm.data.Quote
import com.firozanwar.basicmvvm.utils.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        initializeUI()
    }

    fun initializeUI() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(QuoteViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val sb = StringBuilder()
            quotes.forEach { quote ->
                sb.append("$quote\n\n")
            }

            textView_quotes.text = sb.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(),editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
