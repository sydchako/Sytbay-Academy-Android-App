package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.ExamBoard
import com.example.model.ExamLevel
import com.example.model.MaterialType
import com.example.ui.theme.SytbayGold
import com.example.ui.theme.SytbayGreen
import com.example.ui.theme.SytbayNavy

@Composable
fun ExamLevelBadge(level: ExamLevel, modifier: Modifier = Modifier) {
    val (bgColor, textColor) = when (level) {
        ExamLevel.O_LEVEL -> Color(0xFFDCFCE7) to Color(0xFF166534)
        ExamLevel.A_LEVEL -> Color(0xFFFEF3C7) to Color(0xFF92400E)
        ExamLevel.CAMBRIDGE -> Color(0xFFDBEAFE) to Color(0xFF1E40AF)
        ExamLevel.HEXCO -> Color(0xFFF3E8FF) to Color(0xFF6B21A8)
        ExamLevel.GRADE_7 -> Color(0xFFFFEDD5) to Color(0xFF9A3412)
        ExamLevel.ALL -> Color(0xFFF1F5F9) to Color(0xFF475569)
    }

    Surface(
        color = bgColor,
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
    ) {
        Text(
            text = level.shortBadge,
            color = textColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
        )
    }
}

@Composable
fun BoardBadge(board: ExamBoard, modifier: Modifier = Modifier) {
    val (bgColor, textColor) = when (board) {
        ExamBoard.ZIMSEC -> SytbayGreen.copy(alpha = 0.12f) to SytbayGreen
        ExamBoard.CAMBRIDGE -> SytbayNavy.copy(alpha = 0.12f) to SytbayNavy
        ExamBoard.HEXCO -> SytbayGold.copy(alpha = 0.15f) to SytbayGold
        ExamBoard.ALL -> Color.LightGray.copy(alpha = 0.3f) to Color.DarkGray
    }

    Surface(
        color = bgColor,
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
    ) {
        Text(
            text = board.displayName,
            color = textColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
        )
    }
}

@Composable
fun MaterialTypeBadge(type: MaterialType, modifier: Modifier = Modifier) {
    val (bgColor, textColor) = when (type) {
        MaterialType.PAST_PAPER -> Color(0xFFEFF6FF) to Color(0xFF1D4ED8)
        MaterialType.MARKING_SCHEME -> Color(0xFFF0FDF4) to Color(0xFF15803D)
        MaterialType.REVISION_NOTE -> Color(0xFFFFFBEB) to Color(0xFFB45309)
        MaterialType.SYLLABUS -> Color(0xFFFAF5FF) to Color(0xFF7E22CE)
        MaterialType.WORKSHEET -> Color(0xFFFFF1F2) to Color(0xFFBE123C)
        MaterialType.ALL -> Color.LightGray to Color.Black
    }

    Surface(
        color = bgColor,
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
    ) {
        Text(
            text = type.displayName,
            color = textColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
        )
    }
}

@Composable
fun StatCard(
    title: String,
    value: String,
    subtitle: String,
    icon: ImageVector,
    iconColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(14.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(iconColor.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}

@Composable
fun SearchBarInput(
    query: String,
    onQueryChange: (String) -> Unit,
    placeholder: String = "Search past papers, notes, subjects…",
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        placeholder = { Text(placeholder, fontSize = 14.sp) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .testTag("search_input")
    )
}
