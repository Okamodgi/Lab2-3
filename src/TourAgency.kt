class TourAgency {
    private val tours: MutableList<Tour> = mutableListOf()

    // Добавление тура
    fun add(tour: Tour) {
        tours.add(tour)
    }

    // Удаление тура
    fun remove(tour: Tour) {
        tours.remove(tour)
    }

    // Поиск по предикату
    fun search(predicate: (Tour) -> Boolean): List<Tour> = tours.filter(predicate)

    // Фильтрация
    fun filter(predicate: (Tour) -> Boolean): List<Tour> = tours.filter(predicate)

    // Сортировка
    fun sort(comparator: Comparator<Tour>): List<Tour> = tours.sortedWith(comparator)

    // Получение копии списка
    fun getAll(): List<Tour> = tours.toList()

    // Инфиксный метод
    infix fun include(tour: Tour): TourAgency {
        add(tour)
        return this
    }

    // Унарный оператор
    operator fun unaryPlus(): List<Tour> = getAll()

    // Бинарный оператор
    operator fun plus(other: TourAgency): TourAgency {
        val newAgency = TourAgency()
        newAgency.tours.addAll(this.tours)
        newAgency.tours.addAll(other.tours)
        return newAgency
    }

    // Функция высшего порядка
    fun process(action: (Tour) -> Unit) {
        tours.forEach(action)
    }

    // Лямбда с receiver
    fun configure(block: TourAgency.() -> Unit): TourAgency {
        this.block()
        return this
    }

    // Переопределение toString для красивого вывода
    override fun toString(): String {
        if (tours.isEmpty()) return "▶ Туров нет"
        return tours.joinToString(separator = "\n") { "  $it" }
    }

    // Дополнительный метод для вывода с заголовком
    fun displayTours() {
        println("▶ Список туров:")
        println(this)
    }
}

// Метод-расширение для сортировки по цене
fun TourAgency.sortByPrice(): List<Tour> = sort(compareBy { it.price })
