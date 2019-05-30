package com.jj.sureping.intent.a2b

import android.os.Bundle
import android.util.Log
import com.jj.base.BaseActivity

/**
@author sureping
@create 19-5-30.
 */
open class Intent1Activity :BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(TAG,"onCreate")
    }
    override fun onStart() {
        super.onStart()
    }
    override fun onResume() {
        super.onResume()
    }
    override fun onPause() {
        super.onPause()
    }
    override fun onStop() {
        super.onStop()
    }
    override fun onDestroy() {
        super.onDestroy()
    }
}