package raj.outlet_form.data

data class ServerField(var title: String, var mandatory: Boolean)

data class Field(
    var title: CharSequence,
    var mandatory: Boolean,
    var initial: Any?
) {

    override fun toString(): String {
        return title.toString()
    }
}

data class FieldSet(val title: String, val fields: List<Field>, val enable: Boolean)

data class Step(val set: List<FieldSet>)

data class Quote(
    val quoteText: String,
    val author: String
) {

    override fun toString(): String {
        return "$quoteText - $author"
    }
}