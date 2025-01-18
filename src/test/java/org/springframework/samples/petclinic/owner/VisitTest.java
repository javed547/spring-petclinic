package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.getFieldValue;

public final class VisitTest {
	@InjectMocks
	private Visit visit;

	@Mock
	private LocalDate localDateMock;

	private AutoCloseable mockitoCloseable;

	///region Test suites for executable org.springframework.samples.petclinic.owner.Visit.getDate

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getDate()

	/**
	 * @utbot.classUnderTest {@link Visit}
	 * @utbot.methodUnderTest {@link Visit#getDate()}
	 * @utbot.returnsFrom {@code return this.date;}
	 */
	@Test
	@DisplayName("getDate: -> return this.date")
	public void testGetDate_ReturnThisDate() {
		LocalDate actual = visit.getDate();

		assertSame(localDateMock, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Visit.setDate

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setDate(java.time.LocalDate)

	/**
	 * @utbot.classUnderTest {@link Visit}
	 * @utbot.methodUnderTest {@link Visit#setDate(LocalDate)}
	 */
	@Test
	@DisplayName("setDate: ")
	public void testSetDate() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
		visit.setDate(null);

		LocalDate finalVisitDate = ((LocalDate) getFieldValue(visit, "org.springframework.samples.petclinic.owner.Visit", "date"));

		assertNull(finalVisitDate);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Visit.getDescription

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getDescription()

	/**
	 * @utbot.classUnderTest {@link Visit}
	 * @utbot.methodUnderTest {@link Visit#getDescription()}
	 * @utbot.returnsFrom {@code return this.description;}
	 */
	@Test
	@DisplayName("getDescription: -> return this.description")
	public void testGetDescription_ReturnThisDescription() {
		String string = "";
		visit.setDescription(string);

		String actual = visit.getDescription();

		assertEquals(string, actual);
	}
	///endregion

	///endregion

	///region Test suites for executable org.springframework.samples.petclinic.owner.Visit.setDescription

	///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setDescription(java.lang.String)

	/**
	 * @utbot.classUnderTest {@link Visit}
	 * @utbot.methodUnderTest {@link Visit#setDescription(String)}
	 */
	@Test
	@DisplayName("setDescription: ")
	public void testSetDescription() {
		String string = "";
		visit.setDescription(string);

		visit.setDescription(null);
	}
	///endregion

	///endregion


	@BeforeEach
	public void setUp() {
		mockitoCloseable = openMocks(this);
	}

	@AfterEach
	public void tearDown() throws Exception {
		mockitoCloseable.close();
	}

}
