const val TYPE_MASTERCARD = "MasterCard"
const val TYPE_MAESTRO = "Maestro"
const val TYPE_VISA = "Visa"
const val TYPE_MIR = "Mir"
const val TYPE_VK_PAY = "VK Pay"
const val ERROR_WRONG_TYPE = -1.0
const val ERROR_LIMIT = -2.0


fun main() {
    val typeCard = "Visa"
    val money = 10_000
    val previous = 117_500

    println(commission(typeCard, money, previous))
}

fun commission(typeCard: String = "тип", money: Int = 0, previous: Int = 0): Any {
    return when (typeCard) {
        TYPE_MASTERCARD, TYPE_MAESTRO -> if (money > 150_000 || money + previous > 600_000) {
            ERROR_LIMIT
        } else if (money in 300..75_000) 0.00 + previous else ((money * 0.006) + 20) + previous

        TYPE_VISA, TYPE_MIR -> if (money > 150_000 || money + previous > 600_000) {
            ERROR_LIMIT
        } else if ((money * 0.075) < 35) (money + 35) + previous else (money + (money * 0.075)) + previous

        TYPE_VK_PAY -> if (money > 15_000 || money + previous > 40_000) {
            ERROR_LIMIT
        } else money

        else -> ERROR_WRONG_TYPE
    }
}