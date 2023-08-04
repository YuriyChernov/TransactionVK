fun main() {
    var money = 80000.00
    val typeOfCard = "VK Pay"
    val transactionMaestroMasterCardMin = 300
    val transactionMaestroMasterCardMax = 75000
    val perCommissionVisaMir = 0.0075
    val minCommissionVisaMir = 35

    val commissionMaestroMasterCard = (money * 0.006) + 20
    val resultMaestroMasterCard = money + commissionMaestroMasterCard
    val maestroMasterCard = if (money >= transactionMaestroMasterCardMin && money <= transactionMaestroMasterCardMax) {
        money
    } else resultMaestroMasterCard

    val commissionVisaMir = money * perCommissionVisaMir
    val resultVisaMir = money + commissionVisaMir
    val resultVisaMir2 = money + minCommissionVisaMir
    val visaMir = if (commissionVisaMir < minCommissionVisaMir) {
        resultVisaMir2
    } else resultVisaMir

    val result = when (typeOfCard) {
        "Maestro", "MasterCard" -> maestroMasterCard
        "Visa", "Mir" -> visaMir
        "VK Pay" -> money
        else -> "Карта не найдена"
    }

    println("Ваш тип карты: $typeOfCard")
    println("Сумма перевода с комиссией: $result")
}