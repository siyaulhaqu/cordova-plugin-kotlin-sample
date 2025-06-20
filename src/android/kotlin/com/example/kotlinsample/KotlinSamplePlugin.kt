package com.example.kotlinsample

import org.apache.cordova.CordovaPlugin
import org.apache.cordova.CallbackContext
import org.json.JSONArray
import org.json.JSONException
import java.text.SimpleDateFormat
import java.util.*

class KotlinSamplePlugin : CordovaPlugin() {

    // Add this as a member function of your class
   /* private fun writeDebugLog(context: Context, message: String) {
        try {
            val logFile = File(context.getExternalFilesDir(null), "kotlin_debug.log")
            logFile.appendText("${SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Date())}: $message\n")
        } catch (e: Exception) {
            // Fallback to system logs if file writing fails
            Log.e("KOTLIN_DEBUG", "Failed to write log: ${e.message}")
        }
    }
    
    override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {

        writeDebugLog(cordova.context, "ENTER execute() - Action: $action")
        
        println("ANDROID_DEBUG: Received action - $action") // Check in Android Logcat
    
        when (action) {
                "echo" -> {
                    cordova.activity.runOnUiThread {
                        callbackContext.success("Direct from Kotlin")
                    }
                    return true
                }
                else -> return false
            }
    }*/
    
    override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
        return when (action) {
            "echo" -> {
                val message = args.getString(0)
                callbackContext.success(message)
                //this.echo(message, callbackContext)
                true
            }
            "getDate" -> {
                this.getDate(callbackContext)
                true
            }
            else -> false
        }
    }

    private fun echo(message: String, callbackContext: CallbackContext) {
        if (message.isNotEmpty()) {
            callbackContext.success(message)
        } else {
            callbackContext.error("Empty message!")
        }
    }

    private fun getDate(callbackContext: CallbackContext) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = dateFormat.format(Date())
        callbackContext.success(date)
    }
}
