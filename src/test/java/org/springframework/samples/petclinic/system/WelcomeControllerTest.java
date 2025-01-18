package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class WelcomeControllerTest {
	///region Test suites for executable org.springframework.samples.petclinic.system.WelcomeController.welcome

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method welcome()

	/**
	 * @utbot.classUnderTest {@link WelcomeController}
	 * @utbot.methodUnderTest {@link WelcomeController#welcome()}
	 * @utbot.returnsFrom {@code return "welcome";}
	 */
	@Test
	@DisplayName("welcome: -> return \"welcome\"")
	public void testWelcome_ReturnWelcome() {
		WelcomeController welcomeController = new WelcomeController();

		String actual = welcomeController.welcome();

		String expected = "welcome";

		assertEquals(expected, actual);
	}
	///endregion

	///endregion
}
