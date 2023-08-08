import junit.framework.TestCase.assertEquals
import org.junit.Test

class CommissionTest {


    @Test
    fun masterCardCommissionMore75_000() {
        val type = TYPE_MASTERCARD
        val money = 100_000
        val previous = 0

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(170.0, result)
    }

    @Test
    fun masterCardCommissionMore600_000() {
        val type = TYPE_MASTERCARD
        val money = 900_000
        val previous = 0

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun masterCardCommissionMore300() {
        val type = TYPE_MASTERCARD
        val money = 50_000
        val previous = 0

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(0.0, result)
    }

    @Test
    fun masterCardCommissionPrev() {
        val type = TYPE_MASTERCARD
        val money = 50_000
        val previous = 85_000

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(320.0, result)
    }

    @Test
    fun visaCommission() {
        val type = TYPE_VISA
        val money = 100_000
        val previous = 0

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(107500.0, result)
    }

    @Test
    fun visaCommissionMore150_000() {
        val type = TYPE_VISA
        val money = 200_000
        val previous = 0

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun visaCommissionMore600_000() {
        val type = TYPE_VISA
        val money = 800_000
        val previous = 0

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun visaCommissionLess100_000() {
        val type = TYPE_VISA
        val money = 100
        val previous = 0

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(135, result)
    }

    @Test
    fun vkPayCommission() {
        val type = TYPE_VK_PAY
        val money = 100_000
        val previous = 0

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun vkPayCommissionLess15_000() {
        val type = TYPE_VK_PAY
        val money = 10_000
        val previous = 0

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(money, result)
    }

    @Test
    fun wrongTypeCommission() {
        val type = "Union"
        val money = 100_000
        val previous = 0

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(ERROR_WRONG_TYPE, result)
    }

    @Test
    fun checkLimit() {
        val type = TYPE_MASTERCARD
        val money = 900_000
        val previous = 0

        val result = commission(typeCard = type, money = money, previous = previous)

        assertEquals(ERROR_LIMIT, result)
    }
}