package org.mozilla.fenix.ext

import kotlinx.coroutines.ObsoleteCoroutinesApi
import mozilla.components.support.test.robolectric.testContext
import org.mozilla.fenix.TestApplication
import org.junit.Test
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import io.mockk.mockk
import io.mockk.verify
import android.widget.ImageButton

@ObsoleteCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)

class ImageButtonTest {
    val mockIb: ImageButton = mockk(relaxed = true)
    val imageButton = ImageButton(testContext)

    @Test
    fun `Hide and disable`() {
        mockIb.hideAndDisable()
        imageButton.hideAndDisable()
        verify { mockIb.setVisibility(4) }
        verify { mockIb.setEnabled(false) }
        assertFalse(imageButton.isEnabled)
        assertEquals(4, imageButton.visibility)
    }

    @Test
    fun `Show and enable`() {
        mockIb.showAndEnable()
        imageButton.showAndEnable()
        verify { mockIb.setVisibility(0) }
        verify { mockIb.setEnabled(true) }
        assertTrue(imageButton.isEnabled)
        assertEquals(0, imageButton.visibility)
    }
}
