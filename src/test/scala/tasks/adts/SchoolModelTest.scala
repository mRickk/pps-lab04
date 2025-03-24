package tasks.adts

import org.junit.*
import org.junit.Assert.*
import tasks.adts.SchoolModel.*
import u03.extensionmethods.Sequences.Sequence.{Cons, nil}

class SchoolModelTest:

  val schoolModel: SchoolModule = BasicSchoolModule
  import schoolModel.*

  val schoolEmpty = emptySchool
  val tName = "Mario"
  val cName = "Analisi"
  val schoolFull = schoolEmpty.setTeacherToCourse(teacher(tName), course(cName))

  @Test def testEmptySchool() =
    assertEquals(nil(), schoolEmpty.courses)
    assertEquals(nil(), schoolEmpty.teachers)

  @Test def testSetTeacherToCourse() =
    assertEquals(tName, schoolFull.teachers)
    assertEquals(cName, schoolFull.courses)

  @Test def testHasTeacherOrCourse() =
    assertFalse(schoolEmpty.hasTeacher(tName))
    assertFalse(schoolEmpty.hasCourse(cName))
    assertTrue(schoolFull.hasTeacher(tName))
    assertTrue(schoolFull.hasTeacher(cName))

