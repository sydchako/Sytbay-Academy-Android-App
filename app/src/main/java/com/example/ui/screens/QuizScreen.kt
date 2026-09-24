package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.SytbayViewModel
import com.example.ui.theme.SytbayGold
import com.example.ui.theme.SytbayGreen
import com.example.ui.theme.SytbayNavy

@Composable
fun QuizScreen(
    viewModel: SytbayViewModel,
    modifier: Modifier = Modifier
) {
    val quizState by viewModel.quizState.collectAsState()
    val quizResults by viewModel.quizResults.collectAsState()

    if (quizState.isActive) {
        if (quizState.isFinished) {
            QuizFinishedView(
                title = quizState.subjectTitle,
                score = quizState.score,
                total = quizState.questions.size,
                onRetake = { viewModel.startQuiz(customTitle = quizState.subjectTitle) },
                onExit = { viewModel.exitQuiz() }
            )
        } else {
            ActiveQuizView(
                viewModel = viewModel
            )
        }
    } else {
        QuizDashboardView(
            viewModel = viewModel,
            quizResults = quizResults,
            modifier = modifier
        )
    }
}

@Composable
fun QuizDashboardView(
    viewModel: SytbayViewModel,
    quizResults: List<com.example.local.entity.QuizResultEntity>,
    modifier: Modifier = Modifier
) {
    val subjects = viewModel.subjects

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("quiz_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Quick Challenge Card
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = SytbayGreen),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            color = SytbayGold,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                "DAILY DRILL",
                                color = Color.Black,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Mixed Curriculum Challenge",
                            color = Color.White.copy(alpha = 0.9f),
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Sytbay Speed Revision Quiz",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "10 randomized past examination questions covering Mathematics, Science, Computer Science & Heritage.",
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Button(
                        onClick = { viewModel.startQuiz(customTitle = "All-Round Speed Challenge") },
                        colors = ButtonDefaults.buttonColors(containerColor = SytbayGold),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.testTag("start_daily_quiz_btn")
                    ) {
                        Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null, tint = Color.Black)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Start Speed Quiz", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Subject Quizzes Section
        item {
            Text(
                text = "Subject Specific Quizzes",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        items(subjects) { subject ->
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { viewModel.startQuiz(subjectId = subject.id, customTitle = "${subject.name} (${subject.code}) Quiz") }
                    .testTag("subject_quiz_${subject.id}")
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(SytbayNavy.copy(alpha = 0.12f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Quiz,
                            contentDescription = null,
                            tint = SytbayNavy,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "${subject.name} (${subject.code})",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${subject.level.displayName} • ${subject.quizzesCount} questions in bank",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Button(
                        onClick = { viewModel.startQuiz(subjectId = subject.id, customTitle = "${subject.name} (${subject.code}) Quiz") },
                        colors = ButtonDefaults.buttonColors(containerColor = SytbayGreen),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text("Practice", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Past Results History Section
        if (quizResults.isNotEmpty()) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Recent Practice Scores",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${quizResults.size} recorded",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }

            items(quizResults.take(5)) { result ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(if (result.percentage >= 70) Color(0xFFDCFCE7) else Color(0xFFFEF3C7)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${result.percentage}%",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = if (result.percentage >= 70) Color(0xFF166534) else Color(0xFF92400E)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = result.subjectName,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "${result.examLevel} • ${result.topic}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Text(
                            text = "${result.score} / ${result.totalQuestions}",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ActiveQuizView(
    viewModel: SytbayViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.quizState.collectAsState()
    val currentQuestion = state.questions.getOrNull(state.currentIndex)

    if (currentQuestion == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No questions available for this subject.")
        }
        return
    }

    val progress = (state.currentIndex + 1).toFloat() / state.questions.size.toFloat()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .testTag("active_quiz_view")
    ) {
        // Top Navigation Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = state.subjectTitle,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = SytbayGreen
                )
                Text(
                    text = "Question ${state.currentIndex + 1} of ${state.questions.size}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            IconButton(onClick = { viewModel.exitQuiz() }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Exit Quiz")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Progress Bar
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp)),
            color = SytbayGreen,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Question Card
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Surface(
                    color = SytbayNavy.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = currentQuestion.topic,
                        color = SytbayNavy,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = currentQuestion.question,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Options
        currentQuestion.options.forEachIndexed { index, optionText ->
            val isSelected = state.selectedOptionIndex == index
            val isSubmitted = state.isAnswerSubmitted
            val isCorrect = index == currentQuestion.correctIndex

            val optionBorderColor = when {
                isSubmitted && isCorrect -> Color(0xFF16A34A)
                isSubmitted && isSelected && !isCorrect -> Color(0xFFDC2626)
                isSelected -> SytbayGreen
                else -> MaterialTheme.colorScheme.outline.copy(alpha = 0.4f)
            }

            val optionBgColor = when {
                isSubmitted && isCorrect -> Color(0xFFDCFCE7)
                isSubmitted && isSelected && !isCorrect -> Color(0xFFFEE2E2)
                isSelected -> SytbayGreen.copy(alpha = 0.08f)
                else -> MaterialTheme.colorScheme.surface
            }

            Card(
                colors = CardDefaults.cardColors(containerColor = optionBgColor),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
                    .border(width = if (isSelected || (isSubmitted && isCorrect)) 2.dp else 1.dp, color = optionBorderColor, shape = RoundedCornerShape(12.dp))
                    .clickable(enabled = !isSubmitted) { viewModel.selectQuizOption(index) }
                    .testTag("option_$index")
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val optionLabel = ('A'.code + index).toChar().toString()
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(if (isSelected) SytbayGreen else MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = optionLabel,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = optionText,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        // Feedback / Explanation Card if answer submitted
        if (state.isAnswerSubmitted) {
            Spacer(modifier = Modifier.height(10.dp))
            val isCorrect = state.selectedOptionIndex == currentQuestion.correctIndex
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (isCorrect) Color(0xFFF0FDF4) else Color(0xFFFFFBEB)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = if (isCorrect) Icons.Default.CheckCircle else Icons.Default.HelpOutline,
                            contentDescription = null,
                            tint = if (isCorrect) Color(0xFF15803D) else Color(0xFFB45309),
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isCorrect) "Correct! Examiner Solution:" else "Incorrect. Solution & Explanation:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = if (isCorrect) Color(0xFF15803D) else Color(0xFFB45309)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = currentQuestion.explanation,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.DarkGray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom CTA Buttons
        if (!state.isAnswerSubmitted) {
            Button(
                onClick = { viewModel.submitCurrentAnswer() },
                enabled = state.selectedOptionIndex != null,
                colors = ButtonDefaults.buttonColors(containerColor = SytbayGreen),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("submit_answer_btn")
            ) {
                Text("Check Answer", fontWeight = FontWeight.Bold)
            }
        } else {
            Button(
                onClick = { viewModel.nextQuizQuestion() },
                colors = ButtonDefaults.buttonColors(containerColor = SytbayGold),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("next_question_btn")
            ) {
                Text(
                    text = if (state.currentIndex + 1 >= state.questions.size) "Finish & View Results" else "Next Question",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun QuizFinishedView(
    title: String,
    score: Int,
    total: Int,
    onRetake: () -> Unit,
    onExit: () -> Unit
) {
    val percentage = if (total > 0) (score * 100) / total else 0
    val feedbackMessage = when {
        percentage >= 80 -> "Outstanding Distinction! You are well prepared for the exam!"
        percentage >= 60 -> "Good Pass! A bit more revision will push you to an A grade."
        else -> "Keep Practicing! Review the syllabus notes and try again."
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .testTag("quiz_finished_view"),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .background(SytbayGold.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.EmojiEvents,
                    contentDescription = null,
                    tint = SytbayGold,
                    modifier = Modifier.size(54.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Quiz Completed!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "$score / $total",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = SytbayGreen
                    )
                    Text(
                        text = "$percentage% Final Score",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = feedbackMessage,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = onExit,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Text("Exit to Quizzes")
                }
                Button(
                    onClick = onRetake,
                    colors = ButtonDefaults.buttonColors(containerColor = SytbayGreen),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Icon(imageVector = Icons.Default.RestartAlt, contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Retake")
                }
            }
        }
    }
}
