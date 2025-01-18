package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class PersonTest {
	///region Test suites for executable org.springframework.samples.petclinic.model.Person.getFirstName

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getFirstName()

	/**
	 * @utbot.classUnderTest {@link Person}
	 * @utbot.methodUnderTest {@link Person#getFirstName()}
	 * @utbot.returnsFrom {@code return this.firstName;}
	 */
	@Test
	@DisplayName("getFirstName: -> return this.firstName")
	public void testGetFirstName_ReturnThisFirstName() {
		Person person = new Person();
		String firstName = "";
		person.setFirstName(firstName);

		String actual = person.getFirstName();

		assertEquals(firstName, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.model.Person.setFirstName

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setFirstName(java.lang.String)

	/**
	 * @utbot.classUnderTest {@link Person}
	 * @utbot.methodUnderTest {@link Person#setFirstName(String)}
	 */
	@Test
	@DisplayName("setFirstName: ")
	public void testSetFirstName() {
		Person person = new Person();
		String firstName = "";
		person.setFirstName(firstName);

		person.setFirstName(null);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.model.Person.getLastName

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getLastName()

	/**
	 * @utbot.classUnderTest {@link Person}
	 * @utbot.methodUnderTest {@link Person#getLastName()}
	 * @utbot.returnsFrom {@code return this.lastName;}
	 */
	@Test
	@DisplayName("getLastName: -> return this.lastName")
	public void testGetLastName_ReturnThisLastName() {
		Person person = new Person();
		String lastName = "";
		person.setLastName(lastName);

		String actual = person.getLastName();

		assertEquals(lastName, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.model.Person.setLastName

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setLastName(java.lang.String)

	/**
	 * @utbot.classUnderTest {@link Person}
	 * @utbot.methodUnderTest {@link Person#setLastName(String)}
	 */
	@Test
	@DisplayName("setLastName: ")
	public void testSetLastName() {
		Person person = new Person();
		String lastName = "";
		person.setLastName(lastName);

		person.setLastName(null);
	}
	///endregion

	///endregion
}
