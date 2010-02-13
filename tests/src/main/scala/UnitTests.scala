package com.saladwithsteve.mobilemeat.tests 

import junit.framework.Assert._
import _root_.android.test.AndroidTestCase

class UnitTests extends AndroidTestCase {
  def testPackageIsCorrect {      
    assertEquals("com.saladwithsteve.mobilemeat", getContext.getPackageName)
  }
}