package com.example.colorpicker.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.colorpicker.data.ColorPickerData

class ColorPickerViewModel : ViewModel() {
    var data by mutableStateOf(ColorPickerData())
}