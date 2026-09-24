package com.example.data

import com.example.model.ExamBoard
import com.example.model.ExamLevel
import com.example.model.MaterialType
import com.example.model.QuestionSolution
import com.example.model.QuizQuestion
import com.example.model.StudyMaterial
import com.example.model.Subject
import com.example.model.TimetableEntry

object SytbayDataProvider {

    val subjects: List<Subject> = listOf(
        Subject(
            id = "sub_zimsec_olevel_maths",
            name = "Mathematics",
            code = "4004",
            level = ExamLevel.O_LEVEL,
            examBoard = ExamBoard.ZIMSEC,
            description = "Algebra, Euclidean Geometry, Trigonometry, Statistics, Matrices & Vectors.",
            papersCount = 14,
            notesCount = 8,
            quizzesCount = 25,
            category = "Sciences & Maths"
        ),
        Subject(
            id = "sub_zimsec_olevel_comb_sci",
            name = "Combined Science",
            code = "5076",
            level = ExamLevel.O_LEVEL,
            examBoard = ExamBoard.ZIMSEC,
            description = "Integrated Biology (Cell Biology & Transport), Chemistry (Bonding & Acids), Physics (Mechanics & Electricity).",
            papersCount = 12,
            notesCount = 10,
            quizzesCount = 30,
            category = "Sciences & Maths"
        ),
        Subject(
            id = "sub_zimsec_alevel_cs",
            name = "Computer Science",
            code = "6042",
            level = ExamLevel.A_LEVEL,
            examBoard = ExamBoard.ZIMSEC,
            description = "Data Structures, OOP, Software Engineering, Boolean Algebra, Networking, Database Systems & Python.",
            papersCount = 10,
            notesCount = 12,
            quizzesCount = 20,
            category = "Technical"
        ),
        Subject(
            id = "sub_zimsec_alevel_pure_maths",
            name = "Pure Mathematics",
            code = "9164",
            level = ExamLevel.A_LEVEL,
            examBoard = ExamBoard.ZIMSEC,
            description = "Calculus, Differentiation & Integration, Complex Numbers, Differential Equations, Vectors in 3D.",
            papersCount = 16,
            notesCount = 9,
            quizzesCount = 18,
            category = "Sciences & Maths"
        ),
        Subject(
            id = "sub_zimsec_olevel_heritage",
            name = "Heritage Studies",
            code = "4006",
            level = ExamLevel.O_LEVEL,
            examBoard = ExamBoard.ZIMSEC,
            description = "Zimbabwe Constitution, National Identity, Great Zimbabwe Civilization, Liberation Struggle & Cultural Heritage.",
            papersCount = 8,
            notesCount = 6,
            quizzesCount = 15,
            category = "Humanities"
        ),
        Subject(
            id = "sub_zimsec_olevel_english",
            name = "English Language",
            code = "1122",
            level = ExamLevel.O_LEVEL,
            examBoard = ExamBoard.ZIMSEC,
            description = "Comprehension, Summary Writing, Composition & Registers, Grammar and Vocabulary.",
            papersCount = 12,
            notesCount = 7,
            quizzesCount = 22,
            category = "Languages"
        ),
        Subject(
            id = "sub_cambridge_igcse_maths",
            name = "IGCSE Mathematics",
            code = "0580",
            level = ExamLevel.CAMBRIDGE,
            examBoard = ExamBoard.CAMBRIDGE,
            description = "Number, Algebra, Shape & Space, Probability & Statistics for Extended and Core papers.",
            papersCount = 15,
            notesCount = 8,
            quizzesCount = 20,
            category = "Sciences & Maths"
        ),
        Subject(
            id = "sub_hexco_intro_programming",
            name = "Intro to Programming & Web Dev",
            code = "HEX-CS101",
            level = ExamLevel.HEXCO,
            examBoard = ExamBoard.HEXCO,
            description = "Sytbay Engineering & Programming series: Python fundamentals, HTML/CSS, JavaScript, logic building.",
            papersCount = 6,
            notesCount = 11,
            quizzesCount = 16,
            category = "Technical"
        ),
        Subject(
            id = "sub_grade7_general_paper",
            name = "Grade 7 General Paper",
            code = "G7-GP",
            level = ExamLevel.GRADE_7,
            examBoard = ExamBoard.ZIMSEC,
            description = "Environmental Science, Social Studies, Religious & Moral Education, Health and Safety.",
            papersCount = 9,
            notesCount = 5,
            quizzesCount = 20,
            category = "Primary"
        ),
        Subject(
            id = "sub_zimsec_olevel_commerce",
            name = "Commerce",
            code = "4049",
            level = ExamLevel.O_LEVEL,
            examBoard = ExamBoard.ZIMSEC,
            description = "Production, Banking, Insurance, International Trade, Consumer Protection, Advertising & Warehousing.",
            papersCount = 10,
            notesCount = 8,
            quizzesCount = 18,
            category = "Commercials"
        )
    )

