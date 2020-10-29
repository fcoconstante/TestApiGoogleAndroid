package com.example.test.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines {

    fun <T : Any> ioThenMain(work: suspend (() -> T?), callback: ((T?) -> Unit)) =
        //after the executing the suspend fun we will get the result in the callback

        CoroutineScope(Dispatchers.Main).launch { //main thread
            val data = CoroutineScope(Dispatchers.IO).async rt@{ //IO thread
                return@rt work()
            }.await()

            callback(data)
        }

}