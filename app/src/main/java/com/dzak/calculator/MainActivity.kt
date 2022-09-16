package com.dzak.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//setonclicklistener berfungsi agar action yang di dalam kurung kurawal bisa di click
        btn_tambah.setOnClickListener {
            validasi(editawal.text.toString(), editakhir.text.toString(),"+")
        }
        btn_kurang.setOnClickListener {
            validasi(editawal.text.toString(), editakhir.text.toString(),"-")
        }
        btn_kali.setOnClickListener {
            validasi(editawal.text.toString(), editakhir.text.toString(),"*")
        }
        btn_bagi.setOnClickListener {
            validasi(editawal.text.toString(), editakhir.text.toString(),"/")
        }

    }
    //untuk menjalankan notif dari fun notif dan aritmatika
        fun validasi(awal: String, akhir: String, operator: String){

            if (awal.isEmpty() || akhir.isEmpty()){
                peringatan("loh kok kosong...")
            }else{
                aritmatika(awal.toDouble(),akhir.toDouble(),operator)
            }
        }

//fun peringatan untuk memunculkan notif
    fun peringatan( chat : String){
        AlertDialog.Builder(this)
            .setTitle("alert!!!")
            .setMessage(chat)
            .setPositiveButton("tutup"){
                munculNotif, _ -> munculNotif.dismiss()
            }
            .show()
    }
    //awal,akhir & operator sebagian parameter fungsi
    private fun aritmatika(awal : Double, akhir : Double, operator : String){

        val hasil : Double

        when(operator){
            "+" -> hasil = awal + akhir
            "-" -> hasil = awal - akhir
            "*" -> hasil = awal * akhir
            "/" -> hasil = awal / akhir
            else -> hasil = 0.0
            //else untuk memunculkan jawaban yang tidak tepat dari ke empat button
        }
        txt_hasil.text = hasil.toString()
    }
//kesimpulannya jika kalian ingin membuat function yang lain harus di luar kurung kurawal funtion satunya
}
//nama fun bisa bebas kalian pilih sesuai pasion dan kebutuhan
//private fun di gunakan agar fun tersebut hanya dapat di gunakan di activity tersebut (tidak dapat digunakan di activity lain