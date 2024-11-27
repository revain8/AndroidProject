package com.ravanaliyev.androidtask

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ravanaliyev.androidtask.utils.CredentialsManager
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

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
    fun givenEmailIsCorrect_returnsFalse() {
        assertFalse(credentialsManager.validateEmail("test@gmail.com").isSuccess)
    }

    @Test
    fun givenPasswordIsEmpty_returnFalse() {
        assertFalse(credentialsManager.validatePassword("").isSuccess)
    }

    @Test
    fun givenPasswordIsCorrect_returnsFalse() {
        assertFalse(credentialsManager.validatePassword("123").isSuccess)
    }


    @Test
    fun givenPasswordIsUser_returnsTrue() {
        assertTrue(credentialsManager.validatePassword("1234").isSuccess)
    }

    @Test
    fun givenEmailIsUser_returnsTrue() {
        assertTrue(credentialsManager.validateEmail("test@te.st").isSuccess)
    }

}