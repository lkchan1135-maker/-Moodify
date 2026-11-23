
package com.moodify.app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF100D1C)
private val CardColor = Color(0xFF211A35)
private val Purple = Color(0xFFBD91FF)

@Composable
fun MoodScreen() {
    val moods = listOf(
        "😊 Happy",
        "😢 Sad",
        "😡 Angry",
        "😴 Tired",
        "🤩 Excited",
        "😌 Calm"
    )

    var selectedMood by remember { mutableStateOf("😊 Happy") }

    val recommendations = when (selectedMood) {
        "😊 Happy" -> listOf("Happy Vibes", "Sunny Day", "Good Energy")
        "😢 Sad" -> listOf("Soft Memories", "Quiet Night", "Slow Rain")
        "😡 Angry" -> listOf("Cool Down", "Deep Breath", "Peaceful Mind")
        "😴 Tired" -> listOf("Rest Time", "Dream World", "Sleepy Mood")
        "🤩 Excited" -> listOf("High Energy", "Let's Go", "Bright Future")
        else -> listOf("Calm Ocean", "Silent Sky", "Peaceful Day")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(22.dp)
    ) {
        Text(
            "🎧 Moodify",
            color = Purple,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            "Music that matches your mood.",
            color = Color.LightGray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            "Choose Your Mood",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(15.dp))

        moods.chunked(2).forEach { rowMoods ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                rowMoods.forEach { mood ->
                    val selected = selectedMood == mood

                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = 10.dp)
                            .clickable { selectedMood = mood },
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (selected) {
                                Color(0xFF493064)
                            } else {
                                CardColor
                            }
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(19.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                mood,
                                color = Color.White,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Recommendations",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(recommendations) { song ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = CardColor
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "🎵  $song",
                            color = Color.White,
                            fontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            "♫",
                            color = Purple,
                            fontSize = 22.sp
                        )
                    }
                }
            }
        }
    }
}
