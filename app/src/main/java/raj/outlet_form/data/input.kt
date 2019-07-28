package raj.outlet_form.data

// Private primary constructor inaccessible from other classes
class LocalDatabase private constructor() {

    // All the DAOs go here!
    var dao = FakeQuoteDao()
        private set

    companion object {
        // @Volatile - Writes to this property are immediately visible to other threads
        @Volatile private var instance: LocalDatabase? = null

        // The only way to get hold of the LocalDatabase object
        fun getInstance() =
        // Already instantiated? - return the instance
            // Otherwise instantiate in a thread-safe manner
            instance ?: synchronized(this) {
                // If it's still not instantiated, finally create an object
                // also set the "instance" property to be the currently created one
                instance ?: LocalDatabase().also { instance = it }
            }
    }
}