    val studyMaterials: List<StudyMaterial> = listOf(
        StudyMaterial(
            id = "mat_maths_4004_nov2024_p2",
            title = "ZIMSEC O-Level Mathematics 4004/2 - November 2024 Exam & Full Solutions",
            subjectId = "sub_zimsec_olevel_maths",
            subjectName = "Mathematics (4004)",
            examLevel = ExamLevel.O_LEVEL,
            examBoard = ExamBoard.ZIMSEC,
            type = MaterialType.PAST_PAPER,
            yearSession = "Nov 2024",
            paperNumber = "Paper 2 (Structured)",
            pages = 14,
            sizeText = "1.8 MB",
            viewsCount = 3840,
            summary = "Complete past paper for ZIMSEC 4004/2 with detailed examiner marking scheme solutions for Quadratic Equations, Mensuration, Vectors, Transformations, and Statistics.",
            keyTopics = listOf("Quadratic Equations", "Circle Theorems", "Cumulative Frequency Curves", "Trigonometry 3D", "Vector Geometry"),
            formulaSheet = "Quadratic formula: x = [-b ± √(b² - 4ac)] / 2a\nCosine Rule: a² = b² + c² - 2bc cos(A)\nSine Rule: a/sin(A) = b/sin(B) = c/sin(C)\nArea of triangle: (1/2)ab sin(C)\nVolume of cone: (1/3)πr²h\nSurface area of sphere: 4πr²",
            sampleQuestionsWithSolutions = listOf(
                QuestionSolution(
                    questionNumber = "Question 1(a)",
                    questionText = "Solve the equation 3x² - 7x + 2 = 0 giving your answers correct to 2 decimal places.",
                    answerText = "Using the quadratic formula where a = 3, b = -7, c = 2:\nx = [-(-7) ± √((-7)² - 4(3)(2))] / (2 × 3)\nx = [7 ± √(49 - 24)] / 6\nx = [7 ± √25] / 6\nx = [7 ± 5] / 6\nTherefore, x = (7 + 5)/6 = 12/6 = 2.00 or x = (7 - 5)/6 = 2/6 = 0.33.",
                    examinerNotes = "Award full method marks for correct substitution into formula. Beware of negative sign on -(-7)."
                ),
                QuestionSolution(
                    questionNumber = "Question 2(b)",
                    questionText = "Given that vector OA = (3, 4) and vector OB = (-1, 7), find the magnitude of vector AB.",
                    answerText = "Vector AB = OB - OA\nAB = (-1 - 3, 7 - 4) = (-4, 3)\n|AB| = √((-4)² + 3²) = √(16 + 9) = √25 = 5 units.",
                    examinerNotes = "Ensure candidates write AB = OB - OA rather than adding vectors."
                )
            ),
            fullContent = """
# ZIMSEC O-Level Mathematics 4004/2
**Session:** November Examination Series
**Time Allowed:** 2 hours 30 minutes
**Instructions:** Answer all questions in Section A and any four questions from Section B.

---

### Section A (52 marks)
1. **Algebraic Manipulation & Factorisation**
   - Express 5/(x - 2) - 3/(x + 1) as a single fraction in its simplest form.
   - Solution: [5(x + 1) - 3(x - 2)] / [(x - 2)(x + 1)] = (5x + 5 - 3x + 6) / [(x - 2)(x + 1)] = (2x + 11) / (x² - x - 2).

2. **Matrices and Transformations**
   - Find the inverse of matrix M = [[4, 2], [3, 2]].
   - Determinant = (4 × 2) - (2 × 3) = 8 - 6 = 2.
   - Adj(M) = [[2, -2], [-3, 4]].
   - M⁻¹ = 1/2 × [[2, -2], [-3, 4]] = [[1, -1], [-1.5, 2]].

3. **Coordinate Geometry & Straight Lines**
   - The line passes through points P(2, -3) and Q(6, 5).
   - Gradient m = (5 - (-3)) / (6 - 2) = 8 / 4 = 2.
   - Equation: y - 5 = 2(x - 6) => y = 2x - 7.
            """.trimIndent()
        ),
        StudyMaterial(
            id = "mat_cs_6042_python_revision",
            title = "A-Level Computer Science 6042: Python Programming, Data Structures & Algorithms",
            subjectId = "sub_zimsec_alevel_cs",
            subjectName = "Computer Science (6042)",
            examLevel = ExamLevel.A_LEVEL,
            examBoard = ExamBoard.ZIMSEC,
            type = MaterialType.REVISION_NOTE,
            yearSession = "2024 - 2026 Edition",
            paperNumber = "Paper 1 & Paper 2 Prep",
            pages = 28,
            sizeText = "3.2 MB",
            viewsCount = 5210,
            summary = "Comprehensive Sytbay Academy study guide covering Object Oriented Programming (OOP), Linked Lists, Binary Trees, Big-O Notation, SQL queries, and Python implementation for Paper 2 practical projects.",
            keyTopics = listOf("OOP Principles", "Recursion vs Iteration", "Stacks & Queues", "Binary Search Trees", "SQL & Database Normalization"),
            formulaSheet = "Linear Search: O(n)\nBinary Search: O(log n)\nBubble Sort: O(n²)\nMerge Sort: O(n log n)\nTree Traversal: Pre-order (Root-Left-Right), In-order (Left-Root-Right), Post-order (Left-Right-Root)",
            sampleQuestionsWithSolutions = listOf(
                QuestionSolution(
                    questionNumber = "Section B, Q4",
                    questionText = "Write pseudocode or Python code for a function that implements a binary search on a sorted 1D array of integers.",
                    answerText = """def binary_search(arr, target):
    low = 0
    high = len(arr) - 1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1""",
                    examinerNotes = "Must include initialization of low and high pointers and integer division for mid point."
                )
            ),
            fullContent = """
# Sytbay Academy: A-Level Computer Science Revision
**Focus:** Algorithm Complexity, OOP, and Relational Databases.

### 1. Object-Oriented Programming (OOP)
- **Encapsulation:** Binding data and methods into a single class and restricting direct access using private attributes.
- **Inheritance:** Enabling a sub-class to inherit properties and methods of a parent class.
- **Polymorphism:** Method overriding and overloading allowing entities to take multiple forms.

### 2. Stack & Queue Operations
- **Stack (LIFO):** `push(item)`, `pop()`, `peek()`, `is_empty()`. Used in function call stacks and syntax parsing.
- **Queue (FIFO):** `enqueue(item)`, `dequeue()`, `front()`. Used in printer queues and breadth-first search.

### 3. Normalization Rules (1NF, 2NF, 3NF)
- **1NF:** Eliminate repeating groups; ensure all attributes are atomic.
- **2NF:** Must be in 1NF and all non-key attributes fully functionally dependent on the entire primary key.
- **3NF:** Must be in 2NF and have no transitive functional dependencies.
            """.trimIndent()
        ),
        StudyMaterial(
            id = "mat_comb_sci_5076_summary",
            title = "ZIMSEC Combined Science 5076: Comprehensive Biology, Chemistry & Physics Master Notes",
            subjectId = "sub_zimsec_olevel_comb_sci",
            subjectName = "Combined Science (5076)",
            examLevel = ExamLevel.O_LEVEL,
            examBoard = ExamBoard.ZIMSEC,
            type = MaterialType.REVISION_NOTE,
            yearSession = "2025 Edition",
            paperNumber = "Papers 1, 2 & 3",
            pages = 32,
            sizeText = "4.5 MB",
            viewsCount = 6890,
            summary = "All-in-one revision guide for Combined Science covering Photosynthesis, Respiration, Periodic Table, Electrolysis, Ohm's Law, Force & Motion, and Light reflection/refraction.",
            keyTopics = listOf("Photosynthesis & Mineral Nutrition", "Ionic & Covalent Bonding", "Ohm's Law & Circuit Calculations", "Acids, Bases & Salts", "Newton's Laws of Motion"),
            formulaSheet = "Force: F = m × a\nWork done: W = F × d\nPower: P = W / t = V × I\nOhm's Law: V = I × R\nDensity: ρ = m / V\nKinetic Energy: KE = (1/2)mv²",
            sampleQuestionsWithSolutions = listOf(
                QuestionSolution(
                    questionNumber = "Physics Q3(a)",
                    questionText = "A resistor of 12 Ω is connected in series with a 6 Ω resistor to a 9V battery. Calculate the total current in the circuit.",
                    answerText = "Total Resistance R_total = R1 + R2 = 12 + 6 = 18 Ω.\nUsing Ohm's Law: I = V / R = 9V / 18Ω = 0.5 A.",
                    examinerNotes = "State the unit (A or Amperes) to secure the final answer mark."
                )
            ),
            fullContent = """
# ZIMSEC Combined Science (5076) Master Notes
### Biology Section
- **Photosynthesis Word Equation:** Carbon Dioxide + Water --(Light & Chlorophyll)--> Glucose + Oxygen.
- **Transpiration:** Evaporation of water from the surface of mesophyll cells followed by diffusion out of stomata.
- **Heart Structure:** Right ventricle pumps deoxygenated blood to lungs via pulmonary artery; Left ventricle pumps oxygenated blood to the body via aorta.

### Chemistry Section
- **Acids & Bases:** Acid + Metal -> Salt + Hydrogen gas. Acid + Carbonate -> Salt + Water + Carbon Dioxide.
- **Electrolysis:** Decomposition of an electrolyte by passing an electric current. Cathode is negative (attracts cations); Anode is positive (attracts anions).

### Physics Section
- **Speed, Velocity and Acceleration:** Acceleration a = (v - u) / t.
- **Electrical Energy:** E = P × t = V × I × t.
            """.trimIndent()
        ),
        StudyMaterial(
            id = "mat_heritage_4006_syllabus",
            title = "ZIMSEC O-Level Heritage Studies 4006: Official Syllabus & Examination Guide",
            subjectId = "sub_zimsec_olevel_heritage",
            subjectName = "Heritage Studies (4006)",
            examLevel = ExamLevel.O_LEVEL,
            examBoard = ExamBoard.ZIMSEC,
            type = MaterialType.SYLLABUS,
            yearSession = "Current ZIMSEC Curriculum",
            paperNumber = "Paper 1 & Paper 2",
            pages = 22,
            sizeText = "1.5 MB",
            viewsCount = 2930,
            summary = "Complete curriculum breakdown for Heritage Studies covering the Zimbabwe Constitution, national symbols, indigenous knowledge systems, the First and Second Chimurenga, and preservation of cultural heritage.",
            keyTopics = listOf("Zimbabwe Constitution & Citizenship", "National Symbols & Anthem", "Great Zimbabwe & Munhumutapa", "First & Second Chimurenga", "Indigenous Knowledge Systems"),
            formulaSheet = null,
            sampleQuestionsWithSolutions = listOf(
                QuestionSolution(
                    questionNumber = "Essay 1",
                    questionText = "Explain four causes of the First Chimurenga of 1896-1897 in Zimbabwe.",
                    answerText = "1. Loss of land: The BSAC expropriated fertile land and relegated Africans to dry reserves (Gwai and Shangani).\n2. Cattle confiscation: The colonial administration seized cattle claiming compensation for the 1893 war.\n3. Hut Tax: Forced imposition of taxation compelled Africans to work in European farms and mines.\n4. Forced Labour (Chibharo): Harsh treatment and coercion of local population.\n5. Natural Disasters: Drought, locust invasion, and rinderpest outbreak interpreted by spiritual leaders (Mbuya Nehanda & Sekuru Kaguvi) as divine punishment for colonial presence.",
                    examinerNotes = "Candidates must develop each point clearly with historical examples."
                )
            ),
            fullContent = """
# ZIMSEC Heritage Studies Syllabus Guidelines
### Core Competencies & Themes:
1. **National Identity & Governance:** Values of Ubuntu/Unhu, rule of law, and bill of rights.
2. **Pre-colonial States:** Socio-economic and political structures of Mapungubwe, Great Zimbabwe, Mutapa, Rozvi, and Ndebele kingdoms.
3. **Liberation Struggle:** Causes, phases, armed liberation movement (ZANLA & ZIPRA), and attainment of independence in 1980.
4. **Cultural Heritage Preservation:** Monuments, intangible heritage, folklore, traditional ceremonies, and museology in Zimbabwe.
            """.trimIndent()
        ),
        StudyMaterial(
            id = "mat_cambridge_0580_past_paper",
            title = "Cambridge IGCSE Mathematics 0580/42 - Extended Past Paper & Step-by-Step Marking Scheme",
            subjectId = "sub_cambridge_igcse_maths",
            subjectName = "IGCSE Mathematics (0580)",
            examLevel = ExamLevel.CAMBRIDGE,
            examBoard = ExamBoard.CAMBRIDGE,
            type = MaterialType.PAST_PAPER,
            yearSession = "June 2024",
            paperNumber = "Paper 4 (Extended)",
            pages = 16,
            sizeText = "2.1 MB",
            viewsCount = 4120,
            summary = "Cambridge IGCSE Extended paper 4 with worked model answers for functions, transformation matrices, histograms, probability tree diagrams, and compound interest calculations.",
            keyTopics = listOf("Composite & Inverse Functions", "Probability Trees", "Histograms & Frequency Density", "Sine & Cosine Bearings", "Linear Programming"),
            formulaSheet = "Compound interest: A = P(1 + r/100)ⁿ\nFrequency Density = Frequency / Class Width\nSpeed = Distance / Time",
            sampleQuestionsWithSolutions = listOf(
                QuestionSolution(
                    questionNumber = "Q5(a)",
                    questionText = "Given f(x) = 3x - 5 and g(x) = x² + 2, find f(g(3)).",
                    answerText = "First evaluate g(3) = 3² + 2 = 9 + 2 = 11.\nNow substitute into f(x): f(11) = 3(11) - 5 = 33 - 5 = 28.",
                    examinerNotes = "Work inside-out: find g(3) first, then apply function f."
                )
            ),
            fullContent = """
# Cambridge IGCSE Mathematics 0580/42
**Duration:** 2 hours 30 minutes
**Total Marks:** 130 marks

### Key Question Walkthroughs:
1. **Histogram & Continuous Data**
   - Classes: 0 < t ≤ 10 (freq = 15), 10 < t ≤ 25 (freq = 45), 25 < t ≤ 40 (freq = 30).
   - Frequency Density = Class Frequency / Class Width.
   - For 10 < t ≤ 25: Width = 15 => FD = 45 / 15 = 3.0.

2. **Probability & Tree Diagrams**
   - Independent events: P(A and B) = P(A) × P(B).
   - Complementary rule: P(At least one success) = 1 - P(None).
            """.trimIndent()
        ),
        StudyMaterial(
            id = "mat_hexco_web_prog_worksheet",
            title = "Sytbay Engineering & Programming: Practical Python & Web Development Exercises",
            subjectId = "sub_hexco_intro_programming",
            subjectName = "Intro to Programming",
            examLevel = ExamLevel.HEXCO,
            examBoard = ExamBoard.HEXCO,
            type = MaterialType.WORKSHEET,
            yearSession = "2025 Sytbay Series",
            paperNumber = "Module 1 & 2 Lab Worksheets",
            pages = 18,
            sizeText = "2.9 MB",
            viewsCount = 3780,
            summary = "Hands-on coding challenges for beginner engineers & programmers: control flow, functions, dictionaries, building REST API consumers, and responsive frontend UI components.",
            keyTopics = listOf("Python Syntax & Data Types", "Control Structures & Loops", "JSON Parsing", "Functions & Scope", "Git & GitHub Workflow"),
            formulaSheet = null,
            sampleQuestionsWithSolutions = listOf(
                QuestionSolution(
                    questionNumber = "Lab Exercise 2",
                    questionText = "Write a Python script that takes a list of exam scores and calculates the mean, highest, and lowest mark.",
                    answerText = """scores = [78, 85, 92, 64, 53, 88, 95]
mean_score = sum(scores) / len(scores)
highest = max(scores)
lowest = min(scores)

print(f"Average: {mean_score:.1f}%")
print(f"Top Score: {highest}%")
print(f"Lowest Score: {lowest}%")""",
                    examinerNotes = "Use built-in Python sum(), max(), min() for clean idiomatic code."
                )
            ),
            fullContent = """
# Sytbay Academy: Software Engineering & Programming
**Target:** Polytechnic & HEXCO Certificate / Diploma Students.

### Core Modules:
- **Module 1:** Computational Thinking, Algorithms, and Flowcharts.
- **Module 2:** Python Core: Variables, Lists, Tuples, Dictionaries, Sets.
- **Module 3:** Modular Programming with Functions and Error Handling (`try-except`).
- **Module 4:** Connecting to SQLite databases and building CRUD utilities.
            """.trimIndent()
        ),
        StudyMaterial(
            id = "mat_grade7_maths_papers",
            title = "ZIMSEC Grade 7 Mathematics & General Paper Exam Revision Pack",
            subjectId = "sub_grade7_general_paper",
            subjectName = "Grade 7 General Paper",
            examLevel = ExamLevel.GRADE_7,
            examBoard = ExamBoard.ZIMSEC,
            type = MaterialType.PAST_PAPER,
            yearSession = "2024 Exam Edition",
            paperNumber = "Paper 1 & Paper 2",
            pages = 12,
            sizeText = "1.2 MB",
            viewsCount = 2150,
            summary = "Primary school Grade 7 revision pack including past examination questions, multiple-choice drills with answers, and study notes for Agriculture, Science, and Social Studies.",
            keyTopics = listOf("Agriculture & Soil Science", "Clean Water & Sanitation", "National History", "Fractions & Percentages", "Measurement & Time"),
            formulaSheet = "Perimeter of rectangle = 2 × (Length + Width)\nArea of triangle = (Base × Height) / 2",
            sampleQuestionsWithSolutions = listOf(
                QuestionSolution(
                    questionNumber = "Section A, Q1",
                    questionText = "Which type of soil has the highest water retention capacity?",
                    answerText = "Clay soil (due to its fine particles and tiny pore spaces).",
                    examinerNotes = "Correct scientific reasoning."
                )
            ),
            fullContent = """
# Grade 7 Revision Guide (ZIMSEC)
### Environmental Science & Agriculture
- Soil erosion types: Sheet erosion, Gully erosion, Rill erosion, Splash erosion.
- Soil conservation methods: Terracing, contour ridging, mulching, planting cover crops.
- Human Body: The circulatory system pumps oxygenated blood from heart to body.
            """.trimIndent()
        )
    )

