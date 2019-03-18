package com.df.kolesnikovvv.wargameassistant.textWatchers

import android.text.Editable
import android.text.TextWatcher
import com.df.kolesnikovvv.wargameassistant.entity.GamePoints

class MissionMeterEtTw(_my: Boolean, _key: Int): TextWatcher {
    private val key = _key
    private val my = _my

    override fun afterTextChanged(s: Editable?) {
        if (my) {
            GamePoints.gameVp[key - 1].myVp = s.toString()
        } else {
            GamePoints.gameVp[key - 1].oppVp = s.toString()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}