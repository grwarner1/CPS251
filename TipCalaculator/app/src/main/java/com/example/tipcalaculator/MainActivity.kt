package com.example.tipcalaculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalaculator.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var out = "The Tips Are As Follows:\n";
            if(binding.textBox.text.toString().isNotEmpty()) {
                var bill = binding.textBox.text.toString()
                binding.textBox.text.clear()

                for(percent in 10..20 step 5) {
                    var newBill = bill.toFloat() * percent.toFloat() / 100.0 + bill.toFloat()
                    out += "\n" + percent + "% = " + "%.2f".format(newBill)
                }
            }else {
                out = "YOU MUST ENTER A BILL AMOUNT"
            }
            binding.textView.text = out
        }
    }

    override fun onDestroy() {
        binding.textView.text = "Tip Amount Will Display Here"
        super.onDestroy()
    }
}