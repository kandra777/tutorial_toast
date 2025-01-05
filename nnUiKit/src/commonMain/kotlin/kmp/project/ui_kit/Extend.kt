package kmp.project.ui_kit
fun Int.toPaddedString(): String {
    return when {
        this in 0..9 ->"0${toString()}"
        else -> toString()
    }
}

