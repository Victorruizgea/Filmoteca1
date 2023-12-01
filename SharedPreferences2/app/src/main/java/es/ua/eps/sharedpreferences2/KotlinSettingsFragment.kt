package es.ua.eps.sharedpreferences2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class KotlinSettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        val basicPreference: Preference? =
            findPreference("basic")

        // Configura el manejador de clics para la preferencia de navegación
        basicPreference?.setOnPreferenceClickListener {
            // Navega a la segunda pantalla de preferencias
            findNavController().navigate(R.xml.basic_preferences)
            true
        }
    }

}