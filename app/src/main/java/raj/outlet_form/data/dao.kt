package raj.outlet_form.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

class InputDao {

    private val _listServerFields = mutableListOf<ServerField>()
    private val _serverFields = MutableLiveData<List<ServerField>>()

    init {
        _serverFields.value = _listServerFields
    }

    fun serverFields() = _serverFields as LiveData<List<ServerField>>
}

class FakeQuoteDao {
    // A fake database table
    private val quoteList = mutableListOf<Quote>()
    // MutableLiveData is from the Architecture Components Library
    // LiveData can be observed for changes
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        // Immediately connect the now empty quoteList
        // to the MutableLiveData which can be observed
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        // After adding a quote to the "database",
        // update the value of MutableLiveData
        // which will notify its active observers
        quotes.value = quoteList
    }

    // Casting MutableLiveData to LiveData because its value
    // shouldn't be changed from other classes
    fun getQuotes() = quotes as LiveData<List<Quote>>
}