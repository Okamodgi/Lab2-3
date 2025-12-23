// Класс тура с переопределенным методом toString()
data class Tour(
    val name: String,
    val country: String,
    val duration: Int,
    val price: Double
) {
    override fun toString(): String {
        return "➤ $name | Страна: $country | Дней: $duration | Цена: $price руб."
    }
}