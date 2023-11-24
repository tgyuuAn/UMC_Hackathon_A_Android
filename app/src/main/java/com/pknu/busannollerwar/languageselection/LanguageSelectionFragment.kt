package com.pknu.busannollerwar.languageselection

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.recreate
import com.pknu.busannollerwar.R
import com.pknu.busannollerwar.databinding.FragmentLanguageSelectionBinding
import java.util.Locale


class LanguageSelectionFragment : Fragment() {

    lateinit var binding : FragmentLanguageSelectionBinding

//    val korean = binding.languageKoreaBtn
//    val english = binding.languageEnglishBtn
    private lateinit var language_code: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val sharedPreferences = activity?.getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences?.getString("language", "")
        if (language != null) {
            language_code = language
        }

        binding = FragmentLanguageSelectionBinding.inflate(inflater,container, false)

        binding.languageKoreaBtn.setOnClickListener {

            setLocate("ko")
            activity?.recreate()

        }

        binding.languageEnglishBtn.setOnClickListener {
            setLocate("en")
            activity?.recreate()
        }

        return binding.root
    }

    //Locale 객체를 생성특정 지리적, 정치적 또는 문화적 영역을 나타냅니다.
    private fun setLocate(Lang: String) {
        val locale = Locale(Lang) // Local 객체 생성. 인자로는 해당 언어의 축약어가 들어가게 됩니다. (ex. ko, en)
        Locale.setDefault(locale) // 생성한 Locale로 설정을 해줍니다.

        val configuration = Configuration() //이 클래스는 응용 프로그램이 검색하는 리소스에 영향을 줄 수 있는
        // 모든 장치 구성 정보를 설명합니다.

        configuration.setLocale(locale) // 현재 유저가 선호하는 언어를 환경 설정으로 맞춰 줍니다.
        // Configuration 업데이트
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());


        // Shared에 현재 언어 상태를 저장해 줍니다.
        val editor = activity?.getSharedPreferences("Settings", Context.MODE_PRIVATE)?.edit()
        editor?.putString("language", Lang)
        editor?.apply()
    }


}