    val quizQuestions: List<QuizQuestion> = listOf(
        // Maths
        QuizQuestion(
            id = "quiz_math_1",
            subjectId = "sub_zimsec_olevel_maths",
            subjectName = "Mathematics (4004)",
            examLevel = ExamLevel.O_LEVEL,
            topic = "Algebra & Equations",
            question = "What are the roots of the quadratic equation x² - 5x + 6 = 0?",
            options = listOf("x = 2 and x = 3", "x = -2 and x = -3", "x = 1 and x = 6", "x = -1 and x = -6"),
            correctIndex = 0,
            explanation = "Factoring the equation gives (x - 2)(x - 3) = 0. Therefore, x = 2 or x = 3."
        ),
        QuizQuestion(
            id = "quiz_math_2",
            subjectId = "sub_zimsec_olevel_maths",
            subjectName = "Mathematics (4004)",
            examLevel = ExamLevel.O_LEVEL,
            topic = "Geometry & Trigonometry",
            question = "In a right-angled triangle, if the opposite side is 3 cm and the adjacent side is 4 cm, what is tan(θ)?",
            options = listOf("3/4 (0.75)", "4/3 (1.33)", "3/5 (0.60)", "4/5 (0.80)"),
            correctIndex = 0,
            explanation = "By definition, tan(θ) = Opposite / Adjacent = 3 / 4 = 0.75."
        ),
        QuizQuestion(
            id = "quiz_math_3",
            subjectId = "sub_zimsec_olevel_maths",
            subjectName = "Mathematics (4004)",
            examLevel = ExamLevel.O_LEVEL,
            topic = "Indices & Logarithms",
            question = "Simplify (2³ × 2⁴) ÷ 2²:",
            options = listOf("2⁵ = 32", "2² = 4", "2⁶ = 64", "2⁴ = 16"),
            correctIndex = 0,
            explanation = "Applying laws of indices: 2^(3 + 4 - 2) = 2⁵ = 32."
        ),

        // Combined Science
        QuizQuestion(
            id = "quiz_sci_1",
            subjectId = "sub_zimsec_olevel_comb_sci",
            subjectName = "Combined Science (5076)",
            examLevel = ExamLevel.O_LEVEL,
            topic = "Physics: Electricity",
            question = "A 60W lightbulb operates on a 240V mains supply. What current flows through it?",
            options = listOf("0.25 A", "4.0 A", "14.4 A", "0.5 A"),
            correctIndex = 0,
            explanation = "Power P = V × I, therefore I = P / V = 60W / 240V = 0.25 Amperes."
        ),
        QuizQuestion(
            id = "quiz_sci_2",
            subjectId = "sub_zimsec_olevel_comb_sci",
            subjectName = "Combined Science (5076)",
            examLevel = ExamLevel.O_LEVEL,
            topic = "Chemistry: Acids & Bases",
            question = "What gas is produced when dilute hydrochloric acid reacts with calcium carbonate?",
            options = listOf("Carbon Dioxide", "Hydrogen", "Oxygen", "Chlorine"),
            correctIndex = 0,
            explanation = "Acid + Metal Carbonate -> Salt + Water + Carbon Dioxide gas (CO₂)."
        ),
        QuizQuestion(
            id = "quiz_sci_3",
            subjectId = "sub_zimsec_olevel_comb_sci",
            subjectName = "Combined Science (5076)",
            examLevel = ExamLevel.O_LEVEL,
            topic = "Biology: Human Transport",
            question = "Which blood vessel carries oxygenated blood from the lungs into the left atrium of the heart?",
            options = listOf("Pulmonary Vein", "Pulmonary Artery", "Aorta", "Vena Cava"),
            correctIndex = 0,
            explanation = "The pulmonary vein is the only vein carrying oxygenated blood, running from lungs to left atrium."
        ),

        // Computer Science
        QuizQuestion(
            id = "quiz_cs_1",
            subjectId = "sub_zimsec_alevel_cs",
            subjectName = "Computer Science (6042)",
            examLevel = ExamLevel.A_LEVEL,
            topic = "Data Structures",
            question = "Which abstract data structure operates on a Last-In, First-Out (LIFO) principle?",
            options = listOf("Stack", "Queue", "Array", "Linked List"),
            correctIndex = 0,
            explanation = "A Stack uses LIFO (Last-In, First-Out) with push and pop operations."
        ),
        QuizQuestion(
            id = "quiz_cs_2",
            subjectId = "sub_zimsec_alevel_cs",
            subjectName = "Computer Science (6042)",
            examLevel = ExamLevel.A_LEVEL,
            topic = "Algorithms & Complexity",
            question = "What is the worst-case time complexity of Binary Search on a sorted array of n elements?",
            options = listOf("O(log n)", "O(n)", "O(n²)", "O(1)"),
            correctIndex = 0,
            explanation = "Binary Search halves the search space each step, yielding logarithmic O(log n) complexity."
        ),

        // Heritage Studies
        QuizQuestion(
            id = "quiz_heritage_1",
            subjectId = "sub_zimsec_olevel_heritage",
            subjectName = "Heritage Studies (4006)",
            examLevel = ExamLevel.O_LEVEL,
            topic = "National Heritage",
            question = "Which bird is the national emblem depicted on the flag and coat of arms of Zimbabwe?",
            options = listOf("The Zimbabwe Bird (Bateleur Eagle / Fish Eagle carving)", "African Fish Eagle", "Secretary Bird", "Crowned Crane"),
            correctIndex = 0,
            explanation = "The soapstone Zimbabwe Bird found at Great Zimbabwe is the iconic national emblem."
        ),

        // Cambridge Maths
        QuizQuestion(
            id = "quiz_cambridge_1",
            subjectId = "sub_cambridge_igcse_maths",
            subjectName = "IGCSE Mathematics (0580)",
            examLevel = ExamLevel.CAMBRIDGE,
            topic = "Probability",
            question = "Two fair 6-sided dice are rolled. What is the probability of rolling a sum equal to 7?",
            options = listOf("6/36 (1/6)", "7/36", "1/12", "5/36"),
            correctIndex = 0,
            explanation = "Favourable pairs: (1,6), (2,5), (3,4), (4,3), (5,2), (6,1) = 6 combinations out of 36. 6/36 = 1/6."
        )
    )

