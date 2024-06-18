package ru.easycode.zerotoheroandroidtdd

interface UiState {
    class Base(val text: String) : UiState {
        override fun equals(other: Any?): Boolean {
            return (other as Base).text == text
        }

        override fun hashCode(): Int {
            return text.hashCode()
        }
    }

    class Max(val text: String) : UiState {
        override fun equals(other: Any?): Boolean {
            return (other as Max).text == text
        }

        override fun hashCode(): Int {
            return text.hashCode()
        }
    }
}