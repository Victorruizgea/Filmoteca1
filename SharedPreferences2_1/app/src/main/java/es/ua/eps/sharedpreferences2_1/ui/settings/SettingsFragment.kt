package es.ua.eps.sharedpreferences2_1.ui.settings

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import es.ua.eps.sharedpreferences2_1.R
import es.ua.eps.sharedpreferences2_1.databinding.FragmentSettingsBinding

class SettingsFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_preference, rootKey)
        preferenceManager.sharedPreferences?.registerOnSharedPreferenceChangeListener(this)

        val sizeValue = preferenceManager.sharedPreferences?.getString("pref_size", "1")
        val fgColorValue = preferenceManager.sharedPreferences?.getString("pref_fg_color", "#000000")
        val bgColorValue = preferenceManager.sharedPreferences?.getString("pref_bg_color", "#000000")
        val boldValue = preferenceManager.sharedPreferences?.getBoolean("pref_bold", false)
        val italicValue = preferenceManager.sharedPreferences?.getBoolean("pref_italic", false)
        val alphaValue = preferenceManager.sharedPreferences?.getInt("alpha_preference", 0)
        val rotationValue = preferenceManager.sharedPreferences?.getInt("rotation_preference", 0)
        Log.d("aaa", sizeValue.toString());
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key == "pref_size") {
            val pref = findPreference<Preference>(key)
            val myKey = sharedPreferences!!.getString("pref_size", "1")

        }


    }
}


