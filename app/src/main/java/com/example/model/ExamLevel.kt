package com.example.model

enum class ExamLevel(val displayName: String, val shortBadge: String) {
    ALL("All Levels", "ALL"),
    GRADE_7("Grade 7 (Primary)", "G7"),
    O_LEVEL("Ordinary Level (O-Level)", "O-Level"),
    A_LEVEL("Advanced Level (A-Level)", "A-Level"),
    CAMBRIDGE("Cambridge / IGCSE", "IGCSE"),
    HEXCO("HEXCO / Polytechnic", "HEXCO")
}

enum class ExamBoard(val displayName: String) {
    ALL("All Boards"),
    ZIMSEC("ZIMSEC"),
    CAMBRIDGE("Cambridge"),
    HEXCO("HEXCO")
}

enum class MaterialType(val displayName: String) {
    ALL("All Types"),
    PAST_PAPER("Past Exam Paper"),
    MARKING_SCHEME("Marking Scheme & Solutions"),
    REVISION_NOTE("Revision Notes & Summaries"),
    SYLLABUS("Official Syllabus Guide"),
    WORKSHEET("Practice Worksheets")
}
