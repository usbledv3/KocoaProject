package lx.com.kocoa

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import kotlinx.android.synthetic.main.fragment_festinfor.*
import lx.com.kocoa.databinding.FragmentFestinforBinding
import java.lang.Exception


class FestInforFragment : Fragment() {

    var _binding : FragmentFestinforBinding? = null
    val binding get() = _binding!!
    var festAdapter:FestAdapter? = null
    val Gallary = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFestinforBinding.inflate(inflater, container, false)

        binding.addPosterButton.setOnClickListener { //사진첨부 버튼 눌렀을때
        openGallery()
            val Showposter = binding.inputPosterpic.drawable
            SAppData.data12 = Showposter
        }

        binding.checkInforButton.setOnClickListener {
            val Shwfestname = binding.festOpenName.text.toString()
            val Shwfestrange = binding.festOpenRange.text.toString()
            val Shwfestlocation = binding.festOpenLocation.text.toString()

            SAppData.data5 = Shwfestname
            SAppData.data6 = Shwfestrange
            SAppData.data7 = Shwfestlocation

            binding.festOutput1.text = "입력한 정보 확인 : ${Shwfestname}, ${Shwfestrange}, ${Shwfestlocation}"

            festAdapter?.apply {
                items.add(FestManagerData(Shwfestname, Shwfestrange,Shwfestlocation))
                notifyDataSetChanged()
            }
        }


        return binding.root
    }
    fun openGallery(){
        val intent:Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent,Gallary)
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK){
            if(requestCode==Gallary){
                var currentImageUrl : Uri? = data?.data
                try{
                    val bitmap = MediaStore.Images.Media.getBitmap(getActivity()?.contentResolver,currentImageUrl)
                    inputPosterpic.setImageBitmap(bitmap)
                }catch(e:Exception){
                    e.printStackTrace()
                }
            }
        }else{
            Log.d("ActivityResult","somthingWrong")
        }
    }

}