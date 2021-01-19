package com.smems.androidcleanexample

import android.os.Bundle
import android.util.Log
import android.view.View
import com.smems.androidcleanexample.base.BaseActivity
import com.smems.androidcleanexample.base.observe
import com.smems.androidcleanexample.base.withViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var vm: MainViewModel

    override val fragmentContainerId: Int = R.id.fragmentContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = withViewModel({ MainViewModel(this) }) {
            observe(details) {
                Log.d(TAG, "Details count: ${it?.size ?: 0}")
                it?.forEach { detail ->
                    Log.d(TAG, "---\ntitle: ${detail.title}\ndescription: ${detail.description}\naddress: ${detail.address}\n")
                }
            }
        }
    }

    override fun viewForError(): View? = fragmentContainer
}