package com.krisna_18102271.ligartani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.krisna_18102271.ligartani.data.SettingModel
import com.krisna_18102271.ligartani.databinding.ActivitySettingPreferenceBinding
import com.krisna_18102271.ligartani.util.SettingPreference

class SettingPreferenceActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mSettingPreference: SettingPreference
    private lateinit var settingModel: SettingModel
    private lateinit var binding: ActivitySettingPreferenceBinding
    companion object {
        const val RESULT_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener(this)
        mSettingPreference = SettingPreference(this)
        settingModel = mSettingPreference.getSetting()
        showPreferenceInForm()
        supportActionBar?.title = getString(R.string.setting_page)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val actionbar = supportActionBar

        actionbar!!.title = "Setting"

        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_save) {
            val name = binding.edtName.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val age = binding.edtAge.text.toString().trim()
            val phoneNo = binding.edtPhone.text.toString().trim()
            val gender = binding.edtGender.text.toString().trim()
            val address = binding.edtAddress.text.toString().trim()
            val isLoveMU = binding.rgLoveMu.checkedRadioButtonId == R.id.rb_yes
            if (name.isEmpty()) {
                binding.edtName.error = getString(R.string.field_required)
                return
            }
            if (email.isEmpty()) {
                binding.edtEmail.error = getString(R.string.field_required)
                return
            }
            if (!isValidEmail(email)) {
                binding.edtEmail.error = getString(R.string.email_is_not_valid)
                return
            }
            if (age.isEmpty()) {
                binding.edtAge.error = getString(R.string.field_required)
                return
            }
            if (phoneNo.isEmpty()) {
                binding.edtPhone.error = getString(R.string.field_required)
                return
            }
            if (!TextUtils.isDigitsOnly(phoneNo)) {
                binding.edtPhone.error = getString(R.string.field_digit_only)
                return
            }
            if (gender.isEmpty()) {
                binding.edtGender.error = getString(R.string.field_required)
                return
            }
            if (address.isEmpty()) {
                binding.edtAddress.error = getString(R.string.field_required)
                return
            }
            saveSetting(name, email, age, phoneNo, gender, address, isLoveMU)
            val resultIntent = Intent()
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun showPreferenceInForm() {
        binding.edtName.setText(settingModel.name)
        binding.edtEmail.setText(settingModel.email)
        binding.edtAge.setText(settingModel.age.toString())
        binding.edtPhone.setText(settingModel.phoneNumber)
        binding.edtGender.setText(settingModel.gender)
        binding.edtAddress.setText(settingModel.address)
        if (settingModel.isDarkTheme) {
            binding.rbYes.isChecked = true
        } else {
            binding.rbNo.isChecked = true
        }
    }
    private fun saveSetting(name: String, email: String, age: String, phoneNo: String, gender: String, address: String, isLoveMU: Boolean) {
        val settingPreference = SettingPreference(this)
        settingModel.name = name
        settingModel.email = email
        settingModel.age = Integer.parseInt(age)
        settingModel.phoneNumber = phoneNo
        settingModel.gender = gender
        settingModel.address = address
        settingModel.isDarkTheme = isLoveMU
        settingPreference.setSetting(settingModel)
        Toast.makeText(this, "Data tersimpan", Toast.LENGTH_SHORT).show()
    }
}