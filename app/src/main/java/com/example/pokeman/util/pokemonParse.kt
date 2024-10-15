package com.example.pokeman.util

import androidx.compose.ui.graphics.Color
import com.example.pokeman.data.remote.response.Stat
import com.example.pokeman.data.remote.response.Type
import com.example.pokeman.ui.theme.AtkColor
import com.example.pokeman.ui.theme.DefColor
import com.example.pokeman.ui.theme.HPColor
import com.example.pokeman.ui.theme.SpAtkColor
import com.example.pokeman.ui.theme.SpDefColor
import com.example.pokeman.ui.theme.SpdColor
import com.example.pokeman.ui.theme.TypeBug
import com.example.pokeman.ui.theme.TypeDark
import com.example.pokeman.ui.theme.TypeDragon
import com.example.pokeman.ui.theme.TypeElectric
import com.example.pokeman.ui.theme.TypeFairy
import com.example.pokeman.ui.theme.TypeFighting
import com.example.pokeman.ui.theme.TypeFire
import com.example.pokeman.ui.theme.TypeFlying
import com.example.pokeman.ui.theme.TypeGhost
import com.example.pokeman.ui.theme.TypeGrass
import com.example.pokeman.ui.theme.TypeGround
import com.example.pokeman.ui.theme.TypeIce
import com.example.pokeman.ui.theme.TypeNormal
import com.example.pokeman.ui.theme.TypePoison
import com.example.pokeman.ui.theme.TypePsychic
import com.example.pokeman.ui.theme.TypeRock
import com.example.pokeman.ui.theme.TypeSteel
import com.example.pokeman.ui.theme.TypeWater
import java.util.Locale

fun parseTypeToColor(type: Type): Color {
    return when(type.type.name.toLowerCase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stat): String {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}