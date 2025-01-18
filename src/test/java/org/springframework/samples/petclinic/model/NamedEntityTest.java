package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public final class NamedEntityTest {
	///region Test suites for executable org.springframework.samples.petclinic.model.NamedEntity.getName

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getName()

	/**
	 * @utbot.classUnderTest {@link NamedEntity}
	 * @utbot.methodUnderTest {@link NamedEntity#getName()}
	 * @utbot.returnsFrom {@code return this.name;}
	 */
	@Test
	@DisplayName("getName: -> return this.name")
	public void testGetName_ReturnThisName() {
		NamedEntity namedEntity = new NamedEntity();
		String name = "";
		namedEntity.setName(name);

		String actual = namedEntity.getName();

		assertEquals(name, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.model.NamedEntity.setName

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setName(java.lang.String)

	/**
	 * @utbot.classUnderTest {@link NamedEntity}
	 * @utbot.methodUnderTest {@link NamedEntity#setName(String)}
	 */
	@Test
	@DisplayName("setName: ")
	public void testSetName() {
		NamedEntity namedEntity = new NamedEntity();
		String name = "";
		namedEntity.setName(name);

		namedEntity.setName(null);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.model.NamedEntity.toString

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method toString()

	/**
	 * @utbot.classUnderTest {@link NamedEntity}
	 * @utbot.methodUnderTest {@link NamedEntity#toString()}
	 * @utbot.invokes {@link NamedEntity#getName()}
	 * @utbot.returnsFrom {@code return this.getName();}
	 */
	@Test
	@DisplayName("toString: NamedEntityGetName -> return this.getName()")
	public void testToString_NamedEntityGetName() {
		NamedEntity namedEntity = new NamedEntity();
		String name = "";
		namedEntity.setName(name);

		String actual = namedEntity.toString();

		assertEquals(name, actual);
	}
	///endregion

	///region FUZZER: TIMEOUTS for method toString()

	/**
	 * @utbot.classUnderTest {@link NamedEntity}
	 * @utbot.methodUnderTest {@link NamedEntity#toString()}
	 */
	@Test
	@DisplayName("toString: ")
	@Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
	public void testToString() {
		NamedEntity namedEntity = new NamedEntity();
		namedEntity.setId(-2147483647);

        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
		assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> namedEntity.toString());
	}
	///endregion

	///endregion
}
