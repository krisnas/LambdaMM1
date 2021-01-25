package com.krisna_18102271.ligartani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import com.krisna_18102271.ligartani.data.SettingModel
import com.krisna_18102271.ligartani.databinding.ActivityDashboardBinding
import com.krisna_18102271.ligartani.databinding.ActivityMainBinding
import com.krisna_18102271.ligartani.util.SettingPreference

class DashboardActivity : AppCompatActivity() {
    companion object {
        private const val REQUEST_CODE = 100
    }

    private lateinit var mSettingPreference: SettingPreference
    private lateinit var settingModel: SettingModel
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        binding.act = this
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.main_title)
        mSettingPreference = SettingPreference(this)
        showExistingPreference()
    }

    private fun showExistingPreference() {
        settingModel = mSettingPreference.getSetting()
        populateView(settingModel)
    }
    private fun populateView(settingModel: SettingModel) {
        if (settingModel.isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            delegate.applyDayNight()
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            delegate.applyDayNight()
        }
        binding.settingModel = settingModel
    }
    fun openSetting(){
        val intent = Intent(this@DashboardActivity, SettingPreferenceActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == SettingPreferenceActivity.RESULT_CODE) {
                showExistingPreference()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_setting -> {
                val intent = Intent(this@DashboardActivity, SettingPreferenceActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }
}