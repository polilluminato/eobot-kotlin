package com.whatever.is.your.package

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.interfaces.JSONObjectRequestListener
import java.util.logging.Logger

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

    fun getMiningMode(userId : String, listener : JSONObjectRequestListener) : Unit {
        val urlToCall = urlApi+"idmining="+userId+"&json=true"
        logger.info("Url to call: $urlToCall")
        AndroidNetworking.get(urlToCall)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(listener)
    }


    fun getSpeed(userId : String, listener : JSONObjectRequestListener) : Unit {
        val urlToCall = urlApi+"idspeed="+userId+"&json=true"
        logger.info("Url to call: $urlToCall")
        AndroidNetworking.get(urlToCall)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(listener)
    }

    fun getDepositAddress(userId : String, depositType : String, listener : JSONObjectRequestListener) : Unit {
        val urlToCall = urlApi+"id="+userId+"&deposit="+depositType+"&json=true"
        logger.info("Url to call: $urlToCall")
        AndroidNetworking.get(urlToCall)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(listener)
    }

    fun getUserID(email : String, password : String, listener : JSONObjectRequestListener) : Unit {
        val urlToCall = urlApi+"email="+email+"&password="+password+"&json=true"
        logger.info("Url to call: $urlToCall")
        AndroidNetworking.get(urlToCall)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(listener)
    }


    fun setMiningMode(userId : String, email : String, 
                    password : String, miningMode : String, 
                    listener : JSONObjectRequestListener) : Unit {

        val options = 'id='+userId+'&email='+email+'&password='+password+'&mining='+miningMode
        val urlToCall = urlApi+options+"&json=true"
        logger.info("Url to call: $urlToCall")
        AndroidNetworking.get(urlToCall)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(listener)
    }


    fun setAutomaticWithdraw(userId : String, email : String, 
                                password : String, currency : String, 
                                amount : String, walletAddress : String, 
                                listener : JSONObjectRequestListener) : Unit {

        val options = 'id='+userId+'&email='+email+'&password='+password+'&withdraw='+currency+'&amount='+amount+'&wallet='+walletAddress
        val urlToCall = urlApi+options+"&json=true"
        logger.info("Url to call: $urlToCall")
        AndroidNetworking.get(urlToCall)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(listener)
    }


    fun manualWithdraw(userId : String, email : String, 
                                password : String, currency : String, 
                                amount : String, walletAddress : String, 
                                listener : JSONObjectRequestListener) : Unit {

        val options = 'id='+userId+'&email='+email+'&password='+password+'&manualwithdraw='+currency+'&amount='+amount+'&wallet='+walletAddress
        val urlToCall = urlApi+options+"&json=true"
        logger.info("Url to call: $urlToCall")
        AndroidNetworking.get(urlToCall)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(listener)
    }                          

}