package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import lx.com.kocoa.databinding.ActivityCalendarBinding


class CalendarActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalendarBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.januaryButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, JanuaryFragment()).commit()
        }

        binding.februaryButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, FebruaryFragment()).commit()
        }

        binding.marchButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, MarchFragment()).commit()
        }

        binding.aprilButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, AprilFragment()).commit()
        }

        binding.mayButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, MayFragment()).commit()
        }

        binding.juneButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, JuneFragment()).commit()
        }

        binding.julyButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, JulyFragment()).commit()
        }

        binding.augustButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, AugustFragment()).commit()
        }

        binding.septemberButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, SeptemberFragment()).commit()
        }

        binding.octoberButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, OctoberFragment()).commit()
        }

        binding.novemberButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, NovemberFragment()).commit()
        }

        binding.decemberButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, DecemberFragment()).commit()
        }


    }


}