package br.unifor.cct.colorpick

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var mViewColor:View
    private lateinit var mSeekbarRValue:SeekBar
    private lateinit var mSeekbarGValue:SeekBar
    private lateinit var mSeekbarBValue:SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewColor = findViewById(R.id.main_quadrado_colorpick)
        mSeekbarRValue = findViewById(R.id.main_seekbar_red)
        mSeekbarGValue = findViewById(R.id.main_seekbar_green)
        mSeekbarBValue = findViewById(R.id.main_seekbar_blue)

        mSeekbarRValue.setOnSeekBarChangeListener(this)
        mSeekbarGValue.setOnSeekBarChangeListener(this)
        mSeekbarBValue.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        mViewColor.setBackgroundColor(Color.rgb(mSeekbarRValue.progress,mSeekbarGValue.progress,mSeekbarBValue.progress))
        Log.i("App", "Valor: $progress")
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        Log.i("App", "O usuário tocou no componente!")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        Log.i("App", "O usuário não está mais tocando no componente!")
    }
}