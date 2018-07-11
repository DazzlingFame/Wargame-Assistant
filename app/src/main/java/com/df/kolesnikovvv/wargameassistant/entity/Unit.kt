package com.df.kolesnikovvv.wargameassistant.entity

class Unit(_name: String, _stats: String, _image: Int, _weapons: String, _bigData: String) {

    enum class Factions {
        Necrons, Mechanicus
    }

    var name: String = _name
    var stats: String = _stats
    var image: Int = _image
    var weapons: String = _weapons
    var bigData: String = _bigData

}