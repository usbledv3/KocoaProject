package lx.com.kocoa

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_festpass.*
import lx.com.kocoa.databinding.FragmentFestgameBinding
import lx.com.kocoa.databinding.FragmentFestinforBinding
import lx.com.kocoa.databinding.FragmentFestpassBinding
import lx.com.kocoa.databinding.FragmentShwfirstBinding
import java.util.*

class FestPassFragment : Fragment() {
    var _binding : FragmentFestpassBinding? = null
    val binding get() = _binding!!
    var festAdapter:FestAdapter? = null

    var dateString1 = "" // 시작날짜입력기능
    var dateString2 = "" // 종료날짜입력기능
    var timeString = "" // 시간입력기능

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFestpassBinding.inflate(inflater, container, false)

        binding.checkPassButton.setOnClickListener {
            val passfestname = binding.passFestNameIn.text.toString()
            val passrange = binding.passFestRangeIn.text.toString()
            val passtime = binding.passTimeIn.text.toString()
            SAppData.data1 = passfestname
            SAppData.data3 = passrange
            SAppData.data4 = passtime

            binding.passOutput.text = "입력한 정보 확인 : ${passfestname}, ${passrange}, ${passtime}"
            val curActivity = activity as SHWMainActivity
            curActivity.replaceView(FestPassListFragment())
        }
        //아래는 적용시작 ~ 종료 날짜시간 입력하는 다이얼
        binding.date.setOnClickListener {
            val cal = Calendar.getInstance() // 캘린더뷰 만드는거
            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                dateString1 = "${year}년 ${month+1}월 ${dayOfMonth}일부터"
                passTimeIn.text = dateString1 + dateString2 + " / " + timeString
            }
            DatePickerDialog(requireContext(), dateSetListener, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show()
        }
        binding.date2.setOnClickListener {
            val cal = Calendar.getInstance() // 캘린더뷰 만드는거
            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                dateString2 = "${year}년 ${month+1}월 ${dayOfMonth}일까지,"
                passTimeIn.text = dateString1 + dateString2 + " / " + timeString
            }
            DatePickerDialog(requireContext(), dateSetListener, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        //아래는 날짜시간 입력하는 다이얼
        binding.time.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                timeString = "${hourOfDay}시 ${minute}분"
                passTimeIn.text = dateString1 + dateString2 + " / " + timeString
            }
            TimePickerDialog(requireContext(), timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true).show()
        }

        return binding.root

    }

    }


