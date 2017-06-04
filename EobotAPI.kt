package com.whatever.is.your.package

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.interfaces.JSONObjectRequestListener
import java.util.logging.Logger

/**
 * Created by alberto on 02/06/17.
 */
class EobotAPI {

    companion object {
        val logger = Logger.getLogger(PasswordGenerator::class.java.name)
    }

    var urlApi : String = "https://www.eobot.com/api.aspx?"

    fun getBalances(userId : String, listener : JSONObjectRequestListener) : Unit {
        val urlToCall = urlApi+"total="+userId+"&json=true"
        logger.info("Url to call: $urlToCall")
        AndroidNetworking.get(urlToCall)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(listener)
    }

}