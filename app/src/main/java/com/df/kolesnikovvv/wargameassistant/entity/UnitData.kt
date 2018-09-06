package com.df.kolesnikovvv.wargameassistant.entity

import com.df.kolesnikovvv.wargameassistant.R

data class UnitData (
        val necrons: ArrayList<Unit> = arrayListOf(
                Unit("Imotekh the Stormlord",
                        "M:5 WS:2+ BS:2+ S:5 T:5 W:6 A:3 Sv:2+ Ld:10",
                        R.drawable.necron_imotekh,
                        "Gauntlet of fire\n" +
                                "AsD6 8\" S:4 AP:0 D:1 (This weapon automatically hits its target.)\n\n" +
                                "Staff of the Destroyer (shooting)\n" +
                                "As3 18\" S:6 AP:3 D:2\n\n" +
                                "Staff of the Destroyer (melee)\n" +
                                "Ml S:+1 AP:3 D:2",
                        "Living Metal\n" +
                                "Phaeron of the Sautekh Dynasty: Imotekh the Stormlord can use his My Will Be Done ability twice a turn, but only if you choose friendly SAUTEKH " +
                                "INFANTRY units to be affected by it both times.\n\n" +
                                "Lord of the Storm: Once per battle, in your Shooting phase, Imotekh can call the storm: pick an enemy unit within 48\" of Imotekh, other than a " +
                                "CHARACTER, and roll a D6. On a 2+ that unit suffers that many mortal wounds. Then roll a D6 for each enemy unit within 6\" of that unit; on a 6 the " +
                                "unit being rolled for suffers D3 mortal wounds.\n\n" +
                                "Undying: Imotekh the Stormlord regains D3 lost wounds at the beginning of your turn, rather than 1, from his Living Metal ability.\n\n" +
                                "My Will Be Done: At the beginning your turn, choose a friendly NECRONS INFANTRY unit within 6\" of Imotekh the Stormlord. Add 1 to Advance, charge " +
                                "and hit rolls for that unit until the beginning of your next turn. A unit can only be chosen as the target of this ability once in each turn.\n\n" +
                                "Bloodswarm Necroscarabs: You can re-roll hit rolls of 1 for friendly units of SAUTEKH Flayed Ones that are within 12\" of Imotekh the Stormlord.\n\n" +
                                "Grand Strategist: If your army is Battle-forged, you receive 1 additional Command Point if Imotekh the Stormlord is your Warlord.\n\n" +
                                "Phase Shifter: Imotekh the Stormlord has a 4+ invulnerable save."),
                Unit("Nemesor Zahndrekh",
                        "M:5 WS:2+ BS:2+ S:5 T:5 W:6 A:3 Sv:2+ Ld:10",
                        R.drawable.necron_nemesor,
                        "Staff of light (shooting)\n" +
                                "As3 12\" S:5 AP:2 D:1\n\n" +
                                "Staff of light (melee)\n" +
                                "Ml S:U AP:2 D:1",
                        "Living metal\n\n" +
                                "Counter Tactics: At the beginning of your opponent’s turn, choose one enemy CHARACTER within 12\" of Nemesor Zahndrekh. Any aura abilities that character has cannot " +
                                "be used until the beginning of your opponent’s next turn.\n\n" +
                                "Phase Shifter: Nemesor Zahndrekh has a 4+ invulnerable save.\n\n" +
                                "My Will Be Done: At the beginning of your turn, choose a friendly SAUTEKH INFANTRY unit within 6\" of Nemesor Zahndrekh. Add 1 to Advance, charge and hit rolls " +
                                "for that unit until the beginning of your next turn. A unit can only be chosen as the target of this ability once in each turn.\n\n" +
                                "Transient Madness: Roll a D3 at the beginning of your turn and consult the following table. Choose a friendly SAUTEKH INFANTRY unit within 6\" of " +
                                "Nemesor Zahndrekh to gain the relevant ability until the beginning of your next turn.\n" +
                                "1: Avenge the Fallen: Add 1 to the Attacks characteristic of models in this unit.\n" +
                                "2: Quell the Rebellion: Improve the Ballistic Skill of models in this unit by 1 (e.g. a Ballistic Skill of 3+ becomes 2+).\n" +
                                "3: Solarmills? Charge!: Re-roll failed charge rolls for this unit."),
                Unit("Vargard Obyron",
                        "M:5 WS:2+ BS:3+ S:5 T:5 W:6 A:4 Sv:2+ Ld:10",
                        R.drawable.necron_obyron,
                                "Warscythe\n" +
                                "Ml S:+2 AP:4 D:2",
                        "Living metal\n\n" +
                                "Cleaving Counterblow: If Vargard Obyron is slain during the Fight phase, do not remove his model until the end of the phase. He can still fight in this phase, " +
                                "if he has not already done so.\n\n" +
                                "The Lord’s Will: Re-roll wound rolls of 1 for friendly SAUTEKH INFANTRY units that are within 6\" of Vargard Obyron.\n\n" +
                                "Ghostwalk Mantle: At the end of any of your Movement phases, you can remove Vargard Obyron and a friendly SAUTEKH INFANTRY unit within 6\" of Vargard Obyron " +
                                "(other than Nemesor Zahndrekh) from the battlefield and set them up so that all models are within 6\" of Nemesor Zahndrekh and more than 1\" from any enemy models.\n\n" +
                                "The Vargard’s Duty: Roll a D6 each time Nemesor Zahndrekh loses a wound whilst he is within 3\" of Vargard Obyron; on a 2+ Obyron can intercept that hit – " +
                                "Zahndrekh does not lose a wound but Obyron suffers a mortal wound."),
                Unit("Illuminor Szeras",
                        "M:6 WS:3+ BS:3+ S:4 T:4 W:5 A:4 Sv:3+ Ld:10",
                        R.drawable.necron_illuminor,
                        "Eldritch Lance (shooting)\n" +
                                "As1 36\" S:8 AP:4 D:D6\n\n" +
                                "Eldritch Lance (melee)\n" +
                                "Ml S:U AP:2 D:1",
                        "Living metal\n\n" +
                                "Master Technomancer: Add 1 to all Reanimation Protocols rolls for models from friendly NECRONS units within 3\" of Illuminor Szeras. A unit cannot benefit " +
                                "from both the Master Technomancer and Technomancer abilities in the same turn.\n\n" +
                                "Mechanical Augmentation: At the end of your Movement phase, you can choose a friendly NECRONS Warriors or Immortals unit within 1\" of Illuminor Szeras. Roll a " +
                                "D3 to see what characteristic modifier models in that unit gain for the rest of the battle:\n" +
                                "D3 Augmentation:\n" +
                                "1: +1 Strength\n" +
                                "2: +1 Toughness\n" +
                                "3: Ballistic Skill improved by 1 (e.g. a Ballistic Skill of 3+ becomes 2+)\n" +
                                "A unit can only be the target of this ability once per battle."),
                Unit("Orikan the Diviner",
                        "M:5 WS:3+ BS:3+ S:4 T:4 W:5 A:2 Sv:4+ Ld:10",
                        R.drawable.necron_orikan,
                        "Staff of Tomorrow\n" +
                                "Ml S:U AP:3 D:D3",
                        "Living metal\n\n" +
                                "Master Chronomancer: Friendly SAUTEKH INFANTRY units within 6\" of Orikan the Diviner have a 5+ invulnerable save.\n\n" +
                                "Technomancer: Add 1 to Reanimation Protocols rolls for models from SAUTEKH units within 3\" of any friendly SAUTEKH CRYPTEKS.\n\n" +
                                "The Stars Are Right: Roll a D6 at the start of each of your turns. If the result is less than the current battle round number, Orikan uses the Orikan Empowered " +
                                "profile for the rest of the game (though any damage he has sustained is carried over).\n" +
                                "M:5 WS:2+ BS:2+ S:7 T:7 W:7 A:4 Sv:4+ Ld:10"),
                Unit("Anrakyr the Traveller",
                        "M:5 WS:3+ BS:3+ S:4 T:4 W:5 A:2 Sv:4+ Ld:10",
                        R.drawable.necron_anrakyr,
                        "Tachyon arrow\n" +
                                "As1 120\" S:10 AP:5 D:D6 (This weapon can only be used once per battle.)\n\n" +
                                "Warscythe\n" +
                                "Ml S:+2 AP:4 D:2",
                        "Living metal\n\n" +
                                "Lord of the Pyrrhian Legions: Add 1 to the Attacks characteristic of friendly NECRONS INFANTRY units within 3\" of Anrakyr the Traveller.\n\n" +
                                "Mind in the Machine: At the start of your Shooting phase, choose an enemy VEHICLE model within 12\" of Anrakyr the Traveller and roll a D6. On " +
                                "a 4+, choose one of that vehicle’s weapons. You may shoot with that weapon at another enemy unit. The weapon fires using the vehicle’s Ballistic Skill.\n\n" +
                                "Phase Shifter: Anrakyr the Traveller has a 4+ invulnerable save.\n\n" +
                                "My Will Be Done: At the beginning of your turn, choose a friendly NECRONS INFANTRY unit within 6\" of Anrakyr the Traveller. Add 1 to Advance, charge and hit " +
                                "rolls for that unit until the beginning of your next turn. A unit can only be chosen as the target of this ability once in each turn."),
                Unit("Trazyn the Infinite",
                        "M:5 WS:3+ BS:3+ S:4 T:4 W:5 A:2 Sv:4+ Ld:10",
                        R.drawable.necron_trazyn,
                        "Empathic Obliterator\n" +
                                "Ml S:+2 AP:1 D:D3",
                        "Living metal\n\n" +
                                "Phase Shifter: Trazyn the Infinite has a 4+ invulnerable save.\n\n" +
                                "My Will Be Done: At the beginning of your turn, choose a friendly NIHILAKH INFANTRY unit within 6\" of Trazyn the Infinite. Add 1 to Advance, charge and hit " +
                                "rolls for that unit until the beginning of your next turn. A unit can only be chosen as the target of this ability once in each turn.\n\n" +
                                "Surrogate Hosts: If Trazyn the Infinite is slain, roll a D6. On a 2+, you may choose another friendly NECRONS INFANTRY CHARACTER (other than CHARACTERS that you " +
                                "can only include once in your army). Remove that model as if it were slain and place Trazyn in its place with D3 wounds remaining. If no such CHARACTERS remain, " +
                                "or you rolled a 1, remove Trazyn the Infinite " +
                                "as a casualty as normal."),
                Unit("Catacomb command barge",
                        "M:12 WS:2+ BS:2+ S:5 T:6 W:8 A:3 Sv:3+ Ld:10",
                        R.drawable.necron_bargelord,
                        "Staff of light (shooting)\n" +
                                "As3 12\" S:5 AP:2 D:1\n\n" +
                                "Staff of light (melee)\n" +
                                "Ml S:U AP:2 D:1\n\n" +
                                "Hyperphase sword\n" +
                                "Ml S:+1 AP:3 D:1\n\n" +
                                "VoidBlade\n" +
                                "Ml S:U AP:3 D:1 +1 attack\n\n" +
                                "Warscythe\n" +
                                "Ml S:+2 AP:4 D:2\n\n" +
                                "Gauss cannon\n" +
                                "Hv3 24\" S:6 AP:3 D:D3\n\n" +
                                "Tesla cannon\n" +
                                "As3 24\" S:6 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits instead of 1.)",
                        "Living Metal (pg 82)\n\n" +
                                "Wave of Command: At the beginning of your turn, choose a friendly <DYNASTY> INFANTRY unit within 12\" of this model. Add 1 to Advance, charge and hit rolls for " +
                                "that unit until the beginning of your next turn. A unit can only be chosen as the target of Wave of Command or My Will Be Done once in each turn.\n\n" +
                                "Quantum Shielding: Each time this model fails a saving throw, roll a D6. If the result is less than the damage inflicted by that attack, the damage is ignored " +
                                "(e.g. if this model suffers 4 damage, if you then roll a 3 or less the damage is ignored). Quantum Shielding cannot prevent damage caused by mortal wounds.\n\n" +
                                "Resurrection Orb: If this model has a resurrection orb, once per battle, immediately after you have made your Reanimation Protocols rolls at the beginning of the " +
                                "turn, you can make Reanimation Protocols rolls for models from a friendly <DYNASTY> INFANTRY unit within 3\" of this model.\n\n" +
                                "Explodes: If this model is reduced to 0 wounds, roll a D6 before removing it from the battlefield. On a 6 it explodes, and each unit within 3\" suffers a mortal wound."),
                Unit("Overlord",
                        "M:5 WS:2+ BS:2+ S:5 T:5 W:5 A:3 Sv:3+ Ld:10",
                        R.drawable.necron_overlord,
                        "Staff of light (shooting)\n" +
                                "As3 12\" S:5 AP:2 D:1\n\n" +
                                "Staff of light (melee)\n" +
                                "Ml S:U AP:2 D:1\n\n" +
                                "Hyperphase sword\n" +
                                "Ml S:+1 AP:3 D:1\n\n" +
                                "VoidBlade\n" +
                                "Ml S:U AP:3 D:1 +1 attack\n\n" +
                                "Warscythe\n" +
                                "Ml S:+2 AP:4 D:2\n\n" +
                                "Voidscythe\n" +
                                "Ml S:x2 AP:4 D:3 (When attacking with this weapon, substract 1 from the hit roll)",
                        "Phase shifter: This model has a 4+ invulnerable save.\n\n" +
                                "My Will Be Done: At the beginning of your turn, choose a friendly <DYNASTY> INFANTRY unit within 6\" of this model. Add 1 to Advance," +
                                " charge and hit rolls for that unit until the beginning of your next turn. A unit can only be chosen as the target of this ability once in each turn.\n\n" +
                                "Resurrection Orb: If this model has a resurrection orb, once per battle, immediately after you have made your Reanimation Protocols rolls at the beginning " +
                                "of the turn, you can make Reanimation Protocols rolls for models from a friendly <DYNASTY> INFANTRY unit within 3\" of this model.\n\n" +
                                "Living metal"),
                Unit("Lord",
                        "M:5 WS:3+ BS:3+ S:5 T:5 W:4 A:3 Sv:3+ Ld:10",
                        R.drawable.necron_lord,
                        "Staff of light (shooting)\n" +
                                "As3 12\" S:5 AP:2 D:1\n\n" +
                                "Staff of light (melee)\n" +
                                "Ml S:U AP:2 D:1\n\n" +
                                "Hyperphase sword\n" +
                                "Ml S:+1 AP:3 D:1\n\n" +
                                "VoidBlade\n" +
                                "Ml S:U AP:3 D:1 +1 attack\n\n" +
                                "Warscythe\n" +
                                "Ml S:+2 AP:4 D:2",
                        "The Lord's Will: Reroll 1 to wound for <Dynasty> INFANTRY within 6\n\n" +
                                "Ressurrection Orb: If this model has a resurrection orb, once per battle, immediately after you have made your Reanimation Protocols rolls at the beginning " +
                                "of the turn, you can make Reanimation Protocols rolls for models from a friendly <DYNASTY> INFANTRY unit within 3\" of this model.\n\n" +
                                "Living Metal"),
                Unit("Cryptek",
                        "M:5 WS:3+ BS:3+ S:4 T:4 W:4 A:1 Sv:4+ Ld:10",
                        R.drawable.necron_cryptek,
                        "Staff of light\n" +
                                "As3 12\" S:5 AP:2 D:1",
                        "Chronometron: <DYNASTY> INFANTRY units within 3\" of a friendly model with a chronometron have a 5+ invulnerable save against ranged weapons.\n\n" +
                                "Technomancer: Add 1 to all Reanimation Protocols rolls for models from <DYNASTY> units within 3\" of any friendly <DYNASTY> CRYPTEKS.\n\n" +
                                "Canoptek cloak: A model equipped with a Canoptek cloak has a Move characteristic of 10\" and gains the FLY keyword. In addition, at the start" +
                                " of your turn you can select one friendly <DYNASTY> model that has the Living Metal ability and that is within 3\" of this model. That model" +
                                " regains D3 lost wounds, rather than 1, from its Living Metal ability.\n\n" +
                                "Living metal"),
                Unit("Destroyer lord",
                        "M:10 WS:3+ BS:3+ S:5 T:6 W:6 A:4 Sv:3+ Ld:10",
                        R.drawable.necron_destrlord,
                        "Staff of light (shooting)\n" +
                                "As3 12\" S:5 AP:2 D:1\n\n" +
                                "Staff of light (melee)\n" +
                                "Ml S:U AP:2 D:1\n\n" +
                                "Hyperphase sword\n" +
                                "Ml S:+1 AP:3 D:1\n\n" +
                                "VoidBlade\n" +
                                "Ml S:U AP:3 D:1 +1 attack\n\n" +
                                "Warscythe\n" +
                                "Ml S:+2 AP:4 D:2",
                        "Living Metal\n\n" +
                                "Hardwired Hatred: You can re-roll hit rolls of 1 for this model.\n\n" +
                                "United in Hatred: You can re-roll wound rolls of 1 in the Shooting phase for this model and models from friendly <DYNASTY> Destroyer and <DYNASTY> Heavy Destroyer " +
                                "units within 6\".\n\n" +
                                "Phylactery: A model with a phylactery regains D3 lost wounds at the beginning of your turn, rather than 1, from their Living Metal ability.\n\n" +
                                "Resurrection Orb: If this model has a resurrection orb, once per battle, immediately after you have made your Reanimation Protocols rolls at the beginning of the " +
                                "turn, you can make Reanimation Protocols rolls for models from a friendly <DYNASTY> INFANTRY unit within 3\" of this model."),
                Unit("Warrior",
                        "M:5 WS:3+ BS:3+ S:4 T:4 W:1 A:1 Sv:4+ Ld:10",
                        R.drawable.necron_warrior,
                        "Gauss flayer\n" +
                                "Rf1 24\" S:4 AP:1 D:1",
                        "Reanimation protocols"),
                Unit("Immortall",
                        "M:5 WS:3+ BS:3+ S:4 T:4 W:1 A:1 Sv:4+ Ld:10",
                        R.drawable.necron_immortall,
                        "Gauss blaster\n" +
                                "Rf1 24\" S:5 AP:2 D:1\n\n" +
                                "Tesla carbine\n" +
                                "As2 24\" S:5 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits instead of 1)",
                        "Reanimation protocols"),
                Unit("Lychguard",
                        "M:5 WS:3+ BS:3+ S:5 T:5 W:2 A:2 Sv:3+ Ld:10",
                        R.drawable.necron_lychguard,
                        "Hyperphase sword\n" +
                                "Ml S:+1 AP:3 D:1\n\n" +
                                "Warscythe\n" +
                                "Ml S:+2 AP:4 D:2",
                        "Dispersion ShieLd:A model equipped with a dispersion shield has a 4+ invulnerable save.\n\n" +
                                "Guardian Protocols: Roll a D6 each time a friendly <DYNASTY> CHARACTER loses a wound whilst they are within 3\" of this unit; on a 2+ a model from this unit " +
                                "can intercept that hit – the character does not lose a wound but this unit suffers a mortal wound."),
                Unit("Deathmarks",
                        "M:5 WS:3+ BS:3+ S:4 T:4 W:1 A:1 Sv:3+ Ld:10",
                        R.drawable.necron_deathmark,
                        "Synaptic disintegrator\n" +
                                "Rf1 24\" S:4 AP:0 D:1 (This weapon may target a CHARACTER even if it is not the closest enemy unit. Each time you roll a wound roll of 6+ for this weapon, the target " +
                                "suffers a mortal wound in addition to any other damage.)",
                        "Hunters from Hyperspace: During deployment, you can set up this unit in a hyperspace oubliette instead of placing it on the battlefield. At the end of any of your Movement " +
                                "phases the Deathmarks can slip back into reality – set them up anywhere on the battlefield that is more than 9\" away from any enemy models.\n\n" +
                                "Ethereal Interception: When an enemy unit is set up (other than during deployment or when disembarking) you can immediately set up a unit of Deathmarks that was set " +
                                "up in a hyperspace oubliette on the battlefield, anywhere more than 9\" away from any enemy models and within 12\" of the enemy unit that has just been set up. You " +
                                "can then make a shooting attack with this unit as if it were your Shooting phase, but this attack must target the enemy unit that was just set up."
                        ),
                Unit("C'tan shard of the Deciever",
                        "M:8 WS:2+ BS:2+ S:7 T:7 W:8 A:4 Sv:4+ Ld:10",
                        R.drawable.necron_deciever,
                        "Star-god fists\n" +
                                "Ml S:U AP:4 D:3",
                        "Necrodermis: The C’tan Shard of the Deceiver has a 4+ invulnerable save.\n\n" +
                                "Dread: Your opponent must add 1 to Morale tests for any enemy units within 12\" of the C’tan Shard of the Deceiver.\n\n" +
                                "Grand Illusion: At the beginning of the first battle round, but before the first turn begins, you can remove the C’tan Shard of the Deceiver and/or up to D3 other friendly" +
                                " NECRONS units from the battlefield, then set them up again more than 12\" from any enemy models. If you do so, these units cannot charge in your first turn.\n\n" +
                                "Powers of the C’tan: The C’tan Shard of the Deceiver knows two Powers of the C’tan (pg 113). It can use one of its powers at the end of each of its Movement phases.\n\n" +
                                "Reality Unravels: If the C’tan Shard of the Deceiver is ever reduced to 0 wounds, roll a D6 before removing it from the battlefield; on a 4+ its necrodermis tears" +
                                "a hole in reality, and each unit within 3\" suffers D3 mortal wounds.\n\n" +
                                "Enslaved Star God: This model can never have a Warlord Trait."),
                Unit("C'tan shard of the Nightbringer",
                        "M:8 WS:2+ BS:2+ S:7 T:7 W:8 A:4 Sv:4+ Ld:10",
                        R.drawable.necron_nightbringer,
                        "Gaze of death\n" +
                                "AsD6 12\" S:* AP:4 D:D3 (This weapon wounds on a 2+, unless it is targeting a VEHICLE unit, in which case it wounds on a 6+.)\n\n" +
                                "Scythe of the Nightbringer\n" +
                                "Ml S:* AP:4 D:D6 (This weapon wounds on a 2+, unless it is targeting a VEHICLE unit, in which case it has a Strength characteristic of 7.)",
                        "Necrodermis: The C’tan Shard of the Deceiver has a 4+ invulnerable save.\n\n" +
                                "Powers of the C’tan: The C’tan Shard of the Deceiver knows two Powers of the C’tan (pg 113). It can use one of its powers at the end of each of its Movement phases.\n\n" +
                                "Reality Unravels: If the C’tan Shard of the Deceiver is ever reduced to 0 wounds, roll a D6 before removing it from the battlefield; on a 4+ its necrodermis tears" +
                                "a hole in reality, and each unit within 3\" suffers D3 mortal wounds.\n\n" +
                                "Enslaved Star God: This model can never have a Warlord Trait."),
                Unit("Canoptek wraiths",
                        "M:12 WS:3+ BS:3+ S:6 T:5 W:3 A:3 Sv:4+ Ld:10",
                        R.drawable.necron_wraith,
                        "Particle caster\n" +
                                "P1 12\" S:6 AP:0 D:1\n\n" +
                                "Transdimensional beamer\n" +
                                "HvD3 12\" S:4 AP:3 D:1 (Each time you roll a wound roll of 6+ for this weapon, the target suffers a mortal wound in addition to any other damage.)\n\n" +
                                "Vicious claws\n" +
                                "Ml S:U AP:2 D:2\n\n" +
                                "Whip coils\n" +
                                "Ml S:U AP:2 D:2 (If the bearer is slain in the Fight phase before it has made its attacks, leave the model where it is. When its unit is chosen to " +
                                "fight in that phase, it can do so as normal. Once it has done so, remove the model from the battlefield.)",
                        "Wraith Form: Models in this unit have a 3+ invulnerable save, and can move across models and terrain as if they were not there. Models in this unit " +
                                "can shoot and charge even if they Fell Back this turn."),
                Unit("Canoptek scarabs",
                        "M:10 WS:4+ BS:-- S:3 T:3 W:3 A:4 Sv:6+ Ld:10",
                        R.drawable.necron_scarabs,
                        "Feeder mandibles\n" +
                                "Ml S:U AP:0 D:1 (If the target’s Toughness is higher than this attack’s Strength, this weapon always wounds the target on a wound roll of 5+.)",
                        ""),
                Unit("Tomb blades",
                        "M:14 WS:3+ BS:3+ S:4 T:5 W:2 A:1 Sv:4+ Ld:10",
                        R.drawable.necron_tombblade,
                        "Gauss blaster\n" +
                                "Rf1 24\" S:5 AP:2 D:1\n\n" +
                                "Particle beamer\n" +
                                "As3 24\" S:6 AP:0 D:1\n\n" +
                                "Tesla carbine\n" +
                                "As2 24\" S:5 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits instead of 1)",
                        "Reanimation Protocols (pg 82)\n\n" +
                                "Evasion Engrams: Your opponent must subtract 1 from hit rolls that target this unit in the Shooting phase.\n\n" +
                                "Shieldvanes: A model with shieldvanes has a Save characteristic of 3+.\n\n" +
                                "Shadowloom: A model with a shadowloom has a 5+ invulnerable save.\n\n" +
                                "Nebuloscope: Models do not receive the bonus to their save for being in cover against attacks made by a model with a nebuloscope."),
                Unit("Destroyers",
                        "M:10 WS:3+ BS:3+ S:4 T:5 W:3 A:2 Sv:3+ Ld:10",
                        R.drawable.necron_destroyer,
                        "Gauss cannon\n" +
                                "Hv3 24\" S:6 AP:3 D:D3",
                        "Reanimation Protocols (pg 82)\n\n" +
                                "Hardwired Hatred: You can re-roll hit rolls of 1 for this unit.\n\n" +
                                "Repulsor Platform: This unit can move and fire Heavy weapons without suffering the penalty to its hit rolls."),
                Unit("Heavy destroyers",
                        "M:10 WS:3+ BS:3+ S:4 T:5 W:3 A:2 Sv:3+ Ld:10",
                        R.drawable.necron_destroyer,
                        "Heavy gauss cannon\n" +
                                "Hv1 36\" S:9 AP:4 D:D6",
                        "Reanimation Protocols (pg 82)\n\n" +
                                "Hardwired Hatred: You can re-roll hit rolls of 1 for this unit.\n\n" +
                                "Repulsor Platform: This unit can move and fire Heavy weapons without suffering the penalty to its hit rolls."),
                Unit("Canoptek spyders",
                        "M:6 WS:4+ BS:4+ S:6 T:6 W:4 A:4 Sv:3+ Ld:10",
                        R.drawable.necron_spyder,
                        "Particle beamer\n" +
                                "As3 24\" S:6 AP:0 D:1\n\n" +
                                "Automaton claws\n" +
                                "Ml S:U AP:2 D:D3",
                        "Fabricator Claw Array: At the end of your Movement phase a model equipped with a fabricator claw array can repair a single <DYNASTY> " +
                                "VEHICLE model within 1\". That model regains D3 wounds lost earlier in the battle. A model can only be repaired once per turn.\n\n" +
                                "Gloom Prism: A model equipped with a gloom prism can attempt to deny one psychic power in each enemy Psychic phase in the same manner as a PSYKER.\n\n" +
                                "Scarab Hive: At the beginning of your turn, you can roll\n" +
                                "a D6 for each <DYNASTY> Canoptek Scarabs unit from your army that is below its starting number of models and within 6\" of any friendly <DYNASTY> Canoptek " +
                                "Spyders units. On a 1, one of those Canoptek Spyders units within 6\" of the unit being rolled for suffers a mortal wound. On a 2+ one of those Canoptek Spyders " +
                                "units within 6\" of the unit being rolled for unleashes reinforcements: return a Canoptek Scarab Swarm to the depleted unit, in unit coherency and more than" +
                                " 1\" from enemy models. If you cannot do this because there is no room to place the model, do not set it up."),
                Unit("Monolith",
                        "M:* WS:6+ BS:*+ S:8 T:8 W:20 A:3 Sv:3+ Ld:10",
                        R.drawable.necron_monolith,
                        "Gauss flux arc\n" +
                                "Hv3 24\" S:5 AP:2 D:1\n\n" +
                                "Particle whip\n" +
                                "Hv6 24\" S:8 AP:2 D:D3",
                        "DAMAGE:\n" +
                                "W:11-20 M:6\" BS:3+ Portal of exile:4+\n" +
                                "W:6-10  M:5\" BS:4+ Portal of exile:5+\n" +
                                "W:1-5   M:4\" BS:5+ Portal of exile:6\n\n" +
                                "Living Metal\n\n" +
                                "Death Descending: During deployment, you can set up this model in the upper atmosphere instead of placing it on the battlefield. At the end of any of your Movement " +
                                "phases the Monolith can plummet to the battlefield – set it up anywhere on the battlefield that is more than 12\" from any enemy models.\n\n" +
                                "Portal of Exile: When an enemy unit (other than a MONSTER or VEHICLE) finishes a charge move within 1\" of this model, its portal of exile may activate. Roll a D6 " +
                                "and compare it to the value required on the damage table above. If the roll is successful, the charging unit suffers D6 mortal wounds.\n\n" +
                                "Hovering: Distance and ranges are always measured to and from this model’s hull, even though it has a base.\n\n" +
                                "Floating Fortress: This model can move and fire Heavy weapons without suffering the penalty to its hit rolls.\n\n" +
                                "Eternity Gate: When you set up this model, at the same time you can also set up any number of friendly <DYNASTY> INFANTRY units on their tomb world rather than setting" +
                                " them up on the battlefield. Before this model moves in your Movement phase, a single friendly <DYNASTY> unit that was set up on their tomb world can be transported " +
                                "onto the battlefield by the Monolith. Set up the unit so that it is wholly within 3\" of this model and more than 1\" from any enemy models. If all <DYNASTY> Night " +
                                "Scythes and Monoliths from your army are destroyed, any friendly <DYNASTY> units still on their tomb world are considered to be slain.\n\n" +
                                "Explodes: If this model is reduced to 0 wounds, roll a D6 before removing it from the battlefield. On a 6 it explodes, and each unit within 6\" suffers D6 mortal wounds."),
                Unit("Anihillation barge",
                        "M:12 WS:6+ BS:3+ S:5 T:6 W:8 A:3 Sv:4+ Ld:10",
                        R.drawable.necron_barge,
                        "Gauss cannon\n" +
                                "Hv3 24\" S:6 AP:3 D:D3\n\n" +
                                "Twin tesla destructor\n" +
                                "As8 24\" S:7 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits instead of 1.)\n\n" +
                                "Tesla cannon\n" +
                                "As3 24\" S:6 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits instead of 1.)",
                        "Living Metal\n\n" +
                                "Quantum Shielding: Each time this model fails a saving throw, roll a D6. If the result is less than the damage inflicted by that attack, the damage is ignored " +
                                "(e.g. if this model suffers 4 damage, if you then roll a 3 or less the damage is ignored). Quantum Shielding cannot prevent damage caused by mortal wounds.\n\n" +
                                "Explodes: If this model is reduced to 0 wounds, roll a D6 before removing it from the battlefield. On a 6 it explodes, and each unit within 3\" suffers a mortal wound."),
                Unit("Doomsday arc",
                        "M:* WS:6+ BS:*+ S:6 T:6 W:14 A:* Sv:4+ Ld:10",
                        R.drawable.necron_doomsday,
                        "Dommsday cannon\n" +
                                "- Low power  HvD6 36\" S:8  AP:2 D:D3\n" +
                                "- High power HvD6 72\" S:10 AP:5 D:D6 (A model can only fire the doomsday cannon at high power if it remained stationary in its preceding Movement phase.)\n\n" +
                                "Gauss flayer array\n" +
                                "Rf5 24\" S:4 AP:1 D:1",
                        "DAMAGE:\n" +
                                "W:8-14 M:12\" BS:3+ A:3\n" +
                                "W:4-7  M:8\"  BS:4+ A:D3\n" +
                                "W:1-3  M:4\"  BS:5+ A:1\n\n" +
                                "Living Metal\n\n" +
                                "Explodes: If this model is reduced to 0 wounds, roll a D6 before removing it from the battlefield. On a 6 it explodes, and each unit within 6\" suffers D3 mortal wounds.\n\n" +
                                "Hovering: Instead of measuring distance and ranges to and from this model’s base, measure to and from this model’s hull or base (whichever is closer).\n\n" +
                                "Quantum Shielding: Each time this model fails a saving throw, roll a D6. If the result is less than the damage inflicted by that attack, the damage is ignored (e.g. if " +
                                "this model suffers 4 damage, if you then roll a 3 or less the damage is ignored). Quantum Shielding cannot prevent damage caused by mortal wounds."),
                Unit("Transcendent C'tan",
                        "M:8 WS:2+ BS:2+ S:7 T:7 W:8 A:4 Sv:4+ Ld:10",
                        R.drawable.necron_transcendant,
                                "Crackling tendrils\n" +
                                "Ml S:* AP:4 D:D6",
                        "Necrodermis: The C’tan Shard of the Deceiver has a 4+ invulnerable save.\n\n" +
                                "Powers of the C’tan: The C’tan Shard of the Deceiver knows two Powers of the C’tan (pg 113). It can use one of its powers at the end of each of its Movement phases.\n\n" +
                                "Reality Unravels: If the C’tan Shard of the Deceiver is ever reduced to 0 wounds, roll a D6 before removing it from the battlefield; on a 4+ its necrodermis tears" +
                                "a hole in reality, and each unit within 3\" suffers D3 mortal wounds.\n\n" +
                                "Enslaved Star God: This model can never have a Warlord Trait.\n\n" +
                                "Fractured Personality: Before the battle, you can pick 5 one of the abilities opposite to apply to this model for the duration of the battle. Alternatively, you can " +
                                "roll two D6 to randomly determine two abilities and apply them both to this model for the duration of the battle (duplicate results have no effect)."),
                Unit("Ghost arc",
                        "M:* WS:6+ BS:*+ S:6 T:6 W:14 A:* Sv:4+ Ld:10",
                        R.drawable.necron_ghostarc,
                                "Gauss flayer array\n" +
                                "Rf5 24\" S:4 AP:1 D:1",
                        "DAMAGE:\n" +
                                "W:8-14 M:12\" BS:3+ A:3\n" +
                                "W:4-7  M:8\"  BS:4+ A:D3\n" +
                                "W:1-3  M:4\"  BS:5+ A:1\n\n" +
                                "Living Metal\n\n" +
                                "Explodes: If this model is reduced to 0 wounds, roll a D6 before removing it from the battlefield. On a 6 it explodes, and each unit within 6\" suffers D3 mortal wounds.\n\n" +
                                "Hovering: Instead of measuring distance and ranges to and from this model’s base, measure to and from this model’s hull or base (whichever is closer).\n\n" +
                                "Quantum Shielding: Each time this model fails a saving throw, roll a D6. If the result is less than the damage inflicted by that attack, the damage is ignored (e.g. if " +
                                "this model suffers 4 damage, if you then roll a 3 or less the damage is ignored). Quantum Shielding cannot prevent damage caused by mortal wounds.\n\n" +
                                "Repair Barge: You can make Reanimation Protocols rolls for any slain models from units embarked on a Ghost Ark, even though those units are not on the battlefield." +
                                " Any models returned to the unit this way are added to the number of models embarked on the Ghost Ark – if any models cannot be returned because there is no more " +
                                "room on the Ghost Ark, they are not returned this turn. In addition, at the end of your Movement phase, you can make Reanimation Protocols rolls for slain models " +
                                "from <DYNASTY> Warriors units within 3\" of any friendly <DYNASTY> Ghost Arks. You cannot use this ability on a unit that has been the target of a resurrection " +
                                "orb or the Orb of Eternity this turn."),
                Unit("Doom scythe",
                        "M:* WS:6+ BS:*+ S:6 T:6 W:12 A:* Sv:3+ Ld:10",
                    R.drawable.necron_doomscy,
                    "Death ray\n" +
                            "HvD3 24\" S:10 AP:4 D:D6\n\n" +
                            "Tesla destructor\n" +
                            "As4 24\" S:7 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits instead of 1.)",
                    "DAMAGE:\n" +
                            "W:7-12 M:20-60\" BS:3+ A:3\n" +
                            "W:4-6  M:20-40\" BS:4+ A:D3\n" +
                            "W:1-3  M:20-35\" BS:5+ A:1\n\n" +
                            "Living Metal\n\n" +
                            "Airborne: This model cannot charge, can only be charged by units that can FLY, and can only attack or be attacked in the Fight phase by units that can FLY.\n\n" +
                            "Hard to Hit: Your opponent must subtract 1 from hit rolls for attacks that target this model in the Shooting phase.\n\n" +
                            "Supersonic: Each time this model moves, first pivot it on the spot up to 90° (this does not contribute to how far the model moves), and then move the model straight " +
                            "forwards. Note that it cannot pivot again after the initial pivot. When this model Advances, increase its Move characteristic by 20\" until the end of the phase – " +
                            "do not roll a dice.\n\n" +
                            "Crash and Burn: If this model is reduced to 0 wounds, roll a D6 before removing it from the battlefield. On a 6 it crashes in a fiery explosion and each unit within " +
                            "6\" suffers D3 mortal wounds."),
                Unit("Night scythe",
                        "M:* WS:6+ BS:*+ S:6 T:6 W:12 A:* Sv:3+ Ld:10",
                        R.drawable.necron_doomscy,
                        "Tesla destructor\n" +
                                "As4 24\" S:7 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits instead of 1.)",
                        "DAMAGE:\n" +
                                "W:7-12 M:20-60\" BS:3+ A:3\n" +
                                "W:4-6  M:20-40\" BS:4+ A:D3\n" +
                                "W:1-3  M:20-35\" BS:5+ A:1\n\n" +
                                "Living Metal\n\n" +
                                "Airborne: This model cannot charge, can only be charged by units that can FLY, and can only attack or be attacked in the Fight phase by units that can FLY.\n\n" +
                                "Hard to Hit: Your opponent must subtract 1 from hit rolls for attacks that target this model in the Shooting phase.\n\n" +
                                "Supersonic: Each time this model moves, first pivot it on the spot up to 90° (this does not contribute to how far the model moves), and then move the model straight " +
                                "forwards. Note that it cannot pivot again after the initial pivot. When this model Advances, increase its Move characteristic by 20\" until the end of the phase – " +
                                "do not roll a dice.\n\n" +
                                "Crash and Burn: If this model is reduced to 0 wounds, roll a D6 before removing it from the battlefield. On a 6 it crashes in a fiery explosion and each unit within " +
                                "6\" suffers D3 mortal wounds.\n\n" +
                                "Invasion Beams: When you set up this model, at the same time you can also set up any number of friendly <DYNASTY> INFANTRY units on their tomb world rather than setting " +
                                "them up on the battlefield. Before this model moves in your Movement phase, a single friendly <DYNASTY> unit that was set up on their tomb world can be beamed onto the " +
                                "battlefield by the Night Scythe. Set up the unit so that it is wholly within 3\" of this model and more than 1\" from any enemy models. If all <DYNASTY> Night Scythes " +
                                "and Monoliths from your army are destroyed, any friendly <DYNASTY> units still on their tomb world are considered to be slain."),
                Unit("Obelisk",
                        "M:* WS:6+ BS:*+ S:8 T:8 W:24 A:3 Sv:3+ Ld:10",
                        R.drawable.necron_obelisk,
                        "Tesla sphere\n" +
                                "As5 24\" S:7 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits instead of 1.)",
                        "DAMAGE:\n" +
                                "W:13-24 M:8\" BS:3+ Gravity pulse:18\"\n" +
                                "W:7-12  M:6\" BS:4+ Gravity pulse:12\"\n" +
                                "W:1-6   M:4\" BS:5+ Gravity pulse:6\"\n\n" +
                                "Living Metal\n\n" +
                                "Hovering Sentinel: During deployment, you can set up this model in the upper atmosphere instead of placing it on the battlefield. At the end of any of your Movement " +
                                "phases the Obelisk can plummet to the battlefield – set it up anywhere on the battlefield that is more than 12\" from any enemy models.\n\n" +
                                "Gravity Pulse: At the start of your Shooting phase, roll a D6 for each enemy unit that can FLY and is within the distance specified on the damage table above. " +
                                "On a roll of 6, that unit suffers D3 mortal wounds.\n\n" +
                                "Explodes: If this model is reduced to 0 wounds, roll a D6 before removing it from the battlefield. On a 6 it explodes, and each unit within 2D6\" suffers D6 mortal wounds."),
                Unit("Tesseract vault",
                        "M:* WS:6+ BS:*+ S:8 T:7 W:28 A:3 Sv:3+ Ld:10",
                        R.drawable.necron_tesseract,
                        "Tesla sphere\n" +
                                "As5 24\" S:7 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits instead of 1.)",
                        "DAMAGE:\n" +
                                "W:15-28 M:8\" BS:3+ Powers of C'tan:3\"\n" +
                                "W:8-14  M:6\" BS:4+ Powers of C'tan:2\"\n" +
                                "W:1-7   M:4\" BS:5+ Powers of C'tan:1\"\n\n" +
                                "Living Metal\n\n" +
                                "Powers of the C’tan: This model knows four Powers of the C’tan (pg 113). It can use a number of different Powers of the C’tan equal to the number in the " +
                                "damage table above at the end of each of your Movement phases.\n\n" +
                                "Transtemporal Force FieLd:This model has a 4+ invulnerable save.\n\n" +
                                "Vengeance of the Enchained: If this model is reduced to 0 wounds, roll a D6 before removing it from the battlefield. On a 4+ the Transcendent C’tan contained " +
                                "within takes their vengeance, and each unit within 2D6\" suffers D6 mortal wounds.")
        ),
        val admechs: ArrayList<Unit> = arrayListOf(
                Unit("Belisarius Cawl",
                        "M:6 WS:2+ BS:2+ S:5 T:6 W:8 A:4 Sv:2+ Ld:9",
                        R.drawable.mech_belisarius,
                        "Solar atomiser\n" +
                                "AsD3 12\" S:10 AP:4 D:D3 (If the target is within half range of this weapon, it has a Damage of D6.)\n\n" +
                                "Arc scourge\n" +
                                "Ml S:x2 AP:1 D:1 (When attacking a VEHICLE, this weapon has a Damage of D3.)\n\n" +
                                "Mechadendrite hive\n" +
                                "Ml S:U AP:0 D:1 (Each time Belisarius Cawl fights, he can make 2D6 additional attacks with this weapon.)\n\n" +
                                "Omnissian axe\n" +
                                "Ml S:+1 AP:2 D:2",
                        "Canticles of Omnissiah\n\n" +
                                "Archmagos: Whilst Belisarius Cawl is on the battlefield, you can add or subtract 1 when rolling on the Canticles of the Omnissiah table (pg 73).\n\n" +
                                "Refractor FieLd:Belisarius Cawl has a 5+ invulnerable save.\n\n" +
                                "Self-repair Mechanisms: At the beginning of each of your turns, Belisarius Cawl regains D3 lost wounds.\n\n" +
                                "Master of Machines: At the end of your Movement phase Belisarius Cawl can repair a single friendly IMPERIUM model within 3\" (but not himself). The model being " +
                                "repaired regains 1 lost wound, unless it is an ADEPTUS MECHANICUS model, in which case it regains D3 lost wounds. A model may not be the target of the Master of" +
                                " Machines ability more than once per turn.\n\n" +
                                "Lord of Mars: You can re-roll any hit rolls in the Shooting phase for friendly MARS units within 6\"."),
                Unit("Tech-priest Dominus",
                        "M:6 WS:3+ BS:2+ S:4 T:4 W:5 A:3 Sv:2+ Ld:8",
                        R.drawable.mech_dominus,
                        "Eradication ray\n" +
                                "HvD3 24\" S:6 AP:2 D:1 (Attacks from this weapon that target enemies at 8\" or less are resolved with an AP of -4 and a Damage of D3.)\n\n" +
                                "Macrostubber\n" +
                                "Pl5 12\" S:4 AP:0 D:1\n\n" +
                                "Volkite blaster\n" +
                                "Hv3 24\" S:6 AP:0 D:1 (Each time you make a wound roll of 6+ for this weapon, the target suffers a mortal wound in addition to any other damage.)\n\n" +
                                "Omnissian axe\n" +
                                "Ml S:+1 AP:2 D:2\n\n" +
                                "Phosphor serpenta\n" +
                                "As1 18\" S:5 AP:1 D:1 (Units attacked by this weapon do not gain any bonus to their saving throws for being in cover.)",
                        "Canticles of Omnissiah\n\n" +
                                "Master of Machines: At the end of your Movement phase this model can repair a single friendly <FORGE WORLD> or QUESTOR " +
                                "MECHANICUS model within 3\" (but not itself). If the model being repaired is a <FORGE WORLD> model, it regains D3 lost wounds; if it is a QUESTOR MECHANICUS model, " +
                                "it regains 1 lost wound. A model may not be the target of the Master of Machines ability more than once per turn.\n\n" +
                                "Masterwork Bionics: At the beginning of each of your turns, this model regains D3 lost wounds.\n\n" +
                                "Lord of the Machine Cult: You can re-roll hit rolls of 1 in the Shooting phase for friendly <FORGE WORLD> units within 6\".\n\n" +
                                "Refractor Field: This model has a 5+ invulnerable save."),
                Unit("Tech-priest Enginseer",
                        "M:6 WS:4+ BS:4+ S:4 T:4 W:4 A:2 Sv:3+ Ld:8",
                        R.drawable.mech_enginseer,
                        "Laspistol\n" +
                                "Pl1 12\" S:3 AP:0 D:1\n\n" +
                                "Omnissian axe\n" +
                                "Ml S:+1 AP:2 D:2\n\n" +
                                "Servo-arm\n" +
                                "Ml S:x2 AP:2 D:3 (Each servo-arm can only be used to make one attack each time this model fights. When a model attacks with this weapon, you must subtract 1 from the hit roll.)",
                        "Canticles of Omnissiah\n\n" +
                                "Bionics: All models in this unit have a 6+ invulnerable save.\n\n" +
                                "Master of Machines: At the end of your Movement phase this model can repair a single friendly <FORGE WORLD> VEHICLE, ASTRA MILITARUM VEHICLE or QUESTOR MECHANICUS model within 3\". If the model being repaired is a <FORGE WORLD> or ASTRA MILITARUM model, it regains D3 lost wounds; if it is a QUESTOR MECHANICUS model, it regains 1 lost wound. A model may not be the target of the Master of Machines ability more than once per turn."),
                Unit("Skitarii Rangers",
                        "M:6 WS:4+ BS:3+ S:3 T:3 W:1 A:1 Sv:4+ Ld:6\n" +
                                "M:6 WS:4+ BS:3+ S:3 T:3 W:1 A:2 Sv:4+ Ld:7",
                        R.drawable.mech_ranger,
                        "Galvanic rifle\n" +
                                "Rf1 30\" S:4 AP:0 D:1 (Each time you make a wound roll of 6+ for this weapon, that hit is resolved with an AP of -1.)",
                        "Canticles of Omnissiah\n\n" +
                                "Bionics: All models in this unit have a 6+ invulnerable save.\n\n" +
                                "Omnispex: Enemy units do not receive the benefit to their saving throws for being in cover against attacks made by a unit that includes a model with an omnispex.\n\n" +
                                "Enhanced Data-tether: You can re-roll failed Morale tests for a unit that includes a model with an enhanced data-tether."),
                Unit("Skitarii Vanguard",
                        "M:6 WS:4+ BS:3+ S:3 T:3 W:1 A:1 Sv:4+ Ld:6\n" +
                                "M:6 WS:4+ BS:3+ S:3 T:3 W:1 A:2 Sv:4+ Ld:7",
                        R.drawable.mech_vanguard,
                        "Radium carbine\n" +
                                "As3 18\" S:3 AP:0 D:1 (Each time you make a wound roll of 6+ for this weapon, that hit inflicts 2 damage instead of 1.)",
                        "Canticles of Omnissiah\n\n" +
                                "Bionics: All models in this unit have a 6+ invulnerable save.\n\n" +
                                "Rad-saturation: Reduce the Toughness of enemy units (other than VEHICLES) by 1 whilst they are within 1\" of any Skitarii Vanguard units.\n\n" +
                                "Omnispex: Enemy units do not receive the benefit to their saving throws for being in cover against attacks made by a unit that includes a model with an omnispex.\n\n" +
                                "Enhanced Data-tether: You can re-roll failed Morale tests for a unit that includes a model with an enhanced data-tether."),
                Unit("Kataphron breachers",
                        "M:6 WS:4+ BS:4+ S:5 T:5 W:3 A:3 Sv:3+ Ld:7",
                        R.drawable.mech_destroyer,
                        "Heavy arc rifle\n" +
                                "Hv2 36\" S:6 AP:2 D:D3 (When attacking a VEHICLE, this weapon has a Damage of D6.)\n\n" +
                                "Torsion cannon\n" +
                                "Hv1 24\" S:8 AP:4 D:D6\n\n" +
                                "Arc claw\n" +
                                "Ml S:+1 AP:1 D:1 (When attacking a VEHICLE, this weapon has a Damage of D3.)\n\n" +
                                "Hydraulic claw\n" +
                                "Ml S:x2 AP:1 D:D3 (When attacking with this weapon, you must subtract 1 from the hit roll.)",
                        "Canticles of Omnissiah\n\n" +
                                "Bionics: All models in this unit have a 6+ invulnerable save.\n\n" +
                                "Heavy Battle Servitor: Models in this unit do not suffer the penalty for firing a Heavy weapon after moving, but" +
                                "can only Advance D3\"."),
                Unit("Kataphron destroyers",
                        "M:6 WS:4+ BS:4+ S:5 T:5 W:3 A:2 Sv:4+ Ld:7",
                        R.drawable.mech_destroyer,
                        "Cognis flamer\n" +
                                "AsD6 8\" S:4 AP:0 D:1 (This weapon automatically hits its target. In addition, when firing Overwatch with this weapon, roll two dice when determining how many attacks it makes and discard the lowest result.)\n\n" +
                                "Heavy grav-cannon\n" +
                                "Hv5 30\" S:5 AP:3 D:1 (If the target has a Save characteristic of 3+ or better, this weapon has a Damage characteristic of D3.)\n\n" +
                                "Phosphor blaster\n" +
                                "Rf1 24\" S:5 AP:1 D:1 (Units attacked by this weapon do not gain any bonus to their saving throws for being in cover.)\n\n" +
                                "Plasma culverin\n" +
                                "HvD6 36\" S:7 AP:3 D:1\n" +
                                "HvD6 36\" S:8 AP:3 D:2 (On a hit roll of 1, the bearer is slain after all of this weapon’s shots have been resolved.)",
                        "Canticles of Omnissiah\n\n" +
                                "Bionics: All models in this unit have a 6+ invulnerable save.\n\n" +
                                "Heavy Battle Servitor: Models in this unit do not suffer the penalty for firing a Heavy weapon after moving, but\n" +
                                "can only Advance D3\"."),
                Unit("Servitors",
                        "M:5 WS:5+ BS:5+ S:3 T:3 W:1 A:1 Sv:4+ Ld:6",
                        R.drawable.mech_servitor,
                        "Heavy bolter\n" +
                                "Hv3 36\" S:5 AP:1 D:1\n\n" +
                                "Multi-melta\n" +
                                "Hv1 24\" S:8 AP:4 D:D6 (If the target is within half range of this weapon, roll two dice when inflicting damage with it and discard the lowest result.)\n\n" +
                                "Plasma cannon\n" +
                                "HvD3 36\" S:7 AP:3 D:1\n" +
                                "HvD3 36\" S:8 AP:3 D:2 (On a hit roll of 1, the bearer is slain after all of this weapon’s shots have been resolved.)\n\n" +
                                "Servo-arm\n" +
                                "Ml S:x2 AP:2 D:3 (Each servo-arm can only be used to make one attack each time this model fights. When a model attacks with this weapon, you must subtract 1 from the hit roll.)",
                        "Canticles of Omnissiah\n\n" +
                                "Mindlock: Servitors improve both their Weapon Skill and Ballistic Skill to 4+, and their Leadership to 9, whilst" +
                                "they are within 6\" of any friendly TECH-PRIESTS."),
                Unit("Cybernetica datasmith",
                        "M:6 WS:3+ BS:3+ S:4 T:4 W:4 A:2 Sv:2+ Ld:8",
                        R.drawable.mech_progr,
                        "Gamma pistol\n" +
                                "Pl1 12\" S:6 AP:3 D:2\n\n" +
                                "Power fist\n" +
                                "Ml S:x2 AP:3 D:3",
                        "Canticles of Omnissiah\n\n" +
                                "Bionics: All models in this unit have a 6+ invulnerable save.\n\n" +
                                "Master of Machines: At the end of your Movement phase this model can repair a single friendly <FORGE WORLD> VEHICLE, ASTRA MILITARUM VEHICLE or QUESTOR MECHANICUS model within 3\". If the model being repaired is a <FORGE WORLD> or ASTRA MILITARUM model, it regains D3 lost wounds; if it is a QUESTOR MECHANICUS model, it regains 1 lost wound. A model may not be the target of the Master of Machines ability more than once per turn.\n\n" +
                                "Refractor Field: This model has a 5+ invulnerable save."),
                Unit("Sicarian Ruststalkers",
                        "M:8 WS:3+ BS:3+ S:4 T:3 W:2 A:3 Sv:4+ Ld:6\n" +
                                "M:8 WS:3+ BS:3+ S:4 T:3 W:2 A:4 Sv:4+ Ld:7",
                        R.drawable.mech_stalkers,
                        "Chordclaw\n" +
                                "Ml S:U AP:0 D:D3 (A chordclaw can only be used to make one attack each time this model fights. Each time you make a wound roll of 6+ with this weapon, the target suffers D3 mortal wounds instead of the normal damage.)\n\n" +
                                "Transonic blades\n" +
                                "Ml S:+1 AP:0 D:1 (Each time you make a wound roll of 6+ with this weapon, the target suffers a mortal wound instead of the normal damage.)\n\n" +
                                "Transonic razor\n" +
                                "Ml S:U AP:0 D:1 (Each time you make a wound roll of 6+ with this weapon, the target suffers a mortal wound instead of the normal damage.)",
                        "Canticles of Omnissiah\n\n" +
                                "Bionics: All models in this unit have a 6+ invulnerable save."),
                Unit("Sicarian Infiltrators",
                        "M:8 WS:3+ BS:3+ S:4 T:3 W:2 A:3 Sv:4+ Ld:6\n" +
                                "M:8 WS:3+ BS:3+ S:4 T:3 W:2 A:4 Sv:4+ Ld:7",
                        R.drawable.mech_infiltrators,
                        "Flechette blaster\n" +
                                "Pl5 12\" S:3 AP:0 D:1\n\n" +
                                "Stubcarbine\n" +
                                "Pl3 18\" S:4 AP:0 D:1\n\n" +
                                "Power sword\n" +
                                "Ml S:U AP:0 3 D:1\n\n" +
                                "Taser goad\n" +
                                "Ml S:+2 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits rather than 1.)",
                        "Canticles of Omnissiah\n\n" +
                                "Bionics: All models in this unit have a 6+ invulnerable save.\n\n" +
                                "Infiltrators: During deployment, you can set this unit up in concealment instead of placing it on the battlefield. At the end of any of your Movement phases, this unit can reveal its location – set it up anywhere on the battlefield that is more than 9\" from any enemy model.\n\n" +
                                "Neurostatic Aura: Enemy units within 3\" of any Sicarian Infiltrators must subtract 1 from their Leadership."),
                Unit("Fulgurite Electro-priests",
                        "M:6 WS:3+ BS:4+ S:3 T:3 W:1 A:2 Sv:6+ Ld:8",
                        R.drawable.mech_priest,
                        "Electroleech stave\n" +
                                "Ml S:+2 AP:2 D:D3 (Each time you make a wound roll of 6+ with this weapon, the target suffers D3 mortal wounds instead of the normal damage.)",
                        "Canticles of Omnissiah\n\n" +
                                "Voltagheist Field: All models in this unit have a 5+ invulnerable save. When this unit completes a charge move, pick one of the target units you charged and roll a D6 for each model in the charging unit. Any rolls of 6 inflict a mortal wound on the unit you picked.\n\n" +
                                "Siphoned Vigour: If this unit wipes out an enemy unit in the Fight phase, their invulnerable save is increased to 3+ for the rest of the battle.\n\n" +
                                "Fanatical Devotion: Each time a model in this unit loses a wound, roll a D6; on a roll of 5 or 6, the model does not lose that wound."),
                Unit("Corpuscarii Electro-priests",
                        "M:6 WS:3+ BS:4+ S:3 T:3 W:1 A:2 Sv:6+ Ld:8",
                        R.drawable.mech_priest,
                        "Electrostatic gauntlets (shooting)\n" +
                                "As3 12\" S:5 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits rather than 1.)\n\n" +
                                "Electrostatic gauntlets (melee)\n" +
                                "Ml S:5 AP:0 D:1 (Each hit roll of 6+ with this weapon causes 3 hits rather than 1.)",
                        "Canticles of Omnissiah\n\n" +
                                "Voltagheist Field: All models in this unit have a 5+ invulnerable save. When this unit completes a charge move, pick one of the target units you charged and roll a D6 for each model in the charging unit. Any rolls of 6 inflict a mortal wound on the unit you picked.\n\n" +
                                "Fanatical Devotion: Each time a model in this unit loses a wound, roll a D6; on a roll of 5 or 6, the model does not lose that wound."),
                Unit("Sydonian Dragoons",
                        "M:10 WS:3+ BS:3+ S:5 T:6 W:6 A:3 Sv:4+ Ld:8",
                        R.drawable.mech_strider_meele,
                        "Phosphor serpenta\n" +
                                "As1 18\" S:5 AP:1 D:1 (Units attacked by this weapon do not gain any bonus to their saving throws for being in cover.)\n\n" +
                                "Radium jezzail\n" +
                                "Hv2 S:5 AP:0 D:1 (This weapon may target a CHARACTER even if it is not the closest enemy unit. Each time you make a wound roll of 6+ for this weapon, it inflicts a mortal wound in addition to its normal damage.)\n\n" +
                                "Taser lance\n" +
                                "Ml S:+3 AP:1 D:2 (Each hit roll of 6+ with this weapon causes 3 hits rather than 1.)",
                        "Canticles of Omnissiah\n\n" +
                                "Bionics: All models in this unit have a 6+ invulnerable save.\n\n" +
                                "Broad Spectrum Data-tether: <FORGE WORLD> units within 3\" of any friendly models equipped with a broad spectrum data-tether at the start of the Morale phase add 1 to their Leadership for the duration of the phase.\n\n" +
                                "Explodes: If a model in this unit is reduced to 0 wounds, roll a D6 before removing the model from the battlefield; on a 6 it explodes, and each unit within 3\" suffers 1 mortal wound.\n\n" +
                                "Incense Cloud: Your opponent must subtract 1 from all hit rolls for ranged weapons that target this unit."),
                Unit("Ironstrider Ballistarii",
                        "M:10 WS:3+ BS:3+ S:5 T:6 W:6 A:2 Sv:4+ Ld:8",
                        R.drawable.mech_strider_shoot,
                        "Twin cognis autocannon\n" +
                                "Hv4 48\" S:7 AP:1 D:2 (You may fire this weapon even if the firing model Advanced but you must subtract 2 from any hit rolls if you do so.)\n\n" +
                                "Twin cognis lascannon\n" +
                                "Hv2 48\" S:9 AP:3 D:D6 (You may fire this weapon even if the firing model Advanced but you must subtract 2 from any hit rolls if you do so.)",
                        "Canticles of Omnissiah\n\n" +
                                "Bionics: All models in this unit have a 6+ invulnerable save.\n\n" +
                                "Broad Spectrum Data-tether: <FORGE WORLD> units within 3\" of any friendly models equipped with a broad spectrum data-tether at the start of the Morale phase add 1 to their Leadership for the duration of the phase.\n\n" +
                                "Explodes: If a model in this unit is reduced to 0 wounds, roll a D6 before removing the model from the battlefield; on a 6 it explodes, and each unit within 3\" suffers 1 mortal wound."),
                Unit("Kastelan robots",
                        "M:8 WS:4+ BS:4+ S:6 T:7 W:6 A:3 Sv:3+ Ld:10",
                        R.drawable.mech_robot,
                        "Heavy phosphor blaster\n" +
                                "Hv3 36\" S:6 AP:2 D:1 (Units attacked by this weapon do not gain any bonus to their saving throws for being in cover.)\n\n" +
                                "Incendine combustor\n" +
                                "HvD6 12\" S:5 AP:0 1 D:1 (This weapon automatically hits its target.)\n\n" +
                                "Kastelan fists\n" +
                                "Ml S:+4 AP:3 D:3",
                        "Canticles of Omnissiah\n\n" +
                                "Repulsor Grid: All models in this unit have a 5+ invulnerable save against shooting attacks. In addition, each time you roll a 6 (after re-rolls, but before modifiers) for a repulsor grid’s invulnerable saving throw, the unit that made that attack suffers a mortal wound.\n\n" +
                                "Battle Protocols: When this unit is set up, the Aegis Protocol (see below) is in effect. You can attempt to change the unit’s battle protocol at the start of each of your Movement phases if there is a friendly <FORGE WORLD> Cybernetica Datasmith within 6\". To do so, roll a " +
                                "D6; on a 2+ the attempt is successful and you can select any one of the three battle protocols to take effect from the start of the next battle round. Otherwise, the attempt fails and the unit’s current protocol remains in effect.\n" +
                                "Aegis Protocol: Whilst this battle protocol is in effect, you can add 1 to any armour and invulnerable saving throws you make for models in the unit.\n" +
                                "Conqueror Protocol: Whilst this battle protocol is in effect, this unit cannot shoot, but it can fight twice in each Fight phase instead of only once.\n" +
                                "Protector Protocol: Whilst this battle protocol is in effect, this unit cannot move or charge, but you can double the number of shots it makes with each of its ranged weapons – i.e., the heavy phosphor blaster’s Type becomes Heavy 6 and the incendine combustor’s Type becomes Heavy 2D6.\n\n" +
                                "Explodes: If a model in this unit is reduced to 0 wounds, roll a D6 before removing the model from the battlefield; on a 6 it explodes, and each unit within 3\" suffers D3 mortal wounds."),
                Unit("Onager Dunecrawler",
                        "M:8 WS:5+ BS:3+ S:6 T:7 W:11 A:3 Sv:3+ Ld:8",
                        R.drawable.mech_crawler,
                        "Cognis heavy stubber\n" +
                                "Hv3 36\" S:4 AP:0 D:1 (You may fire this weapon even if the firing model Advanced but you must subtract 2 from any hit rolls if you do so.)\n\n" +
                                "Eradication beamer\n" +
                                "HvD6 36\" S:8 AP:0 2 D:D3 (When attacking units within 12\", change this weapon’s Type to Heavy D3, but resolve the shots with an AP of -4 and a Damage of D6.)\n\n" +
                                "Icarus array (Add 1 to all hit rolls made for this weapon against targets that can FLY. Subtract 1 from hit rolls against all other targets.)\n" +
                                "- Daedalus missile launcher\n" +
                                "Hv1 48\" S:7 AP:3 D:D6\n" +
                                "- Gatling rocket launcher\n" +
                                "Hv5 48\" S:6 AP:2 D:1\n" +
                                "- Twin Icarus autocannon\n" +
                                "Hv4 48\" S:7 AP:1 D:2\n\n" +
                                "Neutron laser\n" +
                                "HvD3 48\" S:10 AP:4 D:D6 (Treat damage rolls of 1 or 2 made by this weapon as 3 instead.)\n\n" +
                                "Twin heavy phosphor blaster\n" +
                                "Hv6 36\" S:6 AP:2 D:1 (Units attacked by this weapon do not gain any bonus to their saving throws for being in cover.)",
                        "DAMAGE:\n" +
                                "W:7-11 M:8\" BS:3+ A:3\n" +
                                "W:3-5  M:6\" BS:4+ A:D3\n" +
                                "W:1-2  M:4\" BS:5+ A:1\n\n" +
                                "Canticles of Omnissiah\n\n" +
                                "Emanatus Force Field: This model has a 5+ invulnerable save. You can re-roll invulnerable saving throws of 1 for any Onager Dunecrawler if it is within 6\" of at least one other friendly <FORGE WORLD> Onager Dunecrawler.\n\n" +
                                "Smoke Launchers: Once per game, a model equipped with smoke launchers can use them instead of shooting any weapons in the Shooting phase; until your next Shooting phase your opponent must subtract 1 from all hit rolls for ranged weapons that target this vehicle.\n\n" +
                                "Broad Spectrum Data-tether: <FORGE WORLD> units within 3\" of any friendly models equipped with a broad spectrum data-tether at the start of the Morale phase add 1 to their Leadership for the duration of the phase.\n\n" +
                                "Crawler: This model can only Advance D3\", but ignores the -1 penalty to its hit rolls for moving and firing a Heavy weapon.\n\n" +
                                "Explodes: If this model is reduced to 0 wounds, roll a D6 before removing the model from the battlefield; on a 6 it explodes, and each unit within 6\" suffers D3 mortal wounds.")

        )

)