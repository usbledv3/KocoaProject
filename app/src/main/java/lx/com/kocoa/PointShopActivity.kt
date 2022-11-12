package lx.com.kocoa

import android.app.AlertDialog
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.google.zxing.BarcodeFormat
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.lx.list.PointAppData
import com.lx.list.PointShopAdapter
import lx.com.kocoa.databinding.ActivityPointShopBinding

class PointShopActivity : AppCompatActivity() {

    lateinit var binding : ActivityPointShopBinding

    var customerAdapter : PointShopAdapter? = null

    var customerInfoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }
    val pointLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback { }
    )


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPointShopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* QR 스캔 선언 */


        // 리스트 초기화
//        initList()

        /* 보유 포인트 */
        binding.rewardPoint2.setText("보유 포인트 : ${PointAppData.reward} points")

        // 사진 바인딩
        binding.profileView1.setImageResource(R.drawable.san2)
        binding.profileView2.setImageResource(R.drawable.san1)
        binding.profileView3.setImageResource(R.drawable.cable)
        binding.profileView4.setImageResource(R.drawable.hotel1)

        // 첫번째 버튼
        binding.pointButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            when (PointAppData.reward) {
                in 5000..1000000 -> {
                    builder.setTitle("산천어 빵을 교환하셨습니다")
                        .setMessage("\n 'bang'을 입력하세요")
                        .setPositiveButton("확인",
                            DialogInterface.OnClickListener { dialog, id ->
                            })
                    builder.show()
                    PointAppData.reward = PointAppData.reward!! - 5000
                    binding.rewardPoint2.text = "보유 포인트 : ${PointAppData.reward} points"
                    binding.rewardWrite1.text = "'bang'"
                }
            }
        }
        // 두번째 버튼
        binding.pointButton2.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            when (PointAppData.reward) {
                in 5000..1000000 -> {
                    builder.setTitle("산천어를 교환하셨습니다")
                        .setMessage("\n 'san'을 입력하세요")
                        .setPositiveButton("확인",
                            DialogInterface.OnClickListener { dialog, id ->
                            })
                    builder.show()
                    PointAppData.reward = PointAppData.reward!! - 10000
                    binding.rewardPoint2.text = "보유 포인트 : ${PointAppData.reward} points"
                    binding.rewardWrite2.text = "'san'"
                }
            }
        }
        // 세번째 버튼
        binding.pointButton3.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            when (PointAppData.reward) {
                in 5000..1000000 -> {
                    builder.setTitle("케이블카 쿠폰을 교환하셨습니다")
                        .setMessage("\n 'cable'을 입력하세요")
                        .setPositiveButton("확인",
                            DialogInterface.OnClickListener { dialog, id ->
                                /*R.drawable.cable*/
                            })
                    builder.show()
                    PointAppData.reward = PointAppData.reward!! - 15000
                    binding.rewardPoint2.text = "보유 포인트 : ${PointAppData.reward} points"
                    binding.rewardWrite3.text = "'cable'"
                }
            }
        }

        // 네번째 버튼
        binding.pointButton4.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            when (PointAppData.reward) {
                in 5000..1000000 -> {
                    builder.setTitle("호텔숙박권을 교환하셨습니다")
                        .setIcon(R.drawable.hotel1)
                        .setMessage("\n 'hotel'을 입력하세요")
                        .setPositiveButton("확인",
                            DialogInterface.OnClickListener { dialog, id ->
                            })
                    builder.show()
                    PointAppData.reward = PointAppData.reward!! - 20000
                    binding.rewardPoint2.text = "보유 포인트 : ${PointAppData.reward} points"
                    binding.rewardWrite4.text = "'hotel'"
                }
            }
        }

        // QR 생성 (포인트샵)
        binding.generateBarcode.setOnClickListener {
            val barcodeEncoder = BarcodeEncoder()
            val barcodeBitmap = barcodeEncoder.encodeBitmap(
                binding.barcodeText.text.toString(),
                BarcodeFormat.QR_CODE,400,400
            )
            binding.barcodeImage.setImageBitmap(barcodeBitmap)

            val input1 = binding.barcodeText.text.toString()
            val input2 = binding.barcodeText.text.toString()
            val input3 = binding.barcodeText.text.toString()
            val input4 = binding.barcodeText.text.toString()

            if (input1 == "bang") {
                binding.rewardWrite1.text = "'${input1}' - 사용된 코드"
            } else if (input2 == "san") {
                binding.rewardWrite2.text = "'${input2}' - 사용된 코드"
            } else if (input3 == "cable") {
                binding.rewardWrite3.text = "'${input3}' - 사용된 코드"
            } else if (input4 == "hotel") {
                binding.rewardWrite4.text = "'${input4}' - 사용된 코드"
            }
        }
        binding.nbackButton2.setOnClickListener {
            val infoIntent = Intent(applicationContext, MyPageActivity::class.java)
            pointLauncher.launch(infoIntent)
        }

    }


    // QR생성(포인트샵)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents != null) {
            }
            if (result.barcodeImagePath != null) {
                Log.i(ContentValues.TAG, "onActivityResult: ${result.barcodeImagePath}")
                val bitmap = BitmapFactory.decodeFile(result.barcodeImagePath)
                binding.barcodeImage.setImageBitmap(bitmap)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    // 포인트샵 리스트
//    fun initList() {
//        // 1. 리스트의 모양을 담당하는 것
//        // (LinearLayoutManager아래쪽으로 아이템들이 보이는 것, GridLayoutManager : 격자 형태로 보이는 것)
//        val layoutManager = LinearLayoutManager(this)
//        binding.pointshoplist.layoutManager = layoutManager
//        // 2. 어댑터를 설정하는 것
//        // 실제 데이터를 관리하고 각 아이템의 모양을 만들어 주는것
//        customerAdapter = PointShopAdapter()
//        binding.pointshoplist.adapter = customerAdapter
//        // 3. 테스트로 아이템을 위한 데이터 넣어보기
//        customerAdapter?. apply {
//            this.items.add(PointShopData(R.drawable.san2,"산천어 빵 20% 할인권", "5000 point" ))
//            this.items.add(PointShopData(R.drawable.cable,"케이블카 20% 할인권", "5000 point" ))
//            this.items.add(PointShopData(R.drawable.san1,"산천어 2마리", "7000 point" ))
//            this.items.add(PointShopData(R.drawable.san1,"산천어 4마리", "12000 point" ))
//        }
//    }

    fun showToast(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}