    val examinationTimetable: List<TimetableEntry> = listOf(
        TimetableEntry(
            id = "time_1",
            examBoard = ExamBoard.ZIMSEC,
            level = ExamLevel.O_LEVEL,
            subjectCode = "4004/1",
            subjectName = "Mathematics Paper 1 (Multiple Choice)",
            paperName = "Paper 1",
            dateDisplay = "Mon, 20 Oct 2025",
            sessionTime = "09:00 AM - 11:30 AM",
            sessionType = "Morning",
            durationText = "2 hrs 30 mins"
        ),
        TimetableEntry(
            id = "time_2",
            examBoard = ExamBoard.ZIMSEC,
            level = ExamLevel.O_LEVEL,
            subjectCode = "4004/2",
            subjectName = "Mathematics Paper 2 (Structured)",
            paperName = "Paper 2",
            dateDisplay = "Wed, 22 Oct 2025",
            sessionTime = "09:00 AM - 11:30 AM",
            sessionType = "Morning",
            durationText = "2 hrs 30 mins"
        ),
        TimetableEntry(
            id = "time_3",
            examBoard = ExamBoard.ZIMSEC,
            level = ExamLevel.O_LEVEL,
            subjectCode = "5076/1",
            subjectName = "Combined Science Paper 1 (MCQ)",
            paperName = "Paper 1",
            dateDisplay = "Mon, 27 Oct 2025",
            sessionTime = "09:00 AM - 10:00 AM",
            sessionType = "Morning",
            durationText = "1 hr"
        ),
        TimetableEntry(
            id = "time_4",
            examBoard = ExamBoard.ZIMSEC,
            level = ExamLevel.O_LEVEL,
            subjectCode = "5076/2",
            subjectName = "Combined Science Paper 2 (Theory)",
            paperName = "Paper 2",
            dateDisplay = "Wed, 29 Oct 2025",
            sessionTime = "09:00 AM - 11:15 AM",
            sessionType = "Morning",
            durationText = "2 hrs 15 mins"
        ),
        TimetableEntry(
            id = "time_5",
            examBoard = ExamBoard.ZIMSEC,
            level = ExamLevel.A_LEVEL,
            subjectCode = "6042/1",
            subjectName = "Computer Science Paper 1 (Theory)",
            paperName = "Paper 1",
            dateDisplay = "Tue, 04 Nov 2025",
            sessionTime = "09:00 AM - 12:00 PM",
            sessionType = "Morning",
            durationText = "3 hrs"
        ),
        TimetableEntry(
            id = "time_6",
            examBoard = ExamBoard.ZIMSEC,
            level = ExamLevel.O_LEVEL,
            subjectCode = "4006/1",
            subjectName = "Heritage Studies Paper 1",
            paperName = "Paper 1",
            dateDisplay = "Thu, 06 Nov 2025",
            sessionTime = "02:00 PM - 03:45 PM",
            sessionType = "Afternoon",
            durationText = "1 hr 45 mins"
        ),
        TimetableEntry(
            id = "time_7",
            examBoard = ExamBoard.CAMBRIDGE,
            level = ExamLevel.CAMBRIDGE,
            subjectCode = "0580/22",
            subjectName = "Cambridge IGCSE Mathematics Paper 2",
            paperName = "Paper 2 Extended",
            dateDisplay = "Mon, 10 Nov 2025",
            sessionTime = "09:00 AM - 10:30 AM",
            sessionType = "Morning",
            durationText = "1 hr 30 mins"
        )
    )
}
