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
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.drawer_header.view.*
import kotlinx.android.synthetic.main.fragment_festinfor.*
import lx.com.kocoa.databinding.FragmentFestinforBinding
import java.io.File
import java.lang.Exception


class FestInforFragment : Fragment() {

    var _binding : FragmentFestinforBinding? = null
    val binding get() = _binding!!
    var festAdapter:FestAdapter? = null
    val Gallary = 1
    var bitmap : Bitmap?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFestinforBinding.inflate(inflater, container, false)


        binding.addPosterButton.setOnClickListener { //사진첨부 버튼 눌렀을때
        openGallery() //갤러리 여는거 앨범런처구버젼
        }

        binding.checkInforButton.setOnClickListener {
            val Shwfestname = binding.festOpenName.text.toString()
            val Shwfestrange = binding.festOpenRange.text.toString()
            val Shwfestlocation = binding.festOpenLocation.text.toString()
            val Showposter = binding.inputPosterpic.imageView


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
    fun openGallery(){ //앨범런처 구버젼
        val intent:Intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.setType("image/*")
        startActivityForResult(intent,Gallary)
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK){
            if(requestCode==Gallary){
                var currentImageUrl : Uri? = data?.data
                SAppData.data12 = currentImageUrl
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