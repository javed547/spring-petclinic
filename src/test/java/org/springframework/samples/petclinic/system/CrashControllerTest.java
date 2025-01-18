package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class CrashControllerTest {
	///region Test suites for executable org.springframework.samples.petclinic.system.CrashController.triggerException

	///region SYMBOLIC EXECUTION: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method triggerException()

	/**
	 * @utbot.classUnderTest {@link CrashController}
	 * @utbot.methodUnderTest {@link CrashController#triggerException()}
	 * @utbot.throwsException {@link RuntimeException} in: throw new RuntimeException("Expected: controller used to showcase what " + "happens when an exception is thrown");
	 */
	@Test
	@DisplayName("triggerException:  -> ThrowRuntimeException")
	public void testTriggerException_ThrowRuntimeException() {
		CrashController crashController = new CrashController();

		assertThrows(RuntimeException.class, () -> crashController.triggerException());
	}
	///endregion

	///endregion
}
