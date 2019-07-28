package raj.outlet_form.utilities

import raj.outlet_form.data.LocalDatabase
import raj.outlet_form.data.QuoteRepository

object InjectorUtils {

    // This will be called from QuotesActivity
   /* fun provideQuotesViewModelFactory(): ModuleViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = QuoteRepository.getInstance(LocalDatabase.getInstance().dao)
        return ModuleViewModelFactory(quoteRepository)
    }*/
}