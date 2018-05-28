package com.test.kolesnikovvv.myapplication.objects

data class UnitData (
        val necrons: ArrayList<Unit> = arrayListOf(
            Unit("Necron Warrior",
                    "M:5 WS:3+ BS:3+ S:4 T:4 W:1 A:1 Sv:4+ Ld:10",
                    com.test.kolesnikovvv.myapplication.R.drawable.necron_warrior,
                    "Gauss flayer\n" +
                                "Rf1 24' S:4 AP:1 D:1\n\n" +
                                "Reanimation protocols"),
                Unit("Immortall",
                        "M:5 WS:3+ BS:3+ S:4 T:4 W:1 A:1 Sv:4+ Ld:10",
                        com.test.kolesnikovvv.myapplication.R.drawable.necron_warrior,
                        "Gauss flayer\n" +
                                "Rf1 24' S:4 AP:1 D:1\n\n" +
                                "Reanimation protocols"),
                Unit("Cryptek",
                        "M:5 WS:3+ BS:3+ S:4 T:4 W:4 A:1 Sv:4+ Ld: 10",
                        com.test.kolesnikovvv.myapplication.R.drawable.necron_cryptek,
                        "Staff of light\n" +
                                "As3 12' S:5 AP:2 D:1\n\n" +
                                "Chronometron: <Dynasty> INFANTRY units within 3' hame 5++ against shooting\n\n" +
                                "Technomancer: +1 to all RP's rolls for models from <Dynasty> units within 3' of Cryptek\n\n" +
                                "Canoptek cloak: 10' fly move, select 1 model within 3' with Living metal to heal d3, rather than 1\n\n" +
                                "Living metal"),
                Unit("Overlord",
                        "M:5 WS:2+ BS:2+ S:5 T:5 W:5 A:3 Sv:3+ Ld: 10",
                        com.test.kolesnikovvv.myapplication.R.drawable.necron_warrior,
                        "bigdata"),
                Unit("Lord",
                        "M:5 WS:3+ BS:3+ S:5 T:5 W:4 A:3 Sv:3+ Ld: 10",
                        com.test.kolesnikovvv.myapplication.R.drawable.necron_warrior,
                        "Staff of light\n" +
                                "As3 12' S:5 AP:2 D:1\n\n" +
                                "Hyperphase sword\n" +
                                "Ml S:+1 AP:3 D:1\n\n" +
                                "VoidBlade\n" +
                                "Ml S:U AP:3 D:1 +1 attack\n\n" +
                                "Warscythe\n" +
                                "Ml S:+2 AP:4 D:2\n\n" +
                                "The Lord's Will: Reroll 1 to wound for <Dynasty> INFANTRY within 6'\n\n" +
                                "Ressurrection Orb\n\n" +
                                "Living Metal"),
                Unit("BargeLord",
                        "M:5 WS:3+ BS:3+ S:4 T:4 W:4 A:1 Sv:4+ Ld: 10",
                        com.test.kolesnikovvv.myapplication.R.drawable.necron_warrior,
                        "bigdata"),
                Unit("Lichguard",
                        "M:5 WS:3+ BS:3+ S:5 T:5 W:2 A:2 Sv:3+ Ld: 10",
                        com.test.kolesnikovvv.myapplication.R.drawable.necron_warrior,
                        "bigdata"),
                Unit("Destroyer",
                        "M:5 WS:3+ BS:3+ S:4 T:4 W:4 A:1 Sv:4+ Ld: 10",
                        com.test.kolesnikovvv.myapplication.R.drawable.necron_warrior,
                        "bigdata"),
                Unit("Wraith",
                        "M:12 WS:3+ BS:3+ S:6 T:5 W:3 A:3 Sv:3++ Ld: 10",
                        com.test.kolesnikovvv.myapplication.R.drawable.necron_warrior,
                        "bigdata")
        ),
        val adeptusMechanicus: ArrayList<Unit> = arrayListOf(
                Unit("Skitarii",
                        "stats",
                        com.test.kolesnikovvv.myapplication.R.drawable.necron_cryptek,
                        "data")
        )
)