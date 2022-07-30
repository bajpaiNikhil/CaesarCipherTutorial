package com.example.caesarciphertutorial

object CaesarCipherObject {

    private const val alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    // i a m s t u p i d
    fun caesarCipherEncryption(plainText: String, rotationKey: Int): String {
        var cipherText = ""
        // to make the algorithm case insensitive
        val plainTextCase = plainText.uppercase()
        for (character in plainTextCase) {
            // to find the numerical value of the character item in the plain text
            val characterValue = alphabet.indexOf(character)
            // to find the numerical value of the encrypted letter.
            val shiftCharacter = (characterValue + rotationKey) % alphabet.length
            // adding the string back to cipher text
            cipherText += alphabet[shiftCharacter]
        }

        return cipherText
    }

    fun caesarCipherDecryption(cipherText: String, rotationKey: Int): String {
        var plainText = ""
        for (character in cipherText) {
            val characterValue = alphabet.indexOf(character)
            val shiftCharacter = (characterValue - rotationKey).mod(alphabet.length)
            plainText += alphabet[shiftCharacter]
        }
        return plainText
    }
    // LDPVWXSLG


    fun caesarCipherBruteForce(cipherText: String): List<TextItem> {
        val textList = mutableListOf<TextItem>()
        for (key in alphabet.indices) {
            var plainText = ""
            for (character in cipherText) {
                val characterValue = alphabet.indexOf(character)
                val shiftCharacter = (characterValue - key).mod(alphabet.length)
                plainText += alphabet[shiftCharacter]
            }
            textList.add(TextItem(key , plainText))
//            println("the $key , $plainText")
//            textList.add(plainText)
        }
        return textList
    }

    fun caesarCipherFrequency(cipherText: String):String{
        val alphabetWithOutSpace = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val cipherMap = HashMap<Char, Int>()
        for(i in cipherText){
            cipherMap[i] = 1 + (cipherMap[i] ?: 0)
        }
        val mapMaxValue = cipherMap.maxBy {
            it.value
        }
        println("this is the frequencyMap $cipherMap , $mapMaxValue , ${mapMaxValue.key}")

        val key = alphabetWithOutSpace.indexOf(mapMaxValue.key) - alphabetWithOutSpace.indexOf("E")

        var plainText = ""
        for (character in cipherText) {
            val characterValue = alphabet.indexOf(character)
            val shiftCharacter = (characterValue - key).mod(alphabet.length)
            plainText += alphabet[shiftCharacter]
        }
        return plainText

    }
}