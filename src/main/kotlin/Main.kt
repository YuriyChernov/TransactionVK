const val TYPE_MASTERCARD = "MasterCard"
const val TYPE_MAESTRO = "Maestro"
const val TYPE_VISA = "Visa"
const val TYPE_MIR = "Mir"
const val TYPE_VK_PAY = "VK Pay"
const val ERROR_WRONG_TYPE = -1.0
const val ERROR_LIMIT = -2.0


fun main() {
    println(commission(typeCard = TYPE_VISA, 100_000, 0))
}

fun commission(typeCard: String, money: Int, previous: Int): Any {
    return when (typeCard) {
        TYPE_MASTERCARD -> if (money > 150_000 || money + previous > 600_000) {
            ERROR_LIMIT
        } else if (money in 300..75_000) 0.00 else (money * 0.006) + 20

        TYPE_MAESTRO -> if (money > 150_000 || money + previous > 600_000) {
            ERROR_LIMIT
        } else if (money in 300..75_000) 0.00 else (money * 0.006) + 20

        TYPE_VISA -> if (money > 150_000 || money + previous > 600_000) {
            ERROR_LIMIT
        } else if ((money * 0.075) < 35) (money + 35) else money + (money * 0.075)

        TYPE_MIR -> if (money > 150_000 || money + previous > 600_000) {
            ERROR_LIMIT
        } else if ((money * 0.075) < 35) (money + 35) else money + (money * 0.075)

        TYPE_VK_PAY -> if (money > 15_000 || money + previous > 40_000) {
            ERROR_LIMIT
        } else money

        else -> ERROR_WRONG_TYPE
    }
}