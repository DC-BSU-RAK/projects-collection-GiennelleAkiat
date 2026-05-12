package com.example.colormixer

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var slider_r1: SeekBar
    private lateinit var slider_g1: SeekBar
    private lateinit var slider_b1: SeekBar
    
    private lateinit var slider_r2: SeekBar
    private lateinit var slider_g2: SeekBar
    private lateinit var slider_b2: SeekBar

    private lateinit var mix_button: Button


    private lateinit var img_pv_1: ImageView
    private lateinit var img_pv_2: ImageView
    private lateinit var img_pv_3: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        img_pv_1 = findViewById(R.id.color1)
        img_pv_2 = findViewById(R.id.color2)
        img_pv_3 = findViewById(R.id.color3)

        mix_button = findViewById(R.id.mix_button)

        //Color Sliders
        slider_r1=findViewById(R.id.seekBar_r1)
        slider_g1=findViewById(R.id.seekBar_g1)
        slider_b1=findViewById(R.id.seekBar_b1)

        slider_r2=findViewById(R.id.seekBar_r2)
        slider_g2=findViewById(R.id.seekBar_g2)
        slider_b2=findViewById(R.id.seekBar_b2)

        var color_1=intArrayOf(0,0,0)
        var color_2=intArrayOf(0,0,0)


        mix_button.setOnClickListener {
            val mixedColor = intArrayOf(
                (color_1[0] + color_2[0]) / 2,
                (color_1[1] + color_2[1]) / 2,
                (color_1[2] + color_2[2]) / 2
            )
            img_pv_3.setBackgroundColor(Color.rgb(mixedColor[0],mixedColor[1],mixedColor[2]))
        }
        slider_r1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                color_1[0]=progress
                img_pv_1.setBackgroundColor(Color.rgb(color_1[0],color_1[1],color_1[2]))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user first touches the thumb
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user releases the thumb
            }
        })

        slider_g1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                color_1[1]=progress
                img_pv_1.setBackgroundColor(Color.rgb(color_1[0],color_1[1],color_1[2]))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user first touches the thumb
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user releases the thumb
            }
        })

        slider_b1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                color_1[2]=progress
                img_pv_1.setBackgroundColor(Color.rgb(color_1[0],color_1[1],color_1[2]))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user first touches the thumb
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user releases the thumb
            }
        })


        //===========================

        slider_r2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                color_2[0]=progress
                img_pv_2.setBackgroundColor(Color.rgb(color_2[0],color_2[1],color_2[2]))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user first touches the thumb
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user releases the thumb
            }
        })

        slider_g2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                color_2[1]=progress
                img_pv_2.setBackgroundColor(Color.rgb(color_2[0],color_2[1],color_2[2]))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user first touches the thumb
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user releases the thumb
            }
        })

        slider_b2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                color_2[2]=progress
                img_pv_2.setBackgroundColor(Color.rgb(color_2[0],color_2[1],color_2[2]))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user first touches the thumb
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Triggered when the user releases the thumb
            }
        })
    }
}