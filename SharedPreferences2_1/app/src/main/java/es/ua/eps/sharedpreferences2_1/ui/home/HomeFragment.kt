package es.ua.eps.sharedpreferences2_1.ui.home

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import es.ua.eps.sharedpreferences2_1.databinding.FragmentMainBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val text: TextView= binding.mostrarText;
        val prefs = activity?.let { PreferenceManager.getDefaultSharedPreferences(it) }
        val sizeValue = prefs?.getString("pref_size", "1")
        val fgColorValue = prefs?.getString("pref_fg_color", "#000000")
        val bgColorValue = prefs?.getString("pref_bg_color", "#000000")
        val boldValue = prefs?.getBoolean("pref_bold", false)
        val italicValue = prefs?.getBoolean("pref_italic", false)
        val alphaValue = prefs?.getInt("alpha_preference", 0)
        val rotationValue = prefs?.getInt("rotation_preference", 0)


        binding.previewButton.setOnClickListener {
            if(binding.editText.text.isEmpty()){

            }else{
                text.setText(binding.editText.text.toString())
                if (sizeValue != null) {
                    text.setTextSize(sizeValue.toFloat())
                }
                if (bgColorValue != null) {
                    if(alphaValue!=null){
                        val bgColor = Color.parseColor(bgColorValue)
                        val transparentColor = Color.argb(alphaValue/100, Color.red(bgColor), Color.green(bgColor), Color.blue(bgColor))
                        text.setBackgroundColor(bgColor)


                    }


                }
                if (fgColorValue != null) {

                    text.setTextColor(Color.parseColor(fgColorValue))
                }
                if(boldValue == true){
                    text.setTypeface(null, Typeface.BOLD)
                }
                if(italicValue==true){
                    text.setTypeface(null, Typeface.ITALIC)
                }

                if(rotationValue!=null){
                    text.rotation= rotationValue.toFloat()
                }




            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}