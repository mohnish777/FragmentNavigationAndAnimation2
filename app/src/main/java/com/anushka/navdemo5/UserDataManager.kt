package com.anushka.navdemo5

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataManager {
    suspend fun getUserDataTotalCount(): Int{
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50
        } // this runs in future and the return statement will not wait for the answer i.e count
        return count // 0
    }

    suspend fun getUserDataTotalCount2(): Int{
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50
        } // this runs in the future, same here also return statment will not wait for the answer
        val deferred  = CoroutineScope(Dispatchers.IO).async {
            delay(3000)

            return@async 70
        } // this also runs in future, but since we are using await below, return statement will wait for the answer

        return count + deferred.await()
    }
}
