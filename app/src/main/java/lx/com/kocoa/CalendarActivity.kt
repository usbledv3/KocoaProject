package lx.com.kocoa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import lx.com.kocoa.databinding.ActivityCalendarBinding


class CalendarActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalendarBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var data = listOf("1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월")

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,data)
        var spinner = binding.spinner
        spinner.adapter = adapter

        spinner.setSelection(0)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when(p2) {
                    0   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, JanuaryFragment()).commit()
                    }
                    1   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, FebruaryFragment()).commit()
                    }
                    2   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, MarchFragment()).commit()
                    }
                    3   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, AprilFragment()).commit()
                    }
                    4   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, MayFragment()).commit()
                    }
                    5   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, JuneFragment()).commit()
                    }
                    6   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, JulyFragment()).commit()
                    }
                    7   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, AugustFragment()).commit()
                    }
                    8   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, SeptemberFragment()).commit()
                    }
                    9   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, OctoberFragment()).commit()
                    }
                    10   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, NovemberFragment()).commit()
                    }
                    11   ->  {
                        supportFragmentManager.beginTransaction().replace(R.id.calendarContainer, DecemberFragment()).commit()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


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