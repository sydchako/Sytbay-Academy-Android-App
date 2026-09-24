package com.example

import com.example.data.SytbayDataProvider
import com.example.model.ExamBoard
import com.example.model.ExamLevel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
  @Test
  fun testSubjectsCatalogueNotEmpty() {
    val subjects = SytbayDataProvider.subjects
    assertFalse(subjects.isEmpty())
    assertTrue(subjects.any { it.code == "4004" }) // ZIMSEC O-Level Maths
    assertTrue(subjects.any { it.code == "6042" }) // ZIMSEC A-Level Computer Science
  }

  @Test
  fun testStudyMaterialsHaveSolutions() {
    val materials = SytbayDataProvider.studyMaterials
    assertFalse(materials.isEmpty())
    val mathsPaper = materials.find { it.subjectId == "sub_zimsec_olevel_maths" }
    assertNotNull(mathsPaper)
    assertFalse(mathsPaper!!.sampleQuestionsWithSolutions.isEmpty())
  }

  @Test
  fun testQuizQuestionsValidOptions() {
    val questions = SytbayDataProvider.quizQuestions
    assertFalse(questions.isEmpty())
    questions.forEach { q ->
      assertTrue("Question must have options", q.options.isNotEmpty())
      assertTrue(
        "Correct index within bounds",
        q.correctIndex in 0 until q.options.size
      )
    }
  }

  @Test
  fun testTimetableHasValidEntries() {
    val timetable = SytbayDataProvider.examinationTimetable
    assertFalse(timetable.isEmpty())
    assertTrue(timetable.any { it.examBoard == ExamBoard.ZIMSEC })
  }
}
