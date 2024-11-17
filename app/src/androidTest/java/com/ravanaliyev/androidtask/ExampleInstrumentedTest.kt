package com.ravanaliyev.androidtask

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ravanaliyev.androidtask.ui.utils.CredentialsManager

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private val credentialsManager = CredentialsManager()

    @Test
    fun givenWrongEmail_returnsFalse() {
        assertFalse(credentialsManager.validateEmail("testEmail@acv").isSuccess)
    }

    @Test
    fun givenEmailIsEmpty_returnsFalse(){
        assertFalse(credentialsManager.validateEmail("").isSuccess)
    }

    @Test
    fun givenEmailIsCorrect_returnsTrue(){
        assertTrue(credentialsManager.validateEmail("test@gmail.com").isSuccess)
    }

    @Test
    fun givenPasswordIsEmpty_returnFalse(){
        assertFalse(credentialsManager.validatePassword("").isSuccess)
    }

    @Test
    fun givenPasswordIsCorrect_returnsTrue(){
        assertTrue(credentialsManager.validatePassword("1234").isSuccess)
    }

}